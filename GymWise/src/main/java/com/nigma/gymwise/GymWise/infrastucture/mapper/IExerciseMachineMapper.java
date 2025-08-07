package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.ExerciseMachine;
import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseMachineEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IExerciseMachineMapper {

    @Mappings({
        @Mapping(source = "pkIdMch", target = "pkIdMch"),
        @Mapping(source = "emName", target = "emName"),
        @Mapping(source = "emDescription", target = "emDescription"),
        @Mapping(source = "urlImg", target = "urlImg")
    })
    ExerciseMachine toExerciseMachine(ExerciseMachineEntity entity);

    @InheritInverseConfiguration
    ExerciseMachineEntity toExerciseMachineEntity(ExerciseMachine model);
}
