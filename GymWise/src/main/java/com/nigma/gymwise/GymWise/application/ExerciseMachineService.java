package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachine;
import com.nigma.gymwise.GymWise.domain.port.IExerciseMachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseMachineService {

    private final IExerciseMachineRepository repository;

    public ExerciseMachineService(IExerciseMachineRepository repository) {
        this.repository = repository;
    }

    public ExerciseMachine save(ExerciseMachine exerciseMachine) {
        return repository.save(exerciseMachine);
    }

    public Optional<ExerciseMachine> findById(Integer id) {
        return repository.findById(id);
    }

    public List<ExerciseMachine> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
