package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Despacho;

public interface DespachoService {
    Despacho registrar(Despacho obj);
    List<Despacho> listar();
    Despacho buscarPorId(Integer id);
    Despacho actualizar(Despacho obj);
    void eliminar(Integer id);
}
