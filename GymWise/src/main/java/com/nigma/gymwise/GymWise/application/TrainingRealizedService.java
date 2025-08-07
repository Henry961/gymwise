package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.TrainingRealized;
import com.nigma.gymwise.GymWise.domain.port.ITrainingRealizedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingRealizedService {
    private final ITrainingRealizedRepository repository;

    public TrainingRealizedService(ITrainingRealizedRepository repository) {
        this.repository = repository;
    }

    public TrainingRealized save(TrainingRealized trainingrealized) {
        return repository.save(trainingrealized);
    }

    public Optional<TrainingRealized> findById(Integer id) {
        return repository.findById(id);
    }

    public List<TrainingRealized> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
