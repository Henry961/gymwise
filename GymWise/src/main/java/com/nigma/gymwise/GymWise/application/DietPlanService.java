package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.DietPlan;
import com.nigma.gymwise.GymWise.domain.port.IDietPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietPlanService {
    private final IDietPlanRepository repository;

    public DietPlanService(IDietPlanRepository repository) {
        this.repository = repository;
    }

    public DietPlan save(DietPlan dietplan) {
        return repository.save(dietplan);
    }

    public Optional<DietPlan> findById(Integer id) {
        return repository.findById(id);
    }

    public List<DietPlan> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
