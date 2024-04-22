package com.BaseDatos1.Modulo1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BaseDatos1.Modulo1.Model.Candidato;
import com.BaseDatos1.Modulo1.Service.CandidatoService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:8023")
@RestController
@RequiredArgsConstructor
@RequestMapping("/candidato")
public class CandidatoController {

    private final CandidatoService candidatoService;

    @GetMapping("/{usuario}")
    public ResponseEntity<String> getMethodName(@PathVariable("usuario") String usuario) {
        Optional<Candidato> optionalCandidato = candidatoService.buscarCandidatoPorUsuario(usuario);
        if (optionalCandidato.isPresent()) {
            return ResponseEntity.ok(optionalCandidato.get().toString());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardarCandidato(@RequestBody Candidato candidato) {
        return candidatoService.guardarCandidato(candidato);
    }

}
