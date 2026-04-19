package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Rol;
import com.Fotocopiadoras.Fotocopiadoras.Repository.RolRepository;

@Service
public class RolImplementacion implements RolService {

    private final RolRepository repo;

    public RolImplementacion(RolRepository repo) {
        this.repo = repo;
    }

    @Override
    public Rol registrar(Rol obj) {
        if (obj == null || obj.getNombre() == null || obj.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del rol es obligatorio");
        }
        return repo.save(obj);
    }

    @Override
    public List<Rol> listar() {
        return repo.findAll();
    }

    @Override
    public Rol buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
    }

    @Override
    public Rol actualizar(Rol obj) {
        if (obj == null || obj.getId() == null) {
            throw new IllegalArgumentException("El ID del rol es obligatorio para actualizar");
        }
        if (obj.getNombre() == null || obj.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del rol es obligatorio");
        }
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}