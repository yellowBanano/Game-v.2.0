package dao;

import entities.Shop;
import support_entities.SessionGetter;

public class ShopDao {
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

    public Shop getShop(Long id) {
        return (Shop) SessionGetter.getData(Shop.class, id);
    }
}
