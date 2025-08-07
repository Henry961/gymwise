package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.UserMeasuresBody;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserMeasuresEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserMeasuresBodyMapper {

    @Mappings(
            {
                    @Mapping(source = "idProgress", target = "idProgress"),
                    @Mapping(source = "idUser", target = "idUser"),
                    @Mapping(source = "weight", target = "weight"),
                    @Mapping(source = "height", target = "height"),
                    @Mapping(source = "neck", target = "neck"),
                    @Mapping(source = "leftArm", target = "leftArm"),
                    @Mapping(source = "rightArm", target = "rightArm"),
                    @Mapping(source = "chest", target = "chest"),
                    @Mapping(source = "waist", target = "waist"),
                    @Mapping(source = "leftThigh", target = "leftThigh"),
                    @Mapping(source = "rightThigh", target = "rightThigh"),
                    @Mapping(source = "leftCalf", target = "leftCalf"),
                    @Mapping(source = "rightCalf", target = "rightCalf"),
                    @Mapping(source = "hip", target = "hip")
            }
    )

    UserMeasuresBody toUserMeasures(UserMeasuresEntity userMeasuresEntity);

    @InheritInverseConfiguration
    UserMeasuresEntity toUserMeasuresEntity(UserMeasuresBody userMeasuresBody);

}
