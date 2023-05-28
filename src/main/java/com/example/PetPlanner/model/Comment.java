package com.example.PetPlanner.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    User user;

    @OneToOne
    @JoinColumn(name = "fk_hotel_id")
    Hotel hotel;
}
