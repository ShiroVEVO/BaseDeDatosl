package com.BaseDatos1.Modulo1.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_doc")
public class TipoDoc {
    @Id
    @Column(name = "id_tipo_doc")
    String id_tipo_doc;

    @Column(name = "desc_tipo_doc")
    String desc_tipo_doc;

    @JsonManagedReference("TipoDoc-Candidato")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tipoDoc")
    private List<Candidato> candidatos;

    @Override
    public String toString() {
        return "\"TipoDoc\": {\"idTipoDoc\":" + id_tipo_doc + ", \"desctTipoDoc\": \"" + desc_tipo_doc + "\"}";
    }

}

/*
 * INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('CC', 'Cedula de
 * ciudadania');
 * INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('TI', 'Tarjeta de
 * identidad');
 * INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('TE', 'Tarjeta de
 * Extranjer');
 * INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('CE', 'Cedula de
 * Extranjeri');
 * INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('NIT', 'Numero de
 * identific');
 * INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('PAS',
 * 'Pasaporte');
 * 
 */