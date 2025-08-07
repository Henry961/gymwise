package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.TrainingRecommendEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainingRecommendCrudRepository extends CrudRepository<TrainingRecommendEntity, Integer> {
}
