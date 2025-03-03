/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.ackparams;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VtdrDataBlock;
import info.gratour.jtcommon.JTMsgId;

/**
 * 行驶记录数据应答参数(0x0700)
 */
@JTMsgId(JT808MsgConsts.VTDR_DATA_0700)
@Expose
public class JT808AckParams_0700_VtdrData implements JT808AckParams, Cloneable {

    private byte cmd;
    private JT808VtdrDataBlock dataBlock;
    private String raw;

    /**
     * 获取命令
     * @return 命令
     */
    public byte getCmd() {
        return cmd;
    }

    /**
     * 设置命令
     * @param cmd 命令
     */
    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    /**
     * 获取数据块
     * @return 数据块
     */
    public JT808VtdrDataBlock getDataBlock() {
        return dataBlock;
    }

    /**
     * 设置数据块
     * @param dataBlock 数据块
     */
    public void setDataBlock(JT808VtdrDataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }

    /**
     * 获取原始数据
     * @return 原始数据
     */
    public String getRaw() {
        return raw;
    }

    /**
     * 设置原始数据
     * @param raw 原始数据
     */
    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808AckParams_0700_VtdrData.class.getSimpleName() + "[", "]")
                .add("cmd=" + cmd)
                .add("dataBlock=" + dataBlock)
                .add("raw='" + raw + "'")
                .toString();
    }

    public void assignFrom(JT808AckParams_0700_VtdrData source) {
        this.cmd = source.cmd;
        this.dataBlock = source.dataBlock != null ? source.dataBlock.clone() : null;
        this.raw = source.raw;
    }

    @Override
    public JT808AckParams_0700_VtdrData clone() {
        JT808AckParams_0700_VtdrData r = new JT808AckParams_0700_VtdrData();
        r.assignFrom(this);
        return r;
    }
}
