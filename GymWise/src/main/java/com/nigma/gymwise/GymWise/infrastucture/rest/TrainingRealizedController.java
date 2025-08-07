package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.TrainingRealizedService;
import com.nigma.gymwise.GymWise.domain.model.TrainingRealized;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainingrealized")
public class TrainingRealizedController {
    private final TrainingRealizedService trainingrealizedService;

    public TrainingRealizedController(TrainingRealizedService trainingrealizedService) {
        this.trainingrealizedService = trainingrealizedService;
    }

    @PostMapping("/save")
    public TrainingRealized save(@RequestBody TrainingRealized trainingrealized) {
        return trainingrealizedService.save(trainingrealized);
    }

    @GetMapping("/findById/{id}")
    public TrainingRealized findById(@PathVariable Integer id) {
        return trainingrealizedService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<TrainingRealized> findAll() {
        return trainingrealizedService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        trainingrealizedService.deleteById(id);
    }
}
