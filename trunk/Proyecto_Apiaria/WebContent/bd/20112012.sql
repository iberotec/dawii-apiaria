-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: db_sistema_apiario
-- ------------------------------------------------------
-- Server version	5.1.45-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `db_sistema_apiario`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_sistema_apiario` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_sistema_apiario`;

--
-- Table structure for table `alza`
--

DROP TABLE IF EXISTS `alza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alza` (
  `idalza` int(11) NOT NULL AUTO_INCREMENT,
  `idpiso` int(11) NOT NULL,
  `idtipo_alza` int(11) NOT NULL,
  PRIMARY KEY (`idalza`),
  KEY `fk_alza_piso1` (`idpiso`),
  KEY `fk_alza_tipo_alza1` (`idtipo_alza`),
  CONSTRAINT `fk_alza_piso1` FOREIGN KEY (`idpiso`) REFERENCES `piso` (`idpiso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alza_tipo_alza1` FOREIGN KEY (`idtipo_alza`) REFERENCES `tipo_alza` (`idtipo_alza`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alza`
--

LOCK TABLES `alza` WRITE;
/*!40000 ALTER TABLE `alza` DISABLE KEYS */;
/*!40000 ALTER TABLE `alza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apiario`
--

DROP TABLE IF EXISTS `apiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apiario` (
  `descripcion_apiario` varchar(45) DEFAULT NULL,
  `idapiario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idapiario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apiario`
--

LOCK TABLES `apiario` WRITE;
/*!40000 ALTER TABLE `apiario` DISABLE KEYS */;
INSERT INTO `apiario` VALUES ('Apiario 1',1),('Apiario 2',2),('Apiario 3',3);
/*!40000 ALTER TABLE `apiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centrifugadora`
--

DROP TABLE IF EXISTS `centrifugadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centrifugadora` (
  `idcentrifugadora` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_centrifugadora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcentrifugadora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centrifugadora`
--

LOCK TABLES `centrifugadora` WRITE;
/*!40000 ALTER TABLE `centrifugadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `centrifugadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colmena`
--

DROP TABLE IF EXISTS `colmena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colmena` (
  `idcolmena` int(11) NOT NULL AUTO_INCREMENT,
  `idapiario` int(11) NOT NULL,
  PRIMARY KEY (`idcolmena`),
  KEY `fk_colmena_apiario1` (`idapiario`),
  CONSTRAINT `fk_colmena_apiario1` FOREIGN KEY (`idapiario`) REFERENCES `apiario` (`idapiario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colmena`
--

LOCK TABLES `colmena` WRITE;
/*!40000 ALTER TABLE `colmena` DISABLE KEYS */;
/*!40000 ALTER TABLE `colmena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_apiario_norma_seg`
--

DROP TABLE IF EXISTS `detalle_apiario_norma_seg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_apiario_norma_seg` (
  `estado_conformidad` varchar(50) DEFAULT NULL,
  `iddetalle_apiario_norma_seguridad` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_registro` date DEFAULT NULL,
  `idapiario` int(11) NOT NULL,
  `idnorma_seguridad` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_apiario_norma_seguridad`),
  KEY `fk_detalle_apiario_norma_seg_apiario1` (`idapiario`),
  KEY `fk_detalle_apiario_norma_seg_norma_seguridad1` (`idnorma_seguridad`),
  CONSTRAINT `fk_detalle_apiario_norma_seg_apiario1` FOREIGN KEY (`idapiario`) REFERENCES `apiario` (`idapiario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_apiario_norma_seg_norma_seguridad1` FOREIGN KEY (`idnorma_seguridad`) REFERENCES `norma_seguridad` (`idnorma_seguridad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_apiario_norma_seg`
--

LOCK TABLES `detalle_apiario_norma_seg` WRITE;
/*!40000 ALTER TABLE `detalle_apiario_norma_seg` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_apiario_norma_seg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_centrifugadora_planilla_cosecha`
--

DROP TABLE IF EXISTS `detalle_centrifugadora_planilla_cosecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_centrifugadora_planilla_cosecha` (
  `idplanilla_cosecha_centrifugadora` int(11) NOT NULL AUTO_INCREMENT,
  `idplanilla_cosecha` int(11) NOT NULL,
  `idcentrifugadora` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_cosecha_centrifugadora`),
  KEY `fk_detalle_centrifugadora_planilla_cosecha_planilla_cosecha1` (`idplanilla_cosecha`),
  KEY `fk_detalle_centrifugadora_planilla_cosecha_centrifugadora1` (`idcentrifugadora`),
  CONSTRAINT `fk_detalle_centrifugadora_planilla_cosecha_centrifugadora1` FOREIGN KEY (`idcentrifugadora`) REFERENCES `centrifugadora` (`idcentrifugadora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_centrifugadora_planilla_cosecha_planilla_cosecha1` FOREIGN KEY (`idplanilla_cosecha`) REFERENCES `planilla_cosecha` (`idplanilla_cosecha`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_centrifugadora_planilla_cosecha`
--

LOCK TABLES `detalle_centrifugadora_planilla_cosecha` WRITE;
/*!40000 ALTER TABLE `detalle_centrifugadora_planilla_cosecha` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_centrifugadora_planilla_cosecha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_est_revision_equi_trab`
--

DROP TABLE IF EXISTS `detalle_est_revision_equi_trab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_est_revision_equi_trab` (
  `idestado_revision_equipamiento_trabajo` int(11) NOT NULL AUTO_INCREMENT,
  `idestado_revision` int(11) NOT NULL,
  `equipamiento_trabajo_idequipamiento_trabajo` int(11) NOT NULL,
  PRIMARY KEY (`idestado_revision_equipamiento_trabajo`),
  KEY `fk_detalle_est_revision_equi_trab_estado_revision1` (`idestado_revision`),
  KEY `fk_detalle_est_revision_equi_trab_equipamiento_trabajo1` (`equipamiento_trabajo_idequipamiento_trabajo`),
  CONSTRAINT `fk_detalle_est_revision_equi_trab_equipamiento_trabajo1` FOREIGN KEY (`equipamiento_trabajo_idequipamiento_trabajo`) REFERENCES `equipamiento_trabajo` (`idequipamiento_trabajo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_est_revision_equi_trab_estado_revision1` FOREIGN KEY (`idestado_revision`) REFERENCES `estado_revision` (`idestado_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_est_revision_equi_trab`
--

LOCK TABLES `detalle_est_revision_equi_trab` WRITE;
/*!40000 ALTER TABLE `detalle_est_revision_equi_trab` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_est_revision_equi_trab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_planilla_rev_tipo_alim`
--

DROP TABLE IF EXISTS `detalle_planilla_rev_tipo_alim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_planilla_rev_tipo_alim` (
  `idplanilla_revision_tipo_alimento` int(11) NOT NULL,
  `idplanilla_revision` int(11) NOT NULL,
  `idtipo_alimentacion` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_revision_tipo_alimento`),
  KEY `fk_detalle_planilla_rev_tipo_alim_planilla_revision1` (`idplanilla_revision`),
  KEY `fk_detalle_planilla_rev_tipo_alim_tipo_alimentacion1` (`idtipo_alimentacion`),
  CONSTRAINT `fk_detalle_planilla_rev_tipo_alim_planilla_revision1` FOREIGN KEY (`idplanilla_revision`) REFERENCES `planilla_revision` (`idplanilla_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_planilla_rev_tipo_alim_tipo_alimentacion1` FOREIGN KEY (`idtipo_alimentacion`) REFERENCES `tipo_alimentacion` (`idtipo_alimentacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_planilla_rev_tipo_alim`
--

LOCK TABLES `detalle_planilla_rev_tipo_alim` WRITE;
/*!40000 ALTER TABLE `detalle_planilla_rev_tipo_alim` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_planilla_rev_tipo_alim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_planilla_revision_alza`
--

DROP TABLE IF EXISTS `detalle_planilla_revision_alza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_planilla_revision_alza` (
  `estado_deterioro_alza` varchar(45) DEFAULT NULL,
  `porcentaje_miel` decimal(10,0) DEFAULT NULL,
  `porcentaje_polen` decimal(10,0) DEFAULT NULL,
  `estado_alza` varchar(45) DEFAULT NULL,
  `idplanilla_revision_alza` int(11) NOT NULL AUTO_INCREMENT,
  `idalza` int(11) NOT NULL,
  `idplanilla_revision` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_revision_alza`),
  KEY `fk_detalle_planilla_revision_alza_alza1` (`idalza`),
  KEY `fk_detalle_planilla_revision_alza_planilla_revision1` (`idplanilla_revision`),
  CONSTRAINT `fk_detalle_planilla_revision_alza_alza1` FOREIGN KEY (`idalza`) REFERENCES `alza` (`idalza`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_planilla_revision_alza_planilla_revision1` FOREIGN KEY (`idplanilla_revision`) REFERENCES `planilla_revision` (`idplanilla_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_planilla_revision_alza`
--

LOCK TABLES `detalle_planilla_revision_alza` WRITE;
/*!40000 ALTER TABLE `detalle_planilla_revision_alza` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_planilla_revision_alza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_planilla_revision_tipo_enfermedad`
--

DROP TABLE IF EXISTS `detalle_planilla_revision_tipo_enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_planilla_revision_tipo_enfermedad` (
  `mienbro_enfermo` varchar(45) DEFAULT NULL,
  `idplanilla_revision_tipo_enfermedad` int(11) NOT NULL AUTO_INCREMENT,
  `idtipo_enfermedad` int(11) NOT NULL,
  `idplanilla_revision` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_revision_tipo_enfermedad`),
  KEY `fk_detalle_planilla_revision_tipo_enfermedad_tipo_enfermedad1` (`idtipo_enfermedad`),
  KEY `fk_detalle_planilla_revision_tipo_enfermedad_planilla_revision1` (`idplanilla_revision`),
  CONSTRAINT `fk_detalle_planilla_revision_tipo_enfermedad_planilla_revision1` FOREIGN KEY (`idplanilla_revision`) REFERENCES `planilla_revision` (`idplanilla_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_planilla_revision_tipo_enfermedad_tipo_enfermedad1` FOREIGN KEY (`idtipo_enfermedad`) REFERENCES `tipo_enfermedad` (`idtipo_enfermedad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_planilla_revision_tipo_enfermedad`
--

LOCK TABLES `detalle_planilla_revision_tipo_enfermedad` WRITE;
/*!40000 ALTER TABLE `detalle_planilla_revision_tipo_enfermedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_planilla_revision_tipo_enfermedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_rec_nat_zona`
--

DROP TABLE IF EXISTS `detalle_rec_nat_zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_rec_nat_zona` (
  `porcentaje_recurso` decimal(10,0) DEFAULT NULL,
  `iddetalle_recursonatura_zona` int(11) NOT NULL AUTO_INCREMENT,
  `idrecurso_natural` int(11) NOT NULL,
  `idzona` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_recursonatura_zona`),
  KEY `fk_detalle_rec_nat_zona_recurso_natural1` (`idrecurso_natural`),
  KEY `fk_detalle_rec_nat_zona_zona1` (`idzona`),
  CONSTRAINT `fk_detalle_rec_nat_zona_recurso_natural1` FOREIGN KEY (`idrecurso_natural`) REFERENCES `recurso_natural` (`idrecurso_natural`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_rec_nat_zona_zona1` FOREIGN KEY (`idzona`) REFERENCES `zona` (`idzona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_rec_nat_zona`
--

LOCK TABLES `detalle_rec_nat_zona` WRITE;
/*!40000 ALTER TABLE `detalle_rec_nat_zona` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_rec_nat_zona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_tipo_alimentacion_insumo`
--

DROP TABLE IF EXISTS `detalle_tipo_alimentacion_insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_tipo_alimentacion_insumo` (
  `idtipo_alimentacion_insumo` int(11) NOT NULL AUTO_INCREMENT,
  `idtipo_alimentacion` int(11) NOT NULL,
  `idinsumo` int(11) NOT NULL,
  PRIMARY KEY (`idtipo_alimentacion_insumo`),
  KEY `fk_detalle_tipo_alimentacion_insumo_tipo_alimentacion1` (`idtipo_alimentacion`),
  KEY `fk_detalle_tipo_alimentacion_insumo_insumo1` (`idinsumo`),
  CONSTRAINT `fk_detalle_tipo_alimentacion_insumo_insumo1` FOREIGN KEY (`idinsumo`) REFERENCES `insumo` (`idinsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_tipo_alimentacion_insumo_tipo_alimentacion1` FOREIGN KEY (`idtipo_alimentacion`) REFERENCES `tipo_alimentacion` (`idtipo_alimentacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_tipo_alimentacion_insumo`
--

LOCK TABLES `detalle_tipo_alimentacion_insumo` WRITE;
/*!40000 ALTER TABLE `detalle_tipo_alimentacion_insumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_tipo_alimentacion_insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_tipo_enfe_tratamiento`
--

DROP TABLE IF EXISTS `detalle_tipo_enfe_tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_tipo_enfe_tratamiento` (
  `dosis` varchar(150) DEFAULT NULL,
  `idtipo_enfermedad_tratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `idtipo_enfermedad` int(11) NOT NULL,
  `idtratamiento` int(11) NOT NULL,
  PRIMARY KEY (`idtipo_enfermedad_tratamiento`),
  KEY `fk_detalle_tipo_enfe_tratamiento_tipo_enfermedad1` (`idtipo_enfermedad`),
  KEY `fk_detalle_tipo_enfe_tratamiento_tratamiento1` (`idtratamiento`),
  CONSTRAINT `fk_detalle_tipo_enfe_tratamiento_tipo_enfermedad1` FOREIGN KEY (`idtipo_enfermedad`) REFERENCES `tipo_enfermedad` (`idtipo_enfermedad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_tipo_enfe_tratamiento_tratamiento1` FOREIGN KEY (`idtratamiento`) REFERENCES `tratamiento` (`idtratamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_tipo_enfe_tratamiento`
--

LOCK TABLES `detalle_tipo_enfe_tratamiento` WRITE;
/*!40000 ALTER TABLE `detalle_tipo_enfe_tratamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_tipo_enfe_tratamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_trat_med`
--

DROP TABLE IF EXISTS `detalle_trat_med`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_trat_med` (
  `idtratamiento_medicina` int(11) NOT NULL,
  `tratamiento_idtratamiento` int(11) NOT NULL,
  `medicamento_idmedicamento` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idtratamiento_medicina`),
  KEY `fk_detalle_trat_med_tratamiento1` (`tratamiento_idtratamiento`),
  KEY `fk_detalle_trat_med_medicamento1` (`medicamento_idmedicamento`),
  CONSTRAINT `fk_detalle_trat_med_medicamento1` FOREIGN KEY (`medicamento_idmedicamento`) REFERENCES `medicamento` (`idmedicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_trat_med_tratamiento1` FOREIGN KEY (`tratamiento_idtratamiento`) REFERENCES `tratamiento` (`idtratamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_trat_med`
--

LOCK TABLES `detalle_trat_med` WRITE;
/*!40000 ALTER TABLE `detalle_trat_med` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_trat_med` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_usuario_enva`
--

DROP TABLE IF EXISTS `detalle_usuario_enva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_usuario_enva` (
  `fecha_uso` varchar(10) DEFAULT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `envasadora_idEnvasadora` int(11) NOT NULL,
  `idusuario_envasadora` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idusuario_envasadora`),
  KEY `fk_detalle_usuario_Enva_usuario1` (`usuario_idusuario`),
  KEY `fk_detalle_usuario_Enva_envasadora1` (`envasadora_idEnvasadora`),
  CONSTRAINT `fk_detalle_usuario_Enva_envasadora1` FOREIGN KEY (`envasadora_idEnvasadora`) REFERENCES `envasadora` (`idEnvasadora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_usuario_Enva_usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_usuario_enva`
--

LOCK TABLES `detalle_usuario_enva` WRITE;
/*!40000 ALTER TABLE `detalle_usuario_enva` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_usuario_enva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envasadora`
--

DROP TABLE IF EXISTS `envasadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `envasadora` (
  `idEnvasadora` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idEnvasadora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envasadora`
--

LOCK TABLES `envasadora` WRITE;
/*!40000 ALTER TABLE `envasadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `envasadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envase`
--

DROP TABLE IF EXISTS `envase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `envase` (
  `idenvase` int(11) NOT NULL AUTO_INCREMENT,
  `unidad_medida` varchar(10) DEFAULT NULL,
  `idtipo_envase` int(11) NOT NULL,
  PRIMARY KEY (`idenvase`),
  KEY `fk_envase_tipo_envase1` (`idtipo_envase`),
  CONSTRAINT `fk_envase_tipo_envase1` FOREIGN KEY (`idtipo_envase`) REFERENCES `tipo_envase` (`idtipo_envase`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envase`
--

LOCK TABLES `envase` WRITE;
/*!40000 ALTER TABLE `envase` DISABLE KEYS */;
/*!40000 ALTER TABLE `envase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamiento_trabajo`
--

DROP TABLE IF EXISTS `equipamiento_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamiento_trabajo` (
  `idequipamiento_trabajo` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idequipamiento_trabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamiento_trabajo`
--

LOCK TABLES `equipamiento_trabajo` WRITE;
/*!40000 ALTER TABLE `equipamiento_trabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipamiento_trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_revision`
--

DROP TABLE IF EXISTS `estado_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_revision` (
  `idestado_revision` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idestado_revision`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_revision`
--

LOCK TABLES `estado_revision` WRITE;
/*!40000 ALTER TABLE `estado_revision` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumo` (
  `idinsumo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idinsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo`
--

LOCK TABLES `insumo` WRITE;
/*!40000 ALTER TABLE `insumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicamento` (
  `idmedicamento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idtipo_medicamento` int(11) NOT NULL,
  PRIMARY KEY (`idmedicamento`),
  KEY `fk_medicamento_tipo_medicamento1` (`idtipo_medicamento`),
  CONSTRAINT `fk_medicamento_tipo_medicamento1` FOREIGN KEY (`idtipo_medicamento`) REFERENCES `tipo_medicamento` (`idtipo_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `norma_seguridad`
--

DROP TABLE IF EXISTS `norma_seguridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `norma_seguridad` (
  `idnorma_seguridad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idnorma_seguridad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `norma_seguridad`
--

LOCK TABLES `norma_seguridad` WRITE;
/*!40000 ALTER TABLE `norma_seguridad` DISABLE KEYS */;
/*!40000 ALTER TABLE `norma_seguridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `idpais` int(11) NOT NULL AUTO_INCREMENT,
  `nom_pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piso`
--

DROP TABLE IF EXISTS `piso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piso` (
  `idpiso` int(11) NOT NULL AUTO_INCREMENT,
  `idcolmena` int(11) NOT NULL,
  PRIMARY KEY (`idpiso`),
  KEY `fk_piso_colmena1` (`idcolmena`),
  CONSTRAINT `fk_piso_colmena1` FOREIGN KEY (`idcolmena`) REFERENCES `colmena` (`idcolmena`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piso`
--

LOCK TABLES `piso` WRITE;
/*!40000 ALTER TABLE `piso` DISABLE KEYS */;
/*!40000 ALTER TABLE `piso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_cosecha`
--

DROP TABLE IF EXISTS `planilla_cosecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_cosecha` (
  `fecha_cosecha` date DEFAULT NULL,
  `idplanilla_cosecha` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `idcolmena` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_cosecha`),
  KEY `fk_planilla_cosecha_usuario1` (`idusuario`),
  KEY `fk_planilla_cosecha_colmena1` (`idcolmena`),
  CONSTRAINT `fk_planilla_cosecha_colmena1` FOREIGN KEY (`idcolmena`) REFERENCES `colmena` (`idcolmena`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_cosecha_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_cosecha`
--

LOCK TABLES `planilla_cosecha` WRITE;
/*!40000 ALTER TABLE `planilla_cosecha` DISABLE KEYS */;
/*!40000 ALTER TABLE `planilla_cosecha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_envasado`
--

DROP TABLE IF EXISTS `planilla_envasado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_envasado` (
  `fecha_envasado` varchar(45) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `idenvase` int(11) NOT NULL,
  `idplanilla_envasado` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `idEnvasadora` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_envasado`),
  KEY `fk_planilla_envasado_envase1` (`idenvase`),
  KEY `fk_planilla_envasado_producto1` (`idproducto`),
  KEY `fk_planilla_envasado_envasadora1` (`idEnvasadora`),
  CONSTRAINT `fk_planilla_envasado_envasadora1` FOREIGN KEY (`idEnvasadora`) REFERENCES `envasadora` (`idEnvasadora`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_envasado_envase1` FOREIGN KEY (`idenvase`) REFERENCES `envase` (`idenvase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_envasado_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_envasado`
--

LOCK TABLES `planilla_envasado` WRITE;
/*!40000 ALTER TABLE `planilla_envasado` DISABLE KEYS */;
/*!40000 ALTER TABLE `planilla_envasado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_revision`
--

DROP TABLE IF EXISTS `planilla_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_revision` (
  `estado_colmena` varchar(45) DEFAULT NULL,
  `necesidad_alimentacion` tinyint(1) DEFAULT NULL,
  `necesidad_curacion` tinyint(1) DEFAULT NULL,
  `falta_espacio_camara_cria` tinyint(1) DEFAULT NULL,
  `peligro_colmena` varchar(45) DEFAULT NULL,
  `idestado_revision` int(11) NOT NULL,
  `comportamiento` varchar(150) DEFAULT NULL,
  `idreina` int(11) NOT NULL,
  `falta_alza` tinyint(1) DEFAULT NULL,
  `existencia_reina` tinyint(1) DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  `idcolmena` int(11) NOT NULL,
  `idplanilla_revision` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_revision`),
  KEY `fk_planilla_revision_estado_revision1` (`idestado_revision`),
  KEY `fk_planilla_revision_reina1` (`idreina`),
  KEY `fk_planilla_revision_usuario1` (`idusuario`),
  KEY `fk_planilla_revision_colmena1` (`idcolmena`),
  CONSTRAINT `fk_planilla_revision_colmena1` FOREIGN KEY (`idcolmena`) REFERENCES `colmena` (`idcolmena`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_estado_revision1` FOREIGN KEY (`idestado_revision`) REFERENCES `estado_revision` (`idestado_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_reina1` FOREIGN KEY (`idreina`) REFERENCES `reina` (`idreina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision`
--

LOCK TABLES `planilla_revision` WRITE;
/*!40000 ALTER TABLE `planilla_revision` DISABLE KEYS */;
/*!40000 ALTER TABLE `planilla_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_seguimiento`
--

DROP TABLE IF EXISTS `planilla_seguimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_seguimiento` (
  `motivo_ubicacion` varchar(45) DEFAULT NULL,
  `idplanilla_seguimiento` int(11) NOT NULL AUTO_INCREMENT,
  `idapiario` int(11) NOT NULL,
  `idzona` int(11) NOT NULL,
  PRIMARY KEY (`idplanilla_seguimiento`),
  KEY `fk_planilla_seguimiento_apiario1` (`idapiario`),
  KEY `fk_planilla_seguimiento_zona1` (`idzona`),
  CONSTRAINT `fk_planilla_seguimiento_apiario1` FOREIGN KEY (`idapiario`) REFERENCES `apiario` (`idapiario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_seguimiento_zona1` FOREIGN KEY (`idzona`) REFERENCES `zona` (`idzona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_seguimiento`
--

LOCK TABLES `planilla_seguimiento` WRITE;
/*!40000 ALTER TABLE `planilla_seguimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `planilla_seguimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idtipo_producto` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `fk_producto_tipo_producto1` (`idtipo_producto`),
  CONSTRAINT `fk_producto_tipo_producto1` FOREIGN KEY (`idtipo_producto`) REFERENCES `tipo_producto` (`idtipo_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso_natural`
--

DROP TABLE IF EXISTS `recurso_natural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recurso_natural` (
  `idrecurso_natural` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idtipo_recurso_natural` int(11) NOT NULL,
  PRIMARY KEY (`idrecurso_natural`),
  KEY `fk_recurso_natural_tipo_recurso_natural` (`idtipo_recurso_natural`),
  CONSTRAINT `fk_recurso_natural_tipo_recurso_natural` FOREIGN KEY (`idtipo_recurso_natural`) REFERENCES `tipo_recurso_natural` (`idtipo_recurso_natural`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso_natural`
--

LOCK TABLES `recurso_natural` WRITE;
/*!40000 ALTER TABLE `recurso_natural` DISABLE KEYS */;
/*!40000 ALTER TABLE `recurso_natural` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reina`
--

DROP TABLE IF EXISTS `reina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reina` (
  `idreina` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idcolmena` int(11) NOT NULL,
  `genetica` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idreina`),
  KEY `fk_reina_colmena1` (`idcolmena`),
  CONSTRAINT `fk_reina_colmena1` FOREIGN KEY (`idcolmena`) REFERENCES `colmena` (`idcolmena`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reina`
--

LOCK TABLES `reina` WRITE;
/*!40000 ALTER TABLE `reina` DISABLE KEYS */;
/*!40000 ALTER TABLE `reina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_alimentacion`
--

DROP TABLE IF EXISTS `tipo_alimentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_alimentacion` (
  `idtipo_alimentacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_alimentacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_alimentacion`
--

LOCK TABLES `tipo_alimentacion` WRITE;
/*!40000 ALTER TABLE `tipo_alimentacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_alimentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_alza`
--

DROP TABLE IF EXISTS `tipo_alza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_alza` (
  `idtipo_alza` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_alza`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_alza`
--

LOCK TABLES `tipo_alza` WRITE;
/*!40000 ALTER TABLE `tipo_alza` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_alza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_enfermedad`
--

DROP TABLE IF EXISTS `tipo_enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_enfermedad` (
  `idtipo_enfermedad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_enfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_enfermedad`
--

LOCK TABLES `tipo_enfermedad` WRITE;
/*!40000 ALTER TABLE `tipo_enfermedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_enfermedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_envase`
--

DROP TABLE IF EXISTS `tipo_envase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_envase` (
  `idtipo_envase` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_envase`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_envase`
--

LOCK TABLES `tipo_envase` WRITE;
/*!40000 ALTER TABLE `tipo_envase` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_envase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_medicamento`
--

DROP TABLE IF EXISTS `tipo_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_medicamento` (
  `idtipo_medicamento` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_medicamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_medicamento`
--

LOCK TABLES `tipo_medicamento` WRITE;
/*!40000 ALTER TABLE `tipo_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_producto`
--

DROP TABLE IF EXISTS `tipo_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_producto` (
  `idtipo_producto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_producto`
--

LOCK TABLES `tipo_producto` WRITE;
/*!40000 ALTER TABLE `tipo_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_recurso_natural`
--

DROP TABLE IF EXISTS `tipo_recurso_natural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_recurso_natural` (
  `idtipo_recurso_natural` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_recurso_natural`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_recurso_natural`
--

LOCK TABLES `tipo_recurso_natural` WRITE;
/*!40000 ALTER TABLE `tipo_recurso_natural` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_recurso_natural` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `idtipo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamiento`
--

DROP TABLE IF EXISTS `tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamiento` (
  `idtratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`idtratamiento`),
  KEY `fk_tratamiento_usuario1` (`idusuario`),
  CONSTRAINT `fk_tratamiento_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamiento`
--

LOCK TABLES `tratamiento` WRITE;
/*!40000 ALTER TABLE `tratamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tratamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubigeo`
--

DROP TABLE IF EXISTS `ubigeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubigeo` (
  `idubigeo` varchar(6) NOT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `distrito` varchar(45) DEFAULT NULL,
  `pais_idpais` int(11) NOT NULL,
  PRIMARY KEY (`idubigeo`),
  KEY `fk_ubigeo_pais1` (`pais_idpais`),
  CONSTRAINT `fk_ubigeo_pais1` FOREIGN KEY (`pais_idpais`) REFERENCES `pais` (`idpais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubigeo`
--

LOCK TABLES `ubigeo` WRITE;
/*!40000 ALTER TABLE `ubigeo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ubigeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nom_usu` varchar(45) DEFAULT NULL,
  `ape_usu` varchar(45) DEFAULT NULL,
  `idtipo_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuario_tipo_usuario1` (`idtipo_usuario`),
  CONSTRAINT `fk_usuario_tipo_usuario1` FOREIGN KEY (`idtipo_usuario`) REFERENCES `tipo_usuario` (`idtipo_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zona` (
  `idzona` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idubigeo` varchar(6) NOT NULL,
  PRIMARY KEY (`idzona`),
  KEY `fk_zona_ubigeo1` (`idubigeo`),
  CONSTRAINT `fk_zona_ubigeo1` FOREIGN KEY (`idubigeo`) REFERENCES `ubigeo` (`idubigeo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_sistema_apiario'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-20 22:31:54
