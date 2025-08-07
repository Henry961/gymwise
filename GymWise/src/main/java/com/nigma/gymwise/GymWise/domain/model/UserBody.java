package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBody {

    private Integer idBody;
    private Integer idUser;
    private BigDecimal bmi;
    private BigDecimal fat;
    private BigDecimal bodyFatWeight;
    private BigDecimal skeletalMuscleMass;
    private BigDecimal weightSkeletalMuscle;
    private BigDecimal muscle;
    private BigDecimal weightMuscle;
    private BigDecimal visceralFat;
    private BigDecimal water;
    private BigDecimal weightWater;
    private BigDecimal metabolism;

}
