package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Hotel;
import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.repository.PetRepository;
import com.example.PetPlanner.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet")
@RequiredArgsConstructor
public class PetContoller {
    private final PetService petService;

    @PostMapping
    public ResponseEntity create(@RequestBody Pet pet) {
        return ResponseEntity.status(HttpStatus.OK).body(petService.create(pet));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(petService.findById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity findByUserId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(petService.findByUserId(id));
    }
}
