package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.LocalDateTime;

public class OrderTest extends BaseTest {

    @Test
    public void testSaveOrderToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        LocalDateTime localDateTime = LocalDateTime.now();

        Image image = new Image("link");
        session.save(image);

        Product product1 = new Product("someName1", 50d, 40, 8, image);
        session.save(product1);

        Wallet wallet = new Wallet(20d);
        session.save(wallet);

        User user = new User("someEmail1", "someLogin1", "somePassword", wallet);
        session.save(user);

        Order order1 = new Order();
        order1.setConsumer(user);
        order1.setProduct(product1);
        order1.setDateTime(localDateTime);
        order1.setPaid(false);
        order1.setDelivered(false);
        session.save(order1);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetOrderFromDb() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(Order.class, 1L));

        transaction.commit();
        session.close();
    }
}
