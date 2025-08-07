package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.MembershipType;
import com.nigma.gymwise.GymWise.domain.port.IMembershipTypeRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.MembershipTypeEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IMembershipTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class MembershipTypeCrudRepositoryImpl implements IMembershipTypeRepository {
    @Autowired
    private IMembershipTypeCrudRepository crudRepository;

    @Autowired
    private IMembershipTypeMapper mapper;

    @Override
    public MembershipType save(MembershipType membershiptype) {
        MembershipTypeEntity entity = mapper.toMembershipTypeEntity(membershiptype);
        MembershipTypeEntity saved = crudRepository.save(entity);
        return mapper.toMembershipType(saved);
    }

    @Override
    public Optional<MembershipType> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toMembershipType);
    }

    @Override
    public List<MembershipType> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toMembershipType)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
