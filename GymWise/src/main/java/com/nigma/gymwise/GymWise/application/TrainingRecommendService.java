package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.TrainingRecommend;
import com.nigma.gymwise.GymWise.domain.port.ITrainingRecommendRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingRecommendService {
    private final ITrainingRecommendRepository repository;

    public TrainingRecommendService(ITrainingRecommendRepository repository) {
        this.repository = repository;
    }

    public TrainingRecommend save(TrainingRecommend trainingrecommend) {
        return repository.save(trainingrecommend);
    }

    public Optional<TrainingRecommend> findById(Integer id) {
        return repository.findById(id);
    }

    public List<TrainingRecommend> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
