/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.mat;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import info.gratour.jt808common.protocol.msg.types.ackparams.AckParamsParser;
import info.gratour.jt808common.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jt808common.spi.model.TermCmdStateChanged;
import info.gratour.jtcommon.JTConsts;

/**
 * TermCmdStateChanged 对象 GSON 自定义序列化器
 */
public class TermCmdStateChangedMaterializer
        implements JsonSerializer<TermCmdStateChanged>, JsonDeserializer<TermCmdStateChanged> {

    /**
     * 反序列化
     * @param json 序列化结果
     * @param typeOfT 目标对象类型
     * @param context 反序列化上下文
     * @return 反序列化结果
     */
    @Override
    public TermCmdStateChanged deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        TermCmdStateChanged r = new TermCmdStateChanged();
        JsonObject obj = (JsonObject) json;

        r.setAppId(obj.getAsJsonPrimitive("appId").getAsString());
        if (obj.has("uuid"))
            r.setUuid(obj.getAsJsonPrimitive("uuid").getAsString());
        r.setId(obj.getAsJsonPrimitive("id").getAsString());
        r.setExternalId(obj.getAsJsonPrimitive("externalId").getAsString());
        if (obj.has("reqId"))
            r.setReqId(obj.getAsJsonPrimitive("reqId").getAsString());
        r.setReqTm(obj.getAsJsonPrimitive("reqTm").getAsString());
        r.setStatus(obj.getAsJsonPrimitive("status").getAsInt());
        if (obj.has("tm"))
            r.setTm(obj.getAsJsonPrimitive("tm").getAsString());
        r.setInitMsgId(obj.getAsJsonPrimitive("initMsgId").getAsString());

        if (obj.has("subCmdTyp"))
            r.setSubCmdTyp(obj.getAsJsonPrimitive("subCmdTyp").getAsString());

        if (obj.has("msgSn"))
            r.setMsgSn(obj.getAsJsonPrimitive("msgSn").getAsInt());

        r.setSimNo(obj.getAsJsonPrimitive("simNo").getAsString());

        if (obj.has("plateNo"))
            r.setPlateNo(obj.getAsJsonPrimitive("plateNo").getAsString());

        if (obj.has("plateColor"))
            r.setPlateColor(obj.getAsJsonPrimitive("plateColor").getAsInt());

        if (obj.has("ackMsgId"))
            r.setAckMsgId(obj.getAsJsonPrimitive("ackMsgId").getAsString());

        if (obj.has("ackSeqNo"))
            r.setAckSeqNo(obj.getAsJsonPrimitive("ackSeqNo").getAsInt());

        if (obj.has("ackCode"))
            r.setAckCode(obj.getAsJsonPrimitive("ackCode").getAsInt());

        if (obj.has("ackParams")) {
            JsonObject jo = obj.getAsJsonObject("ackParams");
            String s = JTConsts.GSON().toJson(jo);
            r.setAckParams(AckParamsParser.fromJsonBySrcMsgId(r.getInitMsgId(), s));
        }

        if (obj.has("pub"))
            r.setPub(obj.getAsJsonPrimitive("pub").getAsString());

        return r;
    }

    /**
     * 序列化
     * @param src 源对象
     * @param typeOfSrc 源对象类型
     * @param context 序列化上下文
     * @return 序列化结果
     */
    @Override
    public JsonElement serialize(TermCmdStateChanged src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        String s;

        obj.addProperty("appId", src.getAppId());
        s = src.getUuid();
        if (s != null)
            obj.addProperty("uuid", s);
        obj.addProperty("id", src.getId());
        obj.addProperty("externalId", src.getExternalId());
        obj.addProperty("reqId", src.getReqId());
        obj.addProperty("reqTm", src.getReqTm());
        obj.addProperty("status", src.getStatus());
        s = src.getTm();
        if (s != null)
            obj.addProperty("tm", s);
        obj.addProperty("initMsgId", src.getInitMsgId());
        s = src.getSubCmdTyp();
        if (s != null)
            obj.addProperty("subCmdTyp", s);
        Integer i = src.getMsgSn();
        if (i != null)
            obj.addProperty("msgSn", i);
        obj.addProperty("simNo", src.getSimNo());
        s = src.getPlateNo();
        if (s != null)
            obj.addProperty("plateNo", s);
        i = src.getPlateColor();
        if (i != null)
            obj.addProperty("plateColor", i);
        s = src.getAckMsgId();
        if (s != null)
            obj.addProperty("ackMsgId", s);
        i = src.getAckSeqNo();
        if (i != null)
            obj.addProperty("ackSeqNo", i);
        i = src.getAckCode();
        if (i != null)
            obj.addProperty("ackCode", i);

        JT808AckParams ap = src.getAckParams();
        if (ap != null)
            obj.add("ackParams", context.serialize(ap));
        s = src.getPub();
        if (s != null)
            obj.addProperty("pub", s);

        return obj;
    }

}
