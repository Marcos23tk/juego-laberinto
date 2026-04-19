package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.Fotocopiadoras.Fotocopiadoras.Entity.DistritoFiscal;
import com.Fotocopiadoras.Fotocopiadoras.Repository.DistritoFiscalRepository;

@Service
public class DistritoFiscalImplementacion implements DistritoFiscalService {

    private final DistritoFiscalRepository repo;

    public DistritoFiscalImplementacion(DistritoFiscalRepository repo) {
        this.repo = repo;
    }

    @Override
    public DistritoFiscal registrar(DistritoFiscal df) {
        if (df.getNombre() == null || df.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        return repo.save(df);
    }

    @Override
    public List<DistritoFiscal> listar() {
        return repo.findAll();
    }

    @Override
    public DistritoFiscal buscarPorId(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el DistritoFiscal con ID: " + id));
    }

    @Override
    public DistritoFiscal actualizar(DistritoFiscal df) {
        if (df.getId() == null) {
            throw new IllegalArgumentException("El ID es obligatorio para actualizar");
        }

        if (!repo.existsById(df.getId())) {
            throw new RuntimeException("No existe el registro con ID: " + df.getId());
        }

        return repo.save(df);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("No existe el registro con ID: " + id);
        }
        repo.deleteById(id);
    }
}
