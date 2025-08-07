package com.nigma.gymwise.GymWise.infrastucture.adapter.Impl;

import com.nigma.gymwise.GymWise.domain.model.UserMeasuresBody;
import com.nigma.gymwise.GymWise.domain.port.IUserMeasuresRepository;
import com.nigma.gymwise.GymWise.infrastucture.adapter.IUserMeasuresCrudRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.UserMeasuresEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IUserMeasuresBodyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserMeasuresCrudRepositoryImpl implements IUserMeasuresRepository {

    private final IUserMeasuresCrudRepository iUserMeasuresCrudRepository;
    private final IUserMeasuresBodyMapper iUserMeasuresBodyMapper;

    public UserMeasuresCrudRepositoryImpl(IUserMeasuresCrudRepository iUserMeasuresCrudRepository, IUserMeasuresBodyMapper iUserMeasuresBodyMapper) {
        this.iUserMeasuresCrudRepository = iUserMeasuresCrudRepository;
        this.iUserMeasuresBodyMapper = iUserMeasuresBodyMapper;
    }

    @Override
    public UserMeasuresBody save(UserMeasuresBody userMeasuresBody){
        return iUserMeasuresBodyMapper.toUserMeasures(iUserMeasuresCrudRepository.save(iUserMeasuresBodyMapper.toUserMeasuresEntity(userMeasuresBody)));
    }

    @Override
    public List<UserMeasuresBody> findAll(){

        List<UserMeasuresEntity> entities = (List<UserMeasuresEntity>) iUserMeasuresCrudRepository.findAll();

        return entities.stream().map(iUserMeasuresBodyMapper::toUserMeasures).collect(Collectors.toList());

    }

    @Override
    public void deleteById(Integer id){

        iUserMeasuresCrudRepository.deleteById(id);

    }

}
