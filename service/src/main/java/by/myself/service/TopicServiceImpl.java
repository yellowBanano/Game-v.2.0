package by.myself.service;

import by.myself.annotation.Loggable;
import by.myself.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;

@Service
@Transactional
@Loggable
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic getTopic() throws OptimisticLockException {
        return topicRepository.findAll().iterator().next();
    }

    @Override
    public void editTopic(Topic topic) {
        topicRepository.save(topic);
    }
}
