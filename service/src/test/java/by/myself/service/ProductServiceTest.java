package by.myself.service;

import by.myself.config.PersistenceConfig;
import by.myself.config.ServiceConfig;
import by.myself.model.ProductModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, ServiceConfig.class})
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testProduct() {
        List<ProductModel> list = productService.searchProducts("SomeName1", 10d, 0);
        list.forEach(System.out::println);
    }
}
