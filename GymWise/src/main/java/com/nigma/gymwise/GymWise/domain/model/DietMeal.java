package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietMeal {
    private Integer id;
    private Integer dietPlanId;
    private String mealType;
    private String name;
    private Integer calories;
    private Integer protein;
    private Integer carbs;
    private Integer fat;
}
