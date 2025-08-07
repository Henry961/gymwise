package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.DietPlan;
import java.util.List;
import java.util.Optional;

public interface IDietPlanRepository {
    DietPlan save(DietPlan dietplan);
    Optional<DietPlan> findById(Integer id);
    List<DietPlan> findAll();
    void deleteById(Integer id);
}
