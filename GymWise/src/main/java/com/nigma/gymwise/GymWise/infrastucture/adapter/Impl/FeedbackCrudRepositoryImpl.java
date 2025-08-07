package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.Feedback;
import com.nigma.gymwise.GymWise.domain.port.IFeedbackRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.FeedbackEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IFeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class FeedbackCrudRepositoryImpl implements IFeedbackRepository {
    @Autowired
    private IFeedbackCrudRepository crudRepository;

    @Autowired
    private IFeedbackMapper mapper;

    @Override
    public Feedback save(Feedback feedback) {
        FeedbackEntity entity = mapper.toFeedbackEntity(feedback);
        FeedbackEntity saved = crudRepository.save(entity);
        return mapper.toFeedback(saved);
    }

    @Override
    public Optional<Feedback> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toFeedback);
    }

    @Override
    public List<Feedback> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toFeedback)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
