package by.myself.dao;

import by.myself.entities.Order;

public class OrderDao extends BaseDao<Order> {

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

    @Override
    protected Class<Order> getEntityClass() {
        return Order.class;
    }
}
