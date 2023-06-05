package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.model.VetStation;
import com.example.PetPlanner.repository.VetStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VetStationService {
    private final VetStationRepository vetStationRepository;

    public VetStation create(VetStation vetStation) {
        return vetStationRepository.save(vetStation);
    }

    public VetStation findById(Long id) {
        return vetStationRepository.findById(id).get();
    }

    public List<VetStation> findAll() {
        return vetStationRepository.findAll();
    }

    public List<VetStation> findByHostId(Long id) {
        return vetStationRepository.findByHostId(id);
    }
}
