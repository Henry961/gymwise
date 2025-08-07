package com.nigma.gymwise.GymWise.infrastucture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diet_plan")
public class DietPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_diet_plan")
    private Integer id;
    @Column(name = "fk_id_user")
    private Integer userId;
    @Column(name = "calories_target")
    private Integer caloriesTarget;
    @Column(name = "protein_target")
    private Integer proteinTarget;
    @Column(name = "fat_target")
    private Integer fatTarget;
    @Column(name = "date_created")
    private java.time.LocalDateTime dateCreated;
}
