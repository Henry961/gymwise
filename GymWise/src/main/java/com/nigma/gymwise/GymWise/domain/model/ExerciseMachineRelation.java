package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseMachineRelation {
    private Integer id;
    private Integer exerciseId;
    private Integer machineId;
}
