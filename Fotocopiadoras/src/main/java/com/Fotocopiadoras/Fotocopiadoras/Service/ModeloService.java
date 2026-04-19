package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Modelo;

public interface ModeloService {
    Modelo registrar(Modelo obj);
    List<Modelo> listar();
    Modelo buscarPorId(Integer id);
    Modelo actualizar(Modelo obj);
    void eliminar(Integer id);
}
