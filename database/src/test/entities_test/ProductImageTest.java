package entities_test;

import entities.Image;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import support_entities.SessionGetter;

public class ProductImageTest extends BaseTest {

    @Test
    private void joinProductImageTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Image image = new Image("test link");
        Product product = new Product("name", 100d, 10, 10, image);
        session.persist(product);

        transaction.commit();
        session.close();
    }

    @Test
    private void getProductImageTest() {
        System.out.println(SessionGetter.getData(Product.class, 1L));
    }
}
