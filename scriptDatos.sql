/*
-- Query: SELECT * FROM redsocial.usuario
LIMIT 0, 1000

-- Date: 2019-05-12 21:26
*/
INSERT INTO `usuario` (`id`,`username`,`email`,`password`,`nombre`,`apellido`,`fecha_nacimiento`,`pais`) VALUES (2,'Batman','caballerooscuro@gmail.com','joker01','Bruce','Wayne','1939-09-13','Gotham');
INSERT INTO `usuario` (`id`,`username`,`email`,`password`,`nombre`,`apellido`,`fecha_nacimiento`,`pais`) VALUES (3,'Hulk','incrediblehulk@gmail.com','hulk','Bruce','Banner','1970-08-29','USA');
INSERT INTO `usuario` (`id`,`username`,`email`,`password`,`nombre`,`apellido`,`fecha_nacimiento`,`pais`) VALUES (4,'IronMan','ironman@gmail.com','3000','Tony','Stark','1980-10-28','USA');
INSERT INTO `usuario` (`id`,`username`,`email`,`password`,`nombre`,`apellido`,`fecha_nacimiento`,`pais`) VALUES (5,'Goku','dragonball@gmail.com','z','Goku','Son','1964-02-17','Vegeta');
INSERT INTO `usuario` (`id`,`username`,`email`,`password`,`nombre`,`apellido`,`fecha_nacimiento`,`pais`) VALUES (6,'Vegeta','principesayan@gmail.com','bulma','Vegeta','Principe','1958-09-27','Vegeta');


/*
-- Query: SELECT * FROM redsocial.amistad
LIMIT 0, 1000

-- Date: 2019-05-12 21:19
*/
INSERT INTO `amistad` (`usuario_id`,`usuario_id1`) VALUES (3,2);
INSERT INTO `amistad` (`usuario_id`,`usuario_id1`) VALUES (2,3);
INSERT INTO `amistad` (`usuario_id`,`usuario_id1`) VALUES (4,3);
INSERT INTO `amistad` (`usuario_id`,`usuario_id1`) VALUES (3,4);
INSERT INTO `amistad` (`usuario_id`,`usuario_id1`) VALUES (6,5);
INSERT INTO `amistad` (`usuario_id`,`usuario_id1`) VALUES (5,6);

/*
-- Query: SELECT * FROM redsocial.grupo
LIMIT 0, 1000

-- Date: 2019-05-12 21:30
*/
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`,`fecha_creacion`,`usuario_id`) VALUES (1,'Joker','Hay que acabar con ese payaso','2019-05-11',2);
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`,`fecha_creacion`,`usuario_id`) VALUES (2,'Grupo Sayans','No admitimos insectos humanos!','2019-05-11',6);
INSERT INTO `grupo` (`id`,`nombre`,`descripcion`,`fecha_creacion`,`usuario_id`) VALUES (3,'Avengers','Iniciativa vengadores','2019-05-11',4);


/*
-- Query: SELECT * FROM redsocial.pertenece
LIMIT 0, 1000

-- Date: 2019-05-12 21:29
*/
INSERT INTO `pertenece` (`usuario_id`,`grupo_id`) VALUES (2,1);
INSERT INTO `pertenece` (`usuario_id`,`grupo_id`) VALUES (5,2);
INSERT INTO `pertenece` (`usuario_id`,`grupo_id`) VALUES (6,2);
INSERT INTO `pertenece` (`usuario_id`,`grupo_id`) VALUES (3,3);
INSERT INTO `pertenece` (`usuario_id`,`grupo_id`) VALUES (4,3);
INSERT INTO `pertenece` (`usuario_id`,`grupo_id`) VALUES (5,3);



/*
-- Query: SELECT * FROM redsocial.peticion
LIMIT 0, 1000

-- Date: 2019-05-12 21:32
*/
INSERT INTO `peticion` (`fecha`,`confirmada`,`usuario_id`,`usuario_id1`) VALUES ('2019-05-11',1,2,3);
INSERT INTO `peticion` (`fecha`,`confirmada`,`usuario_id`,`usuario_id1`) VALUES ('2019-05-11',0,2,4);
INSERT INTO `peticion` (`fecha`,`confirmada`,`usuario_id`,`usuario_id1`) VALUES ('2019-05-11',0,2,6);
INSERT INTO `peticion` (`fecha`,`confirmada`,`usuario_id`,`usuario_id1`) VALUES ('2019-05-11',0,3,5);
INSERT INTO `peticion` (`fecha`,`confirmada`,`usuario_id`,`usuario_id1`) VALUES ('2019-05-11',1,4,3);
INSERT INTO `peticion` (`fecha`,`confirmada`,`usuario_id`,`usuario_id1`) VALUES ('2019-05-11',1,5,6);
INSERT INTO `peticion` (`fecha`,`confirmada`,`usuario_id`,`usuario_id1`) VALUES ('2019-05-11',0,6,3);


/*
-- Query: SELECT * FROM redsocial.post
LIMIT 0, 1000

-- Date: 2019-05-12 21:33
*/
INSERT INTO `post` (`id`,`titulo`,`texto`,`imagen`,`video`,`destinatario`,`fecha`,`usuario_id1`,`usuario_id`) VALUES (1,'Hola a todos','Yo soy Batman!','','',1,'2019-05-11',1,2);
INSERT INTO `post` (`id`,`titulo`,`texto`,`imagen`,`video`,`destinatario`,`fecha`,`usuario_id1`,`usuario_id`) VALUES (2,'Entrenamiento','Vegeta vente a entrenar','','',6,'2019-05-11',6,5);
INSERT INTO `post` (`id`,`titulo`,`texto`,`imagen`,`video`,`destinatario`,`fecha`,`usuario_id1`,`usuario_id`) VALUES (3,'Celula','Hay que acabar con celula,ayuda','','',0,'2019-05-11',5,5);
INSERT INTO `post` (`id`,`titulo`,`texto`,`imagen`,`video`,`destinatario`,`fecha`,`usuario_id1`,`usuario_id`) VALUES (4,'A por el','Destrozare a ese insecto','','',0,'2019-05-11',6,6);
INSERT INTO `post` (`id`,`titulo`,`texto`,`imagen`,`video`,`destinatario`,`fecha`,`usuario_id1`,`usuario_id`) VALUES (5,'Thanos','Se busca gente para derrotar a Thanos','','',1,'2019-05-11',1,4);
INSERT INTO `post` (`id`,`titulo`,`texto`,`imagen`,`video`,`destinatario`,`fecha`,`usuario_id1`,`usuario_id`) VALUES (6,'Hulk aplasta','Dioses a mi','','',0,'2019-05-11',3,3);

/*
-- Query: SELECT * FROM redsocial.publicaciones
LIMIT 0, 1000

-- Date: 2019-05-12 21:34
*/
INSERT INTO `publicaciones` (`post_id`,`grupo_id`) VALUES (3,2);
INSERT INTO `publicaciones` (`post_id`,`grupo_id`) VALUES (4,2);
INSERT INTO `publicaciones` (`post_id`,`grupo_id`) VALUES (6,3);