package com.nigma.gymwise.GymWise.infrastucture.mapper;

import com.nigma.gymwise.GymWise.domain.model.TypeDocument;
import com.nigma.gymwise.GymWise.infrastucture.entity.TypeDocumentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ITypeDocumentMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "abbreviation", target = "abbreviation"),
        @Mapping(source = "typeDocument", target = "typeDocument"),
    })
    TypeDocument toTypeDocument(TypeDocumentEntity entity);

    @InheritInverseConfiguration
    TypeDocumentEntity toTypeDocumentEntity(TypeDocument model);
}
