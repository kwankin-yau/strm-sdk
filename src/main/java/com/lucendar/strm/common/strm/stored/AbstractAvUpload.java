/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stored;

public interface AbstractAvUpload {

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
    Long getSz();

    /**
     * Get the base callback url of FTP notification(for `/upload` and `/upload/progress`).
     *
     * @return base callback url of FTP notification.
     */
    String getCb();
}
