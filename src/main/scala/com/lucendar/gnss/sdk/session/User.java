/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.gnss.sdk.session;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import com.lucendar.strm.common.StreamingApi;

/**
 * 用户对象
 */
public class User implements Cloneable {

    /**
     * ADMIN 授权
     */
    public static final String AUTHORITY__ADMIN = "admin";

    private String userName;
    private String password;
    private String pwdSeed;
    private String pwdMd5;
    private String appId;
    private Set<String> authorities;

    /**
     * 取用户名
     *
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 取密码。此属性仅用于创建用户时，数据库不存储此属性，查询用户信息时，无此属性。
     *
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码，此属性仅用于创建用户时，数据库不存储此属性，查询用户信息时，无此属性。
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 取密码的 seed。此 seed 用于编码 `pwdMd5`
     *
     * @return 密码的 seed
     */
    public String getPwdSeed() {
        return pwdSeed;
    }

    /**
     * 设置密码的 seed
     *
     * @param pwdSeed 密码的 seed
     */
    public void setPwdSeed(String pwdSeed) {
        this.pwdSeed = pwdSeed;
    }

    /**
     * 取密码的MD5，HEX格式
     *
     * @return 密码的MD5，HEX格式
     */
    public String getPwdMd5() {
        return pwdMd5;
    }

    /**
     * 设置密码的MD5，HEX格式。pwdMd5 = HEX(pwdSeed + password)
     *
     * @param pwdMd5 密码的MD5的 HEX 码
     */
    public void setPwdMd5(String pwdMd5) {
        this.pwdMd5 = pwdMd5;
    }

    /**
     * 取用户所属 AppId
     *
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置用户所属 AppId
     *
     * @param appId 用户所属 AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 验证给定的 `password`（用 `pwdSeed` 和 `pwdMd5`属性）
     *
     * @param password 密码
     * @return 密码验证是否通过
     */
    public boolean validate(String password) {
        String s = pwdSeed + password;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(s.getBytes(StandardCharsets.UTF_8));
            String hex = HexFormat.of().formatHex(md5);
            return Objects.equals(hex, pwdMd5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 取 AppId，如果未设置，返回默认 AppId
     *
     * @return AppId
     */
    public String appIdDef() {
        if (appId != null)
            return StreamingApi.DEFAULT_APP_ID;
        else
            return null;
    }

    /**
     * 取用户的已有授权
     *
     * @return 用户的已有授权
     */
    public Set<String> getAuthorities() {
        return authorities;
    }

    /**
     * 设置用户的已有授权
     *
     * @param authorities 用户的已有授权
     */
    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    /**
     * 增加授权到用户
     *
     * @param authority 授权ID
     */
    public void addAuthority(String authority) {
        if (this.authorities == null)
            this.authorities = new TreeSet<>();

        this.authorities.add(authority);
    }

    /**
     * 移除用户的某项授权
     *
     * @param authority 气概移除的授权ID
     */
    public void removeAuthority(String authority) {
        if (this.authorities != null)
            this.authorities.remove(authority);
    }

    /**
     * 检查该用户是否有某个授权
     *
     * @param authority 授权ID
     * @return 是否有指定的授权
     */
    public boolean hasAuthority(String authority) {
        if (authorities != null)
            return authorities.contains(authority);
        else
            return false;
    }

    /**
     * 返回当前用户是否具有 `admin` 授权
     * @return 当前用户是否具有 `admin` 授权
     */
    public boolean isAdmin() {
        return hasAuthority(AUTHORITY__ADMIN);
    }

    /**
     * To string, received by a StringJoiner.
     * @param joiner The StringJoiner used to receive the fields.
     */
    public void toString(StringJoiner joiner) {
        joiner.add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .add("pwdSeed='" + pwdSeed + "'")
                .add("pwdMd5='" + pwdMd5 + "'")
                .add("appId='" + appId + "'")
                .add("authorities=" + String.join(",", authorities));
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", getClass().getSimpleName() + "[", "]");
        toString(joiner);
        return joiner.toString();
    }

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
