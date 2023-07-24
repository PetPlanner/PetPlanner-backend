package com.example.PetPlanner.service;

import com.example.PetPlanner.model.AnswerOnTopic;
import com.example.PetPlanner.repository.AnswerOnTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerOnTopicService {

    private final AnswerOnTopicRepository answerOnTopicRepository;

    public List<AnswerOnTopic> create(AnswerOnTopic asw){
        asw.setDateTime(LocalDateTime.now());
        answerOnTopicRepository.save(asw);
        return findByTopicId(asw.getId());
    }

    public List<AnswerOnTopic> findAll(){
        return answerOnTopicRepository.findAll();
    }

    public AnswerOnTopic findById(Long id){
        return answerOnTopicRepository.findById(id).get();
    }

    public List<AnswerOnTopic> findByTopicId(Long id){
        return answerOnTopicRepository.findByTopicId(id);
    }
}
