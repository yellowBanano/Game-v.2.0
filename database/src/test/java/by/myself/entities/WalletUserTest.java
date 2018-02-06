package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class WalletUserTest extends BaseTest {

    @Test
    public void testSaveWalletToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Wallet wallet = new Wallet(20d);
        session.save(wallet);

        User user = new User("someEmail", "someLogin", "somePassword", wallet);
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetWalletFromDb() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(User.class, 1L));
        System.out.println(session.get(Wallet.class, 1L));

        transaction.commit();
        session.close();
    }
}
