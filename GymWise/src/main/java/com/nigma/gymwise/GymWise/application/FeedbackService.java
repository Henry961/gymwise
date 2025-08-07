package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.Feedback;
import com.nigma.gymwise.GymWise.domain.port.IFeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private final IFeedbackRepository repository;

    public FeedbackService(IFeedbackRepository repository) {
        this.repository = repository;
    }

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }

    public Optional<Feedback> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Feedback> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
