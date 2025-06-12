package com.lucendar.strm.common.strm.stat;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
import java.util.StringJoiner;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

/**
 * 流媒体服务器状态
 */
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

        /**
         * 获取流媒体服务器状态
         * @return 流媒体服务器状态
         */
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

        /**
         * 获取媒体服务版本号
         * @return 媒体服务版本号
         */
        public String getVer() {
            return ver;
        }

        /**
         * 设置媒体服务版本号
         * @param ver 媒体服务版本号
         */
        public void setVer(String ver) {
            this.ver = ver;
        }

        /**
         * 获取媒体服务启动时间
         * @return 媒体服务启动时间, epoch millis
         */
        public long getStartTm() {
            return startTm;
        }

        /**
         * 设置媒体服务启动时间
         * @param startTm 媒体服务启动时间, epoch millis
         */
        public void setStartTm(long startTm) {
            this.startTm = startTm;
        }

        /**
         * 获取进程的CPU负载
         * @return 进程的CPU负载
         */
        public Double getProcCpuLoad() {
            return procCpuLoad;
        }

        /**
         * 设置进程的CPU负载
         * @param procCpuLoad 进程的CPU负载
         */
        public void setProcCpuLoad(Double procCpuLoad) {
            this.procCpuLoad = procCpuLoad;
        }

        /**
         * 获取系统的CPU负载
         * @return 系统的CPU负载
         */
        public Double getSysCpuLoad() {
            return sysCpuLoad;
        }

        /**
         * 设置系统的CPU负载
         * @param sysCpuLoad 系统的CPU负载
         */
        public void setSysCpuLoad(Double sysCpuLoad) {
            this.sysCpuLoad = sysCpuLoad;
        }

        /**
         * 获取系统的负载平均值
         * @return 系统的负载平均值
         */
        public Double getSysLoadAvg() {
            return sysLoadAvg;
        }

        /**
         * 设置系统的负载平均值
         * @param sysLoadAvg 系统的负载平均值
         */
        public void setSysLoadAvg(Double sysLoadAvg) {
            this.sysLoadAvg = sysLoadAvg;
        }

        /**
         * 获取堆内存使用情况
         * @return 堆内存使用情况
         */
        public MemUsage getHeapMemUse() {
            return heapMemUse;
        }

        /**
         * 设置堆内存使用情况
         * @param heapMemUse 堆内存使用情况
         */
        public void setHeapMemUse(MemUsage heapMemUse) {
            this.heapMemUse = heapMemUse;
        }

        /**
         * 获取非堆内存使用情况
         * @return 非堆内存使用情况
         */
        public MemUsage getNonHeapMemUse() {
            return nonHeapMemUse;
        }

        /**
         * 设置非堆内存使用情况
         * @param nonHeapMemUse 非堆内存使用情况
         */
        public void setNonHeapMemUse(MemUsage nonHeapMemUse) {
            this.nonHeapMemUse = nonHeapMemUse;
        }

        /**
         * 获取线程数量
         * @return 线程数量
         */
        public int getThdCnt() {
            return thdCnt;
        }

        /**
         * 设置线程数量
         * @param thdCnt 线程数量
         */
        public void setThdCnt(int thdCnt) {
            this.thdCnt = thdCnt;
        }

        /**
         * 获取死锁线程数量
         * @return 死锁线程数量
         */
        public int getDeadLockThds() {
            return deadLockThds;
        }

        /**
         * 设置死锁线程数量
         * @param deadLockThds 死锁线程数量
         */
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
