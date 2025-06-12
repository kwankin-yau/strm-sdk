package info.gratour.jt808common.spi.model;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

/**
 * 路线区域变更
 */
public class RtRgnChange {

    /**
     * 对象类型，用于GSON序列化、反序列化
     */
    public static final Type TYPE = new TypeToken<RtRgnChange>(){}.getType();

    /**
     * 类型：路线
     */
    public static final String TYP__ROUTE = "rt";


    /**
     * 类型：（终端）区域
     */
    public static final String TYP__REGION = "rgn";

    /**
     * 类型：平台区域
     */
    public static final String TYP__PLAT_RGN = "plat_rgn";

    /**
     * 操作：更新
     */
    public static final int ACTION__UPDATE = 0;

    /**
     * 操作：删除
     */
    public static final int ACTION__DELETE = 1;

    private String typ;
    private String id;
    private String simNo;
    private int action;
    private boolean enabled;
    private Object params;

    /**
     * 取类型
     * 
     * @return 类型
     */
    public String getTyp() {
        return typ;
    }

    /**
     * 设置类型
     * 
     * @param typ 类型
     */
    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * 取ID
     * 
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     * 
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取终端识别号
     * 
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * 
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取操作
     * 
     * @return 操作
     */
    public int getAction() {
        return action;
    }

    /**
     * 设置操作
     * 
     * @param action 操作
     */
    public void setAction(int action) {
        this.action = action;
    }

    /**
     * 取是否启用
     * 
     * @return 是否启用
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置是否启用
     * 
     * @param enabled 是否启用
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 取路线区域变更参数
     * 
     * @return 路线区域变更参数
     */
    public Object getParams() {
        return params;
    }

    /**
     * 设置路线区域变更参数
     * 
     * @param params 路线区域变更参数
     */
    public void setParams(Object params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RtRgnChange{" +
                "typ='" + typ + '\'' +
                ", id='" + id + '\'' +
                ", simNo='" + simNo + '\'' +
                ", action=" + action +
                ", enabled=" + enabled +
                ", params=" + params +
                '}';
    }
}
