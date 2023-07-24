package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.AnswerOnTopic;
import com.example.PetPlanner.service.AnswerOnTopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answer")
@RequiredArgsConstructor
public class AnswerOnTopicContoller {
    private final AnswerOnTopicService answerOnTopicService;

    @PostMapping
    public ResponseEntity create(@RequestBody AnswerOnTopic answerOnTopic){
        return ResponseEntity.status(HttpStatus.OK).body(answerOnTopicService.create(answerOnTopic));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(answerOnTopicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(answerOnTopicService.findById(id));
    }
    @GetMapping("/topic/{id}")
    public ResponseEntity findByTopicId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(answerOnTopicService.findByTopicId(id));
    }


}
