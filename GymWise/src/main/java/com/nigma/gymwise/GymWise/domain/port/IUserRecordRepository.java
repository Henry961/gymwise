package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.UserRecord;
import java.util.List;
import java.util.Optional;

public interface IUserRecordRepository {
    UserRecord save(UserRecord userrecord);
    Optional<UserRecord> findById(Integer id);
    List<UserRecord> findAll();
    void deleteById(Integer id);
}
