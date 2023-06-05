package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.model.VetStation;
import com.example.PetPlanner.service.VetStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/vet-station")
@RestController
public class VetStationContoller {
    private final VetStationService vetStationService;

    @PostMapping
    public ResponseEntity create(@RequestBody VetStation vetStation) {
        return ResponseEntity.status(HttpStatus.OK).body(vetStationService.create(vetStation));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(vetStationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vetStationService.findById(id));
    }

    @GetMapping("/host/{id}")
    public ResponseEntity findByHostId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vetStationService.findByHostId(id));
    }
}
