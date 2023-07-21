package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Long> {

    Training findByImgUrl(String imgUrl);
}
