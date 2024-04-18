/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

import com.lucendar.strm.common.utils.StrmUtils;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * 抽象 A/V 上传请求对象
 */
public interface AbstractAvUpload {

    /**
     * Generate a new AV upload request ID.
     *
     * @param startTm The start time of the AV upload request. epoch millis.
     * @return the new request ID.
     */
    static String newAvUploadReqId(long startTm) {
        return StrmUtils.timeCodedId(startTm);
    }


    /**
     * Get the A/V upload request ID.
     *
     * @return A/V upload request ID.
     */
    String getReqId();

    /**
     * Get `simNo` of the terminal.
     *
     * @return `simNo` of the terminal.
     */
    String getSimNo();

    /**
     * Get the start time of the terminal stored AV file. Date time format: `yyyy-MM-dd HH:mm:ss`.
     *
     * @return start time of the terminal stored AV file.
     */
    String getStartTm();

    /**
     * The claimed size or actual size of the A/V file.
     *
     * @return claimed size or actual size of the A/V file.
     */
    @Nullable
    Long getSz();

    /**
     * Get the base callback url of FTP notification(for `/upload` and `/upload/progress`).
     *
     * @return base callback url of FTP notification.
     */
    String getCb();
}
