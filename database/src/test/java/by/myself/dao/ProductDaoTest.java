package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.Product;
import by.myself.utils.entities.Sort;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class ProductDaoTest extends BaseTest {

    @Test
    public void saveProduct() {
        Session session = SESSION_FACTORY.openSession();

        ProductDao.getInstance().save(session, new Product("someName", 50d, 40, 8));

        session.close();
    }

    @Test
    public void updateProduct() {
        Session session = SESSION_FACTORY.openSession();

        ProductDao.getInstance().update(session, new Product("someName", 50d, 40, 8));

        session.close();
    }

    @Test
    public void deleteProduct() {
        Session session = SESSION_FACTORY.openSession();

        ProductDao.getInstance().delete(session, new Product("someName", 50d, 40, 8));

        session.close();
    }

    @Test
    public void findByIdProduct() {
        Session session = SESSION_FACTORY.openSession();

        ProductDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllProducts() {
        Session session = SESSION_FACTORY.openSession();

        ProductDao.getInstance().findAll(session);

        session.close();
    }

    @Test
    public void searchProducts() {
        Session session = SESSION_FACTORY.openSession();

        ProductDao.getInstance().searchProducts(session, "Me", 10, 0, Sort.NAMEASC);

        session.close();
    }
}
