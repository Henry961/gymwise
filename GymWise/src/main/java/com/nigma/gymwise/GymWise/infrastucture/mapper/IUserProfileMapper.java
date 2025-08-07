package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.UserProfile;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserProfileEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserProfileMapper {

    @Mappings(
            {
                    @Mapping(source = "idUser", target = "idUser"),
                    @Mapping(source = "idDocumentType", target = "idDocumentType"),
                    @Mapping(source = "NDocument", target = "NDocument"),
                    @Mapping(source = "nameUser", target = "nameUser"),
                    @Mapping(source = "lastName", target = "lastName"),
                    @Mapping(source = "birthdate", target = "birthdate"),
                    @Mapping(source = "email", target = "email"),
                    @Mapping(source = "phoneNumber", target = "phoneNumber"),
                    @Mapping(source = "passwordUser", target = "passwordUser"),
                    @Mapping(source = "idRol", target = "idRol")

            }
    )

    UserProfile toUser(UserProfileEntity userProfileEntity);

    @InheritInverseConfiguration
    UserProfileEntity toUserEntity(UserProfile userProfile);

}
