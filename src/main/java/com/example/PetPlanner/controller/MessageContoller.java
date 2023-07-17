package com.example.PetPlanner.controller;

import com.example.PetPlanner.dto.MessageDto;
import com.example.PetPlanner.model.Message;
import com.example.PetPlanner.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/message")
public class MessageContoller {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.findById(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MessageDto message){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.create(message));
    }

    @GetMapping("/receiverId/{id}")
    public ResponseEntity findByReceiverId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.findByReceiverId(id));
    }

    @PutMapping("/seen/{id}")
    public ResponseEntity changeSeenStatus(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(messageService.changeSeenStatus(id));
    }
}
