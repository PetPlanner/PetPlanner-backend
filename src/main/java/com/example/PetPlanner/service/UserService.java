package com.example.PetPlanner.service;

import com.example.PetPlanner.exception.UserNotFound;
import com.example.PetPlanner.model.User;
import com.example.PetPlanner.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() ->new UserNotFound());
    }

    public void deleteById(Long id){
        findById(id);
        userRepository.deleteById(id);
    }

    public List<User> findWalkerByCity(String city) {
        return userRepository.findWalkerByCity(city);
    }
}
