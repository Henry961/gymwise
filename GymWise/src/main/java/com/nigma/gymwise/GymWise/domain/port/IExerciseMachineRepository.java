package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachine;
import java.util.List;
import java.util.Optional;

public interface IExerciseMachineRepository {
    ExerciseMachine save(ExerciseMachine exerciseMachine);
    Optional<ExerciseMachine> findById(Integer id);
    List<ExerciseMachine> findAll();
    void deleteById(Integer id);
}
