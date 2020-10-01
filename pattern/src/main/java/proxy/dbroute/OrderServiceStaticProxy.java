package proxy.dbroute;

import proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:14
 */
public class OrderServiceStaticProxy implements IOrderService {
    private IOrderService orderService;
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        final long createTime = order.getCreateTime();
        final Integer year = Integer.valueOf(sdf.format(new Date(createTime)));
        DynamicDataSourceEntity.set(year);
        this.orderService.createOrder(order);
        DynamicDataSourceEntity.reset();
        return 0;
    }
}