package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.UserRecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRecordCrudRepository extends CrudRepository<UserRecordEntity, Integer> {
}
