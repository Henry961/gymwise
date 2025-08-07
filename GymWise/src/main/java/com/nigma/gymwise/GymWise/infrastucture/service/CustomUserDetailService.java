package com.nigma.gymwise.GymWise.infrastucture.service;

import com.nigma.gymwise.GymWise.application.UserService;
import com.nigma.gymwise.GymWise.domain.model.UserProfile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserProfile userProfile = userService.findByEmail(username);

        return User.builder().username(userProfile.getEmail()).password(userProfile.getPasswordUser())
                .roles(String.valueOf(userProfile.getIdRol())).build();
    }

}
