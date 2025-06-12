/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.cmdparams;

import java.util.ArrayList;
import java.util.List;

import com.lucendar.strm.common.types.Expose;

import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileItemWithType;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttReTransFileBlock;
import info.gratour.jtcommon.JTMsgId;

/**
 * ADAS报警附件上传完成(0x9212)命令参数
 */
@JTMsgId(JTAdasMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_9212)
@Expose
public class CP_9212_AlmAttFileItemCompleted implements JT808CmdParams {

    /**
     * 结果：完成
     */
    public static final byte RESULT__COMPLETED = 0;

    /**
     * 结果：重传需要
     */
    public static final byte RESULT__RETRANSMIT_NEEDED = 1;

    private AlmAttFileItemWithType fileItem;
    private List<AlmAttReTransFileBlock> reTransFileBlocks;

    /**
     * 取附件文件
     * @return 附件文件
     */
    public AlmAttFileItemWithType getFileItem() {
        return fileItem;
    }

    /**
     * 设置附件文件
     * @param fileItem 附件文件
     */
    public void setFileItem(AlmAttFileItemWithType fileItem) {
        this.fileItem = fileItem;
    }

    /**
     * 取重传需要附件文件块
     * @return 重传需要附件文件块
     */
    public List<AlmAttReTransFileBlock> getReTransFileBlocks() {
        return reTransFileBlocks;
    }

    /**
     * 设置重传需要附件文件块
     * @param reTransFileBlocks 重传需要附件文件块
     */
    public void setReTransFileBlocks(List<AlmAttReTransFileBlock> reTransFileBlocks) {
        this.reTransFileBlocks = reTransFileBlocks;
    }

    @Override
    public String toString() {
        return "CP_9212_AlmAttFileItemCompleted{" +
                "fileItem=" + fileItem +
                ", reTransFileBlocks=" + reTransFileBlocks +
                '}';
    }

    /**
     * 从源对象赋值
     * @param source 源对象
     */
    public void assignFrom(CP_9212_AlmAttFileItemCompleted source) {
        this.fileItem = source.fileItem != null ? source.fileItem.clone() : null;
        if (source.reTransFileBlocks != null) {
            this.reTransFileBlocks = new ArrayList<>();
            for (AlmAttReTransFileBlock b : source.reTransFileBlocks) {
                this.reTransFileBlocks.add(b.clone());
            }
        } else
            this.reTransFileBlocks = null;
    }

    @Override
    public CP_9212_AlmAttFileItemCompleted clone() {
        CP_9212_AlmAttFileItemCompleted r = new CP_9212_AlmAttFileItemCompleted();
        r.assignFrom(this);
        return r;
    }
}
