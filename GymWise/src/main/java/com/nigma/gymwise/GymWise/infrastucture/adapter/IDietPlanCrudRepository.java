package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.DietPlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDietPlanCrudRepository extends CrudRepository<DietPlanEntity, Integer> {
}
