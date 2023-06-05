package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.VetStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VetStationRepository extends JpaRepository<VetStation,Long> {

    List<VetStation> findByHostId(Long id);
}
