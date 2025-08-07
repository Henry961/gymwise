package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.UserBody;
import com.nigma.gymwise.GymWise.domain.port.IUserBodyRepository;

import java.util.List;

public class UserBodyService {

    private final IUserBodyRepository iUserBodyRepository;

    public UserBodyService(IUserBodyRepository iUserBodyRepository) {
        this.iUserBodyRepository = iUserBodyRepository;
    }

    public void save(UserBody userBody){
        iUserBodyRepository.save(userBody);
    }

    public List<UserBody> findAll(){
        return iUserBodyRepository.findAll();
    }

    public void deleteById(Integer id){
        iUserBodyRepository.deleteById(id);
    }

}
