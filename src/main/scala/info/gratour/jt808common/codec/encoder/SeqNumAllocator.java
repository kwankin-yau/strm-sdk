/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec.encoder;

/**
 * 流水号分配器
 */
public interface SeqNumAllocator {

    /**
     * 获取下一个流水号
     * @return 下一个流水号
     */
    int nextSeqNo();
}
