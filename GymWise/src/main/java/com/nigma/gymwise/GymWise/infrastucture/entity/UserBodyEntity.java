package com.nigma.gymwise.GymWise.infrastucture.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "user_body")
@Data
@NoArgsConstructor
public class UserBodyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_body")
    private Integer idBody;

    @Column(name = "fk_id_user")
    private Integer idUser;

    @Column(name = "bmi")
    private BigDecimal bmi;

    @Column(name = "fat")
    private BigDecimal fat;

    @Column(name = "body_fat_weight")
    private BigDecimal bodyFatWeight;

    @Column(name = "skeletal_muscle_mass")
    private BigDecimal skeletalMuscleMass;

    @Column(name = "weight_skeletal_muscle")
    private BigDecimal weightSkeletalMuscle;

    @Column(name = "muscle")
    private BigDecimal muscle;

    @Column(name = "weight_muscle")
    private BigDecimal weightMuscle;

    @Column(name = "visceral_fat")
    private BigDecimal visceralFat;

    @Column(name = "water")
    private BigDecimal water;

    @Column(name = "weight_water")
    private BigDecimal weightWater;

    @Column(name = "metabolism")
    private BigDecimal metabolism;

}
