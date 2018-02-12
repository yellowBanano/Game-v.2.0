package by.myself.dao;

import by.myself.entities.Order;
import by.myself.entities.QOrder;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

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
    public List<Order> findAll(Session session) {
        JPAQuery<Order> query = new JPAQuery<>(session);
        QOrder order = QOrder.order;
        query.select(order)
                .from(order);
        return query.fetchResults().getResults();
    }

    @Override
    public Order findById(Session session, Long id) {
        JPAQuery<Order> query = new JPAQuery<>(session);
        QOrder order = QOrder.order;
        query.select(order)
                .from(order)
                .where(order.id.eq(id));
        return query.fetchOne();
    }
}
