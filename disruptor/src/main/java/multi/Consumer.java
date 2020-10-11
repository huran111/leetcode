package multi;

import com.lmax.disruptor.WorkHandler;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leetcode
 * @description: 多消费者 必须实现WorkHandler
 * @author: HuRan
 * @create: 2020-10-11 11:26
 */
public class Consumer implements WorkHandler<Order> {
    private String consumerId;
    private static AtomicInteger count = new AtomicInteger(0);
    private Random random = new Random();

    public Consumer(String consumerId) {
        this.consumerId = consumerId;

    }


    @Override
    public void onEvent(Order event) throws Exception {
       // Thread.sleep(1 * random.nextInt(5));
        System.out.println("当前消费者:" + this.consumerId + ",消费:ID" + event.getId());
        count.incrementAndGet();
    }

    public  Integer getCount() {
        return count.get();
    }
}