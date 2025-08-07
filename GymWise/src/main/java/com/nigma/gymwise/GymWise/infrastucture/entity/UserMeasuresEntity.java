package com.nigma.gymwise.GymWise.infrastucture.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "user_measures")
@Data
@NoArgsConstructor
public class UserMeasuresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_progress")
    private Integer idProgress;

    @Column(name = "fk_id_user")
    private Integer idUser;

    @Column(name = "um_weight")
    private BigDecimal weight;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "neck")
    private BigDecimal neck;

    @Column(name = "left_arm")
    private BigDecimal leftArm;

    @Column(name = "right_arm")
    private BigDecimal rightArm;

    @Column(name = "chest")
    private BigDecimal chest;

    @Column(name = "waist")
    private BigDecimal waist;

    @Column(name = "left_thigh")
    private BigDecimal leftThigh;

    @Column(name = "right_thigh")
    private BigDecimal rightThigh;

    @Column(name = "left_calf")
    private BigDecimal leftCalf;

    @Column(name = "right_calf")
    private BigDecimal rightCalf;

    @Column(name = "hip")
    private BigDecimal hip;

}
