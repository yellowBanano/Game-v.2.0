package entities_test;

import entities.Discount;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

public class DiscountTest extends BaseTest {


    @Test
    private void testSaveToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Discount discount = new Discount(20d);
        session.save(discount);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    private void testGetFromDb() {
        System.out.println(SessionGetter.getData(Discount.class, 1L));
    }
}
