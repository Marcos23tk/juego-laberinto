package com.Fotocopiadoras.Fotocopiadoras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fotocopiadoras.Fotocopiadoras.Entity.DistritoFiscal;
//Aquí va el código que se comunica con la base de datos.
//agreamos el exteden jpaReposytory 
@Repository
//nos prporciona el acceso a la base de datos directamente
// crud 
public interface DistritoFiscalRepository extends JpaRepository <DistritoFiscal,Integer> {


// ===== CRUD básico ya viene incluido por JpaRepository =====
    // save(), findAll(), findById(), deleteById(), count(), existsById()
}
