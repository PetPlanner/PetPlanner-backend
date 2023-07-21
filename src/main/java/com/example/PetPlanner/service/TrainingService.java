package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Training;
import com.example.PetPlanner.repository.TrainingRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public Training create(Training training){
        return trainingRepository.save(training);
    }

    public List<Training> findAll(){
        return trainingRepository.findAll();
    }

    public Training findById(Long id){
        return trainingRepository.findById(id).get();
    }

    public Training findByImgUrl(String img){
        return  trainingRepository.findByImgUrl(img);
    }
}
