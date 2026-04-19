package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Marca;
import com.Fotocopiadoras.Fotocopiadoras.Repository.MarcaRepository;

@Service
public class MarcaImplementacion implements MarcaService {
    
    private final MarcaRepository repo;

    public MarcaImplementacion(MarcaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Marca registrar(Marca m) {
        return repo.save(m);
    }

    @Override
    public List<Marca> listar() {
        return repo.findAll();
    }

    @Override
    public Marca buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + id));
    }

    @Override
    public Marca actualizar(Marca m) {
        return repo.save(m);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
