package com.example.PetPlanner.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CordinateDTO {
    List<Double> startLocation;
    List<Double> endLocation;
}
