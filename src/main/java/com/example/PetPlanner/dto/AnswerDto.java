package com.example.PetPlanner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerDto {
    private Long answerdId;
    private String text;
    private LocalDateTime dateTime;
    private String name;
    private Long topicId;
}
