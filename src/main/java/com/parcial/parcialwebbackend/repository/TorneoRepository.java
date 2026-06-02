package com.parcial.parcialwebbackend.repository;

import com.parcial.parcialwebbackend.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Long> {
}
