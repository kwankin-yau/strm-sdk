/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import java.util.ArrayList;
import java.util.List;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JTAdasMsgConsts;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileItem;
import info.gratour.jtcommon.JTMsgId;

/**
 * ADAS报警附件文件列表消息 (0x1210)
 */
@JTMsgId(JTAdasMsgConsts.ALM_ATT_FILE_LIST_1210)
public class JTAdasMsg_1210_FileList extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JTAdasMsgConsts.ALM_ATT_FILE_LIST_1210;

    /**
     * 正常
     */
    public static final byte KIND__NORMAL = 0;

    /**
     * 重发
     */
    public static final byte KIND__RETRANSMIT = 1;

    /**
     * 构造函数
     */
    public JTAdasMsg_1210_FileList() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JTAdasMsg_1210_FileList(JT808FrameHeader header) {
        super(header);
    }

    private String termId;
    private String almNo;
    private String platformAlmId;
    private byte kind;
    private List<AlmAttFileItem> fileList;

    /**
     * 获取终端ID
     * @return 终端ID
     */
    public String getTermId() {
        return termId;
    }

    /**
     * 设置终端ID
     * @param termId 终端ID
     */
    public void setTermId(String termId) {
        this.termId = termId;
    }

    /**
     * 获取报警识别号
     * @return 报警识别号
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警识别号
     * @param almNo 报警识别号
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    /**
     * 获取平台报警编号
     * @return 平台报警编号
     */
    public String getPlatformAlmId() {
        return platformAlmId;
    }

    /**
     * 设置平台报警编号
     * @param platformAlmId 平台报警编号
     */
    public void setPlatformAlmId(String platformAlmId) {
        this.platformAlmId = platformAlmId;
    }

    /**
     * 获取信息类型
     * @return 信息类型
     */
    public byte getKind() {
        return kind;
    }

    /**
     * 设置信息类型
     * @param kind 信息类型
     */
    public void setKind(byte kind) {
        this.kind = kind;
    }

    /**
     * 获取文件列表
     * @return 文件列表
     */
    public List<AlmAttFileItem> getFileList() {
        return fileList;
    }

    /**
     * 设置文件列表
     * @param fileList 文件列表
     */
    public void setFileList(List<AlmAttFileItem> fileList) {
        this.fileList = fileList;
    }

    /**
     * 添加文件
     * @param fileItem 文件
     */
    public void addFile(AlmAttFileItem fileItem) {
        if (this.fileList == null)
            this.fileList = new ArrayList<>();

        this.fileList.add(fileItem);
    }

    @Override
    public String toString() {
        return "JTAdasMsg_1210_FileList{" +
                "termId='" + termId + '\'' +
                ", almNo='" + almNo + '\'' +
                ", platformAlmId='" + platformAlmId + '\'' +
                ", kind=" + kind +
                ", fileList=" + fileList +
                '}';
    }
}
