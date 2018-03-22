package by.myself.controller;

import by.myself.entities.Comment;
import by.myself.entities.Topic;
import by.myself.entities.User;
import by.myself.service.ChatService;
import by.myself.service.TopicService;
import by.myself.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final UserRepository userRepository;
    private final TopicService topicService;

    @Autowired
    public ChatController(ChatService chatService, UserRepository userRepository, TopicService topicService) {
        this.chatService = chatService;
        this.userRepository = userRepository;
        this.topicService = topicService;
    }

    @ModelAttribute
    public List<Comment> commentList() {
        return chatService.findAllMessages();
    }

    @ModelAttribute
    public Topic topic() {
        return topicService.getTopic();
    }

    @ModelAttribute
    public Comment userNewComment() {
        return new Comment();
    }

    @GetMapping("forum/topic")
    public String goToChat() {
        return "forum/topic";
    }

    @PostMapping("forum/topic")
    public String postComment(Comment comment, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());

        comment.setUser(user);
        comment.setDateTime(LocalDateTime.now());

        chatService.saveComment(comment);
        return "redirect:/forum/topic";
    }

    @PostMapping("forum/topic/edit")
    public String editTopic(Topic topic) {
        topicService.editTopic(topic);
        return "redirect:/forum/topic";
    }
}
