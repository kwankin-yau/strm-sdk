/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VtdrDataBlock;
import info.gratour.jtcommon.JTMsgId;

/**
 * 车辆行驶记录仪数据采集请求(0x8700)命令参数
 */
@JTMsgId(JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700)
@Expose
public class CP_8700_VtdrDataCollectReq implements JT808CmdParams {

    private byte cmd;
    private JT808VtdrDataBlock dataBlock;

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
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(CP_8700_VtdrDataCollectReq source) {
        this.cmd = source.cmd;
        this.dataBlock = source.dataBlock != null ? source.dataBlock.clone() : null;
    }

    @Override
    public CP_8700_VtdrDataCollectReq clone() {
        CP_8700_VtdrDataCollectReq r = new CP_8700_VtdrDataCollectReq();
        r.assignFrom(this);
        return r;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CP_8700_VtdrDataCollectReq.class.getSimpleName() + "[", "]")
                .add("cmd=" + cmd)
                .add("dataBlock=" + dataBlock)
                .toString();
    }
}
