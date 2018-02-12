package by.myself.dao;

import by.myself.entities.BaseTest;
import by.myself.entities.Wallet;
import org.hibernate.Session;
import org.junit.Test;

public class WalletDaoTest extends BaseTest {

    @Test
    public void saveWallet() {
        Session session = SESSION_FACTORY.openSession();

        Wallet wallet = new Wallet(20d);
        WalletDao.getInstance().save(session, wallet);

        session.close();
    }

    @Test
    public void findByIdWallet() {
        Session session = SESSION_FACTORY.openSession();

        WalletDao.getInstance().findById(session, 1L);

        session.close();
    }

    @Test
    public void findAllWallets() {
        Session session = SESSION_FACTORY.openSession();

        WalletDao.getInstance().findAll(session);

        session.close();
    }
}
