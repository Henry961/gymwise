package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.infrastucture.entity.IaRecommendationEntity;

import java.util.List;

public interface IIaRecommendationRepository {
    void save(IaRecommendationEntity iaRecommendationEntity);

    List<IaRecommendationEntity> findAll();
}
