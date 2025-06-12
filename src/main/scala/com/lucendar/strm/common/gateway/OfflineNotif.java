/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.gateway;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * SPI: 终端下线通知
 */
public class OfflineNotif {

    private String[] simNos;

    /**
     * 获取终端识别号列表
     * @return 终端识别号列表
     */
    public String[] getSimNos() {
        return simNos;
    }

    /**
     * 设置终端识别号列表
     * @param simNos 终端识别号列表
     */
    public void setSimNos(String[] simNos) {
        this.simNos = simNos;
    }

    /**
     * 判断终端识别号列表是否为空
     * @return 如果终端识别号列表为空，则返回 true，否则返回 false
     */
    public boolean isEmpty() {
        return simNos != null && simNos.length > 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OfflineNotif.class.getSimpleName() + "[", "]")
                .add("simNos=" + Arrays.toString(simNos))
                .toString();
    }
}
