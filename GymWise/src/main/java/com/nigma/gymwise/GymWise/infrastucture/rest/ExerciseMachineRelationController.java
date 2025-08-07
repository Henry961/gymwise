package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.ExerciseMachineRelationService;
import com.nigma.gymwise.GymWise.domain.model.ExerciseMachineRelation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercisemachinerelation")
public class ExerciseMachineRelationController {
    private final ExerciseMachineRelationService exercisemachinerelationService;

    public ExerciseMachineRelationController(ExerciseMachineRelationService exercisemachinerelationService) {
        this.exercisemachinerelationService = exercisemachinerelationService;
    }

    @PostMapping("/save")
    public ExerciseMachineRelation save(@RequestBody ExerciseMachineRelation exercisemachinerelation) {
        return exercisemachinerelationService.save(exercisemachinerelation);
    }

    @GetMapping("/findById/{id}")
    public ExerciseMachineRelation findById(@PathVariable Integer id) {
        return exercisemachinerelationService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<ExerciseMachineRelation> findAll() {
        return exercisemachinerelationService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        exercisemachinerelationService.deleteById(id);
    }
}
