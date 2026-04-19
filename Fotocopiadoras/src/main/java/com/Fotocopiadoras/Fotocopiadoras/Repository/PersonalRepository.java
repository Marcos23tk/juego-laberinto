package com.Fotocopiadoras.Fotocopiadoras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer> {
}