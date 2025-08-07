package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.infrastucture.entity.UserMembershipEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMembershipCrudRepository extends CrudRepository<UserMembershipEntity, Integer> {
}
