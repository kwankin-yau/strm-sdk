package info.gratour.jt808common.codec.decoder;

import info.gratour.jt808common.Timer;
import info.gratour.jt808common.TimerProvider;
import info.gratour.jt808common.protocol.JT808Frame;
import io.netty.buffer.ByteBufAllocator;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 帧分片收集器管理条目
 */
class FramesCollectorManagementEntry {
    int msgId;
    JT808FramesCollector collector;
    Timer cleanupTimer;
    FragmentTimeoutCallback timeoutCallback;

    /**
     * 构造函数
     * @param msgId 消息ID
     * @param collector 帧分片收集器
     * @param timerProvider 定时器提供者
     * @param timeoutCallback 分片收集超时回调
     */
    public FramesCollectorManagementEntry(int msgId, JT808FramesCollector collector, TimerProvider timerProvider, FragmentTimeoutCallback timeoutCallback) {
        this.msgId = msgId;
        this.collector = collector;
        this.cleanupTimer = timerProvider.newTimer(this, 2, TimeUnit.MINUTES, cleanup);
        this.timeoutCallback = timeoutCallback;
    }

    Runnable cleanup = new Runnable() {
        @Override
        public void run() {
            collector.close();
            if (timeoutCallback != null)
                timeoutCallback.onFragmentTimeout(collector);
        }
    };

    /**
     * 取消定时器
     */
    void cancelTimer() {
        if (cleanupTimer != null) {
            cleanupTimer.cancel();
            cleanupTimer = null;
        }
    }

}

/**
 * JT808 数据包分片管理器
 */
public class JT808PacketFragmentManager implements Closeable {

    private final ByteBufAllocator allocator;
    private final Map<Integer, FramesCollectorManagementEntry> collectorMap = new HashMap<>();
    private final TimerProvider timerProvider;

    /**
     * 构造函数
     * @param allocator 字节缓冲区分配器
     * @param timerProvider 定时器提供者
     */
    public JT808PacketFragmentManager(ByteBufAllocator allocator, TimerProvider timerProvider) {
        this.allocator = allocator;
        this.timerProvider = timerProvider;
    }

    private FramesCollectorManagementEntry get(int msgId, FragmentTimeoutCallback timeoutCallback) {
        FramesCollectorManagementEntry entry = collectorMap.get(msgId);
        if (entry == null) {
            JT808FramesCollector collector = new JT808FramesCollector(allocator, msgId);
            entry = new FramesCollectorManagementEntry(msgId, collector, timerProvider, timeoutCallback);
            collectorMap.put(msgId, entry);
        }

        return entry;
    }


    /**
     * 收集接收到的数据包分片。
     *
     * @param frame 数据包分片。本方法调用后，此JT808Frame对象的所有权转移JT808PacketFragmentManager。
     * @param timeoutCallback 收集超时回调。
     * @return 如果所有分片已收集，返回非 null。
     */
    public JT808Frame collect(JT808Frame frame, FragmentTimeoutCallback timeoutCallback) {
        int msgId = frame.getHeader().getMsgId();
        FramesCollectorManagementEntry entry = get(msgId, timeoutCallback);
        if (entry.collector.collect(frame)) {
            JT808Frame result = entry.collector.buildWholePacket();

            entry.cancelTimer();
            entry.collector.close();
            collectorMap.remove(msgId);

            return result;
        }

        return null;
    }


    @Override
    public void close() {
        collectorMap.values().forEach(entry -> {
            entry.cancelTimer();
            entry.collector.close();
        });

        collectorMap.clear();
    }
}
