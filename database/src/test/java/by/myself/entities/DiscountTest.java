package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class DiscountTest extends BaseTest {


    @Test
    public void testSaveDiscountToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Discount discount = new Discount(20d);
        session.save(discount);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetDiscountFromDb() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(Discount.class, 1L));

        transaction.commit();
        session.close();
    }
}
