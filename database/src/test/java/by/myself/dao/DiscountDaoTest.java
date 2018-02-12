package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.Discount;
import org.hibernate.Session;
import org.junit.Test;

public class DiscountDaoTest extends BaseTest {

    @Test
    public void saveType() {
        Session session = SESSION_FACTORY.openSession();

        Discount discount = new Discount(20d);
        DiscountDao.getInstance().save(session, discount);

        session.close();
    }

    @Test
    public void findByIdType() {
        Session session = SESSION_FACTORY.openSession();

        DiscountDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllTypes() {
        Session session = SESSION_FACTORY.openSession();

        DiscountDao.getInstance().findAll(session);

        session.close();
    }
}
