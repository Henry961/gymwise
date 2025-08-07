package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.UserPreferences;

import java.util.List;

public interface IUserPreferencesRepository {
    void save(UserPreferences userPreferences);

    List<UserPreferences> findAll();
}
