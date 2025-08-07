package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.UserPreferences;
import com.nigma.gymwise.GymWise.domain.port.IUserPreferencesRepository;

import java.util.List;

public class UserPreferencesService {

    private final IUserPreferencesRepository iUserPreferencesRepository;

    public UserPreferencesService(IUserPreferencesRepository iUserPreferencesRepository) {
        this.iUserPreferencesRepository = iUserPreferencesRepository;
    }

    public void save(UserPreferences userPreferences){
        iUserPreferencesRepository.save(userPreferences);
    }

    public List<UserPreferences> findAll(){
        return iUserPreferencesRepository.findAll();
    }

}
