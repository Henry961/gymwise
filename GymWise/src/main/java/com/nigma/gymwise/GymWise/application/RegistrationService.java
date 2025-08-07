package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.UserProfile;
import com.nigma.gymwise.GymWise.domain.port.IUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RegistrationService {

    private final IUserRepository iUserRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegistrationService(IUserRepository iUserRepository, BCryptPasswordEncoder passwordEncoder) {
        this.iUserRepository = iUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserProfile register(UserProfile userProfile){
        userProfile.setPasswordUser(passwordEncoder.encode(userProfile.getPasswordUser()));
        return iUserRepository.save(userProfile);
    }

}
