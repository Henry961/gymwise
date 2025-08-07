package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseMachineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExerciseMachineCrudRepository extends CrudRepository<ExerciseMachineEntity, Integer> {
}
