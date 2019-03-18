-- Generado por Oracle SQL Developer Data Modeler 17.3.0.261.1529
--   en:        2019-03-18 10:05:51 CET
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE amistad (
    usuario_id    INTEGER NOT NULL,
    usuario_id1   INTEGER NOT NULL
);

ALTER TABLE amistad ADD CONSTRAINT amistad_pk PRIMARY KEY ( usuario_id,
usuario_id1 );

CREATE TABLE grupo (
    id               INTEGER NOT NULL,
    nombre           VARCHAR2(15) NOT NULL,
    descripcion      VARCHAR2(50 CHAR),
    fecha_creacion   DATE NOT NULL,
    usuario_id       INTEGER NOT NULL
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( id );

CREATE TABLE pertenece (
    usuario_id   INTEGER NOT NULL,
    grupo_id     INTEGER NOT NULL
);

ALTER TABLE pertenece ADD CONSTRAINT pertenece_pk PRIMARY KEY ( usuario_id,
grupo_id );

CREATE TABLE peticion (
    fecha         DATE NOT NULL,
    confirmada    CHAR(1) NOT NULL,
    usuario_id    INTEGER NOT NULL,
    usuario_id1   INTEGER NOT NULL
);

ALTER TABLE peticion ADD CONSTRAINT peticion_pk PRIMARY KEY ( usuario_id,
usuario_id1 );

CREATE TABLE post (
    id             INTEGER NOT NULL,
    titulo         VARCHAR2(25 CHAR) NOT NULL,
    texto          VARCHAR2(250 CHAR) NOT NULL,
    imagen         VARCHAR2(1000 CHAR),
    video          VARCHAR2(1000 CHAR),
    destinatario   INTEGER NOT NULL,
    fecha          DATE NOT NULL,
    usuario_id1    INTEGER NOT NULL,
    usuario_id     INTEGER NOT NULL
);

ALTER TABLE post ADD CONSTRAINT post_pk PRIMARY KEY ( id );

CREATE TABLE publicaciones (
    post_id    INTEGER NOT NULL,
    grupo_id   INTEGER NOT NULL
);

ALTER TABLE publicaciones ADD CONSTRAINT publicaciones_pk PRIMARY KEY ( post_id,
grupo_id );

CREATE TABLE usuario (
    id                 INTEGER NOT NULL,
    username           VARCHAR2(10 CHAR) NOT NULL,
    email              VARCHAR2(30 CHAR) NOT NULL,
    contraseña         VARCHAR2(30 CHAR) NOT NULL,
    nombre             VARCHAR2(40 CHAR),
    apellido           VARCHAR2(30 CHAR),
    fecha_nacimiento   DATE NOT NULL,
    pais               VARCHAR2(10 CHAR)
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

ALTER TABLE usuario ADD CONSTRAINT usuario_username_un UNIQUE ( username );

ALTER TABLE usuario ADD CONSTRAINT usuario_email_un UNIQUE ( email );

ALTER TABLE amistad
    ADD CONSTRAINT amistad_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE amistad
    ADD CONSTRAINT amistad_usuario_fkv1 FOREIGN KEY ( usuario_id1 )
        REFERENCES usuario ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE pertenece
    ADD CONSTRAINT pertenece_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE pertenece
    ADD CONSTRAINT pertenece_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE peticion
    ADD CONSTRAINT peticion_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE peticion
    ADD CONSTRAINT peticion_usuario_fkv2 FOREIGN KEY ( usuario_id1 )
        REFERENCES usuario ( id );

ALTER TABLE post
    ADD CONSTRAINT post_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( id );

ALTER TABLE post
    ADD CONSTRAINT post_usuario_fkv2 FOREIGN KEY ( usuario_id1 )
        REFERENCES usuario ( id );

ALTER TABLE publicaciones
    ADD CONSTRAINT publicaciones_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE publicaciones
    ADD CONSTRAINT publicaciones_post_fk FOREIGN KEY ( post_id )
        REFERENCES post ( id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                             20
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
