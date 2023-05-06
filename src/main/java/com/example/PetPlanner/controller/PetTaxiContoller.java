package com.example.PetPlanner.controller;

import com.example.PetPlanner.dto.CordinateDTO;
import com.example.PetPlanner.service.PetTaxiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taxi")
@RequiredArgsConstructor
public class PetTaxiContoller {
    private final PetTaxiService petTaxiService;

    @PostMapping("/start")
    public ResponseEntity startTaxi(@RequestBody CordinateDTO cordinates){
        try{
            petTaxiService.start(cordinates);
            return ResponseEntity.status(HttpStatus.OK).body("Started.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some errors occurred please try again later.");
        }
    }
}
