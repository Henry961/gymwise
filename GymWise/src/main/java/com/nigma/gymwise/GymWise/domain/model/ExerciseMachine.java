package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseMachine {
    private Integer pkIdMch;
    private String emName;
    private String emDescription;
    private String urlImg;
}
