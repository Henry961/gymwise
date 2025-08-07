package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.DietMealService;
import com.nigma.gymwise.GymWise.domain.model.DietMeal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet-meal")
public class DietMealController {

    private final DietMealService dietMealService;

    public DietMealController(DietMealService dietMealService) {
        this.dietMealService = dietMealService;
    }

    @PostMapping("/save")
    public DietMeal save(@RequestBody DietMeal dietMeal) {
        return dietMealService.create(dietMeal);
    }

    @GetMapping("/findById/{id}")
    public DietMeal findById(@PathVariable Integer id) {
        return dietMealService.getById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<DietMeal> findAll() {
        return dietMealService.getAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        dietMealService.delete(id);
    }
}
