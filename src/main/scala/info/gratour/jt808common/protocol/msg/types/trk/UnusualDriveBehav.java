package info.gratour.jt808common.protocol.msg.types.trk;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jtcommon.JTUtils;

/**
 * 异常驾驶行为报警(JT/T 1078)附件信息
 */
@Expose
public class UnusualDriveBehav implements Cloneable {

    /**
     * 类型位：疲劳驾驶
     */
    public static final byte TYP_BIT__TIRED_DRIVING = 0;

    /**
     * 类型位：打电话
     */
    public static final byte TYP_BIT__PHONE_CALL = 1;

    /**
     * 类型位：抽烟
     */
    public static final byte TYP_BIT__SMOKING = 2;
    

    private short typ;
    private byte tiredLvl;

    /**
     * 取类型位
     * @return 类型位
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置类型位
     * @param typ 类型位
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 测试是否存在给定的类型位
     * @param typBit 类型位
     * @return 测试结果
     */
    public boolean hasTyp(byte typBit) {
        return JTUtils.test(typ, typBit);
    }

    /**
     * 取疲劳等级
     * @return 疲劳等级
     */
    public byte getTiredLvl() {
        return tiredLvl;
    }

    /**
     * 设置疲劳等级
     * @param tiredLvl 疲劳等级
     */
    public void setTiredLvl(byte tiredLvl) {
        this.tiredLvl = tiredLvl;
    }

    @Override
    public UnusualDriveBehav clone() {
        try {
            return (UnusualDriveBehav) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "UnusualDriveBehavior{" +
                "typ=" + typ +
                ", tiredLvl=" + tiredLvl +
                '}';
    }
}
