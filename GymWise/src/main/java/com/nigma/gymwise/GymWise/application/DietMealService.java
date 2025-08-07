package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.DietMeal;
import com.nigma.gymwise.GymWise.domain.port.IDietMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietMealService {

    @Autowired
    private IDietMealRepository repository;

    public DietMeal create(DietMeal dietMeal) {
        return repository.save(dietMeal);
    }

    public Optional<DietMeal> getById(Integer id) {
        return repository.findById(id);
    }

    public List<DietMeal> getAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public DietMeal update(Integer id, DietMeal newDietMeal) {
        Optional<DietMeal> opt = repository.findById(id);
        if (opt.isPresent()) {
            newDietMeal.setId(id);
            return repository.save(newDietMeal);
        } else {
            throw new RuntimeException("DietMeal not found");
        }
    }
}
