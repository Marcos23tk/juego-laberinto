package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Equipo;
import com.Fotocopiadoras.Fotocopiadoras.Repository.EquipoRepository;

@Service
public class EquipoImplementacion implements EquipoService {
    
    private final EquipoRepository repo;

    public EquipoImplementacion(EquipoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Equipo registrar(Equipo obj) {
        return repo.save(obj);
    }

    @Override
    public List<Equipo> listar() {
        return repo.findAll();
    }

    @Override
    public Equipo buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
    }

    @Override
    public Equipo actualizar(Equipo obj) {
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
