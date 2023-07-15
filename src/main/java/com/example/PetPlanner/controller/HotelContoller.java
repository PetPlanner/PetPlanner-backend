package com.example.PetPlanner.controller;

import com.example.PetPlanner.dto.VetStationSearchDto;
import com.example.PetPlanner.model.Hotel;
import com.example.PetPlanner.model.Pet;
import com.example.PetPlanner.model.VetStation;
import com.example.PetPlanner.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hotel")
public class HotelContoller {
    private final HotelService hotelService;
    @PostMapping
    public ResponseEntity create(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.create(hotel));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.findAll());
    }

    @PostMapping("/search")
    public ResponseEntity search(@RequestBody VetStationSearchDto searchDto){
        List<Hotel> stations = hotelService.search(searchDto);
        if(stations.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        else
            return ResponseEntity.status(HttpStatus.OK).body(stations);
    }
}
