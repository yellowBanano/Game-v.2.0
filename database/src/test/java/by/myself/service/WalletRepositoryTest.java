package by.myself.service;

import by.myself.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class WalletRepositoryTest {

    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void testFindAllWallets() {
        walletRepository.findAll().forEach(System.out::println);
    }
}
