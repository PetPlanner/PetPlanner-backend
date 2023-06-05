package com.example.PetPlanner.service;

import com.example.PetPlanner.model.Comment;
import com.example.PetPlanner.model.Operation;
import com.example.PetPlanner.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {
    private final OperationRepository operationRepository;

    public Operation create(Operation operation){
        return operationRepository.save(operation);
    }

    public Operation findById(Long id){
        return operationRepository.findById(id).get();
    }

    public List<Operation> findByPetId(Long id){
        return operationRepository.findByPetId(id);
    }

    public List<Operation> findByVetId(Long id){
        return operationRepository.findByVetId(id);
    }

    public void deleteById(Long id){
        operationRepository.deleteById(id);
    }
}
