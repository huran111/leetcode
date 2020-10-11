package chain;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import demo03.Trade;
import demo03.TradePushLisher;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-02 20:25
 */
public class Main {
    //构建一个线程池用于提交我们的任务

    public static void main(String[] args) throws InterruptedException {
        //提交任务
        final ExecutorService es1 = Executors.newFixedThreadPool(1);
            //单消费者 弊端，几个handler 需要几个线程池
        final ExecutorService es2 = Executors.newFixedThreadPool(4);
        Disruptor<Trade> disruptor = new Disruptor<Trade>(
                new EventFactory<Trade>() {
                    @Override
                    public Trade newInstance() {
                        return new Trade();
                    }
                },
                1024 * 1024,
                es2,
                ProducerType.SINGLE, new BusySpinWaitStrategy()
        );
        Handle1 h1 = new Handle1();
        Handle2 h2 = new Handle2();
        Handle3 h3 = new Handle3();
        Handle4 h4 = new Handle4();
        Handle5 h5 = new Handle5();
        //h1 h4并行
        disruptor.handleEventsWith(h1, h4);
        disruptor.after(h1).handleEventsWith(h2);
        disruptor.after(h4).handleEventsWith(h5);
        disruptor.after(h2, h5).handleEventsWith(h3);
        final RingBuffer<Trade> ringBuffer = disruptor.start();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        es1.submit(new TradePushLisher(countDownLatch, disruptor));
        System.out.println("start:" + System.currentTimeMillis());
        countDownLatch.await();
        System.out.println("end:" + System.currentTimeMillis());
        disruptor.shutdown();
        es1.shutdown();
        es2.shutdown();
        System.out.println("总耗时：" + ((System.currentTimeMillis() - start)/1000));
    }
}