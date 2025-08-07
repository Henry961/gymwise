package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.UserRecord;
import com.nigma.gymwise.GymWise.domain.port.IUserRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRecordService {
    private final IUserRecordRepository repository;

    public UserRecordService(IUserRecordRepository repository) {
        this.repository = repository;
    }

    public UserRecord save(UserRecord userrecord) {
        return repository.save(userrecord);
    }

    public Optional<UserRecord> findById(Integer id) {
        return repository.findById(id);
    }

    public List<UserRecord> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
