/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.almatt;


import com.google.gson.reflect.TypeToken;
import com.lucendar.gnss.sdk.alm.Alm;
import com.lucendar.strm.common.types.RelativeFileNameProvider;
import com.lucendar.strm.common.utils.StrmUtils;
import info.gratour.common.types.rest.Reply;
import org.w3c.dom.TypeInfo;

import java.lang.reflect.Type;
import java.util.StringJoiner;

/**
 * 主动安全报警附件信息。本类的字符串时间值采用北京时间，格式为：yyyy-MM-dd HH:mm:ss
 */
public class AlmAtt implements Cloneable, RelativeFileNameProvider {

    /**
     * `Reply&lt;AlmAtt&gt;`的类型信息，用于 GSON 序列化
     */
    public static final Type REPLY_TYPE = new TypeToken<Reply<AlmAtt>>(){}.getType();

    /**
     * 平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     */
    private String id;

    /**
     * 报警时间（平台接收或从终端 ADAS 报警编号中解释得出），格式：yyyy-MM-dd HH:mm:ss
     */
    private String tm1;

    /**
     * ADAS 报警类型，常为4位数字，参见 AdasAlmTypes (strm-sdk中定义)
     */
    private String adasTyp;

    /**
     * 报警级别
     */
    private Integer almLvl;

    /**
     * 终端识别号，只用于创建AlmAtt记录时
     */
    private String simNo;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型:
     * 0: 图片（全景图）
     * 1: 音频
     * 2: 视频
     * 3: 文本
     * 4: 面部特征图片
     *
     */
    private short typ;

    /**
     * 文件接收完成时间, yyyy-MM-dd HH:mm:ss
     */
    private String fileTm;

    /**
     * 文件大小，字节数
     */
    private long sz;

    /**
     * 在bucket内的路径，包括前面的 `/`，但不包括后面的 `/`
     */
    private String path;

    /**
     * 文件的下载 URL
     */
    private String url;

    /**
     * 取平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     * @return 平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     */
    public String getId() {
        return id;
    }

    /**
     * 设置平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     * @param id 平台报警ID 或 终端 ADAS 报警编号的 HEX 形式
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取报警开始时间
     *
     * @return 报警开始时间
     */
    public String getTm1() {
        return tm1;
    }

    /**
     * 设置报警开始时间
     * @param tm1 报警开始时间
     */
    public void setTm1(String tm1) {
        this.tm1 = tm1;
    }

    /**
     * 取 ADAS 报警类型代码，常为4位数字，参见 AdasAlmTypes (strm-sdk中定义)
     * @return ADAS 报警类型代码
     */
    public String getAdasTyp() {
        return adasTyp;
    }

    /**
     * 设置 ADAS 报警类型，常为4位数字，参见 AdasAlmTypes (strm-sdk中定义)
     * @param adasTyp ADAS 报警类型
     */
    public void setAdasTyp(String adasTyp) {
        this.adasTyp = adasTyp;
    }

    /**
     * 取报警级别
     *
     * @return 报警级别
     */
    public Integer getAlmLvl() {
        return almLvl;
    }

    /**
     * 设置报警级别
     * @param almLvl 报警级别
     */
    public void setAlmLvl(Integer almLvl) {
        this.almLvl = almLvl;
    }

    /**
     * 取终端识别号
     *
     * @return 终端识别号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置终端识别号
     *
     * @param simNo 终端识别号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    /**
     * 取文件名
     * @return 文件名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件名
     * @param name 文件名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 取文件类型，为下列常量之一
     * <ul>
     *     <li>0: 图片（全景图）</li>
     *     <li>1: 音频</li>
     *     <li>2: 视频</li>
     *     <li>3: 文本</li>
     *     <li>4: 面部特征图片</li>
     * </ul>
     * @return 文件类型
     */
    public short getTyp() {
        return typ;
    }

    /**
     * 设置文件类型
     * @param typ  文件类型
     */
    public void setTyp(short typ) {
        this.typ = typ;
    }

    /**
     * 取文件接收完成时间
     * @return 文件接收完成时间
     */
    public String getFileTm() {
        return fileTm;
    }

    /**
     * 设置文件接收完成时间
     * @param fileTm 文件接收完成时间
     */
    public void setFileTm(String fileTm) {
        this.fileTm = fileTm;
    }

    /**
     * 取文件大小，字节数
     * @return 文件大小，字节数
     */
    public long getSz() {
        return sz;
    }

    /**
     * 设置文件大小，字节数
     * @param sz 文件大小，字节数
     */
    public void setSz(long sz) {
        this.sz = sz;
    }

    /**
     * 返回在bucket内的路径，包括前面的 `/`，但不包括后面的 `/`
     * @return 在bucket内的路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置在bucket内的路径
     * @param path 在bucket内的路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取文件的下载 URL
     * @return 文件的下载 URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文件的下载 URL
     * @param url 文件的下载 URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 将文件名和文件路径拼接成一个带路径的文件名（并不是可直接访问的全文件名）
     *
     * @param withLeadingForwardSlash 返回的带路径文件名是否包含前面的 `/` 符号
     * @return 带路径的文件名
     */
    public String fileNameWithPath(boolean withLeadingForwardSlash) {
        return StrmUtils.calcFileNameWithPath(path, name, withLeadingForwardSlash);
    }

    @Override
    public AlmAtt clone() {
        try {
            return (AlmAtt) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlmAtt.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("tm1='" + tm1 + "'")
                .add("adasTyp='" + adasTyp + "'")
                .add("almLvl=" + almLvl)
                .add("simNo='" + simNo + "'")
                .add("name='" + name + "'")
                .add("typ=" + typ)
                .add("fileTm='" + fileTm + "'")
                .add("sz=" + sz)
                .add("path='" + path + "'")
                .add("url='" + url + "'")
                .toString();
    }

    @Override
    public String relativeFileName() {
        return fileNameWithPath(false);
    }
}
