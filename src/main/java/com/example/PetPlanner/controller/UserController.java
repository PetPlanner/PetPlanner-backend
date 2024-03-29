package com.example.PetPlanner.controller;

import com.example.PetPlanner.model.Role;
import com.example.PetPlanner.model.User;
import com.example.PetPlanner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nothing found.");
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }


    @GetMapping("/city/{city}")
    public ResponseEntity findWalkerByCity(@PathVariable String city){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findWalkerByCity(city));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity findByRole(@PathVariable Role role){
        return  ResponseEntity.status(HttpStatus.OK).body(userService.findByRole(role));
    }

}
