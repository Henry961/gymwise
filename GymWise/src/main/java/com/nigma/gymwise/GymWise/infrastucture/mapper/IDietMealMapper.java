package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.DietMeal;
import com.nigma.gymwise.GymWise.infrastucture.entity.DietMealEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IDietMealMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "dietPlanId", target = "dietPlanId"),
            @Mapping(source = "mealType", target = "mealType"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "calories", target = "calories"),
            @Mapping(source = "protein", target = "protein"),
            @Mapping(source = "carbs", target = "carbs"),
            @Mapping(source = "fat", target = "fat")
    })
    DietMeal toDietMeal(DietMealEntity entity);

    @InheritInverseConfiguration
    DietMealEntity toDietMealEntity(DietMeal model);
}
