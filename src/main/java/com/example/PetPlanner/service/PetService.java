package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public Pet create(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet findById(Long id) {
        return petRepository.findById(id).get();
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public List<Pet> findByUserId(Long id) {
        return petRepository.findByUserId(id);
    }
}
