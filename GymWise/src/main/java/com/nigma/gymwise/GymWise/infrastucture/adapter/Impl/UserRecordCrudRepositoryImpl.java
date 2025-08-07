package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.UserRecord;
import com.nigma.gymwise.GymWise.domain.port.IUserRecordRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserRecordEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IUserRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRecordCrudRepositoryImpl implements IUserRecordRepository {
    @Autowired
    private IUserRecordCrudRepository crudRepository;

    @Autowired
    private IUserRecordMapper mapper;

    @Override
    public UserRecord save(UserRecord userrecord) {
        UserRecordEntity entity = mapper.toUserRecordEntity(userrecord);
        UserRecordEntity saved = crudRepository.save(entity);
        return mapper.toUserRecord(saved);
    }

    @Override
    public Optional<UserRecord> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toUserRecord);
    }

    @Override
    public List<UserRecord> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toUserRecord)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
