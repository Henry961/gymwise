package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.FeedbackService;
import com.nigma.gymwise.GymWise.domain.model.Feedback;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/save")
    public Feedback save(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }

    @GetMapping("/findById/{id}")
    public Feedback findById(@PathVariable Integer id) {
        return feedbackService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<Feedback> findAll() {
        return feedbackService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        feedbackService.deleteById(id);
    }
}
