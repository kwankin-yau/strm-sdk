/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtcommon;

import org.apache.commons.codec.binary.Hex;

import io.netty.buffer.ByteBuf;

/**
 * Netty 工具类
 */
public class NettyUtils {

    /**
     * 解码长度字节前置的字符串
     * @param buf 字节缓冲区
     * @param trimTrailingNullChar 是否修剪尾部空(0x00)字符
     * @return 解码后的字符串
     */
    public static String decodeLenPrefixedString(ByteBuf buf, boolean trimTrailingNullChar) {
        int l = buf.readUnsignedByte();
        byte[] bytes = new byte[l];
        buf.readBytes(bytes);

        if (trimTrailingNullChar)
            return JTUtils.stringMaxLen(bytes, 0, l);
        else
            return new String(bytes, JTConsts$.MODULE$.DEFAULT_CHARSET());
    }

    /**
     * 解码长度字节前置的字符串
     * @param buf 字节缓冲区
     * @return 解码后的字符串
     */
    public static String decodeLenPrefixedString(ByteBuf buf) {
        return decodeLenPrefixedString(buf, false);
    }

    /**
     * 编码长度字节前置的字符串
     * @param s 字符串
     * @param out 字节缓冲区
     */
    public static void encodeLenPrefixedString(String s, ByteBuf out) {
        byte[] bytes = s.getBytes(JTConsts$.MODULE$.DEFAULT_CHARSET());
        int l = bytes.length;
        if (l > 255) {
            throw new RuntimeException("Too long string: " + s + ".");
        } else {
            out.writeByte(l);
            out.writeBytes(bytes);
        }
    }

//    @Deprecated
//    public static String byteBufToHexString(ByteBuf buf) {
//        int size = buf.readableBytes();
//        byte[] bytes = new byte[size];
//        buf.readBytes(bytes);
//        return Hex.encodeHexString(bytes);
//    }

    /**
     * 将字节缓冲区转换为十六进制字符串
     * @param buf 字节缓冲区
     * @param keepReaderIndex 是否保持 buf 的 readerIndex
     * @return 转换后的十六进制字符串
     */
    public static String bufToHex(ByteBuf buf, boolean keepReaderIndex) {
        if (keepReaderIndex) {
            int readerIndex = buf.readerIndex();
            int size = buf.readableBytes();
            byte[] bytes = new byte[size];
            buf.readBytes(bytes);
            buf.readerIndex(readerIndex);
            return Hex.encodeHexString(bytes);
        } else {
            int size = buf.readableBytes();
            byte[] bytes = new byte[size];
            buf.readBytes(bytes);
            return Hex.encodeHexString(bytes);
        }
    }

    /**
     * 将字节缓冲区转换为十六进制字符串
     * @param buf 字节缓冲区，默认保持 readerIndex
     * @return 转换后的十六进制字符串
     */
    public static String bufToHex(ByteBuf buf) {
        return bufToHex(buf, true);
    }

    /**
     * 读取字节缓冲区的剩余内容
     * @param buf 字节缓冲区
     * @return 字节缓冲区的剩余内容(字节数组)
     */
    public static byte[] toByteArray(ByteBuf buf) {
        if (buf.hasArray())
            return buf.array();
        else {
            byte[] r = new byte[buf.readableBytes()];
            buf.readBytes(r);

            return r;
        }

    }

//    public static String bufToHex(ByteBuf buf, boolean keepReaderIndex) {
//        if (keepReaderIndex) {
//            int readerIndex = buf.readerIndex();
//            int size = buf.readableBytes();
//            byte[] bytes = new byte[size];
//            buf.readBytes(bytes);
//            buf.readerIndex(readerIndex);
//            return Hex.encodeHexString(bytes);
//        } else {
//            int size = buf.readableBytes();
//            byte[] bytes = new byte[size];
//            buf.readBytes(bytes);
//            return Hex.encodeHexString(bytes);
//        }
//    }
//
//    public static String bufToHex(ByteBuf buf) {
//        return bufToHex(buf, true);
//    }


//    public static String byteBufToHexStringKeepReaderIndex(ByteBuf buf) {
//        return bufToHex(buf);
//    }

}
