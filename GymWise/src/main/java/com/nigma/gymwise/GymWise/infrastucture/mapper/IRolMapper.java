package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.Rol;
import com.nigma.gymwise.GymWise.infrastucture.entity.RolEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IRolMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "descriptionRol", target = "descriptionRol"),
    })
    Rol toRol(RolEntity entity);

    @InheritInverseConfiguration
    RolEntity toRolEntity(Rol model);
}
