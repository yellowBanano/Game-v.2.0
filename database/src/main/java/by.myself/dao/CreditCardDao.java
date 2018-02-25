package by.myself.dao;

import by.myself.entities.CreditCard;

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
    protected Class<CreditCard> getEntityClass() {
        return CreditCard.class;
    }
}
