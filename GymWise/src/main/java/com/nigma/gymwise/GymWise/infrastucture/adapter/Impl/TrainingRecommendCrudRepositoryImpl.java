package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.TrainingRecommend;
import com.nigma.gymwise.GymWise.domain.port.ITrainingRecommendRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.TrainingRecommendEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.ITrainingRecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class TrainingRecommendCrudRepositoryImpl implements ITrainingRecommendRepository {
    @Autowired
    private ITrainingRecommendCrudRepository crudRepository;

    @Autowired
    private ITrainingRecommendMapper mapper;

    @Override
    public TrainingRecommend save(TrainingRecommend trainingrecommend) {
        TrainingRecommendEntity entity = mapper.toTrainingRecommendEntity(trainingrecommend);
        TrainingRecommendEntity saved = crudRepository.save(entity);
        return mapper.toTrainingRecommend(saved);
    }

    @Override
    public Optional<TrainingRecommend> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toTrainingRecommend);
    }

    @Override
    public List<TrainingRecommend> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toTrainingRecommend)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
