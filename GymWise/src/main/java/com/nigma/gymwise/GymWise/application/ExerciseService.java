package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.Exercise;
import com.nigma.gymwise.GymWise.domain.port.IExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final IExerciseRepository repository;

    public ExerciseService(IExerciseRepository repository) {
        this.repository = repository;
    }

    public Exercise save(Exercise exercise) {
        return repository.save(exercise);
    }

    public Optional<Exercise> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Exercise> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
