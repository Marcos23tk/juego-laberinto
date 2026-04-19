package com.Fotocopiadoras.Fotocopiadoras.Service;


import java.util.List;

import com.Fotocopiadoras.Fotocopiadoras.Entity.DistritoFiscal;

public interface DistritoFiscalService {
    // Crear o guardar (POST)
DistritoFiscal registrar (DistritoFiscal df);
List<DistritoFiscal> listar();
DistritoFiscal buscarPorId(Integer id);
DistritoFiscal actualizar(DistritoFiscal df);
void eliminar(Integer id);
}
