package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.UserBodyEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserBodyCrudRepository extends CrudRepository<UserBodyEntity, Integer> {
}
