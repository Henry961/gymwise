package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.TypeDocument;
import com.nigma.gymwise.GymWise.domain.port.ITypeDocumentRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.TypeDocumentEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.ITypeDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class TypeDocumentCrudRepositoryImpl implements ITypeDocumentRepository {
    @Autowired
    private ITypeDocumentCrudRepository crudRepository;

    @Autowired
    private ITypeDocumentMapper mapper;

    @Override
    public TypeDocument save(TypeDocument typedocument) {
        TypeDocumentEntity entity = mapper.toTypeDocumentEntity(typedocument);
        TypeDocumentEntity saved = crudRepository.save(entity);
        return mapper.toTypeDocument(saved);
    }

    @Override
    public Optional<TypeDocument> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toTypeDocument);
    }

    @Override
    public List<TypeDocument> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toTypeDocument)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
