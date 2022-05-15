package com.lucendar.strm.common.strm;

import java.util.StringJoiner;

public class StrmTraceEntry {
    private String simNo;
    private String startTraceTime;

    public StrmTraceEntry() {
    }

    public StrmTraceEntry(String simNo, String startTraceTime) {
        this.simNo = simNo;
        this.startTraceTime = startTraceTime;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getStartTraceTime() {
        return startTraceTime;
    }

    public void setStartTraceTime(String startTraceTime) {
        this.startTraceTime = startTraceTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmTraceEntry.class.getSimpleName() + "[", "]")
                .add("simNo='" + simNo + "'")
                .add("startTraceTime='" + startTraceTime + "'")
                .toString();
    }
}
