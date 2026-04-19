package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Marca;

public interface MarcaService {
    Marca registrar(Marca obj);
    List<Marca> listar();
    Marca buscarPorId(Integer id);
    Marca actualizar(Marca obj);
    void eliminar(Integer id);
}
