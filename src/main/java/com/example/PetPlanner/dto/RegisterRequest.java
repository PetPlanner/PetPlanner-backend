package com.example.PetPlanner.dto;

import com.example.PetPlanner.model.Address;
import com.example.PetPlanner.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String email;

    private String password;

    private Role role;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private Address address;
}
