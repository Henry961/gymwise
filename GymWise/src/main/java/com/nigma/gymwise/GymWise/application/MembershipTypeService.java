package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.MembershipType;
import com.nigma.gymwise.GymWise.domain.port.IMembershipTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeService {
    private final IMembershipTypeRepository repository;

    public MembershipTypeService(IMembershipTypeRepository repository) {
        this.repository = repository;
    }

    public MembershipType save(MembershipType membershiptype) {
        return repository.save(membershiptype);
    }

    public Optional<MembershipType> findById(Integer id) {
        return repository.findById(id);
    }

    public List<MembershipType> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
