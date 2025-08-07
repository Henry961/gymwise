package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.TypeDocument;
import com.nigma.gymwise.GymWise.domain.port.ITypeDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDocumentService {
    private final ITypeDocumentRepository repository;

    public TypeDocumentService(ITypeDocumentRepository repository) {
        this.repository = repository;
    }

    public TypeDocument save(TypeDocument typedocument) {
        return repository.save(typedocument);
    }

    public Optional<TypeDocument> findById(Integer id) {
        return repository.findById(id);
    }

    public List<TypeDocument> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
