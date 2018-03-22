package by.myself.service;

import by.myself.config.PersistenceConfig;
import by.myself.config.ServiceConfig;
import by.myself.entities.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class,  ServiceConfig.class})
public class ChatServiceTest {

    @Autowired
    public ChatService chatService;

    @Test
    public void testChat() {
        List<Comment> allMessages = chatService.findAllMessages();
        Comment comment = allMessages.iterator().next();
        chatService.saveComment(comment);
    }
}
