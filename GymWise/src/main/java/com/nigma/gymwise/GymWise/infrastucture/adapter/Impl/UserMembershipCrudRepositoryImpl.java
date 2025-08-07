package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.UserMembership;
import com.nigma.gymwise.GymWise.domain.port.IUserMembershipRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserMembershipEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IUserMembershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserMembershipCrudRepositoryImpl implements IUserMembershipRepository {
    @Autowired
    private IUserMembershipCrudRepository crudRepository;

    @Autowired
    private IUserMembershipMapper mapper;

    @Override
    public UserMembership save(UserMembership usermembership) {
        UserMembershipEntity entity = mapper.toUserMembershipEntity(usermembership);
        UserMembershipEntity saved = crudRepository.save(entity);
        return mapper.toUserMembership(saved);
    }

    @Override
    public Optional<UserMembership> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toUserMembership);
    }

    @Override
    public List<UserMembership> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toUserMembership)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
