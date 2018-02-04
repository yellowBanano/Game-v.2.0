package entities_test;

import entities.Type;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

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
        System.out.println(SessionGetter.getData(Type.class, 1L));
    }
}
