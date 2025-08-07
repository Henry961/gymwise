package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.TypeDocument;
import java.util.List;
import java.util.Optional;

public interface ITypeDocumentRepository {
    TypeDocument save(TypeDocument typedocument);
    Optional<TypeDocument> findById(Integer id);
    List<TypeDocument> findAll();
    void deleteById(Integer id);
}
