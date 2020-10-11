package chain;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import demo03.Trade;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-02 20:41
 */
public class Handle1  implements EventHandler<Trade>, WorkHandler<Trade> {
    //WorkHandler
    @Override
    public void onEvent(Trade event) throws Exception {
        System.out.println(this.getClass().getName()+" : set name");
        event.setName("H1");
    }

    //EventHandler
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }
}