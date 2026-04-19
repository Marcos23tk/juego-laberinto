package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Personal;
import com.Fotocopiadoras.Fotocopiadoras.Repository.PersonalRepository;

@Service
public class PersonalImplementacion implements PersonalService {
    
    private final PersonalRepository repo;

    public PersonalImplementacion(PersonalRepository repo) {
        this.repo = repo;
    }

    @Override
    public Personal registrar(Personal obj) {
        return repo.save(obj);
    }

    @Override
    public List<Personal> listar() {
        return repo.findAll();
    }

    @Override
    public Personal buscarPorId(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Personal no encontrado con ID: " + id));
    }

    @Override
    public Personal actualizar(Personal obj) {
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
