-- MySQL Script generated by MySQL Workbench
-- Thu Apr 25 12:50:41 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema redsocial
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `redsocial` ;

-- -----------------------------------------------------
-- Schema redsocial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `redsocial` DEFAULT CHARACTER SET utf8 ;
USE `redsocial` ;

-- -----------------------------------------------------
-- Table `redsocial`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redsocial`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(10) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `nombre` VARCHAR(40) NULL DEFAULT NULL,
  `apellido` VARCHAR(30) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `pais` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `usuario_username_un` (`username` ASC) VISIBLE,
  UNIQUE INDEX `usuario_email_un` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `redsocial`.`amistad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redsocial`.`amistad` (
  `usuario_id` INT(11) NOT NULL,
  `usuario_id1` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_id`, `usuario_id1`),
  INDEX `amistad_usuario_fkv1` (`usuario_id1` ASC) VISIBLE,
  CONSTRAINT `amistad_usuario_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `redsocial`.`usuario` (`id`),
  CONSTRAINT `amistad_usuario_fkv1`
    FOREIGN KEY (`usuario_id1`)
    REFERENCES `redsocial`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `redsocial`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redsocial`.`grupo` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL,
  `descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_creacion` DATE NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `grupo_usuario_fk` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `grupo_usuario_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `redsocial`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `redsocial`.`pertenece`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redsocial`.`pertenece` (
  `usuario_id` INT(11) NOT NULL,
  `grupo_id` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_id`, `grupo_id`),
  INDEX `pertenece_grupo_fk` (`grupo_id` ASC) VISIBLE,
  CONSTRAINT `pertenece_grupo_fk`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `redsocial`.`grupo` (`id`),
  CONSTRAINT `pertenece_usuario_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `redsocial`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `redsocial`.`peticion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redsocial`.`peticion` (
  `fecha` DATE NOT NULL,
  `confirmada` CHAR(1) NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  `usuario_id1` INT(11) NOT NULL,
  PRIMARY KEY (`usuario_id`, `usuario_id1`),
  INDEX `peticion_usuario_fkv2` (`usuario_id1` ASC) VISIBLE,
  CONSTRAINT `peticion_usuario_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `redsocial`.`usuario` (`id`),
  CONSTRAINT `peticion_usuario_fkv2`
    FOREIGN KEY (`usuario_id1`)
    REFERENCES `redsocial`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `redsocial`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redsocial`.`post` (
  `id` INT(11) NOT NULL,
  `titulo` VARCHAR(25) NOT NULL,
  `texto` VARCHAR(250) NOT NULL,
  `imagen` VARCHAR(1000) NULL DEFAULT NULL,
  `video` VARCHAR(1000) NULL DEFAULT NULL,
  `destinatario` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `usuario_id1` INT(11) NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `post_usuario_fk` (`usuario_id` ASC) VISIBLE,
  INDEX `post_usuario_fkv2` (`usuario_id1` ASC) VISIBLE,
  CONSTRAINT `post_usuario_fk`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `redsocial`.`usuario` (`id`),
  CONSTRAINT `post_usuario_fkv2`
    FOREIGN KEY (`usuario_id1`)
    REFERENCES `redsocial`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `redsocial`.`publicaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redsocial`.`publicaciones` (
  `post_id` INT(11) NOT NULL,
  `grupo_id` INT(11) NOT NULL,
  PRIMARY KEY (`post_id`, `grupo_id`),
  INDEX `publicaciones_grupo_fk` (`grupo_id` ASC) VISIBLE,
  CONSTRAINT `publicaciones_grupo_fk`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `redsocial`.`grupo` (`id`),
  CONSTRAINT `publicaciones_post_fk`
    FOREIGN KEY (`post_id`)
    REFERENCES `redsocial`.`post` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
