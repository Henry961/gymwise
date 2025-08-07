package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.port.IIaRecommendationRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.IaRecommendationEntity;

import java.util.List;

public class IaRecommendationService {

    private final IIaRecommendationRepository iIaRecommendationRepository;

    public IaRecommendationService(IIaRecommendationRepository iIaRecommendationRepository) {
        this.iIaRecommendationRepository = iIaRecommendationRepository;
    }

    public void save(IaRecommendationEntity iaRecommendationEntity){
        iIaRecommendationRepository.save(iaRecommendationEntity);
    }

    public List<IaRecommendationEntity> findAll(){
        return iIaRecommendationRepository.findAll();
    }

}
