package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Despacho;
import com.Fotocopiadoras.Fotocopiadoras.Repository.DespachoRepository;

@Service
public class DespachoImplementacion implements DespachoService {
    
    private final DespachoRepository repo;

    public DespachoImplementacion(DespachoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Despacho registrar(Despacho obj) {
        return repo.save(obj);
    }

    @Override
    public List<Despacho> listar() {
        return repo.findAll();
    }

    @Override
    public Despacho buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Despacho no encontrado con ID: " + id));
    }

    @Override
    public Despacho actualizar(Despacho obj) {
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
