package com.nigma.gymwise.GymWise.infrastucture.adapter.Impl;

import com.nigma.gymwise.GymWise.domain.port.IIaRecommendationRepository;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IIaRecommendationCrudRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.IaRecommendationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IaRecommendationCrudRepositoryImpl implements IIaRecommendationRepository {

    private final IIaRecommendationCrudRepository iIaRecommendationCrudRepository;

    public IaRecommendationCrudRepositoryImpl(IIaRecommendationCrudRepository iIaRecommendationCrudRepository) {
        this.iIaRecommendationCrudRepository = iIaRecommendationCrudRepository;
    }

    @Override
    public void save(IaRecommendationEntity iaRecommendationEntity){
        iIaRecommendationCrudRepository.save(iaRecommendationEntity);
    }

    @Override
    public List<IaRecommendationEntity> findAll(){

        return (List<IaRecommendationEntity>) iIaRecommendationCrudRepository.findAll();

    }

}
