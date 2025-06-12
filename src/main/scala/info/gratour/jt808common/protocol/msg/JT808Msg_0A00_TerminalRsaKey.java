/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg;

import java.util.Arrays;
import java.util.StringJoiner;

import info.gratour.jt808common.protocol.JT808FrameHeader;
import info.gratour.jt808common.protocol.JT808Msg;
import info.gratour.jt808common.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

/**
 * 终端RSA密钥消息 (0x0A00)
 */
@JTMsgId(JT808MsgConsts.TERMINAL_RSA_KEY_0x0A00)
public class JT808Msg_0A00_TerminalRsaKey extends JT808Msg {

    /**
     * 消息ID
     */
    public static final int MSG_ID = JT808MsgConsts.TERMINAL_RSA_KEY_0x0A00;

    /**
     * 构造函数
     */
    public JT808Msg_0A00_TerminalRsaKey() {
        setMsgId(MSG_ID);
    }

    /**
     * 构造函数
     * @param header 帧头
     */
    public JT808Msg_0A00_TerminalRsaKey(JT808FrameHeader header) {
        super(header);
    }

    private long e;
    private byte[] n;

    /**
     * 取e
     * @return e
     */
    public long getE() {
        return e;
    }

    /**
     * 设置e
     * @param e e
     */
    public void setE(long e) {
        this.e = e;
    }

    /**
     * 取n
     * @return n
     */
    public byte[] getN() {
        return n;
    }

    /**
     * 设置n
     * @param n n
     */
    public void setN(byte[] n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", JT808Msg_0A00_TerminalRsaKey.class.getSimpleName() + "[", "]")
                .add("e=" + e)
                .add("n=" + Arrays.toString(n))
                .toString();
    }
}
