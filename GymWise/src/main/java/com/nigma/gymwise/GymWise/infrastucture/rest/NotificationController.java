package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.NotificationService;
import com.nigma.gymwise.GymWise.domain.model.Notification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/save")
    public Notification save(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @GetMapping("/findById/{id}")
    public Notification findById(@PathVariable Integer id) {
        return notificationService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<Notification> findAll() {
        return notificationService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        notificationService.deleteById(id);
    }
}
