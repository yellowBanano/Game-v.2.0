package dao;

import entities.Discount;
import support_entities.SessionGetter;

public class DiscountDao {
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

    public Discount getDiscount(Long id) {
        return (Discount) SessionGetter.getData(Discount.class, id);
    }
}
