package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.UserMeasuresBody;

import java.util.List;

public interface IUserMeasuresRepository {
    UserMeasuresBody save(UserMeasuresBody userMeasuresBody);

    List<UserMeasuresBody> findAll();

    void deleteById(Integer id);
}
