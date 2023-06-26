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
public class VetStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_address_id")
    Address address;

    String workTime;

    String phoneNumber;

    String webSiteUrl;

    Long hostId;

    private float avgGrade = 0;
}
