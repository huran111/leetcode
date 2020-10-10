package demo03;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

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
        final ExecutorService es1 = Executors.newFixedThreadPool(4);
        final ExecutorService es2 = Executors.newFixedThreadPool(4);

        Disruptor<Trade> disruptor = new Disruptor<Trade>(
                new EventFactory<Trade>() {
                    @Override
                    public Trade newInstance() {
                        return new Trade();
                    }
                },
                1024 * 1024,
                es1,
                ProducerType.SINGLE, new BusySpinWaitStrategy()
        );
        //设置消费者-串行
//        disruptor.handleEventsWith(new Handle1())
//        .handleEventsWith(new Handle2())
//        .handleEventsWith(new Handle3());


        //并行
        //  disruptor.handleEventsWith(new Handle1(),new Handle2(),new Handle3());

        //串行+并行 菱形操作 1+2是并行 3是串行
//        disruptor.handleEventsWith(new Handle1(), new Handle2())
//                .handleEventsWith(new Handle3());

        //串行+并行 菱形操作  这种方式也是1 2 并行 3串行
        final EventHandlerGroup<Trade> tradeEventHandlerGroup = disruptor.handleEventsWith(new Handle1(), new Handle2());
        tradeEventHandlerGroup.then(new Handle3());

        final RingBuffer<Trade> ringBuffer = disruptor.start();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        es2.submit(new TradePushLisher(countDownLatch, disruptor));
        System.out.println("start:" + System.currentTimeMillis());
        countDownLatch.await();
        System.out.println("end:" + System.currentTimeMillis());
        disruptor.shutdown();
        es1.shutdown();
        es2.shutdown();
        System.out.println("总耗时：" + (System.currentTimeMillis() - start));
    }
}