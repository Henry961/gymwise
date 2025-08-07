package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.Exercise;
import java.util.List;
import java.util.Optional;

public interface IExerciseRepository {
    Exercise save(Exercise exercise);
    Optional<Exercise> findById(Integer id);
    List<Exercise> findAll();
    void deleteById(Integer id);
}
