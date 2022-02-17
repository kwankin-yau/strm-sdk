/*******************************************************************************
 *  Copyright (c) 2019, 2022 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package com.lucendar.strm.common.strm.stat;

import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * Streaming activities statistics
 */
public class StrmStat {

    private LocalDate date;
    private int liveAv;
    private int liveA;
    private int liveV;
    private int liveTalk;
    private int replay;
    private int successPeak;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLiveAv() {
        return liveAv;
    }

    public void setLiveAv(int liveAv) {
        this.liveAv = liveAv;
    }

    public void incLiveAv() {
        this.liveAv += 1;
    }

    public int getLiveA() {
        return liveA;
    }

    public void setLiveA(int liveA) {
        this.liveA = liveA;
    }

    public void incLiveA() {
        this.liveA += 1;
    }

    public int getLiveV() {
        return liveV;
    }

    public void setLiveV(int liveV) {
        this.liveV = liveV;
    }

    public void incLiveV() {
        this.liveV += 1;
    }

    public int getLiveTalk() {
        return liveTalk;
    }

    public void setLiveTalk(int liveTalk) {
        this.liveTalk = liveTalk;
    }

    public void incLiveTalk() {
        this.liveTalk += 1;
    }

    public int getReplay() {
        return replay;
    }

    public void setReplay(int replay) {
        this.replay = replay;
    }

    public void incReplay() {
        this.replay += 1;
    }

    public int getSuccessPeak() {
        return successPeak;
    }

    public void setSuccessPeak(int successPeak) {
        this.successPeak = successPeak;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmStat.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("liveAv=" + liveAv)
                .add("liveA=" + liveA)
                .add("liveV=" + liveV)
                .add("liveTalk=" + liveTalk)
                .add("replay=" + replay)
                .add("successPeak=" + successPeak)
                .toString();
    }
}
