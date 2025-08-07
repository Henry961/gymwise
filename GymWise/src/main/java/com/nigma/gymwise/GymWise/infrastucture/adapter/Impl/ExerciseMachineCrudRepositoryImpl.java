package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachine;
import com.nigma.gymwise.GymWise.domain.port.IExerciseMachineRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseMachineEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IExerciseMachineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ExerciseMachineCrudRepositoryImpl implements IExerciseMachineRepository {

    @Autowired
    private IExerciseMachineCrudRepository crudRepository;

    @Autowired
    private IExerciseMachineMapper mapper;

    @Override
    public ExerciseMachine save(ExerciseMachine exerciseMachine) {
        ExerciseMachineEntity entity = mapper.toExerciseMachineEntity(exerciseMachine);
        ExerciseMachineEntity saved = crudRepository.save(entity);
        return mapper.toExerciseMachine(saved);
    }

    @Override
    public Optional<ExerciseMachine> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toExerciseMachine);
    }

    @Override
    public List<ExerciseMachine> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toExerciseMachine)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
