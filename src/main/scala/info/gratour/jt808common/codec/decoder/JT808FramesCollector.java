package info.gratour.jt808common.codec.decoder;

import java.io.Closeable;

import info.gratour.jt808common.codec.decoder.fragment.CollectedFragment;
import info.gratour.jt808common.protocol.FrameSplitInfo;
import info.gratour.jt808common.protocol.JT808Frame;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;


/**
 * JT808 帧分片收集器
 */
public class JT808FramesCollector implements Closeable, CollectedFragment {


    private final int msgId;
    private JT808Frame[] frames;
    private int totalCount;
    private int recvCount;
    private final ByteBufAllocator allocator;

    /**
     * 构造函数
     * @param allocator 字节缓冲区分配器
     * @param msgId 消息ID
     */
    public JT808FramesCollector(ByteBufAllocator allocator, int msgId) {
        this.allocator = allocator;
        this.msgId = msgId;
    }

    /**
     * 收集分片。方法返回后，`frame` 的所有权将转移到 JT808FramesCollector。
     *
     * @param frame 要收集的分片
     * @return 是否所有分片已接收
     */
    public boolean collect(JT808Frame frame) {
        FrameSplitInfo splitInfo = frame.getHeader().getSplitInfo();

        if (frames == null) {
            totalCount = splitInfo.getTotalPacket();
            if (totalCount == 0) {
                frame.release();
                throw new RuntimeException("Invalid total packet count.");
            }

            frames = new JT808Frame[totalCount];
        }

        int index = splitInfo.getPacketSeqNo() - 1;
        if (index >= totalCount) {
            frame.release();
            throw new RuntimeException("Invalid packet index.");
        }

        if (frames[index] == null) {
            recvCount++;
        } else
            frames[index].release();

        frames[index] = frame;

        return isAllFragmentReceived();
    }

    /**
     * 构建完整消息包
     * @return 完整消息包
     */
    public JT808Frame buildWholePacket() {
        if (recvCount == 0)
            throw new IllegalStateException();

        CompositeByteBuf body = allocator.compositeBuffer(recvCount);

        for (int i = 0; i < recvCount; i++) {
            body.addComponent(true, frames[i].getBody().retain());
        }

        return new JT808Frame(frames[0].getHeader(), body);
    }

    @Override
    public synchronized void close() {
        if (frames != null) {
            for (int i = 0; i < frames.length; i++) {
                if (frames[i] != null) {
                    frames[i].close();
                    frames[i] = null;
                }
            }
            frames = null;
        }
    }

    @Override
    public JT808Frame[] getFrames() {
        return frames;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public int getRecvCount() {
        return recvCount;
    }

    @Override
    public boolean isAllFragmentReceived() {
        return recvCount == totalCount;
    }

    @Override
    public int getMsgId() {
        return msgId;
    }

}
