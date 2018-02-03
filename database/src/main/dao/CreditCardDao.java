package dao;

import entities.CreditCard;
import support_entities.SessionGetter;

public class CreditCardDao {
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

    public CreditCard getCreditCard(Long id) {
        return (CreditCard) SessionGetter.getData(CreditCard.class, id);
    }
}
