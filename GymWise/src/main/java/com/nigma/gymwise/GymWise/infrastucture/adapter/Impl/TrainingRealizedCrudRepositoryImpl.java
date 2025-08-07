package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.TrainingRealized;
import com.nigma.gymwise.GymWise.domain.port.ITrainingRealizedRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.TrainingRealizedEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.ITrainingRealizedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class TrainingRealizedCrudRepositoryImpl implements ITrainingRealizedRepository {
    @Autowired
    private ITrainingRealizedCrudRepository crudRepository;

    @Autowired
    private ITrainingRealizedMapper mapper;

    @Override
    public TrainingRealized save(TrainingRealized trainingrealized) {
        TrainingRealizedEntity entity = mapper.toTrainingRealizedEntity(trainingrealized);
        TrainingRealizedEntity saved = crudRepository.save(entity);
        return mapper.toTrainingRealized(saved);
    }

    @Override
    public Optional<TrainingRealized> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toTrainingRealized);
    }

    @Override
    public List<TrainingRealized> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toTrainingRealized)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
