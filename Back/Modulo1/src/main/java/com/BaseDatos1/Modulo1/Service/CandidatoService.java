package com.BaseDatos1.Modulo1.Service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BaseDatos1.Modulo1.Model.Candidato;
import com.BaseDatos1.Modulo1.Repository.CandidatoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidatoService {
    private final CandidatoRepository candidatoRepository;

    public Optional<Candidato> buscarCandidatoPorUsuario(String usuario) {
        return candidatoRepository.findCandidatoByUsuario(usuario);
    }

    public ResponseEntity<String> guardarCandidato(Candidato candidato) {
        try {
            candidatoRepository.save(candidato);
            return ResponseEntity.status(HttpStatus.CREATED).body("Candidato guardado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el candidato: " + e.getMessage());
        }
    }
}
