package com.example.PetPlanner.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VetStationSearchDto {
    String name;

    String country;

    String city;

    String street;
}
