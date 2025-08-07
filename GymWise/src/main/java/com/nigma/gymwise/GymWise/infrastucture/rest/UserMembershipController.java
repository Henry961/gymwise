package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.UserMembershipService;
import com.nigma.gymwise.GymWise.domain.model.UserMembership;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usermembership")
public class UserMembershipController {
    private final UserMembershipService usermembershipService;

    public UserMembershipController(UserMembershipService usermembershipService) {
        this.usermembershipService = usermembershipService;
    }

    @PostMapping("/save")
    public UserMembership save(@RequestBody UserMembership usermembership) {
        return usermembershipService.save(usermembership);
    }

    @GetMapping("/findById/{id}")
    public UserMembership findById(@PathVariable Integer id) {
        return usermembershipService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<UserMembership> findAll() {
        return usermembershipService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        usermembershipService.deleteById(id);
    }
}
