package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Topic;
import com.example.PetPlanner.model.TopicStatus;
import com.example.PetPlanner.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topic")
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    public ResponseEntity create(@RequestBody Topic topic){
        return ResponseEntity.status(HttpStatus.OK).body(topicService.create(topic));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(topicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(topicService.findById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity findAllByStatus(@PathVariable TopicStatus status){
        return ResponseEntity.status(HttpStatus.OK).body(topicService.findAllByStatus(status));
    }

    @PutMapping("/id/{id}/status/{status}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity changeStatus(@PathVariable TopicStatus status, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(topicService.changeStatus(id,status));
    }

    @GetMapping("/accepted")
    public ResponseEntity findAllAccepted(){
        return ResponseEntity.status(HttpStatus.OK).body(topicService.findAllAccepted());
    }

}
