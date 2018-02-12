package by.myself.dao;

import by.myself.entities.Discount;
import by.myself.entities.QDiscount;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

public class DiscountDao extends BaseDao<Discount> {

    private static DiscountDao INSTANCE;

    public static DiscountDao getInstance() {
        if (INSTANCE == null) {
            synchronized (DiscountDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DiscountDao();
                }
            }
        }
        return INSTANCE;
    }

    private DiscountDao() {
    }

    @Override
    public List<Discount> findAll(Session session) {
        JPAQuery<Discount> query = new JPAQuery<>(session);
        QDiscount discount = QDiscount.discount1;
        query.select(discount)
                .from(discount);
        return query.fetchResults().getResults();
    }

    @Override
    public Discount findById(Session session, Long id) {
        JPAQuery<Discount> query = new JPAQuery<>(session);
        QDiscount discount = QDiscount.discount1;
        query.select(discount)
                .from(discount)
                .where(discount.id.eq(id));
        return query.fetchOne();
    }
}
