package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.UserMeasuresEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserMeasuresCrudRepository extends CrudRepository<UserMeasuresEntity, Integer> {
}
