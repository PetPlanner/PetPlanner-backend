package com.example.PetPlanner.repository;

import com.example.PetPlanner.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByPetId(Long id);

    List<Operation> findByVetId(Long id);

}