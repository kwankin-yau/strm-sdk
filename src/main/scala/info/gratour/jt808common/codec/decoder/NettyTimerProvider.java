/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808common.codec.decoder;

import java.util.concurrent.TimeUnit;

import info.gratour.jt808common.Timer;
import info.gratour.jt808common.TimerProvider;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

/**
 * Netty 定时器提供者
 */
public class NettyTimerProvider implements TimerProvider {

    private io.netty.util.Timer timer;

    /**
     * 构造函数
     * @param timer 定时器
     */
    public NettyTimerProvider(HashedWheelTimer timer) {
        this.timer = timer;
    }

    @Override
    public Timer newTimer(Object key, int time, TimeUnit timeUnit, Runnable job) {
        Timeout timeout = timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                job.run();
            }
        }, time, timeUnit);

        return new NettyTimer(timeout);
    }
}

/**
 * Netty 定时器
 */
class NettyTimer implements Timer {

    private final Timeout timeout;

    /**
     * 构造函数
     * @param timeout 定时器
     */
    NettyTimer(Timeout timeout) {
        this.timeout = timeout;
    }

    /**
     * 取消定时器
     */
    @Override
    public void cancel() {
        timeout.cancel();
    }
}
