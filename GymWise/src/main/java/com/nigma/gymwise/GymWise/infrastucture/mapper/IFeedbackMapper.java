package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.Feedback;
import com.nigma.gymwise.GymWise.infrastucture.entity.FeedbackEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IFeedbackMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "userId", target = "userId"),
        @Mapping(source = "rating", target = "rating"),
        @Mapping(source = "comments", target = "comments"),
        @Mapping(source = "feedbackDate", target = "feedbackDate"),
    })
    Feedback toFeedback(FeedbackEntity entity);

    @InheritInverseConfiguration
    FeedbackEntity toFeedbackEntity(Feedback model);
}
