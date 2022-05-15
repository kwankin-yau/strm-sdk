package com.lucendar.strm.common.strm.stat;

import com.lucendar.strm.common.strm.StrmStatSampling;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.util.StringJoiner;

public class StrmServerStat {
        private String version;
        private long startupTime;
        private Double systemLoadAverage; // null for not available
        private Double procCpuLoad; // null for not available
        private Double sysCpuLoad; // null for not available
        private MemoryUsage heapMemoryUsage;
        private MemoryUsage nonHeapMemoryUsage;
        private int threadCount;
        private int deadLockThreads;

        private StrmStatSampling audioProcessDelay;
        private StrmStatSampling videoProcessDelay;
        private StrmStatSampling flvAvProcessDelay;

        private static Double[] cpuLoads(MBeanServer server) {
            try {
                ObjectName n = ObjectName.getInstance("java.lang:type=OperatingSystem");
                AttributeList list = server.getAttributes(n, new String[]{"ProcessCpuLoad", "SystemCpuLoad"});
                Double[] r = new Double[2];
                for (int i = 0; i < list.size(); i++) {
                    Attribute att = (Attribute) list.get(i);
                    switch (att.getName()) {
                        case "ProcessCpuLoad":
                            double v = (Double) att.getValue();
                            if (v >= 0)
                                r[0] = Math.round(v * 1000) / 10d;
                            break;

                        case "SystemCpuLoad":
                            v = (Double) att.getValue();
                            if (v >= 0)
                                r[1] = Math.round(v * 1000) / 10d;
                            break;
                    }
                }

                return r;
            } catch (MalformedObjectNameException | ReflectionException | InstanceNotFoundException e) {
                return null;
            }
        }

        public static StrmServerStat get() {
            StrmServerStat r = new StrmServerStat();
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            Double[] loads = cpuLoads(server);
            if (loads != null) {
                r.procCpuLoad = loads[0];
                r.sysCpuLoad = loads[1];
            }
            double d = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
            if (d >= 0)
                r.systemLoadAverage = d;
            MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
            r.heapMemoryUsage = mem.getHeapMemoryUsage();
            r.nonHeapMemoryUsage = mem.getNonHeapMemoryUsage();
            ThreadMXBean t = ManagementFactory.getThreadMXBean();
            r.threadCount = t.getThreadCount();
            long[] arr = t.findDeadlockedThreads();
            if (arr != null)
                r.deadLockThreads = arr.length;
            else
                r.deadLockThreads = 0;

            return r;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public long getStartupTime() {
            return startupTime;
        }

        public void setStartupTime(long startupTime) {
            this.startupTime = startupTime;
        }

        public Double getProcCpuLoad() {
            return procCpuLoad;
        }

        public void setProcCpuLoad(Double procCpuLoad) {
            this.procCpuLoad = procCpuLoad;
        }

        public Double getSysCpuLoad() {
            return sysCpuLoad;
        }

        public void setSysCpuLoad(Double sysCpuLoad) {
            this.sysCpuLoad = sysCpuLoad;
        }

        public Double getSystemLoadAverage() {
            return systemLoadAverage;
        }

        public void setSystemLoadAverage(Double systemLoadAverage) {
            this.systemLoadAverage = systemLoadAverage;
        }

        public MemoryUsage getHeapMemoryUsage() {
            return heapMemoryUsage;
        }

        public void setHeapMemoryUsage(MemoryUsage heapMemoryUsage) {
            this.heapMemoryUsage = heapMemoryUsage;
        }

        public MemoryUsage getNonHeapMemoryUsage() {
            return nonHeapMemoryUsage;
        }

        public void setNonHeapMemoryUsage(MemoryUsage nonHeapMemoryUsage) {
            this.nonHeapMemoryUsage = nonHeapMemoryUsage;
        }

        public int getThreadCount() {
            return threadCount;
        }

        public void setThreadCount(int threadCount) {
            this.threadCount = threadCount;
        }

        public int getDeadLockThreads() {
            return deadLockThreads;
        }

        public void setDeadLockThreads(int deadLockThreads) {
            this.deadLockThreads = deadLockThreads;
        }

        public StrmStatSampling getAudioProcessDelay() {
            return audioProcessDelay;
        }

        public void setAudioProcessDelay(StrmStatSampling audioProcessDelay) {
            this.audioProcessDelay = audioProcessDelay;
        }

        public StrmStatSampling getVideoProcessDelay() {
            return videoProcessDelay;
        }

        public void setVideoProcessDelay(StrmStatSampling videoProcessDelay) {
            this.videoProcessDelay = videoProcessDelay;
        }

        public StrmStatSampling getFlvAvProcessDelay() {
            return flvAvProcessDelay;
        }

        public void setFlvAvProcessDelay(StrmStatSampling flvAvProcessDelay) {
            this.flvAvProcessDelay = flvAvProcessDelay;
        }

    @Override
    public String toString() {
        return new StringJoiner(", ", StrmServerStat.class.getSimpleName() + "[", "]")
                .add("version='" + version + "'")
                .add("startupTime=" + startupTime)
                .add("systemLoadAverage=" + systemLoadAverage)
                .add("procCpuLoad=" + procCpuLoad)
                .add("sysCpuLoad=" + sysCpuLoad)
                .add("heapMemoryUsage=" + heapMemoryUsage)
                .add("nonHeapMemoryUsage=" + nonHeapMemoryUsage)
                .add("threadCount=" + threadCount)
                .add("deadLockThreads=" + deadLockThreads)
                .add("audioProcessDelay=" + audioProcessDelay)
                .add("videoProcessDelay=" + videoProcessDelay)
                .add("flvAvProcessDelay=" + flvAvProcessDelay)
                .toString();
    }
}
