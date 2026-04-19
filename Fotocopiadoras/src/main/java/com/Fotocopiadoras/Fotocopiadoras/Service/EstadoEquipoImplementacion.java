package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.EstadoEquipo;
import com.Fotocopiadoras.Fotocopiadoras.Repository.EstadoEquipoRepository;

@Service
public class EstadoEquipoImplementacion implements EstadoEquipoService {
    
    private final EstadoEquipoRepository repo;

    public EstadoEquipoImplementacion(EstadoEquipoRepository repo) {
        this.repo = repo;
    }

    @Override
    public EstadoEquipo registrar(EstadoEquipo obj) {
        return repo.save(obj);
    }

    @Override
    public List<EstadoEquipo> listar() {
        return repo.findAll();
    }

    @Override
    public EstadoEquipo buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("EstadoEquipo no encontrado con ID: " + id));
    }

    @Override
    public EstadoEquipo actualizar(EstadoEquipo obj) {
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
