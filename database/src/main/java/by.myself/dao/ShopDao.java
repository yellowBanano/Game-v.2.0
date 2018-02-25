package by.myself.dao;

import by.myself.entities.Shop;

public class ShopDao extends BaseDao<Shop> {

    private static ShopDao INSTANCE;

    public static ShopDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ShopDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ShopDao();
                }
            }
        }
        return INSTANCE;
    }

    private ShopDao() {
    }

    @Override
    protected Class<Shop> getEntityClass() {
        return Shop.class;
    }
}
