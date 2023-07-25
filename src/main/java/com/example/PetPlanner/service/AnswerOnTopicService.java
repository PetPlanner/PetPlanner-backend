package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.AnswerDto;
import com.example.PetPlanner.model.AnswerOnTopic;
import com.example.PetPlanner.repository.AnswerOnTopicRepository;
import com.example.PetPlanner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerOnTopicService {

    private final AnswerOnTopicRepository answerOnTopicRepository;

    private final UserRepository userRepository;

    public List<AnswerDto> create(AnswerOnTopic asw){
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

    public List<AnswerDto> findByTopicId(Long id){
        List<AnswerDto> retVal = new ArrayList<>();
        List<AnswerOnTopic> answers = answerOnTopicRepository.findByTopicId(id);
        for(AnswerOnTopic a : answers){
            retVal.add(AnswerDto.builder()
                            .text(a.getText())
                            .topicId(a.getTopicId())
                            .answerdId(a.getId())
                            .dateTime(a.getDateTime())
                            .name(userRepository.findById(a.getUserId()).get().getFirstname())
                    .build());
        }
        return retVal;
    }
}
