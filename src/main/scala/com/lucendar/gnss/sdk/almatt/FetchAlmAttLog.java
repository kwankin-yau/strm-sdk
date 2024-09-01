package com.lucendar.gnss.sdk.almatt;

import com.lucendar.common.utils.DateTimeUtils;
import com.lucendar.gnss.sdk.GnssConsts;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileItemWithType;
import info.gratour.jt808common.protocol.msg.types.almatt.AlmAttFileList;
import info.gratour.jt808common.spi.model.TermCmd;
import info.gratour.jt808common.spi.model.TermCmdStateChanged;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 提取主动安全附件日志记录
 */
public class FetchAlmAttLog {

    /**
     * 重复的提取主动安全附件请求
     */
    public static class FetchAlmAttReqDuplicated extends FetchAlmAttReq {

        private String taskId;

        /**
         * 取当时正在执行的任务ID
         * @return 当时正在执行的任务ID
         */
        public String getTaskId() {
            return taskId;
        }

        /**
         * 设置当时正在执行的任务ID
         * @param taskId 当时正在执行的任务ID
         */
        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", FetchAlmAttReqDuplicated.class.getSimpleName() + "[", "]")
                    .add("taskId='" + taskId + "'")
                    .toString();
        }
    }

    /**
     * 提取主动安全附件任务结束事件数据
     */
    public static class FetchAlmAttJobEndEvtData {

        private List<AlmAtt> attList;

        /**
         * 取已接收的报警附件列表
         * @return 已接收的报警附件列表
         */
        public List<AlmAtt> getAttList() {
            return attList;
        }

        /**
         * 设置已接收的报警附件列表
         * @param attList 已接收的报警附件列表
         */
        public void setAttList(List<AlmAtt> attList) {
            this.attList = attList;
        }

        public void add(AlmAtt att) {
            if (attList == null)
                attList = new ArrayList<>();

            attList.add(att);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", FetchAlmAttJobEndEvtData.class.getSimpleName() + "[", "]")
                    .add("attList=" + attList)
                    .toString();
        }
    }

    /**
     * 事件类型：收到提取附件请求，开始执行。此时 evtData 的结构为 `FetchAlmAttReq`
     */
    public static final String EVT_TYP__REQ = "req";

    /**
     * 事件类型：收到提取附件请求，但请求当前正在执行。此时 evtData 的结构为 `FetchAlmAttReq`。
     */
    public static final String EVT_TYP__REQ_DUP = "reqDuplicated";

    /**
     * 事件类型：下发指令。此时 evtData 的结构为 `TermCmd`
     */
    public static final String EVT_TYP__CMD = "cmd";

    /**
     * 事件类型：指令应答。此时 evtData 的结构为 `TermCmdStateChanged`
     */
    public static final String EVT_TYP__ACK = "ack";

    /**
     * 事件类型：收到文件列表。此时 evtData 的结构为 `AlmAttFileList`
     */
    public static final String EVT_TYP__FILE_LIST = "fileList";

    /**
     * 事件类型：开始传输文件。此时 evtData 的结构为 `AlmAttFileItemWithType`
     */
    public static final String EVT_TYP__FILE = "file";

    /**
     * 事件类型：单个文件传输结束。此时 evtData 的结构为 `AlmAttFileItemWithType`
     */
    public static final String EVT_TYP__FILE_RECEIVED = "fileReceived";

    /**
     * 事件类型：提取任务结束。此时 evtData 的结构为 `FetchAlmAttJobEndEvtData`
     */
    public static final String EVT_TYP__JOB_END = "jobEnd";

    /**
     * 事件类型：告警。此时 evtData 为字符串文本
     */
    public static final String EVT_TYP__WARNING = "warning";

    private long id;
    private String taskId;
    private String almNo;
    private String simNo;
    private String evtTyp;
    private long evtTm;
    private String evtData;

    /**
     * 取日志记录ID
     * @return 日志记录ID
     */
    public long getId() {
        return id;
    }

    /**
     * 设置日志记录ID
     * @param id 日志记录ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 取提取任务ID
     * @return 提取任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置提取任务ID
     * @param taskId 提取任务ID
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 取报警标识号(HEX)
     * @return 报警标识号(HEX)
     */
    public String getAlmNo() {
        return almNo;
    }

    /**
     * 设置报警标识号(HEX)
     * @param almNo 报警标识号(HEX)
     */
    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

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
     * 取事件类型代码，为  EVT_TYP__xxx 系列常量之一。事件类型和事件数据结构的关系，详见各事件类型常量的注释
     *
     * @return 事件类型代码
     */
    public String getEvtTyp() {
        return evtTyp;
    }

    /**
     * 设置事件类型代码
     * @param evtTyp 事件类型代码，为  EVT_TYP__xxx 系列常量之一
     */
    public void setEvtTyp(String evtTyp) {
        this.evtTyp = evtTyp;
    }

    /**
     * 取事件时间
     * @return 事件时间, epoch millis
     */
    public long getEvtTm() {
        return evtTm;
    }

    public OffsetDateTime evtTm() {
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(evtTm), DateTimeUtils.defaultZoneOffset());
    }

    /**
     * 设置事件时间
     * @param evtTm 事件时间，epoch millis
     */
    public void setEvtTm(long evtTm) {
        this.evtTm = evtTm;
    }

    /**
     * 取事件数据
     * @return 事件数据。为 JSON 字符串或简单文本字符串，具体结构依 `evtTyp` 属性的不同而不同
     */
    public String getEvtData() {
        return evtData;
    }

    /**
     * 设置事件数据
     * @param evtData 事件数据。为 JSON 字符串或简单文本字符串，具体结构依 `evtTyp` 属性的不同而不同
     */
    public void setEvtData(String evtData) {
        this.evtData = evtData;
    }

    public FetchAlmAttLog setEvtTyp_req(FetchAlmAttReq req) {
        this.evtTyp = EVT_TYP__REQ;
        this.evtData = GnssConsts.GSON.toJson(req);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_reqDuplicated(FetchAlmAttReq req) {
        this.evtTyp = EVT_TYP__REQ_DUP;
        this.evtData = GnssConsts.GSON.toJson(req);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_cmd(TermCmd termCmd) {
        this.evtTyp = EVT_TYP__CMD;
        this.evtData = GnssConsts.GSON.toJson(termCmd);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_ack(TermCmdStateChanged cmdStateChanged) {
        this.evtTyp = EVT_TYP__ACK;
        this.evtData = GnssConsts.GSON.toJson(cmdStateChanged);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_fileList(AlmAttFileList fileList) {
        this.evtTyp = EVT_TYP__FILE_LIST;
        this.evtData = GnssConsts.GSON.toJson(fileList);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_file(AlmAttFileItemWithType file) {
        this.evtTyp = EVT_TYP__FILE;
        this.evtData = GnssConsts.GSON.toJson(file);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_fileReceived(AlmAttFileItemWithType file) {
        this.evtTyp = EVT_TYP__FILE_RECEIVED;
        this.evtData = GnssConsts.GSON.toJson(file);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_jobEnd(FetchAlmAttJobEndEvtData evtData) {
        this.evtTyp = EVT_TYP__JOB_END;
        this.evtData = GnssConsts.GSON.toJson(evtData);
        return this;
    }

    public FetchAlmAttLog setEvtTyp_warning(String message) {
        this.evtTyp = EVT_TYP__WARNING;
        this.evtData = message;
        return this;
    }

    public static FetchAlmAttLog create(String almNo, String simNo, String taskId, long evtTm) {
        FetchAlmAttLog r = new FetchAlmAttLog();
        r.setAlmNo(almNo);
        r.setSimNo(simNo);
        r.setTaskId(taskId);
        r.setEvtTm(evtTm);

        return r;
    }

    public static FetchAlmAttLog create(String almNo, String simNo, String taskId) {
        return create(almNo, simNo, taskId, System.currentTimeMillis());
    }

    public static FetchAlmAttLog create(FetchAlmAttTask task, long evtTm) {
        return create(task.getAlmNo(), task.getSimNo(), task.getTaskId(), evtTm);
    }

    public static FetchAlmAttLog create(FetchAlmAttTask task) {
        return create(task, System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FetchAlmAttLog.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("taskId='" + taskId + "'")
                .add("almNo='" + almNo + "'")
                .add("simNo='" + simNo + "'")
                .add("evtTyp='" + evtTyp + "'")
                .add("evtTm=" + evtTm)
                .add("evtData='" + evtData + "'")
                .toString();
    }
}
