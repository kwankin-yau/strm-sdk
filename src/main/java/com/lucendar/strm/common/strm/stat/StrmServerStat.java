package com.lucendar.strm.common.strm.stat;

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
        private String ver;
        private long startTm;
        private Double sysLoadAvg; // null for not available
        private Double procCpuLoad; // null for not available
        private Double sysCpuLoad; // null for not available
        private MemUsage heapMemUse;
        private MemUsage nonHeapMemUse;
        private int thdCnt;
        private int deadLockThds;

        private static Double[] cpuLoads(MBeanServer server) {
            try {
                ObjectName n = ObjectName.getInstance("java.lang:type=OperatingSystem");
                AttributeList list = server.getAttributes(n, new String[]{"ProcessCpuLoad", "SystemCpuLoad"});
                Double[] r = new Double[2];
                for (Object o : list) {
                    Attribute att = (Attribute) o;
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
                r.sysLoadAvg = d;
            MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
            r.heapMemUse = new MemUsage(mem.getHeapMemoryUsage());
            r.nonHeapMemUse = new MemUsage(mem.getNonHeapMemoryUsage());
            ThreadMXBean t = ManagementFactory.getThreadMXBean();
            r.thdCnt = t.getThreadCount();
            long[] arr = t.findDeadlockedThreads();
            if (arr != null)
                r.deadLockThds = arr.length;
            else
                r.deadLockThds = 0;

            return r;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public long getStartTm() {
            return startTm;
        }

        public void setStartTm(long startTm) {
            this.startTm = startTm;
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

        public Double getSysLoadAvg() {
            return sysLoadAvg;
        }

        public void setSysLoadAvg(Double sysLoadAvg) {
            this.sysLoadAvg = sysLoadAvg;
        }

        public MemUsage getHeapMemUse() {
            return heapMemUse;
        }

        public void setHeapMemUse(MemUsage heapMemUse) {
            this.heapMemUse = heapMemUse;
        }

        public MemUsage getNonHeapMemUse() {
            return nonHeapMemUse;
        }

        public void setNonHeapMemUse(MemUsage nonHeapMemUse) {
            this.nonHeapMemUse = nonHeapMemUse;
        }

        public int getThdCnt() {
            return thdCnt;
        }

        public void setThdCnt(int thdCnt) {
            this.thdCnt = thdCnt;
        }

        public int getDeadLockThds() {
            return deadLockThds;
        }

        public void setDeadLockThds(int deadLockThds) {
            this.deadLockThds = deadLockThds;
        }


    @Override
    public String toString() {
        return new StringJoiner(", ", StrmServerStat.class.getSimpleName() + "[", "]")
                .add("ver='" + ver + "'")
                .add("startTm=" + startTm)
                .add("sysLoadAvg=" + sysLoadAvg)
                .add("procCpuLoad=" + procCpuLoad)
                .add("sysCpuLoad=" + sysCpuLoad)
                .add("heapMemUse=" + heapMemUse)
                .add("nonHeapMemUse=" + nonHeapMemUse)
                .add("thdCnt=" + thdCnt)
                .add("deadLockThds=" + deadLockThds)
                .toString();
    }
}
