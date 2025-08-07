package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseMachineRelationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExerciseMachineRelationCrudRepository extends CrudRepository<ExerciseMachineRelationEntity, Integer> {
}
