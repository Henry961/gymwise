package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachineRelation;
import com.nigma.gymwise.GymWise.domain.port.IExerciseMachineRelationRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseMachineRelationEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IExerciseMachineRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class ExerciseMachineRelationCrudRepositoryImpl implements IExerciseMachineRelationRepository {
    @Autowired
    private IExerciseMachineRelationCrudRepository crudRepository;

    @Autowired
    private IExerciseMachineRelationMapper mapper;

    @Override
    public ExerciseMachineRelation save(ExerciseMachineRelation exercisemachinerelation) {
        ExerciseMachineRelationEntity entity = mapper.toExerciseMachineRelationEntity(exercisemachinerelation);
        ExerciseMachineRelationEntity saved = crudRepository.save(entity);
        return mapper.toExerciseMachineRelation(saved);
    }

    @Override
    public Optional<ExerciseMachineRelation> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toExerciseMachineRelation);
    }

    @Override
    public List<ExerciseMachineRelation> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toExerciseMachineRelation)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
