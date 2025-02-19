/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.spi.model;

import java.util.StringJoiner;

/**
 * 指令异步完成消息
 */
public class CmdAsyncCompletedMsg {

    /**
     * 操作类型：上传音视频资源
     */
    public static final String OP_TYP__UPLOAD_AV_RES = "upload-av-res/1206";

    private String simNo;
    private String plateNo;
    private Short plateColor;
    private String opTyp;
    private String cmdId;
    private String cmdArgs;
    private boolean success;
    private int code;
    private int ackSeqNo;
    private String provision;

    /**
     * 取终端识别号
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取车牌号
     * @return 车牌号
     */
    public String getPlateNo() {
        return plateNo;
    }

    /**
     * 设置车牌号
     * @param plateNo 车牌号
     */
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    /**
     * 取车牌颜色
     * @return 车牌颜色
     */
    public Short getPlateColor() {
        return plateColor;
    }

    /**
     * 设置车牌颜色
     * @param plateColor 车牌颜色
     */
    public void setPlateColor(Short plateColor) {
        this.plateColor = plateColor;
    }

    /**
     * 取车牌号和颜色
     * @return 车牌号和颜色
     */
    public IPlateNoAndColor getPlateNoAndColor() {
        if (plateNo != null && plateColor != null) {
            PlateNoAndColor r = new PlateNoAndColor();
            r.setPlateNo(plateNo);
            r.setPlateColor(plateColor.intValue());
            return r;
        } else
            return null;
    }

    /**
     * 取操作类型
     * @return 操作类型
     */
    public String getOpTyp() {
        return opTyp;
    }

    /**
     * 设置操作类型
     * @param opTyp 操作类型
     */
    public void setOpTyp(String opTyp) {
        this.opTyp = opTyp;
    }

    /**
     * 取指令ID
     * @return 指令ID
     */
    public String getCmdId() {
        return cmdId;
    }

    /**
     * 设置指令ID
     * @param cmdId 指令ID
     */
    public void setCmdId(String cmdId) {
        this.cmdId = cmdId;
    }

    /**
     * 取指令参数
     * @return 指令参数
     */
    public String getCmdArgs() {
        return cmdArgs;
    }

    /**
     * 设置指令参数
     * @param cmdArgs 指令参数
     */
    public void setCmdArgs(String cmdArgs) {
        this.cmdArgs = cmdArgs;
    }

    /**
     * 取是否成功
     * @return 是否成功
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置是否成功
     * @param success 是否成功
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 取错误码
     * @return 错误码
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置错误码
     * @param code 错误码
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 取确认的流水号
     * @return 确认的流水号
     */
    public int getAckSeqNo() {
        return ackSeqNo;
    }

    /**
     * 设置确认的流水号
     * @param ackSeqNo 确认的流水号
     */
    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    /**
     * 取额外信息，不同的操作类型可能有不同的额外信息（暂未用）
     * @return 额外信息
     */
    public String getProvision() {
        return provision;
    }

    /**
     * 设置额外信息（暂未用）
     * @param provision 额外信息
     */
    public void setProvision(String provision) {
        this.provision = provision;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CmdAsyncCompletedMsg.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("plateNo='" + plateNo + "'")
                .add("plateColor=" + plateColor)
                .add("opTyp='" + opTyp + "'")
                .add("cmdId='" + cmdId + "'")
                .add("cmdArgs='" + cmdArgs + "'")
                .add("success=" + success)
                .add("code=" + code)
                .add("ackSeqNo=" + ackSeqNo)
                .add("provision='" + provision + "'")
                .toString();
    }
}
