package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.Notification;
import com.nigma.gymwise.GymWise.infrastucture.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface INotificationMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "notificationMessage", target = "notificationMessage"),
        @Mapping(source = "notificationStatus", target = "notificationStatus"),
        @Mapping(source = "dateSent", target = "dateSent"),
    })
    Notification toNotification(NotificationEntity entity);

    @InheritInverseConfiguration
    NotificationEntity toNotificationEntity(Notification model);
}
