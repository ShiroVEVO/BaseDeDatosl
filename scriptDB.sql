CREATE TABLE tipo_doc (id_tipo_doc VARCHAR2(3) PRIMARY KEY,    desc_tipo_doc VARCHAR2(20) NOT NULL); 

CREATE TABLE candidato (usuario VARCHAR2(30) PRIMARY KEY,    nombre VARCHAR2(30) NOT NULL,
apellido VARCHAR2(30) NOT NULL,    fecha_nac DATE NOT NULL,    n_doc NUMBER(15) NOT NULL,
tipo_doc_id VARCHAR2(3) NOT NULL,    CONSTRAINT fk_tipo_doc FOREIGN KEY (tipo_doc_id) 
REFERENCES tipo_doc(id_tipo_doc));

INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('CC', 'Cedula de ciudadani');
INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('TI', 'Tarjeta de identida');
INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('TE', 'Tarjeta de Extranje');
INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('CE', 'Cedula de Extranjer');
INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('NIT', 'Numero de identifi'); 
INSERT INTO tipo_doc (id_tipo_doc, desc_tipo_doc) VALUES ('PAS', 'Pasaporte');