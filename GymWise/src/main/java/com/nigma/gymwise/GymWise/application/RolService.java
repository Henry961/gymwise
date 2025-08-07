package com.nigma.gymwise.GymWise.application;

import com.nigma.gymwise.GymWise.domain.model.Rol;
import com.nigma.gymwise.GymWise.domain.port.IRolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    private final IRolRepository repository;

    public RolService(IRolRepository repository) {
        this.repository = repository;
    }

    public Rol save(Rol rol) {
        return repository.save(rol);
    }

    public Optional<Rol> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Rol> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
