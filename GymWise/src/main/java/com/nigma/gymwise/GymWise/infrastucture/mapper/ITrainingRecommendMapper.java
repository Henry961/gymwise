package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.TrainingRecommend;
import com.nigma.gymwise.GymWise.infrastucture.entity.TrainingRecommendEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ITrainingRecommendMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "exerciseMachineRelationId", target = "exerciseMachineRelationId"),
        @Mapping(source = "reps", target = "reps"),
        @Mapping(source = "serie", target = "serie"),
        @Mapping(source = "restTime", target = "restTime"),
        @Mapping(source = "startDate", target = "startDate"),
        @Mapping(source = "endDate", target = "endDate"),
    })
    TrainingRecommend toTrainingRecommend(TrainingRecommendEntity entity);

    @InheritInverseConfiguration
    TrainingRecommendEntity toTrainingRecommendEntity(TrainingRecommend model);
}
