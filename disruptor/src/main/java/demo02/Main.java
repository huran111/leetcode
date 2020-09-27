package demo02;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: leetcode
 * @description: 核心的程序组件
 * @author: HuRan
 * @create: 2020-09-26 21:24
 */
public class Main {
    public static void main(String[] args) {
        //实例化一个disruptor对象
        OrderEventFactory orderEventFactory = new OrderEventFactory();
        int ringBufferSize = 1024 * 1024;
        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        /**
         * 1.消息event工程对象
         * 2.容器长度
         * 3.线程池
         * 4.ProducerType 单生产者还是多生产者
         * 5.BlockingWaitStrategy 等待策略
         */
        Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(
                orderEventFactory
                , ringBufferSize
                , executorService
                , ProducerType.SINGLE,
                new BlockingWaitStrategy()
        );
        //添加消息的的监听
        disruptor.handleEventsWith(new OrderEventHandler());
        //启动disruptor
        disruptor.start();
        //获取实际存储数据的容器,RingBuffer
        final RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer producer = new OrderEventProducer(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (long i = 0; i < 100; i++) {
            byteBuffer.putLong(0, i);
            producer.sendData(byteBuffer);
        }
       // disruptor.shutdown();
       // executorService.shutdown();
    }
}