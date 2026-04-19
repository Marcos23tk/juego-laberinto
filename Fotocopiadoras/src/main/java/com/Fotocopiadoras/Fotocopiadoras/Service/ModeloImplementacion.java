package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Modelo;
import com.Fotocopiadoras.Fotocopiadoras.Repository.ModeloRepository;

@Service
public class ModeloImplementacion implements ModeloService {
    
    private final ModeloRepository repo;

    public ModeloImplementacion(ModeloRepository repo) {
        this.repo = repo;
    }

    @Override
    public Modelo registrar(Modelo obj) {
        return repo.save(obj);
    }

    @Override
    public List<Modelo> listar() {
        return repo.findAll();
    }

    @Override
    public Modelo buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Modelo no encontrado con ID: " + id));
    }

    @Override
    public Modelo actualizar(Modelo obj) {
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
