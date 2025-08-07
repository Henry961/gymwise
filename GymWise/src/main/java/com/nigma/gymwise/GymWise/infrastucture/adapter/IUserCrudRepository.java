package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.constants.QueryConstants;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository<UserProfileEntity, Integer> {

    @Query(QueryConstants.userFindEmailDateExpired)
    List<String> findEmailDateExpired();

    Optional<UserProfileEntity> findByEmail(String email);

}
