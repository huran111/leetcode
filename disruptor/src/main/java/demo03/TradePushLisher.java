package demo03;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: leetcode
 * @description: 投递数据
 * @author: HuRan
 * @create: 2020-10-02 20:32
 */


public class TradePushLisher implements Runnable {
    private CountDownLatch countDownLatch;
    private Disruptor disruptor;
    private static int PUBLISH_COUNT=1;
    public TradePushLisher(CountDownLatch countDownLatch, Disruptor<Trade> disruptor) {
        this.countDownLatch = countDownLatch;
        this.disruptor = disruptor;
    }


    @Override
    public void run() {
        //新的提交方式
        for (int i = 0; i < PUBLISH_COUNT; i++) {
            disruptor.publishEvent(new TradeEventTranslator());
        }
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("countDown:" + System.currentTimeMillis());
        countDownLatch.countDown();
    }
}

class TradeEventTranslator implements EventTranslator<Trade> {

    @Override
    public void translateTo(Trade event, long sequence) {
        this.generatorTrade(event);
    }

    private void generatorTrade(Trade event) {
        event.setPrice(new Random(System.currentTimeMillis()).nextDouble());
    }
}