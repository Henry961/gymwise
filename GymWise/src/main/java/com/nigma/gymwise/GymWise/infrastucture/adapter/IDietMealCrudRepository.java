package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.DietMealEntity;
import org.springframework.data.repository.CrudRepository;

public interface IDietMealCrudRepository extends CrudRepository<DietMealEntity, Integer> {
}
