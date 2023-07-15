package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.VetStationSearchDto;
import com.example.PetPlanner.model.Hotel;
import com.example.PetPlanner.model.VetStation;
import com.example.PetPlanner.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    public Hotel findById(Long id){
        return hotelRepository.findById(id).get();
    }

    public Hotel create(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findByHostId(Long id) {
        return hotelRepository.findByHostId(id);
    }

    public List<Hotel> search(VetStationSearchDto searchDto) {
        return hotelRepository.searchByNameAndCity(searchDto.getName().toLowerCase(),searchDto.getCity().toLowerCase(),searchDto.getCountry().toLowerCase(),searchDto.getStreet().toLowerCase());
    }
}
