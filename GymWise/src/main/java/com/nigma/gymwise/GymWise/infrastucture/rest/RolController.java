package com.nigma.gymwise.GymWise.infrastucture.rest;

import com.nigma.gymwise.GymWise.application.RolService;
import com.nigma.gymwise.GymWise.domain.model.Rol;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("/save")
    public Rol save(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @GetMapping("/findById/{id}")
    public Rol findById(@PathVariable Integer id) {
        return rolService.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public List<Rol> findAll() {
        return rolService.findAll();
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        rolService.deleteById(id);
    }
}
