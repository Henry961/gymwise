package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.ExerciseService;
import com.nigma.gymwise.GymWise.domain.model.Exercise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/save")
    public Exercise save(@RequestBody Exercise exercise) {
        return exerciseService.save(exercise);
    }

    @GetMapping("/findById/{id}")
    public Exercise findById(@PathVariable Integer id) {
        return exerciseService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<Exercise> findAll() {
        return exerciseService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        exerciseService.deleteById(id);
    }
}
