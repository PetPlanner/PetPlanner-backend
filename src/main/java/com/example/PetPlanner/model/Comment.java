package com.example.PetPlanner.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    int grade;

    @Column(nullable = false)
    String comment;

    @Column(nullable = false)
    Long userId;

    @Column(nullable = false)
    Long objectId;

    @Column(nullable = false)
    ObjectType objectType;

    LocalDateTime dateTime;
}
