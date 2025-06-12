package info.gratour.jt808common.protocol.msg.types.ackparams;

import com.google.gson.Gson;

import info.gratour.jtcommon.JTConsts;
import info.gratour.jtcommon.JTUtils;

/**
 * 应答参数解析器
 */
public interface JT808AckParamsParser {

    /**
     * 根据源消息 ID 解析 JSON 字符串，获取应答参数
     * @param srcMsgId 源消息 ID
     * @param json JSON 字符串
     * @param gson Gson 实例
     * @return 应答参数
     */
    JT808AckParams fromJsonBySrcMsgId(int srcMsgId, String json, Gson gson);

    /**
     * 根据应答消息 ID 解析 JSON 字符串，获取应答参数
     * @param ackMsgId 应答消息 ID
     * @param json JSON 字符串
     * @param gson Gson 实例
     * @return 应答参数
     */
    JT808AckParams fromJson(int ackMsgId, String json, Gson gson);


    /**
     * 根据源消息 ID 解析 JSON 字符串，获取应答参数
     * @param srcMsgIdHex 源消息 ID 十六进制字符串
     * @param json JSON 字符串
     * @param gson Gson 实例
     * @return 应答参数
     */
    default JT808AckParams fromJsonBySrcMsgId(String srcMsgIdHex, String json, Gson gson) {
        return fromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json, gson);
    }

    /**
     * 根据源消息 ID 解析 JSON 字符串，获取应答参数
     * @param srcMsgId 源消息 ID
     * @param json JSON 字符串
     * @return 应答参数
     */
    default JT808AckParams fromJsonBySrcMsgId(int srcMsgId, String json) {
        return fromJsonBySrcMsgId(srcMsgId, json, JTConsts.GSON());
    }


    /**
     * 根据源消息 ID 解析 JSON 字符串，获取应答参数
     * @param srcMsgIdHex 源消息 ID 十六进制字符串
     * @param json JSON 字符串
     * @return 应答参数
     */
    default JT808AckParams fromJsonBySrcMsgId(String srcMsgIdHex, String json) {
        return fromJsonBySrcMsgId(JTUtils.hexToMsgId(srcMsgIdHex), json);
    }

    /**
     * 根据应答消息 ID 解析 JSON 字符串，获取应答参数
     * @param ackMsgIdHex 应答消息 ID 十六进制字符串
     * @param json JSON 字符串
     * @param gson Gson 实例
     * @return 应答参数
     */
    default JT808AckParams fromJson(String ackMsgIdHex, String json, Gson gson) {
        return fromJson(JTUtils.hexToMsgId(ackMsgIdHex), json, gson);
    }

    /**
     * 根据应答消息 ID 解析 JSON 字符串，获取应答参数
     * @param ackMsgId 应答消息 ID
     * @param json JSON 字符串
     * @return 应答参数
     */
    default JT808AckParams fromJson(int ackMsgId, String json) {
        return fromJson(ackMsgId, json, JTConsts.GSON());
    }

    /**
     * 根据应答消息 ID 解析 JSON 字符串，获取应答参数
     * @param ackMsgIdHex 应答消息 ID 十六进制字符串
     * @param json JSON 字符串
     * @return 应答参数
     */
    default JT808AckParams fromJson(String ackMsgIdHex, String json) {
        return fromJson(JTUtils.hexToMsgId(ackMsgIdHex), json);
    }



}
