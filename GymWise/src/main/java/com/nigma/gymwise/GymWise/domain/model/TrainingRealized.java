package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingRealized {
    private Integer id;
    private Integer exerciseMachineRelationId;
    private Integer userId;
    private Integer reps;
    private Integer serie;
    private Integer restTime;
    private String note;
    private java.time.LocalDateTime dateTraining;
}
