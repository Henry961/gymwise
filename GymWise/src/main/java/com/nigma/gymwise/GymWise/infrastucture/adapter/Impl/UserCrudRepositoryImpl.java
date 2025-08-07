package com.nigma.gymwise.GymWise.infrastucture.adapter.Impl;

import com.nigma.gymwise.GymWise.domain.model.UserProfile;
import com.nigma.gymwise.GymWise.domain.port.IUserRepository;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IUserCrudRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserProfileEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IUserProfileMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    private final IUserCrudRepository iUserCrudRepository;
    private final IUserProfileMapper iUserProfileMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, IUserProfileMapper iUserProfileMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.iUserProfileMapper = iUserProfileMapper;
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return iUserProfileMapper.toUser(iUserCrudRepository.save(iUserProfileMapper.toUserEntity(userProfile)));
    }

    @Override
    public UserProfile findByEmail(String email) {
        return iUserProfileMapper.toUser(iUserCrudRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Usuarion con email: " + email + "no encontrado" )
        ));
    }

    @Override
    public UserProfile findById(Integer id) {
        return iUserProfileMapper.toUser(iUserCrudRepository.findById(id).get());
    }

    @Override
    public void deleteById(Integer id){
        iUserCrudRepository.deleteById(id);
    }

    @Override
    public List<UserProfile> findAll() {
        List<UserProfileEntity> entities = (List<UserProfileEntity>) iUserCrudRepository.findAll();

        return entities.stream()
                .map(iUserProfileMapper::toUser)
                .collect(Collectors.toList());
    }

}
