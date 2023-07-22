package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.VaccineDto;
import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.model.Vaccine;
import com.example.PetPlanner.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public List<Pet> create(Pet pet) {
        petRepository.save(pet);
        return findByUserId(pet.getUserId());
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

    public Pet addVaccine(VaccineDto dto) {
        Pet p = findById(dto.getPetId());
        Vaccine newVaccine = Vaccine.builder()
                .company(dto.getCompany())
                .dossage(dto.getDossage())
                .name(dto.getName())
                .expirationDate(LocalDate.now().plusYears(5))
                .build();
        p.getVaccines().add(newVaccine);
        return petRepository.save(p);
    }
}
