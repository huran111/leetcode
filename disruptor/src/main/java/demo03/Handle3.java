package demo03;

import com.lmax.disruptor.EventHandler;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-02 20:41
 */
public class Handle3 implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(this.getClass().getName()+" instance :"+event.toString());
    }
}