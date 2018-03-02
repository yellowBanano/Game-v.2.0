package by.myself.repository;

import by.myself.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class ShopRepositoryTest {

    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void testFindAllShops() {
        shopRepository.findAll().forEach(System.out::println);
    }
}
