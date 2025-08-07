package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.UserBody;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserBodyEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserBodyMapper {

    @Mappings(
            {
                    @Mapping(source = "idBody", target = "idBody"),
                    @Mapping(source = "idUser", target = "idUser"),
                    @Mapping(source = "bmi", target = "bmi"),
                    @Mapping(source = "fat", target = "fat"),
                    @Mapping(source = "bodyFatWeight", target = "bodyFatWeight"),
                    @Mapping(source = "skeletalMuscleMass", target = "skeletalMuscleMass"),
                    @Mapping(source = "weightSkeletalMuscle", target = "weightSkeletalMuscle"),
                    @Mapping(source = "muscle", target = "muscle"),
                    @Mapping(source = "weightMuscle", target = "weightMuscle"),
                    @Mapping(source = "visceralFat", target = "visceralFat"),
                    @Mapping(source = "water", target = "water"),
                    @Mapping(source = "weightWater", target = "weightWater"),
                    @Mapping(source = "metabolism", target = "metabolism")
            }
    )
    UserBody toUserBody(UserBodyEntity userBodyEntity);

    @InheritInverseConfiguration
    UserBodyEntity toUserBodyEntity(UserBody userBody);

}
