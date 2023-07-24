package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Topic;
import com.example.PetPlanner.model.TopicStatus;
import com.example.PetPlanner.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public Topic create(Topic topic){
        topic.setStatus(TopicStatus.PENDING);
        topic.setDateTime(LocalDateTime.now());
        topic.setNumberOfPreview(0L);
        return topicRepository.save(topic);
    }

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public List<Topic> findAllByStatus(TopicStatus status){
        return topicRepository.findAllByStatus(status);
    }

    public Topic findById(Long id){
        Topic t = topicRepository.findById(id).get();
        t.setNumberOfPreview(t.getNumberOfPreview()+1);
        return topicRepository.save(t);
    }

    public List<Topic> changeStatus(Long id, TopicStatus status) {
        Topic t = findById(id);
        t.setStatus(status);
        topicRepository.save(t);
        return findAllByStatus(TopicStatus.PENDING);
    }
}
