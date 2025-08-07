package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietPlan {
    private Integer id;
    private Integer userId;
    private Integer caloriesTarget;
    private Integer proteinTarget;
    private Integer fatTarget;
    private java.time.LocalDateTime dateCreated;
}
