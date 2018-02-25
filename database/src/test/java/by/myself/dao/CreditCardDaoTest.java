package by.myself.dao;

import by.myself.entities.*;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreditCardDaoTest extends BaseTest {

    @Test
    public void savePayment() {
        Session session = SESSION_FACTORY.openSession();

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        Wallet wallet = new Wallet(20d);
        session.save(wallet);
        User user = new User("someEmail", "someLogin", "somePassword", wallet);
        session.save(user);
        CreditCard creditCard = new CreditCard(localDateTime, wallet, "serial", "someCVV", localDate);
        CreditCardDao.getInstance().save(session, creditCard);

        session.close();
    }

    @Test
    public void findByIdPayment() {
        Session session = SESSION_FACTORY.openSession();

        CreditCardDao.getInstance().findById(session, 3L);

        session.close();
    }

    @Test
    public void findAllPayments() {
        Session session = SESSION_FACTORY.openSession();

        CreditCardDao.getInstance().findAll(session);

        session.close();
    }
}
