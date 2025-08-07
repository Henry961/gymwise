package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.UserBodyService;
import com.nigma.gymwise.GymWise.domain.model.UserBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userBody")
public class UserBodyController {

    private final UserBodyService userBodyService;

    public UserBodyController(UserBodyService userBodyService) {
        this.userBodyService = userBodyService;
    }

    private Integer getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Integer.valueOf(authentication.getName());
    }

    @PostMapping("/save")
    public void save(@RequestBody UserBody userBody){
        userBodyService.save(userBody);
    }

    @GetMapping("/findAll")
    public List<UserBody> findAll(){
        return userBodyService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id){

    }

}
