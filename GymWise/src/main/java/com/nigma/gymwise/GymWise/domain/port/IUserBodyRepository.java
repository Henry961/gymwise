package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.UserBody;

import java.util.List;

public interface IUserBodyRepository {
    void save(UserBody userBody);

    List<UserBody> findAll();

    void deleteById(Integer id);
}
