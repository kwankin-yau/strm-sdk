package info.gratour.jt808common.codec.decoder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.gratour.jt808common.codec.CodecError;
import info.gratour.jt808common.codec.CrcError;
import info.gratour.jt808common.protocol.FrameSplitInfo;
import info.gratour.jt808common.protocol.JT808Frame;
import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jtcommon.BcdUtils;
import info.gratour.jtcommon.ByteBufBackOffReader;
import info.gratour.jtcommon.JTUtils;
import info.gratour.jtcommon.LazyBytesProvider;
import info.gratour.jtcommon.NettyUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ReferenceCounted;

/**
 * JT808 帧解码器
 */
public class JT808FrameDecoder implements AutoCloseable {

    /**
     * 最小帧长度（REV-2013）
     */
    public static final int MIN_FRAME_LENGTH_REV_2013 = 1 + 12 + 1 + 1; // REV-2013

    private static final Logger LOGGER = LoggerFactory.getLogger("jt808.frameDecoder");

    private final ByteBufAllocator alloc;
    private ByteBuf workBuf;

    private ParseState parseState = ParseState.START_7E;

    private final List<ByteBuf> buffers = new ArrayList<>();

    /**
     * 构造函数
     * @param allocator 字节缓冲区分配器
     */
    public JT808FrameDecoder(ByteBufAllocator allocator) {
        alloc = allocator;
        workBuf = alloc.buffer();
    }

    /**
     * 分配一个临时字节缓冲区，用于 {@link JT808FrameDecoder#decodeFrame(ByteBuf, byte[])}。
     * 此方法分配的缓冲区大小与 {@link JT808FrameDecoder#decodeFrame(ByteBuf, byte[])} 方法内部保持一致。
     *
     * @return 新分配的临时字节缓冲区。
     */
    public static byte[] allocTempBuf() {
        return new byte[128];
    }

    /**
     * 分割和解码分片。
     *
     * @param buf 连续缓冲区
     * @return 解码状态
     */
    public DecodeState splitAndUnescape(ByteBuf buf) {
        while (buf.readableBytes() > 0) {
            byte b = buf.readByte();
            switch (parseState) {
                case START_7E:
                    if (b == 0x7e) {
                        workBuf.writeByte(b);
                        parseState = ParseState.END_7E;
                    }
                    break;

                case ENCOUNTERED_7D:
                    if (b == 0x01) {
                        workBuf.writeByte(0x7D);
                        parseState = ParseState.END_7E;
                    } else if (b == 0x02) {
                        workBuf.writeByte(0x7E);
                        parseState = ParseState.END_7E;
                    } else {
                        // bad format, discard it
                        parseState = ParseState.START_7E;
                        workBuf.clear();
                    }
                    break;

                case END_7E:
                    if (b == 0x7e) {
                        workBuf.writeByte(b);

                        buffers.add(workBuf);

                        workBuf = alloc.buffer(); // re-allocate new one
                        parseState = ParseState.START_7E;
                    } else if (b == 0x7d) {
                        parseState = ParseState.ENCOUNTERED_7D;
                    } else
                        workBuf.writeByte(b);
                    break;
            }
        }

        if (!buffers.isEmpty())
            return DecodeState.DECODED;
        else if (parseState != ParseState.START_7E)
            return DecodeState.RECOGNIZED;
        else
            return DecodeState.UNRECOGNIZED;
    }

    /**
     * 获取解码后的分片
     * @param decoded 解码后的分片列表
     */
    public void getSplit(List<ByteBuf> decoded) {
        decoded.addAll(buffers);
        buffers.clear();
    }

    /**
     * 关闭解码器
     */
    @Override
    public void close() {
        workBuf.release();
        if (!buffers.isEmpty()) {
            buffers.forEach(ReferenceCounted::release);
            buffers.clear();
        }
    }

    /**
     * 计算CRC
     * @param buf 字节缓冲区
     * @return CRC值
     */
    public static int calcCrc(ByteBuf buf) {
        int crc = 0;
        int count = buf.readableBytes();
        while (count > 0) {
            crc ^= buf.readByte();
            count--;
        }

        return crc;
    }

    /**
     * 验证CRC
     * @param wholeFrame 完整帧
     * @return 是否验证成功
     */
    public static boolean verifyCrc(ByteBuf wholeFrame) {
        int readableBytes = wholeFrame.readableBytes();
        if (readableBytes >= MIN_FRAME_LENGTH_REV_2013) {
            ByteBuf buf = wholeFrame.slice(1, readableBytes - 3);
            int crcCalc = calcCrc(buf);
            int crcActual = wholeFrame.getByte(readableBytes - 2);

            return crcCalc == crcActual;
        } else
            return false;
    }

    /**
     * 从字节缓冲区解码一个 JT808 帧对象。
     *
     * @param buf         帧缓冲区. 此缓冲区在方法返回成功后将被保留。
     * @param tempBuf     用于解码过程的临时字节缓冲区，应通过 {@link JT808FrameDecoder#allocTempBuf()} 分配。
     * @param doVerifyCrc 是否进行 CRC 验证
     * @return Jt808Frame 对象。如果解码失败，将抛出异常。
     */
    public static JT808Frame decodeFrame(ByteBuf buf, byte[] tempBuf, boolean doVerifyCrc) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("BEFORE-decodeFrame: " + NettyUtils.bufToHex(buf));
        }

        LazyBytesProvider bytes = new ByteBufBackOffReader(buf);

        if (buf.readableBytes() < MIN_FRAME_LENGTH_REV_2013) {
            LOGGER.debug("Invalid JT/T 808 frame.");
            throw new CodecError("Invalid JT/T 808 frame.", bytes);
        }

        if (doVerifyCrc && !verifyCrc(buf)) {
            LOGGER.debug("CRC verification failed.");
            throw new CrcError("CRC verification failed.", bytes);
        }


        buf.skipBytes(1); // start-tag

        JT808FrameHeader header = new JT808FrameHeader();

        // msgId
        header.setMsgId(buf.readUnsignedShort());

        // attr
        int attr = buf.readUnsignedShort();
        header.setAttr(attr);

        // protoVer
        boolean v2019 = JTUtils.bitTest(attr, 14);
        if (v2019)
            header.setProtoVer(buf.readByte());

        // simNo
        int bcdSz = v2019 ? 10 : 6;
        buf.readBytes(tempBuf, 0, bcdSz);
        String simNo = BcdUtils.decode(tempBuf, 0, bcdSz);
        simNo = JTUtils.normalizeSimNo(simNo);
        header.setSimNo(simNo);

        // seqNo
        header.setSeqNo(buf.readUnsignedShort());

        // splitInfo
        if (JTUtils.bitTest(attr, 13)) {
            FrameSplitInfo splitInfo = new FrameSplitInfo();
            splitInfo.setTotalPacket(buf.readUnsignedShort());
            splitInfo.setPacketSeqNo(buf.readUnsignedShort());
            header.setSplitInfo(splitInfo);
        }

        JT808Frame r = new JT808Frame(
                header,
                buf.retainedSlice(buf.readerIndex(), buf.readableBytes() - 2) // exclude crc and end-tag
        );

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Frame decoded (" + r.getClass().getSimpleName() + "):" + r);
        }

        return r;
    }

    /**
     * 从字节缓冲区解码一个 JT808 帧对象。
     *
     * @param buf         帧缓冲区. 此缓冲区在方法返回成功后将被保留。
     * @param tempBuf     用于解码过程的临时字节缓冲区，应通过 {@link JT808FrameDecoder#allocTempBuf()} 分配。
     * @return Jt808Frame 对象。如果解码失败，将抛出异常。
     */
    public static JT808Frame decodeFrame(ByteBuf buf, byte[] tempBuf) {
        return decodeFrame(buf, tempBuf, true);
    }

//     public static void main(String[] args) {
// //        String hex = "7e0704012d01332012052100100003010051000000000000000101696a9406d8a445000000000000240405000115010400000001020200000302000030010031010025040000000014040000000515040000000f1604000000001702000518030000000082000000000000000101696a9406d8a445000000000000240405000138010400000001020200000302000030010031010025040000000014040000000515040000000f160400000000170200051803000000652f00000001000702000000000050000001696a9406d8a4452404050001370001303137303736332404050001370005000051000000000000000101696a9406d8a445000000000000240405000145010400000001020200000302000030011f31010025040000000014040000000515040000000f160400000000170200051803000000d07e";
// //        String hex = "7e0200008201332012052101a600000000000c000301696b3e06d8a40800b900000000241105220401010400000001020200000302000030011f31011625040000000014040000000515040000000f160400000000170200051803000000652f0000001500070200000000005000b901696b3e06d8a4082411052203590401303137303736332411052203590005001b7e";
// //        String hex = "7e0200008a01827067539220d80800000000400003015a083006cc6ba1000000c800002411051703480104003ac138030200c830011431010a25040000000014040000000515040000003e160400000000170200051803000000f00ae10400000000ee0101d5652f000002ab0005010500000000140000015a083006cc6ba12411051703460401303637353339322411051703465b05006d7e";
//         String hex = "7e020040bd010000000001330649809771890000000000480003016198b206c058f80018023a00c524110610462301040002e6a7020200000302024e140480000000150400000000160400000000170200002504000000002b040000000030011d31010d64470000000e00030200000000003a000001619a3306c0597c241106104620046100000000000000000000000000000000000000000000543634393830393724110610462000050000eb11000700d401003658fe000600f880000000ef0d000000480000492492000011038e7e";
//         ByteBuf buf = Unpooled.buffer();
//         try {
//             buf.writeBytes(HexFormat.of().parseHex(hex));
//             JT808FrameDecoder frameDecoder = new JT808FrameDecoder(UnpooledByteBufAllocator.DEFAULT);
//             JT808MsgDecoder msgDecoder = new JT808MsgDecoder(AdasDialect.JIANG_SU, false);
//             try {
//                 DecodeState st = frameDecoder.splitAndUnescape(buf);
//                 if (!st.ok())
//                     System.err.println("Decode failed");

//                 List<ByteBuf> frames = new ArrayList<>();
//                 try {
//                     frameDecoder.getSplit(frames);
//                     byte[] temp = allocTempBuf();

//                     frames.forEach(f -> {
//                         JT808Frame frame = decodeFrame(f, temp, false);
//                         JT808Msg msg = msgDecoder.decode(frame, temp);
//                         System.out.println(msg.toString());
//                     });
//                 } finally {
//                     frames.forEach(ReferenceCounted::release);
//                 }
//             } finally {
//                 frameDecoder.close();
//             }
//         } finally {
//             buf.release();
//         }
//     }
}
