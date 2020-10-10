package demo03;

import com.lmax.disruptor.EventHandler;

import java.util.UUID;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-02 20:41
 */
public class Handle2  implements EventHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(this.getClass().getName()+" : set id");
        Thread.sleep(200);
        event.setId(UUID.randomUUID().toString());
    }
}