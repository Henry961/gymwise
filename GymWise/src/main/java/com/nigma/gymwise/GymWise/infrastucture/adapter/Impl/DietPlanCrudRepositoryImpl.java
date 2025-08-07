package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.DietPlan;
import com.nigma.gymwise.GymWise.domain.port.IDietPlanRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.DietPlanEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IDietPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class DietPlanCrudRepositoryImpl implements IDietPlanRepository {
    @Autowired
    private IDietPlanCrudRepository crudRepository;

    @Autowired
    private IDietPlanMapper mapper;

    @Override
    public DietPlan save(DietPlan dietplan) {
        DietPlanEntity entity = mapper.toDietPlanEntity(dietplan);
        DietPlanEntity saved = crudRepository.save(entity);
        return mapper.toDietPlan(saved);
    }

    @Override
    public Optional<DietPlan> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDietPlan);
    }

    @Override
    public List<DietPlan> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toDietPlan)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
