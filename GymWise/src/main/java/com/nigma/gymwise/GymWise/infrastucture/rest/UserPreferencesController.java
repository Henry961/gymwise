package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.UserPreferencesService;
import com.nigma.gymwise.GymWise.domain.model.UserPreferences;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userPreference")
public class UserPreferencesController {

    private final UserPreferencesService userPreferencesService;

    public UserPreferencesController(UserPreferencesService userPreferencesService) {
        this.userPreferencesService = userPreferencesService;
    }

    @PostMapping("/save")
    public void save(@RequestBody UserPreferences userPreferences){
        userPreferencesService.save(userPreferences);
    }

    @GetMapping("/findAll")
    public List<UserPreferences> findAll(){
        return userPreferencesService.findAll();
    }

}
