package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.Exercise;
import com.nigma.gymwise.GymWise.infrastucture.entity.ExerciseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IExerciseMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "description", target = "description"),
        @Mapping(source = "urlImg", target = "urlImg"),
        @Mapping(source = "urlVideo", target = "urlVideo"),
    })
    Exercise toExercise(ExerciseEntity entity);

    @InheritInverseConfiguration
    ExerciseEntity toExerciseEntity(Exercise model);
}
