package by.myself.service;

import by.myself.entities.Topic;

import javax.persistence.OptimisticLockException;

public interface TopicService {

    Topic getTopic();

    void editTopic(Topic topic) throws OptimisticLockException;
}
