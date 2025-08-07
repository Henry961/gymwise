package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.DietPlanService;
import com.nigma.gymwise.GymWise.domain.model.DietPlan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dietplan")
public class DietPlanController {
    private final DietPlanService dietplanService;

    public DietPlanController(DietPlanService dietplanService) {
        this.dietplanService = dietplanService;
    }

    @PostMapping("/save")
    public DietPlan save(@RequestBody DietPlan dietplan) {
        return dietplanService.save(dietplan);
    }

    @GetMapping("/findById/{id}")
    public DietPlan findById(@PathVariable Integer id) {
        return dietplanService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<DietPlan> findAll() {
        return dietplanService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        dietplanService.deleteById(id);
    }
}
