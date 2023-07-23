package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Reminder;
import com.example.PetPlanner.repository.ReminderRepository;
import com.example.PetPlanner.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reminder")
public class ReminderController {

    private final ReminderService reminderService;


    @PostMapping
    public ResponseEntity create(@RequestBody Reminder reminder){
        return ResponseEntity.status(HttpStatus.OK).body(reminderService.create(reminder));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(reminderService.findAll());
    }

    @GetMapping("/change-active/id/{id}")
    public ResponseEntity changeActivateStatus(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reminderService.changeStatus(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reminderService.deleteById(id));
    }
}
