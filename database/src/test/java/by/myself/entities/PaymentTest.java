package by.myself.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentTest extends BaseTest {

    @Test
    public void testSaveProductToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();

        Wallet wallet = new Wallet(20d);
        session.save(wallet);

        User user = new User("someEmail", "someLogin", "somePassword", wallet);
        session.save(user);

        CreditCard creditCard = new CreditCard(localDateTime, wallet, "serial", "someCVV", localDate);
        session.save(creditCard);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetProductFromDb() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println(session.get(Payment.class, 1L));

        transaction.commit();
        session.close();
    }
}
