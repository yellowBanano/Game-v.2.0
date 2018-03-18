package by.myself.service;

import by.myself.config.PersistenceConfig;
import by.myself.config.ServiceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class,  ServiceConfig.class})
public class UserServiceTest {

}
