package by.myself.repository;

import by.myself.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAllProducts() {
        productRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void testSearchRequiredProducts() {
        productRepository.findAllByNameOrProducerOrCost(null, null, null).forEach(System.out::println);
        productRepository.findAllByNameOrProducerOrCost("someName1", null, null).forEach(System.out::println);
        productRepository.findAllByNameOrProducerOrCost("someName1", "someProducer2", null).forEach(System.out::println);
        productRepository.findAllByNameOrProducerOrCost("someName2", null, 20d).forEach(System.out::println);
    }
}
