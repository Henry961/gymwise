package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.DietPlan;
import com.nigma.gymwise.GymWise.infrastucture.entity.DietPlanEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IDietPlanMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "caloriesTarget", target = "caloriesTarget"),
        @Mapping(source = "proteinTarget", target = "proteinTarget"),
        @Mapping(source = "fatTarget", target = "fatTarget"),
        @Mapping(source = "dateCreated", target = "dateCreated"),
    })
    DietPlan toDietPlan(DietPlanEntity entity);

    @InheritInverseConfiguration
    DietPlanEntity toDietPlanEntity(DietPlan model);
}
