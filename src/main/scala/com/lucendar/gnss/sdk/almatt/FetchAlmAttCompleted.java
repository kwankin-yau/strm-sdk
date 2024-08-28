package com.lucendar.gnss.sdk.almatt;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.StringJoiner;

/**
 * ADAS附件提取操作结束（成功或失败）通知
 */
public class FetchAlmAttCompleted {

    private String simNo;
    private String almNo;
    private String almTyp;
    private Integer almLvl;
    private boolean success;
    private String completeTm;
    private int retryTimes;

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    @NonNull
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
     * 取终端 ADAS 报警编号的 HEX 形式
     *
     * @return 终端 ADAS 报警编号的 HEX 形式
     */
    @NonNull
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置终端 ADAS 报警编号的 HEX 形式
     *
     * @param almNo 终端 ADAS 报警编号的 HEX 形式
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    /**
     * 取报警类型代码。注意，此报警类型为 {@link info.gratour.jt808common.adas.AdasAlmTypes} 中定义的报警类型代码，由于各省 ADAS 标准有
     * 冲突，所以此处采用的是统一的报警类型代码。
     *
     * @return 报警类型代码
     */
    @NonNull
    public String getAlmTyp() {
        return almTyp;
    }

    /**
     * 设置报警类型代码
     *
     * @param almTyp 报警类型代码
     */
    public void setAlmTyp(String almTyp) {
        this.almTyp = almTyp;
    }

    /**
     * 取报警级别。有些 ADAS 报警没有级别。
     *
     * @return 报警级别
     */
    @Nullable
    public Integer getAlmLvl() {
        return almLvl;
    }

    /**
     * 设置报警级别
     *
     * @param almLvl 报警级别
     */
    public void setAlmLvl(Integer almLvl) {
        this.almLvl = almLvl;
    }

    /**
     * 取任务是否成功
     * @return 任务是否成功
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置任务是否成功
     * @param success 任务是否成功
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 取结束时间
     * @return 结束时间
     */
    public String getCompleteTm() {
        return completeTm;
    }

    /**
     * 设置结束时间
     * @param completeTm 结束时间
     */
    public void setCompleteTm(String completeTm) {
        this.completeTm = completeTm;
    }

    /**
     * 取重试次数
     * @return 重试次数
     */
    public int getRetryTimes() {
        return retryTimes;
    }

    /**
     * 设置重试次数
     * @param retryTimes 重试次数
     */
    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FetchAlmAttCompleted.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("almNo='" + almNo + "'")
                .add("almTyp='" + almTyp + "'")
                .add("almLvl=" + almLvl)
                .add("success=" + success)
                .add("completeTm='" + completeTm + "'")
                .add("retryTimes=" + retryTimes)
                .toString();
    }
}
