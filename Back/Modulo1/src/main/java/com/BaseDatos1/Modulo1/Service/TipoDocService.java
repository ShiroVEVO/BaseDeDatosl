package com.BaseDatos1.Modulo1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BaseDatos1.Modulo1.Model.TipoDoc;
import com.BaseDatos1.Modulo1.Repository.TipoDocRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDocService {
    private final TipoDocRepository tipoDocRepository;

    public List<TipoDoc> buscarTodos() {
        return tipoDocRepository.findAll();
    }

}
