package com.example.PetPlanner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserNotFound extends RuntimeException{
    public UserNotFound(){ super("User not found.");}
}
