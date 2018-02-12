package by.myself.dao;

import by.myself.entities.*;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDateTime;

public class OrderDaoTest extends BaseTest {

    @Test
    public void saveOrder() {
        Session session = SESSION_FACTORY.openSession();

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
        OrderDao.getInstance().save(session, order1);

        session.close();
    }

    @Test
    public void findByIdOrder() {
        Session session = SESSION_FACTORY.openSession();

        OrderDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllOrders() {
        Session session = SESSION_FACTORY.openSession();

        OrderDao.getInstance().findAll(session);

        session.close();
    }
}
