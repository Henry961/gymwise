package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.UserRecord;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserRecordEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserRecordMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "dateRecord", target = "dateRecord"),
    })
    UserRecord toUserRecord(UserRecordEntity entity);

    @InheritInverseConfiguration
    UserRecordEntity toUserRecordEntity(UserRecord model);
}
