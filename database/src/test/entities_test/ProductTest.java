package entities_test;

import entities.Image;
import entities.Product;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

public class ProductTest extends BaseTest {

    @Test
    public void testSaveProductToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Image image = new Image("link");
        Product product = new Product("name", 50d, 40, 8, image);
        session.persist(product);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetProductFromDb() {
        System.out.println(SessionGetter.getData(Product.class, 1L));
    }
}
