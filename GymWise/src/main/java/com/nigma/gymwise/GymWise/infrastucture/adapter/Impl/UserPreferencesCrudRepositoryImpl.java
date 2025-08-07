package com.nigma.gymwise.GymWise.infrastucture.adapter.Impl;

import com.nigma.gymwise.GymWise.domain.model.UserPreferences;
import com.nigma.gymwise.GymWise.domain.port.IUserPreferencesRepository;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IUserPreferencesCrudRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserPreferencesEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IUserPreferencesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserPreferencesCrudRepositoryImpl implements IUserPreferencesRepository {

    private final IUserPreferencesCrudRepository iUserPreferencesCrudRepository;
    private final IUserPreferencesMapper iUserPreferencesMapper;

    public UserPreferencesCrudRepositoryImpl(IUserPreferencesCrudRepository iUserPreferencesCrudRepository, IUserPreferencesMapper iUserPreferencesMapper) {
        this.iUserPreferencesCrudRepository = iUserPreferencesCrudRepository;
        this.iUserPreferencesMapper = iUserPreferencesMapper;
    }

    @Override
    public void save(UserPreferences userPreferences){
        iUserPreferencesCrudRepository.save(iUserPreferencesMapper.toUserPreferencesEntity(userPreferences));
    }

    @Override
    public List<UserPreferences> findAll(){

        List<UserPreferencesEntity> entities = (List<UserPreferencesEntity>) iUserPreferencesCrudRepository.findAll();

        return entities.stream().map(iUserPreferencesMapper::toUserPreferences).collect(Collectors.toList());

    }

}
