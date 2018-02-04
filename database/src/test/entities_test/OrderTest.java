package entities_test;

import entities.Order;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

import java.time.LocalDateTime;

public class OrderTest extends BaseTest {

    @Test
    public void testSaveOrderToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        LocalDateTime localDateTime = new LocalDateTime();
        Order order = new Order(localDateTime, false, false);
        session.save(order);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetOrderFromDb() {
        System.out.println(SessionGetter.getData(Order.class, 1L));
    }
}
