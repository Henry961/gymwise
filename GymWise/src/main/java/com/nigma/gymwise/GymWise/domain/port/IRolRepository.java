package com.nigma.gymwise.GymWise.domain.port;

import com.nigma.gymwise.GymWise.domain.model.Rol;
import java.util.List;
import java.util.Optional;

public interface IRolRepository {
    Rol save(Rol rol);
    Optional<Rol> findById(Integer id);
    List<Rol> findAll();
    void deleteById(Integer id);
}
