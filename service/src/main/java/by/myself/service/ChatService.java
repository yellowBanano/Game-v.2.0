package by.myself.service;

import by.myself.entities.Comment;

import java.util.List;

public interface ChatService {

    List<Comment> findAllMessages();

    void saveComment(Comment comment);
}
