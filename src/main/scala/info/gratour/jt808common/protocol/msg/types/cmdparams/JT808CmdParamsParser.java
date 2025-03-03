package info.gratour.jt808common.protocol.msg.types.cmdparams;

import com.google.gson.Gson;

import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

/**
 * JT808命令参数解析器接口
 */
public interface JT808CmdParamsParser {

    /**
     * 从JSON字符串解析命令参数
     * @param msgId 消息ID
     * @param json JSON字符串
     * @param gson Gson实例
     * @return 命令参数
     */
    default JT808CmdParams fromJson(String msgIdHex, String json, Gson gson) {
        return fromJson(JTUtils.hexToMsgId(msgIdHex), json, gson);
    }

    /**
     * 从JSON字符串解析命令参数
     * @param msgId 消息ID
     * @param json JSON字符串
     * @return 命令参数
     */
    default JT808CmdParams fromJson(int msgId, String json) {
        return fromJson(msgId, json, JTConsts.GSON());
    }

    /**
     * 从JSON字符串解析命令参数
     * @param msgIdHex 消息ID十六进制字符串
     * @param json JSON字符串
     * @return 命令参数
     */
    default JT808CmdParams fromJson(String msgIdHex, String json) {
        return fromJson(JTUtils.hexToMsgId(msgIdHex), json);
    }

}
