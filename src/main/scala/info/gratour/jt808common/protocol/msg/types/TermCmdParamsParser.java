package info.gratour.jt808common.protocol.msg.types;

import com.google.gson.Gson;
import info.gratour.jt808common.protocol.msg.types.ackparams.AckParamsParser$;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParamsParser;
import info.gratour.jt808common.protocol.msg.types.cmdparams.CmdParamsParser$;
import info.gratour.jt808common.protocol.msg.types.cmdparams.JT808CmdParams;
import info.gratour.jt808common.protocol.msg.types.cmdparams.JT808CmdParamsParser;
import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

/**
 * 终端命令参数解析器
 */
public class TermCmdParamsParser {

    /**
     * 默认实例
     */
    public static final TermCmdParamsParser DEFAULT =
            new TermCmdParamsParser(CmdParamsParser$.MODULE$, AckParamsParser$.MODULE$);

    private final JT808CmdParamsParser cmdParamsParser;
    private final JT808AckParamsParser ackParamsParser;

    /**
     * 构造函数
     * @param cmdParamsParser 命令参数解析器
     * @param ackParamsParser 确认参数解析器
     */
    public TermCmdParamsParser(JT808CmdParamsParser cmdParamsParser, JT808AckParamsParser ackParamsParser) {
        this.cmdParamsParser = cmdParamsParser;
        this.ackParamsParser = ackParamsParser;
    }

    /**
     * 从JSON字符串解析命令参数
     * @param msgId 消息ID
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 命令参数
     */
    public JT808CmdParams cmdParamsFromJson(int msgId, String json, Gson gson) {
        return cmdParamsParser.fromJson(msgId, json, gson);
    }

    /**
     * 从JSON字符串解析命令参数
     * @param msgIdHex 消息ID十六进制字符串
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 命令参数
     */
    public JT808CmdParams cmdParamsFromJson(String msgIdHex, String json, Gson gson) {
        return cmdParamsFromJson(JTUtils.hexToMsgId(msgIdHex), json, gson);
    }

    /**
     * 从JSON字符串解析命令参数
     * @param msgId 消息ID
     * @param json JSON字符串
     * @return 命令参数
     */
    public JT808CmdParams cmdParamsFromJson(int msgId, String json) {
        return cmdParamsFromJson(msgId, json, JTConsts.GSON());
    }

    /**
     * 从JSON字符串解析命令参数
     * @param msgIdHex 消息ID十六进制字符串
     * @param json JSON字符串
     * @return 命令参数
     */
    public JT808CmdParams cmdParamsFromJson(String msgIdHex, String json) {
        return cmdParamsFromJson(msgIdHex, json, JTConsts.GSON());
    }

    /**
     * 从JSON字符串解析应答参数
     * @param srcMsgId 源消息ID
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJsonBySrcMsgId(int srcMsgId, String json, Gson gson) {
        return ackParamsParser.fromJsonBySrcMsgId(srcMsgId, json, gson);
    }

    /**
     * 从JSON字符串解析应答参数
     * @param ackMsgId 应答消息ID
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJson(int ackMsgId, String json, Gson gson) {
        return ackParamsParser.fromJson(ackMsgId, json, gson);
    }

    /**
     * 从JSON字符串解析应答参数
     * @param srcMsgIdHex 源消息ID十六进制字符串
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJsonBySrcMsgId(String srcMsgIdHex, String json, Gson gson) {
        return ackParamsFromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json, gson);
    }

    /**
     * 从JSON字符串解析应答参数
     * @param srcMsgId 源消息ID
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJsonBySrcMsgId(int srcMsgId, String json) {
        return ackParamsFromJsonBySrcMsgId(srcMsgId, json, JTConsts.GSON());
    }

    /**
     * 从JSON字符串解析应答参数
     * @param srcMsgIdHex 源消息ID十六进制字符串
     * @param json JSON字符串
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJsonBySrcMsgId(String srcMsgIdHex, String json) {
        return ackParamsFromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json);
    }

    /**
     * 从JSON字符串解析应答参数
     * @param ackMsgId 应答消息ID
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJson(String ackMsgIdHex, String json, Gson gson) {
        return ackParamsFromJson(JTUtils.hexToMsgId(ackMsgIdHex), json, gson);
    }

    /**
     * 从JSON字符串解析应答参数
     * @param ackMsgId 应答消息ID
     * @param json JSON字符串
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJson(int ackMsgId, String json) {
        return ackParamsFromJson(ackMsgId, json, JTConsts.GSON());
    }

    /**
     * 从JSON字符串解析应答参数
     * @param ackMsgIdHex 应答消息ID十六进制字符串
     * @param json JSON字符串
     * @return 应答参数
     */
    public JT808AckParams ackParamsFromJson(String ackMsgIdHex, String json) {
        return ackParamsFromJson(JTUtils.hexToMsgId(ackMsgIdHex), json);
    }

}
