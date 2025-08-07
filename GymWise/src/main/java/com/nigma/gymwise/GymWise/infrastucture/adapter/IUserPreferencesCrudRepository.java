package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.UserPreferencesEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserPreferencesCrudRepository extends CrudRepository<UserPreferencesEntity, Integer> {
}
