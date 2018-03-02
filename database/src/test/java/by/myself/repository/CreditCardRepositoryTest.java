package by.myself.repository;

import by.myself.config.PersistenceConfig;
import by.myself.entities.CreditCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class CreditCardRepositoryTest {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Test
    public void testFindAllCreditCards() {
        Iterable<CreditCard> all = creditCardRepository.findAll();
        all.forEach(System.out::println);
    }
}
