package com.nigma.gymwise.GymWise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMeasuresBody {

    private Integer idProgress;

    private Integer idUser;

    private BigDecimal weight;

    private BigDecimal height;

    private BigDecimal neck;

    private BigDecimal leftArm;

    private BigDecimal rightArm;

    private BigDecimal chest;

    private BigDecimal waist;

    private BigDecimal leftThigh;

    private BigDecimal rightThigh;

    private BigDecimal leftCalf;

    private BigDecimal rightCalf;

    private BigDecimal hip;

}
