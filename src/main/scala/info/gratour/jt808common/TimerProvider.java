package info.gratour.jt808common;


import java.util.concurrent.TimeUnit;

/**
 * 定时器提供者接口
 */
public interface TimerProvider {

    /**
     * 创建定时器
     * @param key 键
     * @param time 时间
     * @param timeUnit 时间单位
     * @param job 任务
     * @return 定时器
     */
    Timer newTimer(Object key, int time, TimeUnit timeUnit, Runnable job);
}
