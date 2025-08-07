package com.nigma.gymwise.GymWise.infrastucture.adapter;

import com.nigma.gymwise.GymWise.domain.model.Rol;
import com.nigma.gymwise.GymWise.domain.port.IRolRepository;
import com.nigma.gymwise.GymWise.infrastucture.entity.RolEntity;
import com.nigma.gymwise.GymWise.infrastucture.mapper.IRolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class RolCrudRepositoryImpl implements IRolRepository {
    @Autowired
    private IRolCrudRepository crudRepository;

    @Autowired
    private IRolMapper mapper;

    @Override
    public Rol save(Rol rol) {
        RolEntity entity = mapper.toRolEntity(rol);
        RolEntity saved = crudRepository.save(entity);
        return mapper.toRol(saved);
    }

    @Override
    public Optional<Rol> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toRol);
    }

    @Override
    public List<Rol> findAll() {
        return StreamSupport
                .stream(crudRepository.findAll().spliterator(), false)
                .map(mapper::toRol)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
