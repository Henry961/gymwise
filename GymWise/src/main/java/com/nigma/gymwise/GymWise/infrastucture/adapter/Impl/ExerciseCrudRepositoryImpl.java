package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.Exercise;
import com.nigma.gymwise.GymWise.domain.port.IExerciseRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IExerciseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ExerciseCrudRepositoryImpl implements IExerciseRepository {
    @Autowired
    private IExerciseCrudRepository crudRepository;

    @Autowired
    private IExerciseMapper mapper;

    @Override
    public Exercise save(Exercise exercise) {
        ExerciseEntity entity = mapper.toExerciseEntity(exercise);
        ExerciseEntity saved = crudRepository.save(entity);
        return mapper.toExercise(saved);
    }

    @Override
    public Optional<Exercise> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toExercise);
    }

    @Override
    public List<Exercise> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toExercise)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
