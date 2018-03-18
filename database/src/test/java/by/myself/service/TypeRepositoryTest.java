package by.myself.service;

import by.myself.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class TypeRepositoryTest {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    public void testFindAllTypes() {
        typeRepository.findAll().forEach(System.out::println);
    }
}
