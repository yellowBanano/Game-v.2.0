package by.myself.dao;

import by.myself.entities.QShop;
import by.myself.entities.QType;
import by.myself.entities.Shop;
import by.myself.entities.Type;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

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
    public List<Shop> findAll(Session session) {
        JPAQuery<Shop> query = new JPAQuery<>(session);
        QShop shop = QShop.shop;
        query.select(shop)
                .from(shop);
        return query.fetchResults().getResults();
    }

    @Override
    public Shop findById(Session session, Long id) {
        JPAQuery<Shop> query = new JPAQuery<>();
        QShop shop = QShop.shop;
        query.select(shop)
                .from(shop)
                .where(shop.id.eq(id));
        return query.fetchOne();
    }
}
