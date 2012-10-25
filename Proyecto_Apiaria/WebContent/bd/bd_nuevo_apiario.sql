SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `db_sistema_apiario` ;
CREATE SCHEMA IF NOT EXISTS `db_sistema_apiario` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `db_sistema_apiario` ;

-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_recurso_natural`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_recurso_natural` (
  `idtipo_recurso_natural` INT NOT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_recurso_natural`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`recurso_natural`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`recurso_natural` (
  `idrecurso_natural` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  `idtipo_recurso_natural` INT NOT NULL ,
  PRIMARY KEY (`idrecurso_natural`) ,
  INDEX `fk_recurso_natural_tipo_recurso_natural` (`idtipo_recurso_natural` ASC) ,
  CONSTRAINT `fk_recurso_natural_tipo_recurso_natural`
    FOREIGN KEY (`idtipo_recurso_natural` )
    REFERENCES `db_sistema_apiario`.`tipo_recurso_natural` (`idtipo_recurso_natural` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`pais`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`pais` (
  `idpais` INT NOT NULL AUTO_INCREMENT ,
  `nom_pais` VARCHAR(45) NULL ,
  PRIMARY KEY (`idpais`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`ubigeo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`ubigeo` (
  `idubigeo` VARCHAR(6) NOT NULL ,
  `departamento` VARCHAR(45) NULL ,
  `provincia` VARCHAR(45) NULL ,
  `distrito` VARCHAR(45) NULL ,
  `pais_idpais` INT NOT NULL ,
  PRIMARY KEY (`idubigeo`) ,
  INDEX `fk_ubigeo_pais1` (`pais_idpais` ASC) ,
  CONSTRAINT `fk_ubigeo_pais1`
    FOREIGN KEY (`pais_idpais` )
    REFERENCES `db_sistema_apiario`.`pais` (`idpais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`zona`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`zona` (
  `idzona` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  `idubigeo` VARCHAR(6) NOT NULL ,
  PRIMARY KEY (`idzona`) ,
  INDEX `fk_zona_ubigeo1` (`idubigeo` ASC) ,
  CONSTRAINT `fk_zona_ubigeo1`
    FOREIGN KEY (`idubigeo` )
    REFERENCES `db_sistema_apiario`.`ubigeo` (`idubigeo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_rec_nat_zona`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_rec_nat_zona` (
  `porcentaje_recurso` DECIMAL NULL ,
  `iddetalle_recursonatura_zona` INT NOT NULL AUTO_INCREMENT ,
  `idrecurso_natural` INT NOT NULL ,
  `idzona` INT NOT NULL ,
  PRIMARY KEY (`iddetalle_recursonatura_zona`) ,
  INDEX `fk_detalle_rec_nat_zona_recurso_natural1` (`idrecurso_natural` ASC) ,
  INDEX `fk_detalle_rec_nat_zona_zona1` (`idzona` ASC) ,
  CONSTRAINT `fk_detalle_rec_nat_zona_recurso_natural1`
    FOREIGN KEY (`idrecurso_natural` )
    REFERENCES `db_sistema_apiario`.`recurso_natural` (`idrecurso_natural` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_rec_nat_zona_zona1`
    FOREIGN KEY (`idzona` )
    REFERENCES `db_sistema_apiario`.`zona` (`idzona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`apiario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`apiario` (
  `idapiario` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idapiario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_seguimiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_seguimiento` (
  `motivo_ubicacion` VARCHAR(45) NULL ,
  `idplanilla_seguimiento` INT NOT NULL AUTO_INCREMENT ,
  `idapiario` INT NOT NULL ,
  `idzona` INT NOT NULL ,
  PRIMARY KEY (`idplanilla_seguimiento`) ,
  INDEX `fk_planilla_seguimiento_apiario1` (`idapiario` ASC) ,
  INDEX `fk_planilla_seguimiento_zona1` (`idzona` ASC) ,
  CONSTRAINT `fk_planilla_seguimiento_apiario1`
    FOREIGN KEY (`idapiario` )
    REFERENCES `db_sistema_apiario`.`apiario` (`idapiario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_seguimiento_zona1`
    FOREIGN KEY (`idzona` )
    REFERENCES `db_sistema_apiario`.`zona` (`idzona` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`norma_seguridad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`norma_seguridad` (
  `idnorma_seguridad` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(100) NULL ,
  PRIMARY KEY (`idnorma_seguridad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_apiario_norma_seg`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_apiario_norma_seg` (
  `estado_conformidad` VARCHAR(50) NULL ,
  `iddetalle_apiario_norma_seguridad` INT NOT NULL AUTO_INCREMENT ,
  `fecha_registro` DATE NULL ,
  `idapiario` INT NOT NULL ,
  `idnorma_seguridad` INT NOT NULL ,
  PRIMARY KEY (`iddetalle_apiario_norma_seguridad`) ,
  INDEX `fk_detalle_apiario_norma_seg_apiario1` (`idapiario` ASC) ,
  INDEX `fk_detalle_apiario_norma_seg_norma_seguridad1` (`idnorma_seguridad` ASC) ,
  CONSTRAINT `fk_detalle_apiario_norma_seg_apiario1`
    FOREIGN KEY (`idapiario` )
    REFERENCES `db_sistema_apiario`.`apiario` (`idapiario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_apiario_norma_seg_norma_seguridad1`
    FOREIGN KEY (`idnorma_seguridad` )
    REFERENCES `db_sistema_apiario`.`norma_seguridad` (`idnorma_seguridad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`colmena`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`colmena` (
  `idcolmena` INT NOT NULL AUTO_INCREMENT ,
  `idapiario` INT NOT NULL ,
  PRIMARY KEY (`idcolmena`) ,
  INDEX `fk_colmena_apiario1` (`idapiario` ASC) ,
  CONSTRAINT `fk_colmena_apiario1`
    FOREIGN KEY (`idapiario` )
    REFERENCES `db_sistema_apiario`.`apiario` (`idapiario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`piso`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`piso` (
  `idpiso` INT NOT NULL AUTO_INCREMENT ,
  `idcolmena` INT NOT NULL ,
  PRIMARY KEY (`idpiso`) ,
  INDEX `fk_piso_colmena1` (`idcolmena` ASC) ,
  CONSTRAINT `fk_piso_colmena1`
    FOREIGN KEY (`idcolmena` )
    REFERENCES `db_sistema_apiario`.`colmena` (`idcolmena` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_alza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_alza` (
  `idtipo_alza` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_alza`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`alza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`alza` (
  `idalza` INT NOT NULL AUTO_INCREMENT ,
  `idpiso` INT NOT NULL ,
  `idtipo_alza` INT NOT NULL ,
  PRIMARY KEY (`idalza`) ,
  INDEX `fk_alza_piso1` (`idpiso` ASC) ,
  INDEX `fk_alza_tipo_alza1` (`idtipo_alza` ASC) ,
  CONSTRAINT `fk_alza_piso1`
    FOREIGN KEY (`idpiso` )
    REFERENCES `db_sistema_apiario`.`piso` (`idpiso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alza_tipo_alza1`
    FOREIGN KEY (`idtipo_alza` )
    REFERENCES `db_sistema_apiario`.`tipo_alza` (`idtipo_alza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_usuario` (
  `idtipo_usuario` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_usuario`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT ,
  `nom_usu` VARCHAR(45) NULL ,
  `ape_usu` VARCHAR(45) NULL ,
  `idtipo_usuario` INT NOT NULL ,
  PRIMARY KEY (`idusuario`) ,
  INDEX `fk_usuario_tipo_usuario1` (`idtipo_usuario` ASC) ,
  CONSTRAINT `fk_usuario_tipo_usuario1`
    FOREIGN KEY (`idtipo_usuario` )
    REFERENCES `db_sistema_apiario`.`tipo_usuario` (`idtipo_usuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`estado_revision`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`estado_revision` (
  `idestado_revision` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idestado_revision`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`reina`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`reina` (
  `idreina` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  `idcolmena` INT NOT NULL ,
  `genetica` VARCHAR(45) NULL ,
  PRIMARY KEY (`idreina`) ,
  INDEX `fk_reina_colmena1` (`idcolmena` ASC) ,
  CONSTRAINT `fk_reina_colmena1`
    FOREIGN KEY (`idcolmena` )
    REFERENCES `db_sistema_apiario`.`colmena` (`idcolmena` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_revision`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_revision` (
  `estado_colmena` VARCHAR(45) NULL ,
  `necesidad_alimentacion` TINYINT(1)  NULL ,
  `necesidad_curacion` TINYINT(1)  NULL ,
  `falta_espacio_camara_cria` TINYINT(1)  NULL ,
  `peligro_colmena` VARCHAR(45) NULL ,
  `idestado_revision` INT NOT NULL ,
  `comportamiento` VARCHAR(150) NULL ,
  `idreina` INT NOT NULL ,
  `falta_alza` TINYINT(1)  NULL ,
  `existencia_reina` TINYINT(1)  NULL ,
  `idusuario` INT NOT NULL ,
  `idcolmena` INT NOT NULL ,
  `idplanilla_revision` INT NOT NULL ,
  INDEX `fk_planilla_revision_estado_revision1` (`idestado_revision` ASC) ,
  INDEX `fk_planilla_revision_reina1` (`idreina` ASC) ,
  INDEX `fk_planilla_revision_usuario1` (`idusuario` ASC) ,
  INDEX `fk_planilla_revision_colmena1` (`idcolmena` ASC) ,
  PRIMARY KEY (`idplanilla_revision`) ,
  CONSTRAINT `fk_planilla_revision_estado_revision1`
    FOREIGN KEY (`idestado_revision` )
    REFERENCES `db_sistema_apiario`.`estado_revision` (`idestado_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_reina1`
    FOREIGN KEY (`idreina` )
    REFERENCES `db_sistema_apiario`.`reina` (`idreina` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_usuario1`
    FOREIGN KEY (`idusuario` )
    REFERENCES `db_sistema_apiario`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_colmena1`
    FOREIGN KEY (`idcolmena` )
    REFERENCES `db_sistema_apiario`.`colmena` (`idcolmena` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_cosecha`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_cosecha` (
  `fecha_cosecha` DATE NULL ,
  `idplanilla_cosecha` INT NOT NULL ,
  `idusuario` INT NOT NULL ,
  `idcolmena` INT NOT NULL ,
  PRIMARY KEY (`idplanilla_cosecha`) ,
  INDEX `fk_planilla_cosecha_usuario1` (`idusuario` ASC) ,
  INDEX `fk_planilla_cosecha_colmena1` (`idcolmena` ASC) ,
  CONSTRAINT `fk_planilla_cosecha_usuario1`
    FOREIGN KEY (`idusuario` )
    REFERENCES `db_sistema_apiario`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_cosecha_colmena1`
    FOREIGN KEY (`idcolmena` )
    REFERENCES `db_sistema_apiario`.`colmena` (`idcolmena` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`centrifugadora`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`centrifugadora` (
  `idcentrifugadora` INT NOT NULL AUTO_INCREMENT ,
  `nombre_centrifugadora` VARCHAR(45) NULL ,
  PRIMARY KEY (`idcentrifugadora`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_alimentacion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_alimentacion` (
  `idtipo_alimentacion` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_alimentacion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_planilla_rev_tipo_alim`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_planilla_rev_tipo_alim` (
  `idplanilla_revision_tipo_alimento` INT NOT NULL ,
  `idplanilla_revision` INT NOT NULL ,
  `idtipo_alimentacion` INT NOT NULL ,
  PRIMARY KEY (`idplanilla_revision_tipo_alimento`) ,
  INDEX `fk_detalle_planilla_rev_tipo_alim_planilla_revision1` (`idplanilla_revision` ASC) ,
  INDEX `fk_detalle_planilla_rev_tipo_alim_tipo_alimentacion1` (`idtipo_alimentacion` ASC) ,
  CONSTRAINT `fk_detalle_planilla_rev_tipo_alim_planilla_revision1`
    FOREIGN KEY (`idplanilla_revision` )
    REFERENCES `db_sistema_apiario`.`planilla_revision` (`idplanilla_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_planilla_rev_tipo_alim_tipo_alimentacion1`
    FOREIGN KEY (`idtipo_alimentacion` )
    REFERENCES `db_sistema_apiario`.`tipo_alimentacion` (`idtipo_alimentacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`insumo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`insumo` (
  `idinsumo` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idinsumo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_tipo_alimentacion_insumo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_tipo_alimentacion_insumo` (
  `idtipo_alimentacion_insumo` INT NOT NULL AUTO_INCREMENT ,
  `idtipo_alimentacion` INT NOT NULL ,
  `idinsumo` INT NOT NULL ,
  PRIMARY KEY (`idtipo_alimentacion_insumo`) ,
  INDEX `fk_detalle_tipo_alimentacion_insumo_tipo_alimentacion1` (`idtipo_alimentacion` ASC) ,
  INDEX `fk_detalle_tipo_alimentacion_insumo_insumo1` (`idinsumo` ASC) ,
  CONSTRAINT `fk_detalle_tipo_alimentacion_insumo_tipo_alimentacion1`
    FOREIGN KEY (`idtipo_alimentacion` )
    REFERENCES `db_sistema_apiario`.`tipo_alimentacion` (`idtipo_alimentacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_tipo_alimentacion_insumo_insumo1`
    FOREIGN KEY (`idinsumo` )
    REFERENCES `db_sistema_apiario`.`insumo` (`idinsumo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`equipamiento_trabajo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`equipamiento_trabajo` (
  `idequipamiento_trabajo` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idequipamiento_trabajo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_est_revision_equi_trab`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_est_revision_equi_trab` (
  `idestado_revision_equipamiento_trabajo` INT NOT NULL AUTO_INCREMENT ,
  `idestado_revision` INT NOT NULL ,
  `equipamiento_trabajo_idequipamiento_trabajo` INT NOT NULL ,
  PRIMARY KEY (`idestado_revision_equipamiento_trabajo`) ,
  INDEX `fk_detalle_est_revision_equi_trab_estado_revision1` (`idestado_revision` ASC) ,
  INDEX `fk_detalle_est_revision_equi_trab_equipamiento_trabajo1` (`equipamiento_trabajo_idequipamiento_trabajo` ASC) ,
  CONSTRAINT `fk_detalle_est_revision_equi_trab_estado_revision1`
    FOREIGN KEY (`idestado_revision` )
    REFERENCES `db_sistema_apiario`.`estado_revision` (`idestado_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_est_revision_equi_trab_equipamiento_trabajo1`
    FOREIGN KEY (`equipamiento_trabajo_idequipamiento_trabajo` )
    REFERENCES `db_sistema_apiario`.`equipamiento_trabajo` (`idequipamiento_trabajo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_enfermedad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_enfermedad` (
  `idtipo_enfermedad` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_enfermedad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tratamiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tratamiento` (
  `idtratamiento` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  `idusuario` INT NOT NULL ,
  PRIMARY KEY (`idtratamiento`) ,
  INDEX `fk_tratamiento_usuario1` (`idusuario` ASC) ,
  CONSTRAINT `fk_tratamiento_usuario1`
    FOREIGN KEY (`idusuario` )
    REFERENCES `db_sistema_apiario`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_tipo_enfe_tratamiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_tipo_enfe_tratamiento` (
  `dosis` VARCHAR(150) NULL ,
  `idtipo_enfermedad_tratamiento` INT NOT NULL AUTO_INCREMENT ,
  `idtipo_enfermedad` INT NOT NULL ,
  `idtratamiento` INT NOT NULL ,
  PRIMARY KEY (`idtipo_enfermedad_tratamiento`) ,
  INDEX `fk_detalle_tipo_enfe_tratamiento_tipo_enfermedad1` (`idtipo_enfermedad` ASC) ,
  INDEX `fk_detalle_tipo_enfe_tratamiento_tratamiento1` (`idtratamiento` ASC) ,
  CONSTRAINT `fk_detalle_tipo_enfe_tratamiento_tipo_enfermedad1`
    FOREIGN KEY (`idtipo_enfermedad` )
    REFERENCES `db_sistema_apiario`.`tipo_enfermedad` (`idtipo_enfermedad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_tipo_enfe_tratamiento_tratamiento1`
    FOREIGN KEY (`idtratamiento` )
    REFERENCES `db_sistema_apiario`.`tratamiento` (`idtratamiento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_medicamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_medicamento` (
  `idtipo_medicamento` INT NOT NULL ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_medicamento`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`medicamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`medicamento` (
  `idmedicamento` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  `idtipo_medicamento` INT NOT NULL ,
  PRIMARY KEY (`idmedicamento`) ,
  INDEX `fk_medicamento_tipo_medicamento1` (`idtipo_medicamento` ASC) ,
  CONSTRAINT `fk_medicamento_tipo_medicamento1`
    FOREIGN KEY (`idtipo_medicamento` )
    REFERENCES `db_sistema_apiario`.`tipo_medicamento` (`idtipo_medicamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_trat_med`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_trat_med` (
  `idtratamiento_medicina` INT NOT NULL ,
  `tratamiento_idtratamiento` INT NOT NULL ,
  `medicamento_idmedicamento` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idtratamiento_medicina`) ,
  INDEX `fk_detalle_trat_med_tratamiento1` (`tratamiento_idtratamiento` ASC) ,
  INDEX `fk_detalle_trat_med_medicamento1` (`medicamento_idmedicamento` ASC) ,
  CONSTRAINT `fk_detalle_trat_med_tratamiento1`
    FOREIGN KEY (`tratamiento_idtratamiento` )
    REFERENCES `db_sistema_apiario`.`tratamiento` (`idtratamiento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_trat_med_medicamento1`
    FOREIGN KEY (`medicamento_idmedicamento` )
    REFERENCES `db_sistema_apiario`.`medicamento` (`idmedicamento` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`envasadora`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`envasadora` (
  `idEnvasadora` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idEnvasadora`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_usuario_Enva`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_usuario_Enva` (
  `fecha_uso` VARCHAR(10) NULL ,
  `usuario_idusuario` INT NOT NULL ,
  `envasadora_idEnvasadora` INT NOT NULL ,
  `idusuario_envasadora` INT NOT NULL AUTO_INCREMENT ,
  INDEX `fk_detalle_usuario_Enva_usuario1` (`usuario_idusuario` ASC) ,
  INDEX `fk_detalle_usuario_Enva_envasadora1` (`envasadora_idEnvasadora` ASC) ,
  PRIMARY KEY (`idusuario_envasadora`) ,
  CONSTRAINT `fk_detalle_usuario_Enva_usuario1`
    FOREIGN KEY (`usuario_idusuario` )
    REFERENCES `db_sistema_apiario`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_usuario_Enva_envasadora1`
    FOREIGN KEY (`envasadora_idEnvasadora` )
    REFERENCES `db_sistema_apiario`.`envasadora` (`idEnvasadora` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_producto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_producto` (
  `idtipo_producto` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_producto`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`producto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`producto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  `idtipo_producto` INT NOT NULL ,
  PRIMARY KEY (`idproducto`) ,
  INDEX `fk_producto_tipo_producto1` (`idtipo_producto` ASC) ,
  CONSTRAINT `fk_producto_tipo_producto1`
    FOREIGN KEY (`idtipo_producto` )
    REFERENCES `db_sistema_apiario`.`tipo_producto` (`idtipo_producto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`tipo_envase`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`tipo_envase` (
  `idtipo_envase` INT NOT NULL AUTO_INCREMENT ,
  `descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idtipo_envase`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`envase`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`envase` (
  `idenvase` INT NOT NULL AUTO_INCREMENT ,
  `unidad_medida` VARCHAR(10) NULL ,
  `idtipo_envase` INT NOT NULL ,
  PRIMARY KEY (`idenvase`) ,
  INDEX `fk_envase_tipo_envase1` (`idtipo_envase` ASC) ,
  CONSTRAINT `fk_envase_tipo_envase1`
    FOREIGN KEY (`idtipo_envase` )
    REFERENCES `db_sistema_apiario`.`tipo_envase` (`idtipo_envase` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`planilla_envasado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`planilla_envasado` (
  `fecha_envasado` VARCHAR(45) NULL ,
  `cantidad` VARCHAR(45) NULL ,
  `idenvase` INT NOT NULL ,
  `idplanilla_envasado` INT NOT NULL ,
  `idproducto` INT NOT NULL ,
  `idEnvasadora` INT NOT NULL ,
  PRIMARY KEY (`idplanilla_envasado`) ,
  INDEX `fk_planilla_envasado_envase1` (`idenvase` ASC) ,
  INDEX `fk_planilla_envasado_producto1` (`idproducto` ASC) ,
  INDEX `fk_planilla_envasado_envasadora1` (`idEnvasadora` ASC) ,
  CONSTRAINT `fk_planilla_envasado_envase1`
    FOREIGN KEY (`idenvase` )
    REFERENCES `db_sistema_apiario`.`envase` (`idenvase` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_envasado_producto1`
    FOREIGN KEY (`idproducto` )
    REFERENCES `db_sistema_apiario`.`producto` (`idproducto` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_envasado_envasadora1`
    FOREIGN KEY (`idEnvasadora` )
    REFERENCES `db_sistema_apiario`.`envasadora` (`idEnvasadora` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_planilla_revision_tipo_enfermedad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_planilla_revision_tipo_enfermedad` (
  `mienbro_enfermo` VARCHAR(45) NULL ,
  `idplanilla_revision_tipo_enfermedad` INT NOT NULL AUTO_INCREMENT ,
  `idtipo_enfermedad` INT NOT NULL ,
  `idplanilla_revision` INT NOT NULL ,
  PRIMARY KEY (`idplanilla_revision_tipo_enfermedad`) ,
  INDEX `fk_detalle_planilla_revision_tipo_enfermedad_tipo_enfermedad1` (`idtipo_enfermedad` ASC) ,
  INDEX `fk_detalle_planilla_revision_tipo_enfermedad_planilla_revision1` (`idplanilla_revision` ASC) ,
  CONSTRAINT `fk_detalle_planilla_revision_tipo_enfermedad_tipo_enfermedad1`
    FOREIGN KEY (`idtipo_enfermedad` )
    REFERENCES `db_sistema_apiario`.`tipo_enfermedad` (`idtipo_enfermedad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_planilla_revision_tipo_enfermedad_planilla_revision1`
    FOREIGN KEY (`idplanilla_revision` )
    REFERENCES `db_sistema_apiario`.`planilla_revision` (`idplanilla_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_planilla_revision_alza`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_planilla_revision_alza` (
  `estado_deterioro_alza` VARCHAR(45) NULL ,
  `porcentaje_miel` DECIMAL NULL ,
  `porcentaje_polen` DECIMAL NULL ,
  `estado_alza` VARCHAR(45) NULL ,
  `idplanilla_revision_alza` INT NOT NULL AUTO_INCREMENT ,
  `idalza` INT NOT NULL ,
  `idplanilla_revision` INT NOT NULL ,
  PRIMARY KEY (`idplanilla_revision_alza`) ,
  INDEX `fk_detalle_planilla_revision_alza_alza1` (`idalza` ASC) ,
  INDEX `fk_detalle_planilla_revision_alza_planilla_revision1` (`idplanilla_revision` ASC) ,
  CONSTRAINT `fk_detalle_planilla_revision_alza_alza1`
    FOREIGN KEY (`idalza` )
    REFERENCES `db_sistema_apiario`.`alza` (`idalza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_planilla_revision_alza_planilla_revision1`
    FOREIGN KEY (`idplanilla_revision` )
    REFERENCES `db_sistema_apiario`.`planilla_revision` (`idplanilla_revision` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_sistema_apiario`.`detalle_centrifugadora_planilla_cosecha`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `db_sistema_apiario`.`detalle_centrifugadora_planilla_cosecha` (
  `idplanilla_cosecha_centrifugadora` INT NOT NULL AUTO_INCREMENT ,
  `idplanilla_cosecha` INT NOT NULL ,
  `idcentrifugadora` INT NOT NULL ,
  PRIMARY KEY (`idplanilla_cosecha_centrifugadora`) ,
  INDEX `fk_detalle_centrifugadora_planilla_cosecha_planilla_cosecha1` (`idplanilla_cosecha` ASC) ,
  INDEX `fk_detalle_centrifugadora_planilla_cosecha_centrifugadora1` (`idcentrifugadora` ASC) ,
  CONSTRAINT `fk_detalle_centrifugadora_planilla_cosecha_planilla_cosecha1`
    FOREIGN KEY (`idplanilla_cosecha` )
    REFERENCES `db_sistema_apiario`.`planilla_cosecha` (`idplanilla_cosecha` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_centrifugadora_planilla_cosecha_centrifugadora1`
    FOREIGN KEY (`idcentrifugadora` )
    REFERENCES `db_sistema_apiario`.`centrifugadora` (`idcentrifugadora` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
