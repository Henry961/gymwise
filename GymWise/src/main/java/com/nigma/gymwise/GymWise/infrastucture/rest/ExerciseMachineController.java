package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.ExerciseMachineService;
import com.nigma.gymwise.GymWise.domain.model.ExerciseMachine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercisemachine")
public class ExerciseMachineController {

    private final ExerciseMachineService exerciseMachineService;

    public ExerciseMachineController(ExerciseMachineService exerciseMachineService) {
        this.exerciseMachineService = exerciseMachineService;
    }

    @PostMapping("/save")
    public ExerciseMachine save(@RequestBody ExerciseMachine exerciseMachine) {
        return exerciseMachineService.save(exerciseMachine);
    }

    @GetMapping("/findById/{id}")
    public ExerciseMachine findById(@PathVariable Integer id) {
        return exerciseMachineService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<ExerciseMachine> findAll() {
        return exerciseMachineService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        exerciseMachineService.deleteById(id);
    }
}
