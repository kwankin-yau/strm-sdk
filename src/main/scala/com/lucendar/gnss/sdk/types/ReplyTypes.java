/*
 * Copyright (c) 2024 lucendar.com.
 * All rights reserved.
 */
package com.lucendar.gnss.sdk.types;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.lucendar.strm.common.strm.KeepStrmResult;

import info.gratour.common.types.rest.Reply;

/**
 * 回复类型常量定义类
 */
public class ReplyTypes {

    /**
     * 保持流结果类型
     */
    public static final Type REPLY_TYPE__KEEP_STRM_RESULT = new TypeToken<Reply<KeepStrmResult>>(){}.getType();
}
