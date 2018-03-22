package by.myself.service;

import by.myself.config.PersistenceConfig;
import by.myself.config.ServiceConfig;
import by.myself.entities.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class,  ServiceConfig.class})
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void test() {
        Topic topic = topicService.getTopic();
        System.out.println(topic);
        topicService.editTopic(topic);
    }
}
