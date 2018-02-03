package dao;

import entities.Order;
import support_entities.SessionGetter;

public class OrderDao {
    private static OrderDao INSTANCE;

    public static OrderDao getInstance() {
        if (INSTANCE == null) {
            synchronized (OrderDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OrderDao();
                }
            }
        }
        return INSTANCE;
    }

    private OrderDao() {
    }

    public Order getOrder(Long id) {
        return (Order) SessionGetter.getData(Order.class, id);
    }
}
