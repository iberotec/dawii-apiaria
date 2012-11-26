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
  `id_alza` int(11) NOT NULL AUTO_INCREMENT,
  `id_piso` int(11) NOT NULL,
  `id_tipo_alza` int(11) NOT NULL,
  PRIMARY KEY (`id_alza`),
  KEY `fk_Alza_Piso1` (`id_piso`),
  KEY `fk_Alza_Tipo_alza1` (`id_tipo_alza`),
  CONSTRAINT `fk_Alza_Piso1` FOREIGN KEY (`id_piso`) REFERENCES `piso` (`id_piso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alza_Tipo_alza1` FOREIGN KEY (`id_tipo_alza`) REFERENCES `tipo_alza` (`id_tipo_alza`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `id_apiario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_apiario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apiario`
--

LOCK TABLES `apiario` WRITE;
/*!40000 ALTER TABLE `apiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `apiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colmena`
--

DROP TABLE IF EXISTS `colmena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colmena` (
  `id_colmena` int(11) NOT NULL AUTO_INCREMENT,
  `id_apiario` int(11) NOT NULL,
  PRIMARY KEY (`id_colmena`),
  KEY `fk_Colmena_Apiario1` (`id_apiario`),
  CONSTRAINT `fk_Colmena_Apiario1` FOREIGN KEY (`id_apiario`) REFERENCES `apiario` (`id_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `equipamiento_trabajo`
--

DROP TABLE IF EXISTS `equipamiento_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamiento_trabajo` (
  `id_equipamiento_trabajo` int(11) NOT NULL,
  `descripcion_equipo_trabajo` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id_equipamiento_trabajo`)
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
  `id_estado_revision` int(11) NOT NULL,
  `descripcion_estado_revision` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_estado_revision`)
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
-- Table structure for table `estado_revision_equipamiento_trabajo`
--

DROP TABLE IF EXISTS `estado_revision_equipamiento_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_revision_equipamiento_trabajo` (
  `id_estado_revision_equipamiento_trabajo` int(11) NOT NULL AUTO_INCREMENT,
  `id_equipamiento_trabajo` int(11) NOT NULL,
  `id_estado_revision` int(11) NOT NULL,
  `cantidad` double DEFAULT NULL,
  PRIMARY KEY (`id_estado_revision_equipamiento_trabajo`),
  KEY `fk_estado_revision_equipamiento_trabajo1` (`id_equipamiento_trabajo`),
  KEY `fk_estado_revision_estado_revision1` (`id_estado_revision`),
  CONSTRAINT `fk_estado_revision_equipamiento_trabajo1` FOREIGN KEY (`id_equipamiento_trabajo`) REFERENCES `equipamiento_trabajo` (`id_equipamiento_trabajo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_estado_revision_estado_revision1` FOREIGN KEY (`id_estado_revision`) REFERENCES `estado_revision` (`id_estado_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_revision_equipamiento_trabajo`
--

LOCK TABLES `estado_revision_equipamiento_trabajo` WRITE;
/*!40000 ALTER TABLE `estado_revision_equipamiento_trabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado_revision_equipamiento_trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumo` (
  `id_insumo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_insumo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_insumo`)
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
  `id_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_medicamento` varchar(145) DEFAULT NULL,
  `id_tipo_medicamento` int(11) NOT NULL,
  PRIMARY KEY (`id_medicamento`),
  KEY `fk_medicamento_tipo_medicamento2` (`id_tipo_medicamento`),
  CONSTRAINT `fk_medicamento_tipo_medicamento2` FOREIGN KEY (`id_tipo_medicamento`) REFERENCES `tipo_medicamento` (`id_tipo_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `id_norma_seguridad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_norma_seguridad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_norma_seguridad`)
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
-- Table structure for table `norma_seguridad_apiario`
--

DROP TABLE IF EXISTS `norma_seguridad_apiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `norma_seguridad_apiario` (
  `id_norma_seguridad_apiario` int(11) NOT NULL AUTO_INCREMENT,
  `id_norma_seguridad` int(11) NOT NULL,
  `id_apiario` int(11) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`id_norma_seguridad_apiario`),
  KEY `fk_norma_seguridad_apiario_norma_seguridad1` (`id_norma_seguridad`),
  KEY `fk_norma_seguridad_apiario_apiario1` (`id_apiario`),
  CONSTRAINT `fk_norma_seguridad_apiario_norma_seguridad1` FOREIGN KEY (`id_norma_seguridad`) REFERENCES `norma_seguridad` (`id_norma_seguridad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_norma_seguridad_apiario_apiario1` FOREIGN KEY (`id_apiario`) REFERENCES `apiario` (`id_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `norma_seguridad_apiario`
--

LOCK TABLES `norma_seguridad_apiario` WRITE;
/*!40000 ALTER TABLE `norma_seguridad_apiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `norma_seguridad_apiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL,
  `nombre_pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
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
  `id_piso` int(11) NOT NULL AUTO_INCREMENT,
  `id_colmena` int(11) NOT NULL,
  PRIMARY KEY (`id_piso`),
  KEY `fk_Piso_Colmena1` (`id_colmena`),
  CONSTRAINT `fk_Piso_Colmena1` FOREIGN KEY (`id_colmena`) REFERENCES `colmena` (`id_colmena`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `planilla_revision`
--

DROP TABLE IF EXISTS `planilla_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_revision` (
  `id_planilla_revision` int(11) NOT NULL AUTO_INCREMENT,
  `id_colmena` int(11) NOT NULL,
  `existencia_reina` tinyint(1) DEFAULT NULL,
  `id_reina` int(11) NOT NULL,
  `estado_cosecha` varchar(45) DEFAULT NULL,
  `necesidad_alimentacion` tinyint(1) DEFAULT NULL,
  `necesidad_curacion` tinyint(1) DEFAULT NULL,
  `id_estado_revision` int(11) NOT NULL,
  `falta_espacio_camara` tinyint(1) DEFAULT NULL,
  `falta_alza` tinyint(1) DEFAULT NULL,
  `comportamiento` varchar(100) DEFAULT NULL,
  `id_usuario_apiario` int(11) NOT NULL,
  PRIMARY KEY (`id_planilla_revision`),
  KEY `fk_Planilla_revision_Colmena1` (`id_colmena`),
  KEY `fk_planilla_revision_reina2` (`id_reina`),
  KEY `fk_planilla_revision_estado_revision2` (`id_estado_revision`),
  KEY `fk_planilla_revision_usuario_apiario1` (`id_usuario_apiario`),
  CONSTRAINT `fk_Planilla_revision_Colmena1` FOREIGN KEY (`id_colmena`) REFERENCES `colmena` (`id_colmena`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_reina2` FOREIGN KEY (`id_reina`) REFERENCES `reina` (`id_reina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_estado_revision2` FOREIGN KEY (`id_estado_revision`) REFERENCES `estado_revision` (`id_estado_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_usuario_apiario1` FOREIGN KEY (`id_usuario_apiario`) REFERENCES `usuario_apiario` (`id_usuario_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `planilla_revision_alza`
--

DROP TABLE IF EXISTS `planilla_revision_alza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_revision_alza` (
  `id_planilla_revision_alza` int(11) NOT NULL AUTO_INCREMENT,
  `id_planilla_revision` int(11) NOT NULL,
  `id_alza` int(11) NOT NULL,
  `estado_alza` varchar(45) DEFAULT NULL,
  `porcentaje_miel` double DEFAULT NULL,
  `estado_deterioro_alza` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_planilla_revision_alza`),
  KEY `fk_planilla_revision_alza_planilla_revision1` (`id_planilla_revision`),
  KEY `fk_planilla_revision_alza_alza1` (`id_alza`),
  CONSTRAINT `fk_planilla_revision_alza_planilla_revision1` FOREIGN KEY (`id_planilla_revision`) REFERENCES `planilla_revision` (`id_planilla_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_alza_alza1` FOREIGN KEY (`id_alza`) REFERENCES `alza` (`id_alza`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision_alza`
--

LOCK TABLES `planilla_revision_alza` WRITE;
/*!40000 ALTER TABLE `planilla_revision_alza` DISABLE KEYS */;
/*!40000 ALTER TABLE `planilla_revision_alza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_revision_tipo_alimentacion`
--

DROP TABLE IF EXISTS `planilla_revision_tipo_alimentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_revision_tipo_alimentacion` (
  `id_planilla_revision_tipo_alimentacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_planilla_revision` int(11) NOT NULL,
  `id_tipo_alimentacion` int(11) NOT NULL,
  PRIMARY KEY (`id_planilla_revision_tipo_alimentacion`),
  KEY `fk_planilla_revision_tipo_alimentacion_planilla_revision1` (`id_planilla_revision`),
  KEY `fk_planilla_revision_tipo_alimentacion_tipo_alimentacion1` (`id_tipo_alimentacion`),
  CONSTRAINT `fk_planilla_revision_tipo_alimentacion_planilla_revision1` FOREIGN KEY (`id_planilla_revision`) REFERENCES `planilla_revision` (`id_planilla_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_tipo_alimentacion_tipo_alimentacion1` FOREIGN KEY (`id_tipo_alimentacion`) REFERENCES `tipo_alimentacion` (`id_tipo_alimentacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision_tipo_alimentacion`
--

LOCK TABLES `planilla_revision_tipo_alimentacion` WRITE;
/*!40000 ALTER TABLE `planilla_revision_tipo_alimentacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `planilla_revision_tipo_alimentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_revision_tipo_enfermedad`
--

DROP TABLE IF EXISTS `planilla_revision_tipo_enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_revision_tipo_enfermedad` (
  `id_planilla_revision_tipo_enfermedad` int(11) NOT NULL AUTO_INCREMENT,
  `id_planilla_revision` int(11) NOT NULL,
  `id_tipo_enfermedad` int(11) NOT NULL,
  PRIMARY KEY (`id_planilla_revision_tipo_enfermedad`),
  KEY `fk_planilla_revision_tipo_enfermedad_planilla_revision1` (`id_planilla_revision`),
  KEY `fk_planilla_revision_tipo_enfermedad_tipo_enfermedad1` (`id_tipo_enfermedad`),
  CONSTRAINT `fk_planilla_revision_tipo_enfermedad_planilla_revision1` FOREIGN KEY (`id_planilla_revision`) REFERENCES `planilla_revision` (`id_planilla_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_tipo_enfermedad_tipo_enfermedad1` FOREIGN KEY (`id_tipo_enfermedad`) REFERENCES `tipo_enfermedad` (`id_tipo_enfermedad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision_tipo_enfermedad`
--

LOCK TABLES `planilla_revision_tipo_enfermedad` WRITE;
/*!40000 ALTER TABLE `planilla_revision_tipo_enfermedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `planilla_revision_tipo_enfermedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_seguimiento`
--

DROP TABLE IF EXISTS `planilla_seguimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_seguimiento` (
  `id_planilla_seguimiento` int(11) NOT NULL AUTO_INCREMENT,
  `id_apiario` int(11) NOT NULL,
  `id_zona` int(11) NOT NULL,
  `motivo_ubicacion` varchar(100) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`id_planilla_seguimiento`),
  KEY `fk_Planilla_seguimiento_Apiario1` (`id_apiario`),
  KEY `fk_Planilla_seguimiento_Zona1` (`id_zona`),
  CONSTRAINT `fk_Planilla_seguimiento_Apiario1` FOREIGN KEY (`id_apiario`) REFERENCES `apiario` (`id_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Planilla_seguimiento_Zona1` FOREIGN KEY (`id_zona`) REFERENCES `zona` (`id_zona`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `recurso_natural`
--

DROP TABLE IF EXISTS `recurso_natural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recurso_natural` (
  `id_recurso_natural` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_recurso_natural` varchar(100) DEFAULT NULL,
  `id_tipo_recurso` int(11) NOT NULL,
  PRIMARY KEY (`id_recurso_natural`),
  KEY `fk_recurso_natural_tipo_recurso1` (`id_tipo_recurso`),
  CONSTRAINT `fk_recurso_natural_tipo_recurso1` FOREIGN KEY (`id_tipo_recurso`) REFERENCES `tipo_recurso` (`id_tipo_recurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `id_reina` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_reina` varchar(45) DEFAULT NULL,
  `caracteristica_reina` varchar(45) DEFAULT NULL,
  `id_colmena` int(11) NOT NULL,
  PRIMARY KEY (`id_reina`),
  KEY `fk_Reina_Colmena1` (`id_colmena`),
  CONSTRAINT `fk_Reina_Colmena1` FOREIGN KEY (`id_colmena`) REFERENCES `colmena` (`id_colmena`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `temporada`
--

DROP TABLE IF EXISTS `temporada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temporada` (
  `id_temporada` int(11) NOT NULL AUTO_INCREMENT,
  `periodo_inicial` date DEFAULT NULL,
  `periodo_final` date DEFAULT NULL,
  `estado_etapa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_temporada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporada`
--

LOCK TABLES `temporada` WRITE;
/*!40000 ALTER TABLE `temporada` DISABLE KEYS */;
/*!40000 ALTER TABLE `temporada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_alimentacion`
--

DROP TABLE IF EXISTS `tipo_alimentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_alimentacion` (
  `id_tipo_alimentacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_tipo_alimentacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_alimentacion`)
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
-- Table structure for table `tipo_alimentacion_insumo`
--

DROP TABLE IF EXISTS `tipo_alimentacion_insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_alimentacion_insumo` (
  `id_tipo_alimentacion_insumo` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_alimentacion` int(11) NOT NULL,
  `id_insumo` int(11) NOT NULL,
  PRIMARY KEY (`id_tipo_alimentacion_insumo`),
  KEY `fk_tipo_alimentacion_insumo_tipo_alimentacion1` (`id_tipo_alimentacion`),
  KEY `fk_tipo_alimentacion_insumo_Insumo1` (`id_insumo`),
  CONSTRAINT `fk_tipo_alimentacion_insumo_tipo_alimentacion1` FOREIGN KEY (`id_tipo_alimentacion`) REFERENCES `tipo_alimentacion` (`id_tipo_alimentacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_alimentacion_insumo_Insumo1` FOREIGN KEY (`id_insumo`) REFERENCES `insumo` (`id_insumo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_alimentacion_insumo`
--

LOCK TABLES `tipo_alimentacion_insumo` WRITE;
/*!40000 ALTER TABLE `tipo_alimentacion_insumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_alimentacion_insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_alza`
--

DROP TABLE IF EXISTS `tipo_alza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_alza` (
  `id_tipo_alza` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_tipo_alza` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_alza`)
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
  `id_tipo_enfermedad` int(11) NOT NULL,
  `descripcion_tipo_enfermedad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_enfermedad`)
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
-- Table structure for table `tipo_enfermedad_tratamiento`
--

DROP TABLE IF EXISTS `tipo_enfermedad_tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_enfermedad_tratamiento` (
  `id_tipo_enfermedad_tratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_enfermedad` int(11) NOT NULL,
  `id_tratamiento` int(11) NOT NULL,
  PRIMARY KEY (`id_tipo_enfermedad_tratamiento`),
  KEY `fk_tipo_enfermedad_tratamiento_tipo_enfermedad1` (`id_tipo_enfermedad`),
  KEY `fk_tipo_enfermedad_tratamiento_tratamiento1` (`id_tratamiento`),
  CONSTRAINT `fk_tipo_enfermedad_tratamiento_tipo_enfermedad1` FOREIGN KEY (`id_tipo_enfermedad`) REFERENCES `tipo_enfermedad` (`id_tipo_enfermedad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_enfermedad_tratamiento_tratamiento1` FOREIGN KEY (`id_tratamiento`) REFERENCES `tratamiento` (`id_tratamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_enfermedad_tratamiento`
--

LOCK TABLES `tipo_enfermedad_tratamiento` WRITE;
/*!40000 ALTER TABLE `tipo_enfermedad_tratamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_enfermedad_tratamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_medicamento`
--

DROP TABLE IF EXISTS `tipo_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_medicamento` (
  `id_tipo_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_tipo_medicamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_medicamento`)
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
-- Table structure for table `tipo_recurso`
--

DROP TABLE IF EXISTS `tipo_recurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_recurso` (
  `id_tipo_recurso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_tipo_recurso` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_recurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_recurso`
--

LOCK TABLES `tipo_recurso` WRITE;
/*!40000 ALTER TABLE `tipo_recurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_recurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usario`
--

DROP TABLE IF EXISTS `tipo_usario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usario` (
  `id_tipo_usario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_usario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usario`
--

LOCK TABLES `tipo_usario` WRITE;
/*!40000 ALTER TABLE `tipo_usario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_usario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamiento`
--

DROP TABLE IF EXISTS `tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamiento` (
  `id_tratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_tratamiento` varchar(145) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_tratamiento`),
  KEY `fk_tratamiento_usuario2` (`id_usuario`),
  CONSTRAINT `fk_tratamiento_usuario2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `tratamiento_medicamento`
--

DROP TABLE IF EXISTS `tratamiento_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamiento_medicamento` (
  `id_tratamiento_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `id_medicamento` int(11) NOT NULL,
  `id_tratamiento` int(11) NOT NULL,
  PRIMARY KEY (`id_tratamiento_medicamento`),
  KEY `fk_tratamiento_medicamento_medicamento1` (`id_medicamento`),
  KEY `fk_tratamiento_medicamento_tratamiento1` (`id_tratamiento`),
  CONSTRAINT `fk_tratamiento_medicamento_medicamento1` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tratamiento_medicamento_tratamiento1` FOREIGN KEY (`id_tratamiento`) REFERENCES `tratamiento` (`id_tratamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamiento_medicamento`
--

LOCK TABLES `tratamiento_medicamento` WRITE;
/*!40000 ALTER TABLE `tratamiento_medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tratamiento_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubigeo`
--

DROP TABLE IF EXISTS `ubigeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubigeo` (
  `id_ubigeo` int(11) NOT NULL AUTO_INCREMENT,
  `departamento` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `distrito` varchar(45) DEFAULT NULL,
  `id_pais` int(11) NOT NULL,
  PRIMARY KEY (`id_ubigeo`),
  KEY `fk_ubigeo_pais2` (`id_pais`),
  CONSTRAINT `fk_ubigeo_pais2` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(45) DEFAULT NULL,
  `ape_pater_usuario` varchar(45) DEFAULT NULL,
  `ape_mater_usuario` varchar(45) DEFAULT NULL,
  `id_tipo_usario` int(11) NOT NULL,
  `contrasenia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuario_tipo_usario1` (`id_tipo_usario`),
  CONSTRAINT `fk_usuario_tipo_usario1` FOREIGN KEY (`id_tipo_usario`) REFERENCES `tipo_usario` (`id_tipo_usario`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `usuario_apiario`
--

DROP TABLE IF EXISTS `usuario_apiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_apiario` (
  `id_usuario_apiario` int(11) NOT NULL AUTO_INCREMENT,
  `id_apiario` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_temporada` int(11) NOT NULL,
  `estado_asignacion` varchar(45) DEFAULT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  `fecha_revision` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario_apiario`),
  KEY `fk_usuario_apiario_apiario1` (`id_apiario`),
  KEY `fk_usuario_apiario_usuario1` (`id_usuario`),
  KEY `fk_usuario_apiario_temporada1` (`id_temporada`),
  CONSTRAINT `fk_usuario_apiario_apiario1` FOREIGN KEY (`id_apiario`) REFERENCES `apiario` (`id_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_apiario_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_apiario_temporada1` FOREIGN KEY (`id_temporada`) REFERENCES `temporada` (`id_temporada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_apiario`
--

LOCK TABLES `usuario_apiario` WRITE;
/*!40000 ALTER TABLE `usuario_apiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_apiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zona` (
  `id_zona` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_zona` varchar(100) DEFAULT NULL,
  `id_ubigeo` int(11) NOT NULL,
  PRIMARY KEY (`id_zona`),
  KEY `fk_zona_ubigeo2` (`id_ubigeo`),
  CONSTRAINT `fk_zona_ubigeo2` FOREIGN KEY (`id_ubigeo`) REFERENCES `ubigeo` (`id_ubigeo`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `zona_recuso_natural`
--

DROP TABLE IF EXISTS `zona_recuso_natural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zona_recuso_natural` (
  `id_zona_recurso_natural` int(11) NOT NULL AUTO_INCREMENT,
  `zona_id_zona` int(11) NOT NULL,
  `id_recurso_natural` int(11) NOT NULL,
  PRIMARY KEY (`id_zona_recurso_natural`),
  KEY `fk_zona_Recuso_Natural_zona1` (`zona_id_zona`),
  KEY `fk_zona_Recuso_Natural_recurso_natural1` (`id_recurso_natural`),
  CONSTRAINT `fk_zona_Recuso_Natural_zona1` FOREIGN KEY (`zona_id_zona`) REFERENCES `zona` (`id_zona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_zona_Recuso_Natural_recurso_natural1` FOREIGN KEY (`id_recurso_natural`) REFERENCES `recurso_natural` (`id_recurso_natural`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona_recuso_natural`
--

LOCK TABLES `zona_recuso_natural` WRITE;
/*!40000 ALTER TABLE `zona_recuso_natural` DISABLE KEYS */;
/*!40000 ALTER TABLE `zona_recuso_natural` ENABLE KEYS */;
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

-- Dump completed on 2012-11-26  0:41:37
