package com.example.PetPlanner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDtoResponse {
    private Long id;
    private String message;
    private String subject;
    private String sender;
}
