package entities_test;

import entities.Location;
import entities.Shop;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

public class ShopTest extends BaseTest {

    @Test
    public void testSaveShopToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Location location = new Location("country", "city", "address");
        Shop shop = new Shop("+1000-22-33", location);
        session.save(shop);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetShopFromDb() {
        System.out.println(SessionGetter.getData(Shop.class, 1L));
    }
}
