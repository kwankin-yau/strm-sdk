package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jtcommon.JTUtils;

/**
 * 胎压报警信息
 */
@Expose
public class PressureAlarmInfo {

    /**
     * 胎压值位掩码 
     */    
    public static final byte BIT__PRESS_VALUE = 0;

    /**
     * 胎压过高位掩码
     */
    public static final byte BIT__PRESS_TOO_HIGH = 1;

    /**
     * 胎压过低位掩码
     */
    public static final byte BIT__PRESS_TOO_LOW = 2;

    /**
     * 胎温过高位掩码
     */
    public static final byte BIT__TEMP_TOO_HIGH = 3;

    /**
     * 传感器故障位掩码
     */
    public static final byte BIT__SENSOR_FAILURE = 4;

    /**
     * 胎压不平衡位掩码
     */
    public static final byte BIT__PRESS_DISBALANCE = 5;

    /**
     * 缓慢漏气位掩码
     */
    public static final byte BIT__AIR_LEAK_SLOWLY = 6;

    /**
     * 电池低压位掩码
     */
    public static final byte BIT__BATTERY_LOW = 7;

    private byte tyreNo;
    private short typ;
    private int press;
    private int temp;
    private int batt;

    /**
     * 取胎压报警位置
     * @return 胎压报警位置
     */
    public byte getTyreNo() {
        return tyreNo;
    }

    /**
     * 设置胎压报警位置
     * @param tyreNo 胎压报警位置
     */
    public void setTyreNo(byte tyreNo) {
        this.tyreNo = tyreNo;
    }

    /**
     * 取胎压报警/事件类型
     * @return 胎压报警/事件类型
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置胎压报警/事件类型
     * @param typ 胎压报警/事件类型
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 测试是否出现给定的胎压报警/事件类型
     * @param almBit 胎压报警/事件类型位掩码
     * @return 测试结果
     */
    public boolean hasAlm(int almBit) {
        return JTUtils.test(typ, almBit);
    }

    /**
     * 取胎压值
     * @return 胎压值
     */
    public int getPress() {
        return press;
    }

    /**
     * 设置胎压值
     * @param press 胎压值
     */
    public void setPress(int press) {
        this.press = press;
    }

    /**
     * 取胎温值
     * @return 胎温值
     */
    public int getTemp() {
        return temp;
    }

    /**
     * 设置胎温值
     * @param temp 胎温值
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }

    /**
     * 取电池电压值
     * @return 电池电压值
     */
    public int getBatt() {
        return batt;
    }

    /**
     * 设置电池电压值
     * @param batt 电池电压值
     */
    public void setBatt(int batt) {
        this.batt = batt;
    }

    @Override
    public String toString() {
        return "PressureAlarmInfo{" +
                "tyreNo=" + tyreNo +
                ", typ=" + typ +
                ", press=" + press +
                ", temp=" + temp +
                ", batt=" + batt +
                '}';
    }
}
