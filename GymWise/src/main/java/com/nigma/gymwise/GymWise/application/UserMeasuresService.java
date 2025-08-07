package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.UserMeasuresBody;
import com.nigma.gymwise.GymWise.domain.port.IUserMeasuresRepository;

import java.util.List;

public class UserMeasuresService {

    private final IUserMeasuresRepository iUserMeasuresRepository;

    public UserMeasuresService(IUserMeasuresRepository iUserMeasuresRepository) {
        this.iUserMeasuresRepository = iUserMeasuresRepository;
    }

    public UserMeasuresBody save(UserMeasuresBody userMeasuresBody){
        return iUserMeasuresRepository.save(userMeasuresBody);
    }

    public List<UserMeasuresBody> findAll(){
        return iUserMeasuresRepository.findAll();
    }

    public void deleteById(Integer id){
        iUserMeasuresRepository.deleteById(id);
    }

}
