package by.myself.dao;

import by.myself.entities.Discount;

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
    protected Class<Discount> getEntityClass() {
        return Discount.class;
    }
}
