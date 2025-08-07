package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachineRelation;
import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseMachineRelationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IExerciseMachineRelationMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "exerciseId", target = "exerciseId"),
        @Mapping(source = "machineId", target = "machineId"),
    })
    ExerciseMachineRelation toExerciseMachineRelation(ExerciseMachineRelationEntity entity);

    @InheritInverseConfiguration
    ExerciseMachineRelationEntity toExerciseMachineRelationEntity(ExerciseMachineRelation model);
}
