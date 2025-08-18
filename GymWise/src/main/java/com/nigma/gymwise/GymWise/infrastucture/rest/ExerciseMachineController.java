package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nigma.gymwise.GymWise.application.ExerciseMachineService;
import com.nigma.gymwise.GymWise.domain.model.ExerciseMachine;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/exercisemachine")
public class ExerciseMachineController {

    private final ExerciseMachineService exerciseMachineService;
    private final ObjectMapper objectMapper;

    public ExerciseMachineController(ExerciseMachineService exerciseMachineService, ObjectMapper objectMapper) {
        this.exerciseMachineService = exerciseMachineService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/save")
    public ExerciseMachine save(@RequestPart("machine") String machineJson, @RequestPart("image")MultipartFile multipartFile) throws IOException {

        ExerciseMachine exerciseMachine = objectMapper.readValue(machineJson, ExerciseMachine.class);

        return exerciseMachineService.save(exerciseMachine, multipartFile);
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
