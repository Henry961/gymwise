package com.nigma.gymwise.GymWise.infrastucture.adapter.Impl;

import com.nigma.gymwise.GymWise.domain.model.UserBody;
import com.nigma.gymwise.GymWise.domain.port.IUserBodyRepository;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IUserBodyCrudRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserBodyEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IUserBodyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserBodyCrudRepositoryImpl implements IUserBodyRepository {

    private final IUserBodyCrudRepository iUserBodyCrudRepository;
    private final IUserBodyMapper iUserBodyMapper;

    public UserBodyCrudRepositoryImpl(IUserBodyCrudRepository iUserBodyCrudRepository, IUserBodyMapper iUserBodyMapper) {
        this.iUserBodyCrudRepository = iUserBodyCrudRepository;
        this.iUserBodyMapper = iUserBodyMapper;
    }

    @Override
    public void save(UserBody userBody){
        iUserBodyCrudRepository.save(iUserBodyMapper.toUserBodyEntity(userBody));
    }

    @Override
    public List<UserBody> findAll(){

        List<UserBodyEntity> entities = (List<UserBodyEntity>) iUserBodyCrudRepository.findAll();

        return entities.stream().map(iUserBodyMapper::toUserBody).collect(Collectors.toList());

    }

    @Override
    public void deleteById(Integer id){
        iUserBodyCrudRepository.deleteById(id);
    }

}
