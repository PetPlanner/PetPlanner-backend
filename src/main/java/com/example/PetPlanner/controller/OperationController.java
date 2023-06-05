package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.model.Operation;
import com.example.PetPlanner.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operation")
public class OperationController {
    private final OperationService operationService;

    @PostMapping
    public ResponseEntity create(@RequestBody Operation operation) {
        return ResponseEntity.status(HttpStatus.OK).body(operationService.create(operation));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(operationService.findById(id));
    }
    @GetMapping("/pet/{id}")
    public ResponseEntity findByPetId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(operationService.findByPetId(id));
    }

    @GetMapping("/vet/{id}")
    public ResponseEntity findByVetId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(operationService.findByVetId(id));
    }

    @DeleteMapping("id")
    public ResponseEntity deleteById(@PathVariable Long id){
        operationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted.");
    }
}

