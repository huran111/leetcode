package chain;

import com.lmax.disruptor.EventHandler;
import demo03.Trade;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-02 20:41
 */
public class Handle4 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(this.getClass().getName()+" set price");
        event.setPrice(100);
    }
}