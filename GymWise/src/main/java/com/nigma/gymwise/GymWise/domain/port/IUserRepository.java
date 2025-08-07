package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.UserProfile;

import java.util.List;

public interface IUserRepository {
    UserProfile save(UserProfile userProfile);
    UserProfile findByEmail(String email);
    UserProfile findById(Integer id);
    void deleteById(Integer id);
    List<UserProfile> findAll();
}
