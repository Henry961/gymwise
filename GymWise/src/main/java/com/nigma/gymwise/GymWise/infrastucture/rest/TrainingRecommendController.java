package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.TrainingRecommendService;
import com.nigma.gymwise.GymWise.domain.model.TrainingRecommend;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainingrecommend")
public class TrainingRecommendController {
    private final TrainingRecommendService trainingrecommendService;

    public TrainingRecommendController(TrainingRecommendService trainingrecommendService) {
        this.trainingrecommendService = trainingrecommendService;
    }

    @PostMapping("/save")
    public TrainingRecommend save(@RequestBody TrainingRecommend trainingrecommend) {
        return trainingrecommendService.save(trainingrecommend);
    }

    @GetMapping("/findById/{id}")
    public TrainingRecommend findById(@PathVariable Integer id) {
        return trainingrecommendService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<TrainingRecommend> findAll() {
        return trainingrecommendService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        trainingrecommendService.deleteById(id);
    }
}
