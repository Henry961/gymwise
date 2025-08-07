package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.TrainingRealized;
import java.util.List;
import java.util.Optional;

public interface ITrainingRealizedRepository {
    TrainingRealized save(TrainingRealized trainingrealized);
    Optional<TrainingRealized> findById(Integer id);
    List<TrainingRealized> findAll();
    void deleteById(Integer id);
}
