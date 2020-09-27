package demo02;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @program: leetcode
 * @description: 生产者
 * @author: HuRan
 * @create: 2020-09-26 21:48
 */
public class OrderEventProducer {
    private RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    //投递一个一个的数据
    public void sendData(ByteBuffer data) {
        //在生产者发送消息的时候，首先需要从ringbuffer获取一个可用的序号
        final long next = ringBuffer.next();
       try {
           //根据这个序号获取具体的OrderEvent元素，注意：此时获取的OrderEvnet对象是一个没有被赋值的
           final OrderEvent orderEvent = ringBuffer.get(next);
           orderEvent.setValue(data.getLong(0));
       }finally {
            ringBuffer.publish(next);
       }
    }
}