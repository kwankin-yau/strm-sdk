/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common;

public class GnssApi {

    public static class Session {

        public static class LoginReq {

            private String userName;
            private String password;
            private String typ;
            private String lang;

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getTyp() {
                return typ;
            }

            public void setTyp(String typ) {
                this.typ = typ;
            }

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            @Override
            public String toString() {
                return "LoginReq{" +
                        "userName='" + userName + '\'' +
                        ", password='" + password + '\'' +
                        ", typ='" + typ + '\'' +
                        ", lang='" + lang + '\'' +
                        '}';
            }
        }

        public static class LoginResult {
            private String authToken;

            public String getAuthToken() {
                return authToken;
            }

            public void setAuthToken(String authToken) {
                this.authToken = authToken;
            }

            @Override
            public String toString() {
                return "LoginResult{" +
                        "authToken='" + authToken + '\'' +
                        '}';
            }
        }
    }



}
