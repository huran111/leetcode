package proxy.dbroute;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:09
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("调用orderDao插入订单");
        return orderDao.insert(order);
    }
}