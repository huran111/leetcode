package demo04;

import com.lmax.disruptor.EventHandler;
import demo03.Trade;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-02 20:41
 */
public class Handle5 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(this.getClass().getName() + " get price");
        event.setPrice(event.getPrice() + 3.0);
    }
}