package entities_test;

import entities.User;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

public class UserTest extends BaseTest {

    @Test
    private void testSaveToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        User user = new User("someEmail", "Newbie", "1111");
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    private void testGetFromDb() {
        System.out.println(SessionGetter.getData(User.class, 1L));
    }
}
