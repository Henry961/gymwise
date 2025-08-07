package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.UserMembership;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserMembershipEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserMembershipMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "trainerId", target = "trainerId"),
        @Mapping(source = "typeMembershipId", target = "typeMembershipId"),
        @Mapping(source = "expirationDate", target = "expirationDate"),
        @Mapping(source = "active", target = "active"),
    })
    UserMembership toUserMembership(UserMembershipEntity entity);

    @InheritInverseConfiguration
    UserMembershipEntity toUserMembershipEntity(UserMembership model);
}
