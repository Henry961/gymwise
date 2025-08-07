package com.nigma.gymwise.GymWise.infrastucture.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ia_recommendation")
@Data
@NoArgsConstructor
public class IaRecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_recommendation")
    private Integer idIaRecommendation;

    @Column(name = "fk_id_user")
    private Integer idUser;

    @Column(name = "recommendation_text")
    private String recommendationText;

}
