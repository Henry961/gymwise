package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.UserMembership;
import com.nigma.gymwise.GymWise.domain.port.IUserMembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMembershipService {
    private final IUserMembershipRepository repository;

    public UserMembershipService(IUserMembershipRepository repository) {
        this.repository = repository;
    }

    public UserMembership save(UserMembership usermembership) {
        return repository.save(usermembership);
    }

    public Optional<UserMembership> findById(Integer id) {
        return repository.findById(id);
    }

    public List<UserMembership> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
