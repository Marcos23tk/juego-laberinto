package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Mantenimiento;
import com.Fotocopiadoras.Fotocopiadoras.Repository.MantenimientoRepository;

@Service
public class MantenimientoImplementacion implements MantenimientoService {
    
    private final MantenimientoRepository repo;

    public MantenimientoImplementacion(MantenimientoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Mantenimiento registrar(Mantenimiento obj) {
        return repo.save(obj);
    }

    @Override
    public List<Mantenimiento> listar() {
        return repo.findAll();
    }

    @Override
    public Mantenimiento buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado con ID: " + id));
    }

    @Override
    public Mantenimiento actualizar(Mantenimiento obj) {
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
