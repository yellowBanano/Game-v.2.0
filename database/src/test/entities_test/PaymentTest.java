package entities_test;

import entities.CreditCard;
import entities.Payment;
import entities.User;
import entities.Wallet;
import org.hibernate.Session;
import org.junit.Test;
import support_entities.SessionGetter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentTest extends BaseTest {

    @Test
    public void testSaveProductToDb() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        LocalDateTime localDateTime = new LocalDateTime();
        LocalDate localDate = new LocalDate();
        User user = new User("email", "login", "password");
        Wallet wallet = new Wallet(user, 20d);
        CreditCard creditCard = new CreditCard(localDateTime, wallet, "serial", "cvv", localDate, user);
        session.persist(creditCard);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testGetProductFromDb() {
        System.out.println(SessionGetter.getData(Payment.class, 1L));
    }
}
