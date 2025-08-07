package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diet_meal")
public class DietMealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_diet_meal")
    private Integer id;

    @Column(name = "fk_id_diet_plan", nullable = false)
    private Integer dietPlanId;

    @Column(name = "meal_type", nullable = false, length = 50)
    private String mealType;

    @Column(name = "dm_name", nullable = false, length = 255)
    private String name;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "protein")
    private Integer protein;

    @Column(name = "carbs")
    private Integer carbs;

    @Column(name = "fat")
    private Integer fat;
}
