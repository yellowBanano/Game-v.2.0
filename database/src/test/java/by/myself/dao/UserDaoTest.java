package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.User;
import by.myself.entities.Wallet;
import org.hibernate.Session;
import org.junit.Test;

public class UserDaoTest extends BaseTest {

    @Test
    public void saveUser() {
        Session session = SESSION_FACTORY.openSession();

        Wallet wallet = new Wallet(20d);
        session.save(wallet);
        User user = new User("someEmail", "someLogin", "somePassword", wallet);
        UserDao.getInstance().save(session, user);

        session.close();
    }

    @Test
    public void findByIdUser() {
        Session session = SESSION_FACTORY.openSession();

        UserDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllUsers() {
        Session session = SESSION_FACTORY.openSession();

        UserDao.getInstance().findAll(session);

        session.close();
    }
}
