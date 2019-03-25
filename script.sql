DROP SCHEMA IF EXISTS `RedSocial` ;

-- -----------------------------------------------------
-- Schema Lavadero
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RedSocial` DEFAULT CHARACTER SET utf8 ;
USE `RedSocial` ;

CREATE TABLE amistad (
    usuario_id    INTEGER NOT NULL,
    usuario_id1   INTEGER NOT NULL
);

ALTER TABLE amistad ADD CONSTRAINT amistad_pk PRIMARY KEY ( usuario_id,
usuario_id1 );

CREATE TABLE grupo (
    id               INTEGER NOT NULL,
    nombre           VARCHAR(15) NOT NULL,
    descripcion      VARCHAR(50),
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
    titulo         VARCHAR(25) NOT NULL,
    texto          VARCHAR(250) NOT NULL,
    imagen         VARCHAR(1000),
    video          VARCHAR(1000),
    destinatario   INTEGER NOT NULL,
    fecha          DATE NOT NULL,
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
    username           VARCHAR(10) NOT NULL,
    email              VARCHAR(30) NOT NULL,
    password         VARCHAR(30) NOT NULL,
    nombre             VARCHAR(40 ),
    apellido           VARCHAR(30),
    fecha_nacimiento   DATE NOT NULL,
    pais               VARCHAR(10)
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

ALTER TABLE publicaciones
    ADD CONSTRAINT publicaciones_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE publicaciones
    ADD CONSTRAINT publicaciones_post_fk FOREIGN KEY ( post_id )
        REFERENCES post ( id );
