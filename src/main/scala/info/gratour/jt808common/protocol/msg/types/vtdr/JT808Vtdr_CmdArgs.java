/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 采集指定的数据记录命令帧参数
 */
@Expose
public class JT808Vtdr_CmdArgs implements JT808VtdrDataBlock {

    private String startTime;
    private String endTime;
    private int blockCnt;

    /**
     * 取开始时间, yyyy-MM-dd HH:mm:ss
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 取结束时间, yyyy-MM-dd HH:mm:ss
     * @return 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 取数据块数
     * @return 数据块数
     */
    public int getBlockCnt() {
        return blockCnt;
    }

    /**
     * 设置数据块数
     * @param blockCnt 数据块数
     */
    public void setBlockCnt(int blockCnt) {
        this.blockCnt = blockCnt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Vtdr_CmdArgs.class.getSimpleName() + "[", "]")
                .add("startTime='" + startTime + "'")
                .add("endTime='" + endTime + "'")
                .add("blockCnt=" + blockCnt)
                .toString();
    }

    @Override
    public JT808Vtdr_CmdArgs clone() {
        try {
            return (JT808Vtdr_CmdArgs) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
