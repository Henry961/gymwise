package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.TypeDocumentService;
import com.nigma.gymwise.GymWise.domain.model.TypeDocument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typedocument")
public class TypeDocumentController {
    private final TypeDocumentService typedocumentService;

    public TypeDocumentController(TypeDocumentService typedocumentService) {
        this.typedocumentService = typedocumentService;
    }

    @PostMapping("/save")
    public TypeDocument save(@RequestBody TypeDocument typedocument) {
        return typedocumentService.save(typedocument);
    }

    @GetMapping("/findById/{id}")
    public TypeDocument findById(@PathVariable Integer id) {
        return typedocumentService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<TypeDocument> findAll() {
        return typedocumentService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        typedocumentService.deleteById(id);
    }
}
