package multi;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-11 11:21
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RingBuffer<Order> ringBuffer = RingBuffer.create(ProducerType.MULTI,
                new EventFactory<Order>() {
                    @Override
                    public Order newInstance() {
                        return new Order();
                    }
                },
                8192,
                new YieldingWaitStrategy()
        );
        //通过ringBuffer 创建一个屏障
        final SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        //构建多个消费者
        Consumer[] consumers = new Consumer[10];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer("C:" + i);
        }
        //构建多消费者工作池
        final WorkerPool<Order> orderWorkerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new EventExceptionHandler(), consumers);
        //设置多个消费者sequence序号，用于单独统计消费进度，并且设置到ringbuffer中
        ringBuffer.addGatingSequences(orderWorkerPool.getWorkerSequences());
        //启动workpoll
        orderWorkerPool.start(Executors.newFixedThreadPool(10));
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 100; i++) {
            Producer p = new Producer(ringBuffer);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (int i1 = 0; i1 < 100; i1++) {
                        p.sendData(UUID.randomUUID().toString());
                    }
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("线程创建完毕，开始生产数据");
        latch.countDown();
        TimeUnit.SECONDS.sleep(8);
        System.err.println("消费者的总任务总数" + consumers[3].getCount());
    }


    static class EventExceptionHandler implements ExceptionHandler<Order> {

        //消费出现异常
        @Override
        public void handleEventException(Throwable ex, long sequence, Order event) {
            ex.printStackTrace();
        }

        //启动
        @Override
        public void handleOnStartException(Throwable ex) {
            ex.printStackTrace();
        }

        //消费结束
        @Override
        public void handleOnShutdownException(Throwable ex) {
            ex.printStackTrace();
        }
    }

}