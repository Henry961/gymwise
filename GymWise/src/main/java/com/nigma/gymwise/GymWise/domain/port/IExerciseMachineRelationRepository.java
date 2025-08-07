package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachineRelation;
import java.util.List;
import java.util.Optional;

public interface IExerciseMachineRelationRepository {
    ExerciseMachineRelation save(ExerciseMachineRelation exercisemachinerelation);
    Optional<ExerciseMachineRelation> findById(Integer id);
    List<ExerciseMachineRelation> findAll();
    void deleteById(Integer id);
}
