package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void testSaveProductToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Image image = new Image("link");
        session.save(image);

        Product product = new Product("someName", 50d, 40, 8, image);
        session.save(product);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetProductFromDb() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(Product.class, 1L));

        transaction.commit();
        session.close();
    }
}
