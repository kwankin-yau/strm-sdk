package info.gratour.jt808common.protocol.msg.types;

import com.lucendar.common.utils.DateTimeUtils;
import info.gratour.jtcommon.BcdUtils;
import info.gratour.jtcommon.JTUtils;
import io.netty.buffer.ByteBuf;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringJoiner;

/**
 * 从一长串字节码解释后的得到ADAS 报警识别号（编号）信息
 */
public class AdasAlmNo {

    private String deviceId;
    private String time;
    private int seqNum;
    private int attFileCount;

    /**
     * 取终端（设备）ID
     *
     * @return 终端（设备）ID
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置终端（设备）ID
     *
     * @param deviceId 终端（设备）ID
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 取报警时间
     *
     * @return 报警时间，格式：yyyy-MM-dd
     */
    public String getTime() {
        return time;
    }

    /**
     * 将报警时间转换成 epoch second
     *
     * @return 代表报警时间的 epoch second
     */
    public long timeAsEpochSeconds() {
        return DateTimeUtils.BeijingConv.stringToSeconds(time);
    }

    /**
     * 将报警时间转换成本地时间
     *
     * @return 报警的本地时间
     */
    public LocalDateTime timeAsLocalDateTime() {
        return DateTimeUtils.BeijingConv.strToLdt(time);
    }

    /**
     * 设置报警时间
     *
     * @param time 报警时间，格式：yyyy-MM-dd
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 设置报警时间
     *
     * @param time 报警时间, epoch millis
     */
    public void setTime(long time) {
        this.time = DateTimeUtils.BeijingConv.millisToString(time);
    }

    /**
     * 取序号
     *
     * @return 序号
     */
    public int getSeqNum() {
        return seqNum;
    }

    /**
     * 设置序号
     *
     * @param seqNum 序号
     */
    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    /**
     * 取附件数量
     *
     * @return 附件数量
     */
    public int getAttFileCount() {
        return attFileCount;
    }

    /**
     * 设置附件数量
     *
     * @param attFileCount 附件数量
     */
    public void setAttFileCount(int attFileCount) {
        this.attFileCount = attFileCount;
    }

    /**
     * 从字节码中解释出报警时间信息
     *
     * @param bcd    字节码
     * @param offset 字节码的偏移量
     * @return 报警时间，格式：yyyy-MM-dd
     */
    public static String bcdTime(byte[] bcd, int offset) {
        int y = 2000 + BcdUtils.decodeByte(bcd[offset]);
        int m = BcdUtils.decodeByte(bcd[offset + 1]);
        if (m < 0 || m > 12)
            return null;

        int d = BcdUtils.decodeByte(bcd[offset + 2]);
        if (d < 0 || d > 31)
            return null;

        int h = BcdUtils.decodeByte(bcd[offset + 3]);
        if (h < 0 || h > 23)
            return null;
        int min = BcdUtils.decodeByte(bcd[offset + 4]);
        if (min < 0 || min > 59)
            return null;
        int s = BcdUtils.decodeByte(bcd[offset + 5]);
        if (s < 0 || s > 60) //
            return null;

        StringBuilder str = new StringBuilder();
        str.append(y).append('-');
        if (m < 10)
            str.append('0');
        str.append(m).append('-');
        if (d < 10)
            str.append('0');
        str.append(d).append(' ');
        if (h < 10)
            str.append('0');
        str.append(h).append(':');
        if (min < 10)
            str.append('0');
        str.append(min).append(':');
        if (s < 10)
            str.append('0');
        str.append(s);

        return str.toString();
    }


    /**
     * 将BCD字节数组转换成日期时间字符串
     *
     * @param bcd BCD字节数组
     * @return 日期时间字符串
     */
    public static String bcdTime(byte[] bcd) {
        return bcdTime(bcd, 0);
    }

    /**
     * 将给定的时间写入目标BCD字节数组的指定偏移位置
     *
     * @param dateTime 时间，转成本地时间后提供
     * @param bcd      目标 BCD 字节数组
     * @param offset   偏移位置
     */
    public static void setBcdTime(LocalDateTime dateTime, byte[] bcd, int offset) {
        bcd[offset] = BcdUtils.encodeByte(dateTime.getYear() - 2000);
        bcd[offset + 1] = BcdUtils.encodeByte(dateTime.getMonthValue());
        bcd[offset + 2] = BcdUtils.encodeByte(dateTime.getDayOfMonth());
        bcd[offset + 3] = BcdUtils.encodeByte(dateTime.getHour());
        bcd[offset + 4] = BcdUtils.encodeByte(dateTime.getMinute());
        bcd[offset + 5] = BcdUtils.encodeByte(dateTime.getSecond());
    }

    /**
     * 分配一个解码 ADAS 报警编号的临时缓冲区
     *
     * @return 解码 ADAS 报警编号的临时缓冲区
     */
    public static byte[] newDecodeTempBuf() {
        return new byte[30];
    }

    /**
     * 基于2013版的 ADAS 报警 ID 长度
     */
    public static final int ID_LEN_2013 = 16;

    /**
     * 基于2019版的 ADAS 报警 ID 长度
     */
    public static final int ID_LEN_2019 = 40;

    /**
     * 按 2013 版本格式解码 ADAS 报警编号( byte array 版 )
     *
     * @param buf ADAS 报警编号的二进制字节数组
     * @return ADAS 报警编号
     */
    public static AdasAlmNo decodeFrom_2013(byte[] buf) {
        AdasAlmNo r = new AdasAlmNo();
        r.setDeviceId(JTUtils.cStr(buf, 7));
        r.setTime(bcdTime(buf, 7));
        r.setSeqNum(buf[13] & 0xFF);
        r.setAttFileCount(buf[14] & 0xFF);

        return r;
    }

    /**
     * 按 2013 版本格式解码 ADAS 报警编号 ( ByteBuf 参数版 )。
     *
     * @param buf     ADAS 报警编号的二进制缓冲区
     * @param tempBuf 用于解码的临时缓冲区
     * @return ADAS 报警编号
     */
    public static AdasAlmNo decodeFrom_2013(ByteBuf buf, byte[] tempBuf) {
        AdasAlmNo r = new AdasAlmNo();
        buf.readBytes(tempBuf, 0, 7);

        r.setDeviceId(JTUtils.cStr(tempBuf, 7));
        buf.readBytes(tempBuf, 0, 6);
        r.setTime(bcdTime(tempBuf));
        if (r.getTime() == null)
            return null;

        r.setSeqNum(buf.readUnsignedByte());
        r.setAttFileCount(buf.readUnsignedByte());
        buf.skipBytes(1);

        return r;
    }

    /**
     * 按 2019 版本格式解码 ADAS 报警编号( byte array 版 )
     *
     * @param buf ADAS 报警编号的二进制字节数组
     * @return ADAS 报警编号
     */
    public static AdasAlmNo decodeFrom_2019(byte[] buf) {
        AdasAlmNo r = new AdasAlmNo();

        r.setDeviceId(JTUtils.cStr(buf, 30));
        r.setTime(bcdTime(buf, 30));
        if (r.getTime() == null)
            return null;

        r.setSeqNum(buf[36] & 0xFF);
        r.setAttFileCount(buf[37] & 0xFF);

        return r;
    }

    /**
     * 按 2019 版本格式解码 ADAS 报警编号 ( ByteBuf 参数版 )。
     *
     * @param buf     ADAS 报警编号的二进制缓冲区
     * @param tempBuf 用于解码的临时缓冲区
     * @return ADAS 报警编号
     */
    public static AdasAlmNo decodeFrom_2019(ByteBuf buf, byte[] tempBuf) {
        AdasAlmNo r = new AdasAlmNo();
        buf.readBytes(tempBuf, 0, 30);

        r.setDeviceId(JTUtils.cStr(tempBuf, 30));
        buf.readBytes(tempBuf, 0, 6);
        r.setTime(bcdTime(tempBuf));
        r.setSeqNum(buf.readUnsignedByte());
        r.setAttFileCount(buf.readUnsignedByte());
        buf.skipBytes(2);

        return r;
    }

    /**
     * 解码给定的 ADAS 报警编号的二进制字节数组，根据字节数组长度判别 JT/T 808的版本号
     *
     * @param buf ADAS 报警编号的二进制字节数组
     * @return ADAS 报警编号
     */
    public static AdasAlmNo decodeFrom(byte[] buf) {
        if (buf.length == ID_LEN_2013)
            return decodeFrom_2013(buf);
        else
            return decodeFrom_2019(buf);
    }


    /**
     * 返回 ADAS 报警 ID 在给定协议版本号下的长度
     *
     * @param protoVer JT/T 808 协议版本号, 参见 {@link info.gratour.jt808common.JT808Consts.ProtocolVersions}
     * @return ADAS 报警 ID 在给定协议版本号下的长度
     */
    public static int almNoLen(byte protoVer) {
        if (protoVer > 0)
            return 30 + 6 + 1 + 1 + 2;
        else
            return 7 + 6 + 1 + 1 + 1;
    }

    /**
     * 将 ADAS 报警编号编码到字节数组
     *
     * @param protoVer JT/T 808 协议版本号。见 {@link info.gratour.jt808common.JT808Consts.ProtocolVersions}
     * @param out      用于输出的字节数组
     * @param offset   输出字节数组的便宜量
     */
    public void encode(byte protoVer, byte[] out, int offset) {
        int devIdLen;
        if (protoVer > 0)
            devIdLen = 30;
        else
            devIdLen = 7;

        byte[] bytes = deviceId.getBytes(StandardCharsets.US_ASCII);
        int copyLen = Math.min(bytes.length, devIdLen);

        System.arraycopy(bytes, 0, out, offset, copyLen);
        if (copyLen < devIdLen) {
            // fill remains to zero
            for (int i = 0; i < devIdLen - copyLen; i++) {
                out[offset + copyLen + i] = 0;
            }
        }

        LocalDateTime ldt = timeAsLocalDateTime();
        setBcdTime(ldt, out, offset + devIdLen);

        out[offset + devIdLen + 6] = (byte) seqNum;
        out[offset + devIdLen + 6 + 1] = (byte) attFileCount;
        out[offset + devIdLen + 6 + 2] = 0;
        if (protoVer > 0)
            out[offset + devIdLen + 6 + 3] = 0;
    }

    /**
     * 将 ADAS 报警编号编码为字节数组
     *
     * @param protoVer JT/T 808 协议版本号。见 {@link info.gratour.jt808common.JT808Consts.ProtocolVersions}
     * @return 结果字节数组
     */
    public byte[] encodeToBytes(byte protoVer) {
        int len = almNoLen(protoVer);
        byte[] r = new byte[len];
        encode(protoVer, r, 0);
        return r;
    }

    /**
     * 将编码 ADAS 报警编号编码为 HEX 字符串
     *
     * @param protoVer JT/T 808 协议版本号。见 {@link info.gratour.jt808common.JT808Consts.ProtocolVersions}
     * @return HEX 字符串
     */
    public String encodeToHex(byte protoVer) {
        return Hex.encodeHexString(encodeToBytes(protoVer));
    }


    /**
     * 从 HEX 字符串中解码为 ADAS 报警编号对象
     *
     * @param hex 输入HEX 字符串
     * @return ADAS 报警编号对象
     */
    public static AdasAlmNo decodeFromHex(String hex) {
        return decodeFrom(JTUtils.hex(hex));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AdasAlmNo.class.getSimpleName() + "[", "]")
                .add("deviceId='" + deviceId + "'")
                .add("time='" + time + "'")
                .add("seqNum=" + seqNum)
                .add("attFileCount=" + attFileCount)
                .toString();
    }
}
