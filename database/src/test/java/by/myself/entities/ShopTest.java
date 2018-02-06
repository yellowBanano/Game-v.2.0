package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

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
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(Shop.class, 1L));

        transaction.commit();
        session.close();
    }
}
