package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachineRelation;
import com.nigma.gymwise.GymWise.domain.port.IExerciseMachineRelationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseMachineRelationService {
    private final IExerciseMachineRelationRepository repository;

    public ExerciseMachineRelationService(IExerciseMachineRelationRepository repository) {
        this.repository = repository;
    }

    public ExerciseMachineRelation save(ExerciseMachineRelation exercisemachinerelation) {
        return repository.save(exercisemachinerelation);
    }

    public Optional<ExerciseMachineRelation> findById(Integer id) {
        return repository.findById(id);
    }

    public List<ExerciseMachineRelation> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
