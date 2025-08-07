package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.MembershipTypeService;
import com.nigma.gymwise.GymWise.domain.model.MembershipType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membershiptype")
public class MembershipTypeController {
    private final MembershipTypeService membershiptypeService;

    public MembershipTypeController(MembershipTypeService membershiptypeService) {
        this.membershiptypeService = membershiptypeService;
    }

    @PostMapping("/save")
    public MembershipType save(@RequestBody MembershipType membershiptype) {
        return membershiptypeService.save(membershiptype);
    }

    @GetMapping("/findById/{id}")
    public MembershipType findById(@PathVariable Integer id) {
        return membershiptypeService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<MembershipType> findAll() {
        return membershiptypeService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        membershiptypeService.deleteById(id);
    }
}
