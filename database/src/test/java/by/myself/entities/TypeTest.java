package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TypeTest extends BaseTest {

    @Test
    public void testSaveTypeToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Type shoes = new Type("shoes");
        session.save(shoes);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetTypeFromDb() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(Type.class, 3L));

        transaction.commit();
        session.close();
    }
}
