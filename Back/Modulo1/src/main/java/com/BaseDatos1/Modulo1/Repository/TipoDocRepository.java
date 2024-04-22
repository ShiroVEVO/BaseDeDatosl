package com.BaseDatos1.Modulo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BaseDatos1.Modulo1.Model.TipoDoc;

@Repository
public interface TipoDocRepository extends JpaRepository<TipoDoc, String> {

}
