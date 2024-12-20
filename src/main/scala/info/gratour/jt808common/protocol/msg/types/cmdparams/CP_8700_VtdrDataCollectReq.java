/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.lucendar.strm.common.types.Expose;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jt808common.protocol.msg.types.vtdr.JT808VtdrDataBlock;
import info.gratour.jtcommon.JTMsgId;

import java.util.StringJoiner;

@JTMsgId(JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700)
@Expose
public class CP_8700_VtdrDataCollectReq implements JT808CmdParams {

    private byte cmd;
    private JT808VtdrDataBlock dataBlock;

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public JT808VtdrDataBlock getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(JT808VtdrDataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }

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
