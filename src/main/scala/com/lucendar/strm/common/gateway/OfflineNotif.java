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

    public String[] getSimNos() {
        return simNos;
    }

    public void setSimNos(String[] simNos) {
        this.simNos = simNos;
    }

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
