package by.myself.dao;

import by.myself.entities.Payment;

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
    protected Class<Payment> getEntityClass() {
        return Payment.class;
    }
}
