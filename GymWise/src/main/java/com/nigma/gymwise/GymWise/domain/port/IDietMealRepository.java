package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.DietMeal;
import java.util.List;
import java.util.Optional;

public interface IDietMealRepository {
    DietMeal save(DietMeal dietMeal);
    Optional<DietMeal> findById(Integer id);
    List<DietMeal> findAll();
    void deleteById(Integer id);
}
