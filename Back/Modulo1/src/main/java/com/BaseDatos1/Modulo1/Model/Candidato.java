package com.BaseDatos1.Modulo1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidato")
public class Candidato {

    @Id
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_Nac")
    private Date fecha_nac;

    @Column(name = "n_Doc")
    private Long n_doc;

    @ManyToOne
    @JsonBackReference("TipoDoc-Candidato")
    @JoinColumn(name = "tipo_doc_id", nullable = false)
    private TipoDoc tipoDoc;

    @Override
    public String toString() {
        return "{\"usuario\":\"" + usuario + "\"," +
                "\"nombre\":\"" + nombre + "\"," +
                "\"apellido\":\"" + apellido + "\"," +
                "\"fechaNac\":\"" + fecha_nac + "\"," +
                "\"nDoc\":" + n_doc + "," +
                "\"tipoDoc\":\"" + tipoDoc.id_tipo_doc + "\"}";
    }
}
