package entities_test;

import entities.User;
import entities.Wallet;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

public class WalletUserTest extends BaseTest {

    @Test
    public void testSaveWalletToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();


        User user = new User("email", "login", "password");
        Wallet wallet = new Wallet(user, 20d);
        session.persist(wallet);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetWalletFromDb() {
        System.out.println(SessionGetter.getData(Wallet.class, 1L));
    }
}
