package by.myself.dao;

import by.myself.entities.CreditCard;
import by.myself.entities.QCreditCard;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

public class CreditCardDao extends BaseDao<CreditCard> {

    private static CreditCardDao INSTANCE;

    public static CreditCardDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CreditCardDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CreditCardDao();
                }
            }
        }
        return INSTANCE;
    }

    private CreditCardDao() {
    }

    @Override
    public List<CreditCard> findAll(Session session) {
        JPAQuery<CreditCard> query = new JPAQuery<>(session);
        QCreditCard creditCard = QCreditCard.creditCard;
        query.select(creditCard)
                .from(creditCard);
        return query.fetchResults().getResults();
    }

    @Override
    public CreditCard findById(Session session, Long id) {
        JPAQuery<CreditCard> query = new JPAQuery<>(session);
        QCreditCard creditCard = QCreditCard.creditCard;
        query.select(creditCard)
                .from(creditCard)
                .where(creditCard.id.eq(id));
        return query.fetchOne();
    }
}
