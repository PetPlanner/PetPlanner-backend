package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.VetStationSearchDto;
import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.model.VetStation;
import com.example.PetPlanner.repository.VetStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

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

    public List<VetStation> search(VetStationSearchDto searchDto) {
        return vetStationRepository.searchByNameAndCity(searchDto.getName().toLowerCase(),searchDto.getCity().toLowerCase(),searchDto.getCountry().toLowerCase(),searchDto.getStreet().toLowerCase());
    }
}
