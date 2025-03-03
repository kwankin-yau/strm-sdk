/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.protocol.msg.types.vtdr;

import java.util.StringJoiner;

import com.lucendar.strm.common.types.Expose;

/**
 * 记录仪参数修改记录
 */
@Expose
public class Vtdr_RevEvent implements Cloneable {

    private String time;
    private byte cmd;

    /**
     * 取事件时间, yyyy-MM-dd HH:mm:ss
     * @return 事件时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置事件时间, yyyy-MM-dd HH:mm:ss
     * @param time 事件时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 取设置参数命令字
     * @return 设置参数命令字
     */
    public byte getCmd() {
        return cmd;
    }

    /**
     * 设置设置参数命令字
     * @param cmd 设置参数命令字
     */
    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    @Override
    public Vtdr_RevEvent clone() {
        try {
            return (Vtdr_RevEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vtdr_RevEvent.class.getSimpleName() + "[", "]")
                .add("time='" + time + "'")
                .add("cmd=" + cmd)
                .toString();
    }
}
