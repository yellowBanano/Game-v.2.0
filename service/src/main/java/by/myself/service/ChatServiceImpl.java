package by.myself.service;

import by.myself.annotation.Loggable;
import by.myself.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Loggable
public class ChatServiceImpl implements ChatService {

    private final CommentRepository commentRepository;

    @Autowired
    public ChatServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAllMessages() {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
