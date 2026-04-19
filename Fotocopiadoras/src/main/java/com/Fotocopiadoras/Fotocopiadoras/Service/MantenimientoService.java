package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Mantenimiento;

public interface MantenimientoService {
    Mantenimiento registrar(Mantenimiento obj);
    List<Mantenimiento> listar();
    Mantenimiento buscarPorId(Integer id);
    Mantenimiento actualizar(Mantenimiento obj);
    void eliminar(Integer id);
}
