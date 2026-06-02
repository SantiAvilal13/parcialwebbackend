package com.parcial.parcialwebbackend.repository;

import com.parcial.parcialwebbackend.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
