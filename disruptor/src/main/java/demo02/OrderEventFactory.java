package demo02;

import com.lmax.disruptor.EventFactory;


/**
 * @program: leetcode
 * @description: 订单工厂类
 * @author: HuRan
 * @create: 2020-09-26 13:19
 */
public class OrderEventFactory implements EventFactory<OrderEvent> {
    @Override
    public OrderEvent newInstance() {
        return new OrderEvent(); //返回空的消息 数据对象<Event>
    }
}