package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.UserRecordService;
import com.nigma.gymwise.GymWise.domain.model.UserRecord;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userrecord")
public class UserRecordController {
    private final UserRecordService userrecordService;

    public UserRecordController(UserRecordService userrecordService) {
        this.userrecordService = userrecordService;
    }

    @PostMapping("/save")
    public UserRecord save(@RequestBody UserRecord userrecord) {
        return userrecordService.save(userrecord);
    }

    @GetMapping("/findById/{id}")
    public UserRecord findById(@PathVariable Integer id) {
        return userrecordService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<UserRecord> findAll() {
        return userrecordService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        userrecordService.deleteById(id);
    }
}
