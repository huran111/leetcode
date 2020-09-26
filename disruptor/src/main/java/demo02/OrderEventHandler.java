package demo02;


import com.lmax.disruptor.EventHandler;

/**
 * @program: leetcode
 * @description: 消息的消费者
 * @author: HuRan
 * @create: 2020-09-26 13:22
 */
public class OrderEventHandler  implements EventHandler<OrderEvent> {

    public void onEvent(OrderEvent orderEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("消费者：" + orderEvent.getValue());
    }
}