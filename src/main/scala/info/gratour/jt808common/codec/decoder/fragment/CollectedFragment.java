/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec.decoder.fragment;

import java.io.Closeable;

import info.gratour.jt808common.protocol.JT808Frame;

/**
 * 收集的分片终端消息报文
 */
public interface CollectedFragment extends Closeable {

    /**
     * 获取消息ID
     * @return 消息ID
     */
    int getMsgId();

    /**
     * 获取所有分片报文
     * @return 所有分片报文
     */
    JT808Frame[] getFrames();

    /**
     * 获取总分片数
     * @return 总分片数
     */
    int getTotalCount();

    /**
     * 获取已接收分片数
     * @return 已接收分片数
     */
    int getRecvCount();

    /**
     * 是否已接收所有分片
     * @return 是否已接收所有分片
     */
    boolean isAllFragmentReceived();

    /**
     * 关闭，释放资源
     */
    void close();
}
