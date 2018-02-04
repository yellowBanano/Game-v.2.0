package entities_test;

import entities.User;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

public class UserTest extends BaseTest {

    @Test
    public void testSaveUserToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        User user = new User("someEmail", "Newbie", "1111");
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetUserFromDb() {
        System.out.println(SessionGetter.getData(User.class, 1L));
    }
}
