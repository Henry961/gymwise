package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.UserService;
import com.nigma.gymwise.GymWise.domain.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public UserProfile save(@RequestBody UserProfile userProfile){
        return userService.save(userProfile);
    }

    @GetMapping("/findById/{id}")
    public UserProfile findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping("/findAll")
    public List<UserProfile> findAll(){
        return userService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteById(id);
    }

}
