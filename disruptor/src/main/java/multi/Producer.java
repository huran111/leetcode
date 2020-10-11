package multi;

import com.lmax.disruptor.RingBuffer;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-11 11:59
 */
public class Producer {
    private RingBuffer<Order> ringBuffer;

    public Producer(RingBuffer<Order> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(String data) {
        final long sequeue = ringBuffer.next();
        try {
            final Order order = ringBuffer.get(sequeue);
            order.setId(data);
        } finally {
            ringBuffer.publish(sequeue);
        }
    }
}