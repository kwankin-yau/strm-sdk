package info.gratour.jtcommon;

import org.apache.commons.codec.binary.Hex;

import io.netty.buffer.ByteBuf;

/**
 * 保持当前的 readerIndex 的 ByteBuf 供稍后读取的类
 */
public class ByteBufBackOffReader implements LazyBytesProvider {

    private ByteBuf buf;
    private int originalReaderIndex;
    private int sz;

    private byte[] _binary;
    private String _hex;

    /**
     * 构造函数
     * @param buf 字节缓冲区
     */
    public ByteBufBackOffReader(ByteBuf buf) {
        this.buf = buf;
        originalReaderIndex = buf.readerIndex();
        sz = buf.readableBytes();
    }

    /**
     * 重新设置 `buffer`
     * @param buf 新的 buffer
     */
    public void reset(ByteBuf buf) {
        this.buf = buf;
        originalReaderIndex = buf.readerIndex();
        sz = buf.readableBytes();

        _binary = null;
        _hex = null;
    }

    @Override
    public byte[] binary() {
        if (_binary == null) {
            _binary = new byte[sz];
            buf.getBytes(originalReaderIndex, _binary);
        }

        return _binary;
    }

    @Override
    public String hex() {
        if (_hex == null)
            _hex = Hex.encodeHexString(binary());

        return _hex;
    }

    /**
     * 构建原始缓冲区区域的切片
     * @return 原始缓冲区区域的切片
     */
    public ByteBuf slice() {
        return buf.slice(originalReaderIndex, sz);
    }
}
