package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.TrainingRecommend;
import java.util.List;
import java.util.Optional;

public interface ITrainingRecommendRepository {
    TrainingRecommend save(TrainingRecommend trainingrecommend);
    Optional<TrainingRecommend> findById(Integer id);
    List<TrainingRecommend> findAll();
    void deleteById(Integer id);
}
