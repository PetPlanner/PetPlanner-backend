package com.example.PetPlanner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {

    private Long topicId;

    private LocalDateTime dateTime;

    private Long numberOfPreview;

    private String title;

    private int numOfAnswers;
}
