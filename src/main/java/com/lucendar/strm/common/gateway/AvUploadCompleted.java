/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.gateway;

import java.util.StringJoiner;

/**
 * SPI: 录像上传完成通知，对应JT1078-2016的1206消息的消息体
 */
public class AvUploadCompleted {

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;

    private int ackSeqNo;
    private byte result;

    /**
     * 取应答流水号
     *
     * @return 应答流水号
     */
    public int getAckSeqNo() {
        return ackSeqNo;
    }

    public void setAckSeqNo(int ackSeqNo) {
        this.ackSeqNo = ackSeqNo;
    }

    public boolean isSuccess() {
        return result == RESULT__SUCCESS;
    }

    /**
     * 取上传结果。为RESULT__XXXX值之一
     *
     * @return 上传结果
     */
    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public void setResult(boolean success) {
        this.result = success ? RESULT__SUCCESS : RESULT__FAILED;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AvUploadCompleted.class.getSimpleName() + "[", "]")
                .add("ackSeqNo=" + ackSeqNo)
                .add("result=" + result)
                .toString();
    }
}
