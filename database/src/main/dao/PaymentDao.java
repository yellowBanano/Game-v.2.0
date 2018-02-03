package dao;

import entities.Payment;
import support_entities.SessionGetter;

public class PaymentDao {
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

    public Payment getPayment(Long id) {
        return (Payment) SessionGetter.getData(Payment.class, id);
    }
}
