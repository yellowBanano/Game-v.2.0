package by.myself.dao;

import by.myself.entities.Payment;
import by.myself.entities.Product;
import by.myself.entities.QPayment;
import by.myself.entities.QProduct;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

public class PaymentDao extends BaseDao<Payment> {

    private static PaymentDao INSTANCE;

    public static PaymentDao getInstance() {
        if (INSTANCE == null) {
            synchronized (PaymentDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PaymentDao();
                }
            }
        }
        return INSTANCE;
    }

    private PaymentDao() {
    }

    @Override
    public List<Payment> findAll(Session session) {
        JPAQuery<Payment> query = new JPAQuery<>(session);
        QPayment payment = QPayment.payment;
        query.select(payment)
                .from(payment);
        return query.fetchResults().getResults();
    }

    @Override
    public Payment findById(Session session, Long id) {
        JPAQuery<Payment> query = new JPAQuery<>();
        QPayment payment = QPayment.payment;
        query.select(payment)
                .from(payment)
                .where(payment.id.eq(id));
        return query.fetchOne();
    }
}
