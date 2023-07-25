package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.TopicDto;
import com.example.PetPlanner.model.Topic;
import com.example.PetPlanner.model.TopicStatus;
import com.example.PetPlanner.repository.AnswerOnTopicRepository;
import com.example.PetPlanner.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    private final AnswerOnTopicRepository answerOnTopicRepository;

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

    public List<TopicDto> findAllAccepted(){
        List<Topic> topics = findAllByStatus(TopicStatus.ACCEPTED);
        List<TopicDto> retVal = new ArrayList<>();

        for(Topic t : topics){
            retVal.add(TopicDto.builder()
                            .title(t.getTitle())
                            .dateTime(t.getDateTime())
                            .numberOfPreview(t.getNumberOfPreview())
                            .topicId(t.getId())
                            .numOfAnswers(countAnswer(t.getId()))
                    .build());
        }
        return retVal;
    }

    private int countAnswer(Long topicId){
        return answerOnTopicRepository.countAnswer(topicId);
    }
}
