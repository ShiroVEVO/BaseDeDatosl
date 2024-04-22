package com.BaseDatos1.Modulo1.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.BaseDatos1.Modulo1.Model.TipoDoc;
import com.BaseDatos1.Modulo1.Service.TipoDocService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:8023")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tipoDoc")
public class TipoDocController {

    private final TipoDocService tipoDocService;

    @GetMapping
    public ResponseEntity<List<TipoDoc>> buscarTodosTipoDoc() {
        List<TipoDoc> tiposDoc = tipoDocService.buscarTodos();
        return ResponseEntity.ok().body(tiposDoc);
    }
}
