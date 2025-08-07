package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.DietMeal;
import com.nigma.gymwise.GymWise.domain.port.IDietMealRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.DietMealEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IDietMealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class DietMealCrudRepositoryImpl implements IDietMealRepository {

    @Autowired
    private IDietMealCrudRepository crudRepository;

    @Autowired
    private IDietMealMapper mapper;

    @Override
    public DietMeal save(DietMeal dietMeal) {
        DietMealEntity entity = mapper.toDietMealEntity(dietMeal);
        DietMealEntity saved = crudRepository.save(entity);
        return mapper.toDietMeal(saved);
    }

    @Override
    public Optional<DietMeal> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDietMeal);
    }

    @Override
    public List<DietMeal> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toDietMeal)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
