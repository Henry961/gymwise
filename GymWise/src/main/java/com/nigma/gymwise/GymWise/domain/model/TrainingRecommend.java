package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingRecommend {
    private Integer id;
    private Integer userId;
    private Integer exerciseMachineRelationId;
    private Integer reps;
    private Integer serie;
    private Integer restTime;
    private java.time.LocalDateTime startDate;
    private java.time.LocalDateTime endDate;
}
