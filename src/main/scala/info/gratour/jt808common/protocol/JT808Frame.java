package info.gratour.jt808common.protocol;

import java.io.Closeable;
import java.util.StringJoiner;

import info.gratour.jtcommon.ByteBufBackOffReader;
import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCounted;

/**
 * JT808 帧。JT808Frame 是一个 ReferenceCounted 对象。包含有帧头和数据体。
 */
public class JT808Frame implements Closeable, ReferenceCounted {

    private final JT808FrameHeader header;
    private final ByteBuf body;
    private final ByteBufBackOffReader backOffReader;

    /**
     * 构造函数
     * @param header 帧头
     * @param body 数据体 buffer
     */
    public JT808Frame(JT808FrameHeader header, ByteBuf body) {
        this.header = header;
        this.body = body;
        this.backOffReader = new ByteBufBackOffReader(body);
    }

    /**
     * 取帧头
     * @return 帧头
     */
    public JT808FrameHeader getHeader() {
        return header;
    }

    /**
     * 取数据体 buffer
     * @return 数据体 buffer
     */
    public ByteBuf getBody() {
        return body;
    }

    /**
     * 关闭，释放数据体 buffer
     */
    @Override
    public void close() {
        body.release();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Frame.class.getSimpleName() + "[", "]")
                .add("header=" + header)
                .add("body=" + body)
                .add("backOffReader=" + backOffReader)
                .toString();
    }

    @Override
    public int refCnt() {
        return body.refCnt();
    }

    @Override
    public JT808Frame retain() {
        body.retain();
        return this;
    }

    @Override
    public JT808Frame retain(int increment) {
        body.retain(increment);
        return this;
    }

    @Override
    public JT808Frame touch() {
        body.touch();
        return this;
    }

    @Override
    public JT808Frame touch(Object hint) {
        body.touch(hint);
        return this;
    }

    @Override
    public boolean release() {
        return body.release();
    }

    @Override
    public boolean release(int decrement) {
        return body.release(decrement);
    }

    /**
     * 获取回退读取器
     * @return 回退读取器
     */
    public ByteBufBackOffReader getBackOffReader() {
        return backOffReader;
    }
}
