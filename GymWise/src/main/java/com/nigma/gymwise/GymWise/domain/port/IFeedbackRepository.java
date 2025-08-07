package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.Feedback;
import java.util.List;
import java.util.Optional;

public interface IFeedbackRepository {
    Feedback save(Feedback feedback);
    Optional<Feedback> findById(Integer id);
    List<Feedback> findAll();
    void deleteById(Integer id);
}
