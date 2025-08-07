package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.UserPreferences;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserPreferencesEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserPreferencesMapper {

    @Mappings(
            {
                    @Mapping(source = "idUserPreferences", target = "idUserPreferences"),
                    @Mapping(source = "idUser", target = "idUser"),
                    @Mapping(source = "goal", target = "goal"),
                    @Mapping(source = "dietaryRestrictions", target = "dietaryRestrictions"),
                    @Mapping(source = "limitations", target = "limitations")
            }
    )
    UserPreferences toUserPreferences(UserPreferencesEntity userPreferencesEntity);

    @InheritInverseConfiguration
    UserPreferencesEntity toUserPreferencesEntity(UserPreferences userPreferences);

}
