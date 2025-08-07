package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.MembershipType;
import com.nigma.gymwise.GymWise.infrastucture.entity.MembershipTypeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IMembershipTypeMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "abbreviation", target = "abbreviation"),
        @Mapping(source = "nameMembership", target = "nameMembership"),
    })
    MembershipType toMembershipType(MembershipTypeEntity entity);

    @InheritInverseConfiguration
    MembershipTypeEntity toMembershipTypeEntity(MembershipType model);
}
