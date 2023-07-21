package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Training;
import com.example.PetPlanner.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingContoller {
    private final TrainingService trainingService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(trainingService.findAll());
    }

    @GetMapping("/img/{img}")
    public ResponseEntity findByImg(@PathVariable String img){
        return ResponseEntity.status(HttpStatus.OK).body(trainingService.findByImgUrl(img));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Training training){
        return ResponseEntity.status(HttpStatus.OK).body(trainingService.create(training));
    }

}
