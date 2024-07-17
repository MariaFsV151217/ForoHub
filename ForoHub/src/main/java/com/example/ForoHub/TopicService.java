package com.example.ForoHub;

import com.alura.foroalura.model.Topic;
import com.alura.foroalura.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic updateTopic(Long id, Topic updatedTopic) {
        return topicRepository.findById(id)
                .map(topic -> {
                    topic.setTitle(updatedTopic.getTitle());
                    topic.setMessage(updatedTopic.getMessage());
                    return topicRepository.save(topic);
                }).orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}