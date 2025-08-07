package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.TrainingRealized;
import com.nigma.gymwise.GymWise.infrastucture.entity.TrainingRealizedEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ITrainingRealizedMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "exerciseMachineRelationId", target = "exerciseMachineRelationId"),
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "reps", target = "reps"),
        @Mapping(source = "serie", target = "serie"),
        @Mapping(source = "restTime", target = "restTime"),
        @Mapping(source = "note", target = "note"),
        @Mapping(source = "dateTraining", target = "dateTraining"),
    })
    TrainingRealized toTrainingRealized(TrainingRealizedEntity entity);

    @InheritInverseConfiguration
    TrainingRealizedEntity toTrainingRealizedEntity(TrainingRealized model);
}
