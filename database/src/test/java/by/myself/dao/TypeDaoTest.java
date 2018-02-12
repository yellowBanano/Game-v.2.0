package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.Type;
import org.hibernate.Session;
import org.junit.Test;

public class TypeDaoTest extends BaseTest {

    @Test
    public void saveType() {
        Session session = SESSION_FACTORY.openSession();

        Type shoes = new Type("shoes");
        TypeDao.getInstance().save(session, shoes);

        session.close();
    }

    @Test
    public void findByIdType() {
        Session session = SESSION_FACTORY.openSession();

        TypeDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllTypes() {
        Session session = SESSION_FACTORY.openSession();

        TypeDao.getInstance().findAll(session);

        session.close();
    }
}
