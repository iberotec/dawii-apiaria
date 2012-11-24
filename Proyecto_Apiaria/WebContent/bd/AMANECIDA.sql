SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `db_sistema_apiario` ;
CREATE SCHEMA IF NOT EXISTS `db_sistema_apiario` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `db_sistema_apiario` ;

-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`apiario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`apiario` (
  `id_apiario` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`id_apiario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`colmena`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`colmena` (
  `id_colmena` INT NOT NULL AUTO_INCREMENT ,
  `id_apiario` INT NOT NULL ,
  PRIMARY KEY (`id_colmena`) ,
  INDEX `fk_Colmena_Apiario1` (`id_apiario` ASC) ,
  CONSTRAINT `fk_Colmena_Apiario1`
    FOREIGN KEY (`id_apiario` )
    REFERENCES `db_sistema_apiario`.`apiario` (`id_apiario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_usario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_usario` (
  `id_tipo_usario` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_usuario` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_tipo_usario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT ,
  `nombre_usuario` VARCHAR(45) NULL ,
  `ape_pater_usuario` VARCHAR(45) NULL ,
  `ape_mater_usuario` VARCHAR(45) NULL ,
  `id_tipo_usario` INT NOT NULL ,
  PRIMARY KEY (`id_usuario`) ,
  INDEX `fk_usuario_tipo_usario1` (`id_tipo_usario` ASC) ,
  CONSTRAINT `fk_usuario_tipo_usario1`
    FOREIGN KEY (`id_tipo_usario` )
    REFERENCES `db_sistema_apiario`.`tipo_usario` (`id_tipo_usario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`reina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`reina` (
  `id_reina` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_reina` VARCHAR(45) NULL ,
  `caracteristica_reina` VARCHAR(45) NULL ,
  `id_colmena` INT NOT NULL ,
  PRIMARY KEY (`id_reina`) ,
  INDEX `fk_Reina_Colmena1` (`id_colmena` ASC) ,
  CONSTRAINT `fk_Reina_Colmena1`
    FOREIGN KEY (`id_colmena` )
    REFERENCES `db_sistema_apiario`.`colmena` (`id_colmena` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`estado_revision`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`estado_revision` (
  `id_estado_revision` INT NOT NULL ,
  `descripcion_estado_revision` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_estado_revision`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`temporada`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`temporada` (
  `id_temporada` INT NOT NULL AUTO_INCREMENT ,
  `periodo_inicial` DATE NULL ,
  `periodo_final` DATE NULL ,
  `estado_etapa` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_temporada`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_revision`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_revision` (
  `id_planilla_revision` INT NOT NULL AUTO_INCREMENT ,
  `id_colmena` INT NOT NULL ,
  `id_usuario` INT NOT NULL ,
  `existencia_reina` TINYINT(1)  NULL ,
  `id_reina` INT NOT NULL ,
  `estado_cosecha` VARCHAR(45) NULL ,
  `necesidad_alimentacion` TINYINT(1)  NULL ,
  `necesidad_curacion` TINYINT(1)  NULL ,
  `id_estado_revision` INT NOT NULL ,
  `falta_espacio_camara` TINYINT(1)  NULL ,
  `falta_alza` VARCHAR(45) NULL ,
  `comportamiento` VARCHAR(100) NULL ,
  `temporada_id_temporada` INT NOT NULL ,
  PRIMARY KEY (`id_planilla_revision`) ,
  INDEX `fk_Planilla_revision_Colmena1` (`id_colmena` ASC) ,
  INDEX `fk_planilla_revision_usuario2` (`id_usuario` ASC) ,
  INDEX `fk_planilla_revision_reina2` (`id_reina` ASC) ,
  INDEX `fk_planilla_revision_estado_revision2` (`id_estado_revision` ASC) ,
  INDEX `fk_planilla_revision_temporada1` (`temporada_id_temporada` ASC) ,
  CONSTRAINT `fk_Planilla_revision_Colmena1`
    FOREIGN KEY (`id_colmena` )
    REFERENCES `db_sistema_apiario`.`colmena` (`id_colmena` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_usuario2`
    FOREIGN KEY (`id_usuario` )
    REFERENCES `db_sistema_apiario`.`usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_reina2`
    FOREIGN KEY (`id_reina` )
    REFERENCES `db_sistema_apiario`.`reina` (`id_reina` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_estado_revision2`
    FOREIGN KEY (`id_estado_revision` )
    REFERENCES `db_sistema_apiario`.`estado_revision` (`id_estado_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_temporada1`
    FOREIGN KEY (`temporada_id_temporada` )
    REFERENCES `db_sistema_apiario`.`temporada` (`id_temporada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`piso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`piso` (
  `id_piso` INT NOT NULL AUTO_INCREMENT ,
  `id_colmena` INT NOT NULL ,
  PRIMARY KEY (`id_piso`) ,
  INDEX `fk_Piso_Colmena1` (`id_colmena` ASC) ,
  CONSTRAINT `fk_Piso_Colmena1`
    FOREIGN KEY (`id_colmena` )
    REFERENCES `db_sistema_apiario`.`colmena` (`id_colmena` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_alza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_alza` (
  `id_tipo_alza` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_tipo_alza` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_tipo_alza`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`alza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`alza` (
  `id_alza` INT NOT NULL AUTO_INCREMENT ,
  `id_piso` INT NOT NULL ,
  `id_tipo_alza` INT NOT NULL ,
  PRIMARY KEY (`id_alza`) ,
  INDEX `fk_Alza_Piso1` (`id_piso` ASC) ,
  INDEX `fk_Alza_Tipo_alza1` (`id_tipo_alza` ASC) ,
  CONSTRAINT `fk_Alza_Piso1`
    FOREIGN KEY (`id_piso` )
    REFERENCES `db_sistema_apiario`.`piso` (`id_piso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alza_Tipo_alza1`
    FOREIGN KEY (`id_tipo_alza` )
    REFERENCES `db_sistema_apiario`.`tipo_alza` (`id_tipo_alza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`pais`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`pais` (
  `id_pais` INT NOT NULL ,
  `nombre_pais` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_pais`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`ubigeo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`ubigeo` (
  `id_ubigeo` INT NOT NULL AUTO_INCREMENT ,
  `departamento` VARCHAR(45) NULL ,
  `provincia` VARCHAR(45) NULL ,
  `distrito` VARCHAR(45) NULL ,
  `id_pais` INT NOT NULL ,
  PRIMARY KEY (`id_ubigeo`) ,
  INDEX `fk_ubigeo_pais2` (`id_pais` ASC) ,
  CONSTRAINT `fk_ubigeo_pais2`
    FOREIGN KEY (`id_pais` )
    REFERENCES `db_sistema_apiario`.`pais` (`id_pais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`zona`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`zona` (
  `id_zona` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_zona` VARCHAR(100) NULL ,
  `id_ubigeo` INT NOT NULL ,
  PRIMARY KEY (`id_zona`) ,
  INDEX `fk_zona_ubigeo2` (`id_ubigeo` ASC) ,
  CONSTRAINT `fk_zona_ubigeo2`
    FOREIGN KEY (`id_ubigeo` )
    REFERENCES `db_sistema_apiario`.`ubigeo` (`id_ubigeo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_seguimiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_seguimiento` (
  `id_planilla_seguimiento` INT NOT NULL AUTO_INCREMENT ,
  `id_apiario` INT NOT NULL ,
  `id_zona` INT NOT NULL ,
  `motivo_ubicacion` VARCHAR(100) NULL ,
  `fecha_registro` DATE NULL ,
  PRIMARY KEY (`id_planilla_seguimiento`) ,
  INDEX `fk_Planilla_seguimiento_Apiario1` (`id_apiario` ASC) ,
  INDEX `fk_Planilla_seguimiento_Zona1` (`id_zona` ASC) ,
  CONSTRAINT `fk_Planilla_seguimiento_Apiario1`
    FOREIGN KEY (`id_apiario` )
    REFERENCES `db_sistema_apiario`.`apiario` (`id_apiario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Planilla_seguimiento_Zona1`
    FOREIGN KEY (`id_zona` )
    REFERENCES `db_sistema_apiario`.`zona` (`id_zona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_recurso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_recurso` (
  `id_tipo_recurso` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_tipo_recurso` VARCHAR(100) NULL ,
  PRIMARY KEY (`id_tipo_recurso`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`recurso_natural`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`recurso_natural` (
  `id_recurso_natural` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_recurso_natural` VARCHAR(100) NULL ,
  `id_tipo_recurso` INT NOT NULL ,
  PRIMARY KEY (`id_recurso_natural`) ,
  INDEX `fk_recurso_natural_tipo_recurso1` (`id_tipo_recurso` ASC) ,
  CONSTRAINT `fk_recurso_natural_tipo_recurso1`
    FOREIGN KEY (`id_tipo_recurso` )
    REFERENCES `db_sistema_apiario`.`tipo_recurso` (`id_tipo_recurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`zona_recuso_natural`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`zona_recuso_natural` (
  `id_zona_recurso_natural` INT NOT NULL AUTO_INCREMENT ,
  `zona_id_zona` INT NOT NULL ,
  `id_recurso_natural` INT NOT NULL ,
  PRIMARY KEY (`id_zona_recurso_natural`) ,
  INDEX `fk_zona_Recuso_Natural_zona1` (`zona_id_zona` ASC) ,
  INDEX `fk_zona_Recuso_Natural_recurso_natural1` (`id_recurso_natural` ASC) ,
  CONSTRAINT `fk_zona_Recuso_Natural_zona1`
    FOREIGN KEY (`zona_id_zona` )
    REFERENCES `db_sistema_apiario`.`zona` (`id_zona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_zona_Recuso_Natural_recurso_natural1`
    FOREIGN KEY (`id_recurso_natural` )
    REFERENCES `db_sistema_apiario`.`recurso_natural` (`id_recurso_natural` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`norma_seguridad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`norma_seguridad` (
  `id_norma_seguridad` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_norma_seguridad` VARCHAR(100) NULL ,
  PRIMARY KEY (`id_norma_seguridad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`norma_seguridad_apiario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`norma_seguridad_apiario` (
  `id_norma_seguridad_apiario` INT NOT NULL AUTO_INCREMENT ,
  `id_norma_seguridad` INT NOT NULL ,
  `id_apiario` INT NOT NULL ,
  `estado` TINYINT(1)  NULL ,
  `fecha_registro` DATE NULL ,
  PRIMARY KEY (`id_norma_seguridad_apiario`) ,
  INDEX `fk_norma_seguridad_apiario_norma_seguridad1` (`id_norma_seguridad` ASC) ,
  INDEX `fk_norma_seguridad_apiario_apiario1` (`id_apiario` ASC) ,
  CONSTRAINT `fk_norma_seguridad_apiario_norma_seguridad1`
    FOREIGN KEY (`id_norma_seguridad` )
    REFERENCES `db_sistema_apiario`.`norma_seguridad` (`id_norma_seguridad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_norma_seguridad_apiario_apiario1`
    FOREIGN KEY (`id_apiario` )
    REFERENCES `db_sistema_apiario`.`apiario` (`id_apiario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_alimentacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_alimentacion` (
  `id_tipo_alimentacion` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_tipo_alimentacion` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_tipo_alimentacion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_revision_tipo_alimentacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_revision_tipo_alimentacion` (
  `id_planilla_revision_tipo_alimentacion` INT NOT NULL AUTO_INCREMENT ,
  `id_planilla_revision` INT NOT NULL ,
  `id_tipo_alimentacion` INT NOT NULL ,
  PRIMARY KEY (`id_planilla_revision_tipo_alimentacion`) ,
  INDEX `fk_planilla_revision_tipo_alimentacion_planilla_revision1` (`id_planilla_revision` ASC) ,
  INDEX `fk_planilla_revision_tipo_alimentacion_tipo_alimentacion1` (`id_tipo_alimentacion` ASC) ,
  CONSTRAINT `fk_planilla_revision_tipo_alimentacion_planilla_revision1`
    FOREIGN KEY (`id_planilla_revision` )
    REFERENCES `db_sistema_apiario`.`planilla_revision` (`id_planilla_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_tipo_alimentacion_tipo_alimentacion1`
    FOREIGN KEY (`id_tipo_alimentacion` )
    REFERENCES `db_sistema_apiario`.`tipo_alimentacion` (`id_tipo_alimentacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`Insumo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`Insumo` (
  `id_insumo` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_insumo` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_insumo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_alimentacion_insumo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_alimentacion_insumo` (
  `id_tipo_alimentacion_insumo` INT NOT NULL AUTO_INCREMENT ,
  `id_tipo_alimentacion` INT NOT NULL ,
  `id_insumo` INT NOT NULL ,
  PRIMARY KEY (`id_tipo_alimentacion_insumo`) ,
  INDEX `fk_tipo_alimentacion_insumo_tipo_alimentacion1` (`id_tipo_alimentacion` ASC) ,
  INDEX `fk_tipo_alimentacion_insumo_Insumo1` (`id_insumo` ASC) ,
  CONSTRAINT `fk_tipo_alimentacion_insumo_tipo_alimentacion1`
    FOREIGN KEY (`id_tipo_alimentacion` )
    REFERENCES `db_sistema_apiario`.`tipo_alimentacion` (`id_tipo_alimentacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_alimentacion_insumo_Insumo1`
    FOREIGN KEY (`id_insumo` )
    REFERENCES `db_sistema_apiario`.`Insumo` (`id_insumo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_enfermedad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_enfermedad` (
  `id_tipo_enfermedad` INT NOT NULL ,
  `descripcion_tipo_enfermedad` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_tipo_enfermedad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_revision_tipo_enfermedad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_revision_tipo_enfermedad` (
  `id_planilla_revision_tipo_enfermedad` INT NOT NULL AUTO_INCREMENT ,
  `id_planilla_revision` INT NOT NULL ,
  `id_tipo_enfermedad` INT NOT NULL ,
  PRIMARY KEY (`id_planilla_revision_tipo_enfermedad`) ,
  INDEX `fk_planilla_revision_tipo_enfermedad_planilla_revision1` (`id_planilla_revision` ASC) ,
  INDEX `fk_planilla_revision_tipo_enfermedad_tipo_enfermedad1` (`id_tipo_enfermedad` ASC) ,
  CONSTRAINT `fk_planilla_revision_tipo_enfermedad_planilla_revision1`
    FOREIGN KEY (`id_planilla_revision` )
    REFERENCES `db_sistema_apiario`.`planilla_revision` (`id_planilla_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_tipo_enfermedad_tipo_enfermedad1`
    FOREIGN KEY (`id_tipo_enfermedad` )
    REFERENCES `db_sistema_apiario`.`tipo_enfermedad` (`id_tipo_enfermedad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tratamiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tratamiento` (
  `id_tratamiento` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_tratamiento` VARCHAR(145) NULL ,
  `id_usuario` INT NOT NULL ,
  PRIMARY KEY (`id_tratamiento`) ,
  INDEX `fk_tratamiento_usuario2` (`id_usuario` ASC) ,
  CONSTRAINT `fk_tratamiento_usuario2`
    FOREIGN KEY (`id_usuario` )
    REFERENCES `db_sistema_apiario`.`usuario` (`id_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_enfermedad_tratamiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_enfermedad_tratamiento` (
  `id_tipo_enfermedad_tratamiento` INT NOT NULL AUTO_INCREMENT ,
  `id_tipo_enfermedad` INT NOT NULL ,
  `id_tratamiento` INT NOT NULL ,
  PRIMARY KEY (`id_tipo_enfermedad_tratamiento`) ,
  INDEX `fk_tipo_enfermedad_tratamiento_tipo_enfermedad1` (`id_tipo_enfermedad` ASC) ,
  INDEX `fk_tipo_enfermedad_tratamiento_tratamiento1` (`id_tratamiento` ASC) ,
  CONSTRAINT `fk_tipo_enfermedad_tratamiento_tipo_enfermedad1`
    FOREIGN KEY (`id_tipo_enfermedad` )
    REFERENCES `db_sistema_apiario`.`tipo_enfermedad` (`id_tipo_enfermedad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_enfermedad_tratamiento_tratamiento1`
    FOREIGN KEY (`id_tratamiento` )
    REFERENCES `db_sistema_apiario`.`tratamiento` (`id_tratamiento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_medicamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_medicamento` (
  `id_tipo_medicamento` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_tipo_medicamento` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_tipo_medicamento`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`medicamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`medicamento` (
  `id_medicamento` INT NOT NULL AUTO_INCREMENT ,
  `descripcion_medicamento` VARCHAR(145) NULL ,
  `id_tipo_medicamento` INT NOT NULL ,
  PRIMARY KEY (`id_medicamento`) ,
  INDEX `fk_medicamento_tipo_medicamento2` (`id_tipo_medicamento` ASC) ,
  CONSTRAINT `fk_medicamento_tipo_medicamento2`
    FOREIGN KEY (`id_tipo_medicamento` )
    REFERENCES `db_sistema_apiario`.`tipo_medicamento` (`id_tipo_medicamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tratamiento_medicamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tratamiento_medicamento` (
  `id_tratamiento_medicamento` INT NOT NULL AUTO_INCREMENT ,
  `id_medicamento` INT NOT NULL ,
  `id_tratamiento` INT NOT NULL ,
  PRIMARY KEY (`id_tratamiento_medicamento`) ,
  INDEX `fk_tratamiento_medicamento_medicamento1` (`id_medicamento` ASC) ,
  INDEX `fk_tratamiento_medicamento_tratamiento1` (`id_tratamiento` ASC) ,
  CONSTRAINT `fk_tratamiento_medicamento_medicamento1`
    FOREIGN KEY (`id_medicamento` )
    REFERENCES `db_sistema_apiario`.`medicamento` (`id_medicamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tratamiento_medicamento_tratamiento1`
    FOREIGN KEY (`id_tratamiento` )
    REFERENCES `db_sistema_apiario`.`tratamiento` (`id_tratamiento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`equipamiento_trabajo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`equipamiento_trabajo` (
  `id_equipamiento_trabajo` INT NOT NULL ,
  `descripcion_equipo_trabajo` VARCHAR(145) NULL ,
  PRIMARY KEY (`id_equipamiento_trabajo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`estado_revision_equipamiento_trabajo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`estado_revision_equipamiento_trabajo` (
  `id_estado_revision_equipamiento_trabajo` INT NOT NULL AUTO_INCREMENT ,
  `id_equipamiento_trabajo` INT NOT NULL ,
  `id_estado_revision` INT NOT NULL ,
  PRIMARY KEY (`id_estado_revision_equipamiento_trabajo`) ,
  INDEX `fk_estado_revision_equipamiento_trabajo1` (`id_equipamiento_trabajo` ASC) ,
  INDEX `fk_estado_revision_estado_revision1` (`id_estado_revision` ASC) ,
  CONSTRAINT `fk_estado_revision_equipamiento_trabajo1`
    FOREIGN KEY (`id_equipamiento_trabajo` )
    REFERENCES `db_sistema_apiario`.`equipamiento_trabajo` (`id_equipamiento_trabajo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estado_revision_estado_revision1`
    FOREIGN KEY (`id_estado_revision` )
    REFERENCES `db_sistema_apiario`.`estado_revision` (`id_estado_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_resvision_alza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_resvision_alza` (
  `id_planilla_resvision_alza` INT NOT NULL AUTO_INCREMENT ,
  `iid_alza` INT NOT NULL ,
  `id_planilla_revision` INT NOT NULL ,
  `estado_deterioro_alza` VARCHAR(45) NULL ,
  `estado_alza` VARCHAR(45) NULL ,
  `porcentaje_miel` DOUBLE NULL ,
  PRIMARY KEY (`id_planilla_resvision_alza`) ,
  INDEX `fk_planilla_resvision_alza_alza1` (`iid_alza` ASC) ,
  INDEX `fk_planilla_resvision_alza_planilla_revision1` (`id_planilla_revision` ASC) ,
  CONSTRAINT `fk_planilla_resvision_alza_alza1`
    FOREIGN KEY (`iid_alza` )
    REFERENCES `db_sistema_apiario`.`alza` (`id_alza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_resvision_alza_planilla_revision1`
    FOREIGN KEY (`id_planilla_revision` )
    REFERENCES `db_sistema_apiario`.`planilla_revision` (`id_planilla_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_revision_alza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_revision_alza` (
  `id_planilla_revision_alza` INT NOT NULL AUTO_INCREMENT ,
  `id_planilla_revision` INT NOT NULL ,
  `id_alza` INT NOT NULL ,
  `estado_alza` VARCHAR(45) NULL ,
  `porcentaje_miel` DOUBLE NULL ,
  `estado_deterioro_alza` TINYINT(1)  NULL ,
  PRIMARY KEY (`id_planilla_revision_alza`) ,
  INDEX `fk_planilla_revision_alza_planilla_revision1` (`id_planilla_revision` ASC) ,
  INDEX `fk_planilla_revision_alza_alza1` (`id_alza` ASC) ,
  CONSTRAINT `fk_planilla_revision_alza_planilla_revision1`
    FOREIGN KEY (`id_planilla_revision` )
    REFERENCES `db_sistema_apiario`.`planilla_revision` (`id_planilla_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_alza_alza1`
    FOREIGN KEY (`id_alza` )
    REFERENCES `db_sistema_apiario`.`alza` (`id_alza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
