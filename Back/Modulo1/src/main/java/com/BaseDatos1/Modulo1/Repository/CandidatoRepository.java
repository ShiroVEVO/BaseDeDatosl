package com.BaseDatos1.Modulo1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BaseDatos1.Modulo1.Model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, String> {
    Optional<Candidato> findCandidatoByUsuario(String usuario);
}