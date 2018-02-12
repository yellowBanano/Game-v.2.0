package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.Location;
import by.myself.entities.Shop;
import org.hibernate.Session;
import org.junit.Test;

public class ShopDaoTest extends BaseTest {

    @Test
    public void saveShop() {
        Session session = SESSION_FACTORY.openSession();

        Location location = new Location("country", "city", "address");
        Shop shop = new Shop("+1000-22-33", location);
        ShopDao.getInstance().save(session, shop);

        session.close();
    }

    @Test
    public void findByIdShop() {
        Session session = SESSION_FACTORY.openSession();

        ShopDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllShops() {
        Session session = SESSION_FACTORY.openSession();

        ShopDao.getInstance().findAll(session);

        session.close();
    }
}
