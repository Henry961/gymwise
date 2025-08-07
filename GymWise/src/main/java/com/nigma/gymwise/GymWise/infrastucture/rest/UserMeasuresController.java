package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.UserMeasuresService;
import com.nigma.gymwise.GymWise.domain.model.UserMeasuresBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userMeasures")
public class UserMeasuresController {

    private final UserMeasuresService userMeasuresService;

    public UserMeasuresController(UserMeasuresService userMeasuresService) {
        this.userMeasuresService = userMeasuresService;
    }

    @PostMapping("/save")
    public UserMeasuresBody save(@RequestBody UserMeasuresBody userMeasuresBody){
        return userMeasuresService.save(userMeasuresBody);
    }

    @GetMapping("/findAll")
    public List<UserMeasuresBody> findAll(){
        return userMeasuresService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        userMeasuresService.deleteById(id);
    }

}
