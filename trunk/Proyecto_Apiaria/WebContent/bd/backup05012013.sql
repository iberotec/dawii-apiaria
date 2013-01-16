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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alza`
--

LOCK TABLES `alza` WRITE;
/*!40000 ALTER TABLE `alza` DISABLE KEYS */;
INSERT INTO `alza` VALUES (1,1,1),(2,1,1),(3,1,1),(4,1,1),(5,2,1),(6,2,1),(7,2,1),(8,3,1),(9,3,1),(10,3,1),(11,3,1),(12,4,1),(13,4,1),(14,4,1),(15,4,1),(16,5,1),(17,5,1),(18,5,1),(19,5,1),(20,6,1),(21,6,1),(22,6,1),(23,6,1),(24,7,1),(25,7,1),(26,7,1),(27,7,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apiario`
--

LOCK TABLES `apiario` WRITE;
/*!40000 ALTER TABLE `apiario` DISABLE KEYS */;
INSERT INTO `apiario` VALUES (1),(2),(3),(4),(5);
/*!40000 ALTER TABLE `apiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centrifugadora`
--

DROP TABLE IF EXISTS `centrifugadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centrifugadora` (
  `id_centrifugadora` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_centrifugadora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_centrifugadora`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centrifugadora`
--

LOCK TABLES `centrifugadora` WRITE;
/*!40000 ALTER TABLE `centrifugadora` DISABLE KEYS */;
INSERT INTO `centrifugadora` VALUES (1,'Centrifugadora 1');
/*!40000 ALTER TABLE `centrifugadora` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colmena`
--

LOCK TABLES `colmena` WRITE;
/*!40000 ALTER TABLE `colmena` DISABLE KEYS */;
INSERT INTO `colmena` VALUES (1,1),(2,1),(3,1),(4,1),(5,3),(6,3),(7,3);
/*!40000 ALTER TABLE `colmena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decantadora`
--

DROP TABLE IF EXISTS `decantadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `decantadora` (
  `id_decantadora` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_decantadora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_decantadora`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decantadora`
--

LOCK TABLES `decantadora` WRITE;
/*!40000 ALTER TABLE `decantadora` DISABLE KEYS */;
INSERT INTO `decantadora` VALUES (1,'Decantadora 1');
/*!40000 ALTER TABLE `decantadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_centrifugadora_planilla_cosecha`
--

DROP TABLE IF EXISTS `detalle_centrifugadora_planilla_cosecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_centrifugadora_planilla_cosecha` (
  `id_detalle_centrifugadora_planilla_cosecha` int(11) NOT NULL AUTO_INCREMENT,
  `id_planilla_cosecha` int(11) NOT NULL,
  `id_centrifugadora` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_centrifugadora_planilla_cosecha`),
  KEY `fk_detalle_centrifugadora_planilla_cosecha` (`id_centrifugadora`),
  KEY `fk_detalle_centrifugadora_planilla_cosecha_planilla_cosecha` (`id_planilla_cosecha`),
  CONSTRAINT `fk_detalle_centrifugadora_planilla_cosecha_planilla_cosecha` FOREIGN KEY (`id_planilla_cosecha`) REFERENCES `planilla_cosecha` (`id_planilla_cosecha`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_centrifugadora_planilla_cosecha` FOREIGN KEY (`id_centrifugadora`) REFERENCES `centrifugadora` (`id_centrifugadora`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `detalle_decantadora_planilla_cosecha`
--

DROP TABLE IF EXISTS `detalle_decantadora_planilla_cosecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_decantadora_planilla_cosecha` (
  `id_detalle_decantadora_planilla_cosecha` int(11) NOT NULL AUTO_INCREMENT,
  `id_planilla_cosecha` int(11) NOT NULL,
  `id_decantadora` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_decantadora_planilla_cosecha`),
  KEY `fk_detalle_decantadora_planilla_cosecha_planilla_cosecha` (`id_planilla_cosecha`),
  KEY `fk_detalle_decantadora_planilla_cosecha_decantadora` (`id_decantadora`),
  CONSTRAINT `fk_detalle_decantadora_planilla_cosecha_planilla_cosecha` FOREIGN KEY (`id_planilla_cosecha`) REFERENCES `planilla_cosecha` (`id_planilla_cosecha`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_decantadora_planilla_cosecha_decantadora` FOREIGN KEY (`id_decantadora`) REFERENCES `decantadora` (`id_decantadora`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_decantadora_planilla_cosecha`
--

LOCK TABLES `detalle_decantadora_planilla_cosecha` WRITE;
/*!40000 ALTER TABLE `detalle_decantadora_planilla_cosecha` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_decantadora_planilla_cosecha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipamiento_trabajo`
--

DROP TABLE IF EXISTS `equipamiento_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamiento_trabajo` (
  `id_equipamiento_trabajo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_equipo_trabajo` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id_equipamiento_trabajo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipamiento_trabajo`
--

LOCK TABLES `equipamiento_trabajo` WRITE;
/*!40000 ALTER TABLE `equipamiento_trabajo` DISABLE KEYS */;
INSERT INTO `equipamiento_trabajo` VALUES (1,'guantes'),(2,'botas'),(3,'Mallas'),(4,'ropa anti abejas'),(5,'humeador');
/*!40000 ALTER TABLE `equipamiento_trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_revision`
--

DROP TABLE IF EXISTS `estado_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_revision` (
  `id_estado_revision` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_estado_revision` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_estado_revision`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_revision`
--

LOCK TABLES `estado_revision` WRITE;
/*!40000 ALTER TABLE `estado_revision` DISABLE KEYS */;
INSERT INTO `estado_revision` VALUES (1,'Peligro'),(2,'Normal');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_revision_equipamiento_trabajo`
--

LOCK TABLES `estado_revision_equipamiento_trabajo` WRITE;
/*!40000 ALTER TABLE `estado_revision_equipamiento_trabajo` DISABLE KEYS */;
INSERT INTO `estado_revision_equipamiento_trabajo` VALUES (2,5,1,10),(3,1,2,2),(4,2,2,2),(5,3,1,1),(6,4,2,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `norma_seguridad`
--

LOCK TABLES `norma_seguridad` WRITE;
/*!40000 ALTER TABLE `norma_seguridad` DISABLE KEYS */;
INSERT INTO `norma_seguridad` VALUES (1,'Distancia entre Apiarios(2 a 3 km)'),(2,'Flora melifera adecuada'),(3,'Fuente natural de agua o bebederos adecuados'),(4,'Aguas contaminadas o residuales a 2km de distancia'),(5,'Zona apropiada(no humedas, no calurosas)'),(6,'Distancia entre vias publicas(200m)'),(7,'Posicionamiento adecuado de piqueras');
/*!40000 ALTER TABLE `norma_seguridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `norma_seguridad_usuario_apiario`
--

DROP TABLE IF EXISTS `norma_seguridad_usuario_apiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `norma_seguridad_usuario_apiario` (
  `id_norma_seguridad_usuario_apiario` int(11) NOT NULL AUTO_INCREMENT,
  `id_norma_seguridad` int(11) NOT NULL,
  `id_usuario_apiario` int(11) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`id_norma_seguridad_usuario_apiario`),
  KEY `fk_norma_seguridad_usuario_apiario_norma_seguridad1` (`id_norma_seguridad`),
  KEY `fk_norma_seguridad_usuario_apiario_usuario_apiario1` (`id_usuario_apiario`),
  CONSTRAINT `fk_norma_seguridad_usuario_apiario_norma_seguridad1` FOREIGN KEY (`id_norma_seguridad`) REFERENCES `norma_seguridad` (`id_norma_seguridad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_norma_seguridad_usuario_apiario_usuario_apiario1` FOREIGN KEY (`id_usuario_apiario`) REFERENCES `usuario_apiario` (`id_usuario_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `norma_seguridad_usuario_apiario`
--

LOCK TABLES `norma_seguridad_usuario_apiario` WRITE;
/*!40000 ALTER TABLE `norma_seguridad_usuario_apiario` DISABLE KEYS */;
INSERT INTO `norma_seguridad_usuario_apiario` VALUES (10,1,1,NULL,NULL),(11,2,1,NULL,NULL);
/*!40000 ALTER TABLE `norma_seguridad_usuario_apiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Peru');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piso`
--

LOCK TABLES `piso` WRITE;
/*!40000 ALTER TABLE `piso` DISABLE KEYS */;
INSERT INTO `piso` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7);
/*!40000 ALTER TABLE `piso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planilla_cosecha`
--

DROP TABLE IF EXISTS `planilla_cosecha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planilla_cosecha` (
  `id_planilla_cosecha` int(11) NOT NULL AUTO_INCREMENT,
  `id_colmena` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha_cosecha` date DEFAULT NULL,
  `kilos` double DEFAULT NULL,
  PRIMARY KEY (`id_planilla_cosecha`),
  KEY `fk_planilla_cosecha_colmena` (`id_colmena`),
  KEY `fk_planilla_cosecha_usuario` (`id_usuario`),
  CONSTRAINT `fk_planilla_cosecha_colmena` FOREIGN KEY (`id_colmena`) REFERENCES `colmena` (`id_colmena`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_cosecha_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  CONSTRAINT `fk_planilla_revision_estado_revision2` FOREIGN KEY (`id_estado_revision`) REFERENCES `estado_revision` (`id_estado_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_reina2` FOREIGN KEY (`id_reina`) REFERENCES `reina` (`id_reina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_usuario_apiario1` FOREIGN KEY (`id_usuario_apiario`) REFERENCES `usuario_apiario` (`id_usuario_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision`
--

LOCK TABLES `planilla_revision` WRITE;
/*!40000 ALTER TABLE `planilla_revision` DISABLE KEYS */;
INSERT INTO `planilla_revision` VALUES (2,2,1,2,'cosechable',1,1,1,1,1,'normal',2),(19,1,1,1,'cosechable',0,0,1,0,0,'agresivo',1),(23,3,1,3,'cosechable',1,1,2,0,0,'normal',1),(24,2,1,2,'no cosechable',0,0,1,0,0,'agresivo',1),(28,4,1,4,'cosechable',0,0,1,0,0,'peligroso',1),(39,5,1,5,'no cosechable',0,0,2,0,0,'normalazo',21),(45,6,1,6,'cosechable',0,0,2,0,0,'normalazo',21);
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
  CONSTRAINT `fk_planilla_revision_alza_alza1` FOREIGN KEY (`id_alza`) REFERENCES `alza` (`id_alza`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planilla_revision_alza_planilla_revision1` FOREIGN KEY (`id_planilla_revision`) REFERENCES `planilla_revision` (`id_planilla_revision`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision_alza`
--

LOCK TABLES `planilla_revision_alza` WRITE;
/*!40000 ALTER TABLE `planilla_revision_alza` DISABLE KEYS */;
INSERT INTO `planilla_revision_alza` VALUES (10,19,1,'en colmena',54,0),(11,19,2,'en colmena',43,1),(12,19,3,'en colmena',43,1),(13,19,4,'en colmena',44,1),(14,23,8,'en colmena',33,0),(15,24,5,'en colmena',43,0),(16,23,9,'en colmena',45,0),(18,39,16,'en colmena',65,0),(19,39,17,'en colmena',44,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision_tipo_alimentacion`
--

LOCK TABLES `planilla_revision_tipo_alimentacion` WRITE;
/*!40000 ALTER TABLE `planilla_revision_tipo_alimentacion` DISABLE KEYS */;
INSERT INTO `planilla_revision_tipo_alimentacion` VALUES (2,23,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_revision_tipo_enfermedad`
--

LOCK TABLES `planilla_revision_tipo_enfermedad` WRITE;
/*!40000 ALTER TABLE `planilla_revision_tipo_enfermedad` DISABLE KEYS */;
INSERT INTO `planilla_revision_tipo_enfermedad` VALUES (2,23,2);
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
  `estado` int(1) DEFAULT NULL,
  PRIMARY KEY (`id_planilla_seguimiento`),
  KEY `fk_Planilla_seguimiento_Apiario1` (`id_apiario`),
  KEY `fk_Planilla_seguimiento_Zona1` (`id_zona`),
  CONSTRAINT `fk_Planilla_seguimiento_Apiario1` FOREIGN KEY (`id_apiario`) REFERENCES `apiario` (`id_apiario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Planilla_seguimiento_Zona1` FOREIGN KEY (`id_zona`) REFERENCES `zona` (`id_zona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planilla_seguimiento`
--

LOCK TABLES `planilla_seguimiento` WRITE;
/*!40000 ALTER TABLE `planilla_seguimiento` DISABLE KEYS */;
INSERT INTO `planilla_seguimiento` VALUES (1,1,1,'por ser un apiario pequeÃ±o','2012-12-01',0),(2,1,2,'el apiario crecio','2012-12-15',1),(3,2,3,'apiario pequeÃ±o','2012-12-30',1),(4,3,4,'apiario pequeÃ±o','2012-12-31',1),(5,4,5,'apiario pequeÃ±o','2012-12-31',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reina`
--

LOCK TABLES `reina` WRITE;
/*!40000 ALTER TABLE `reina` DISABLE KEYS */;
INSERT INTO `reina` VALUES (1,'Maya','crias de produccion rapida',1),(2,'Africana','crias que recorren rango alto',2),(3,'Peruana','crias mieleras',3),(4,'Boliviana','crias de polen',4),(5,'Rasta','crias one love',5),(6,'Punk','crias RHCPP',6);
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
  `etapa_temporada` varchar(45) DEFAULT NULL,
  `estado_temporada` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_temporada`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporada`
--

LOCK TABLES `temporada` WRITE;
/*!40000 ALTER TABLE `temporada` DISABLE KEYS */;
INSERT INTO `temporada` VALUES (1,'2012-11-12','2013-01-31','seleccion',1),(2,'2012-09-16','2012-11-12','seleccion',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_alimentacion`
--

LOCK TABLES `tipo_alimentacion` WRITE;
/*!40000 ALTER TABLE `tipo_alimentacion` DISABLE KEYS */;
INSERT INTO `tipo_alimentacion` VALUES (1,'A'),(2,'B'),(3,'C');
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
  CONSTRAINT `fk_tipo_alimentacion_insumo_Insumo1` FOREIGN KEY (`id_insumo`) REFERENCES `insumo` (`id_insumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tipo_alimentacion_insumo_tipo_alimentacion1` FOREIGN KEY (`id_tipo_alimentacion`) REFERENCES `tipo_alimentacion` (`id_tipo_alimentacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_alza`
--

LOCK TABLES `tipo_alza` WRITE;
/*!40000 ALTER TABLE `tipo_alza` DISABLE KEYS */;
INSERT INTO `tipo_alza` VALUES (1,'Melaria');
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
INSERT INTO `tipo_enfermedad` VALUES (1,'A'),(2,'B'),(3,'C');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usario`
--

LOCK TABLES `tipo_usario` WRITE;
/*!40000 ALTER TABLE `tipo_usario` DISABLE KEYS */;
INSERT INTO `tipo_usario` VALUES (1,'operario seleccion');
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
) ENGINE=InnoDB AUTO_INCREMENT=179022214 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubigeo`
--

LOCK TABLES `ubigeo` WRITE;
/*!40000 ALTER TABLE `ubigeo` DISABLE KEYS */;
INSERT INTO `ubigeo` VALUES (1111,'AMAZONAS','CHACHAPOYAS','CHACHAPOYAS',1),(2112,'AMAZONAS','CHACHAPOYAS','ASUNCION',1),(3113,'AMAZONAS','CHACHAPOYAS','BALSAS',1),(4114,'AMAZONAS','CHACHAPOYAS','CHETO',1),(5115,'AMAZONAS','CHACHAPOYAS','CHILIQUIN',1),(6116,'AMAZONAS','CHACHAPOYAS','CHUQUIBAMBA',1),(7117,'AMAZONAS','CHACHAPOYAS','GRANADA',1),(8118,'AMAZONAS','CHACHAPOYAS','HUANCAS',1),(9119,'AMAZONAS','CHACHAPOYAS','LA JALCA',1),(22121,'AMAZONAS','BAGUA','LA PECA',1),(23122,'AMAZONAS','BAGUA','ARAMANGO',1),(24123,'AMAZONAS','BAGUA','COPALLIN',1),(25124,'AMAZONAS','BAGUA','EL PARCO',1),(26126,'AMAZONAS','BAGUA','IMAZA',1),(27131,'AMAZONAS','BONGARA','JUMBILLA',1),(28132,'AMAZONAS','BONGARA','COROSHA',1),(29133,'AMAZONAS','BONGARA','CUISPES',1),(30134,'AMAZONAS','BONGARA','CHISQUILLA',1),(31135,'AMAZONAS','BONGARA','CHURUJA',1),(32136,'AMAZONAS','BONGARA','FLORIDA',1),(33137,'AMAZONAS','BONGARA','RECTA',1),(34138,'AMAZONAS','BONGARA','SAN CARLOS',1),(35139,'AMAZONAS','BONGARA','SHIPASBAMBA',1),(39141,'AMAZONAS','LUYA','LAMUD',1),(40142,'AMAZONAS','LUYA','CAMPORREDONDO',1),(41143,'AMAZONAS','LUYA','COCABAMBA',1),(42144,'AMAZONAS','LUYA','COLCAMAR',1),(43145,'AMAZONAS','LUYA','CONILA',1),(44146,'AMAZONAS','LUYA','INGUILPATA',1),(45147,'AMAZONAS','LUYA','LONGUITA',1),(46148,'AMAZONAS','LUYA','LONYA CHICO',1),(47149,'AMAZONAS','LUYA','LUYA',1),(62151,'AMAZONAS','RODRIGUEZ DE MENDOZA','SAN NICOLAS',1),(63152,'AMAZONAS','RODRIGUEZ DE MENDOZA','COCHAMAL',1),(64153,'AMAZONAS','RODRIGUEZ DE MENDOZA','CHIRIMOTO',1),(65154,'AMAZONAS','RODRIGUEZ DE MENDOZA','HUAMBO',1),(66155,'AMAZONAS','RODRIGUEZ DE MENDOZA','LIMABAMBA',1),(67156,'AMAZONAS','RODRIGUEZ DE MENDOZA','LONGAR',1),(68157,'AMAZONAS','RODRIGUEZ DE MENDOZA','MILPUC',1),(69158,'AMAZONAS','RODRIGUEZ DE MENDOZA','MCAL BENAVIDES',1),(70159,'AMAZONAS','RODRIGUEZ DE MENDOZA','OMIA',1),(74161,'AMAZONAS','CONDORCANQUI','NIEVA',1),(75162,'AMAZONAS','CONDORCANQUI','RIO SANTIAGO',1),(76163,'AMAZONAS','CONDORCANQUI','EL CENEPA',1),(77171,'AMAZONAS','UTCUBAMBA','BAGUA GRANDE',1),(78172,'AMAZONAS','UTCUBAMBA','CAJARURO',1),(79173,'AMAZONAS','UTCUBAMBA','CUMBA',1),(80174,'AMAZONAS','UTCUBAMBA','EL MILAGRO',1),(81175,'AMAZONAS','UTCUBAMBA','JAMALCA',1),(82176,'AMAZONAS','UTCUBAMBA','LONYA GRANDE',1),(83177,'AMAZONAS','UTCUBAMBA','YAMON',1),(84211,'ANCASH','HUARAZ','HUARAZ',1),(85212,'ANCASH','HUARAZ','INDEPENDENCIA',1),(86213,'ANCASH','HUARAZ','COCHABAMBA',1),(87214,'ANCASH','HUARAZ','COLCABAMBA',1),(88215,'ANCASH','HUARAZ','HUANCHAY',1),(89216,'ANCASH','HUARAZ','JANGAS',1),(90217,'ANCASH','HUARAZ','LA LIBERTAD',1),(91218,'ANCASH','HUARAZ','OLLEROS',1),(92219,'ANCASH','HUARAZ','PAMPAS',1),(96221,'ANCASH','AIJA','AIJA',1),(97223,'ANCASH','AIJA','CORIS',1),(98225,'ANCASH','AIJA','HUACLLAN',1),(99226,'ANCASH','AIJA','LA MERCED',1),(100228,'ANCASH','AIJA','SUCCHA',1),(101110,'AMAZONAS','CHACHAPOYAS','LEIMEBAMBA',1),(101231,'ANCASH','BOLOGNESI','CHIQUIAN',1),(102232,'ANCASH','BOLOGNESI','A PARDO LEZAMETA',1),(103234,'ANCASH','BOLOGNESI','AQUIA',1),(104235,'ANCASH','BOLOGNESI','CAJACAY',1),(111111,'AMAZONAS','CHACHAPOYAS','LEVANTO',1),(116241,'ANCASH','CARHUAZ','CARHUAZ',1),(117242,'ANCASH','CARHUAZ','ACOPAMPA',1),(118243,'ANCASH','CARHUAZ','AMASHCA',1),(119244,'ANCASH','CARHUAZ','ANTA',1),(120245,'ANCASH','CARHUAZ','ATAQUERO',1),(121112,'AMAZONAS','CHACHAPOYAS','MAGDALENA',1),(121246,'ANCASH','CARHUAZ','MARCARA',1),(122247,'ANCASH','CARHUAZ','PARIAHUANCA',1),(123248,'ANCASH','CARHUAZ','SAN MIGUEL DE ACO',1),(124249,'ANCASH','CARHUAZ','SHILLA',1),(127251,'ANCASH','CASMA','CASMA',1),(128252,'ANCASH','CASMA','BUENA VISTA ALTA',1),(129253,'ANCASH','CASMA','COMANDANTE NOEL',1),(130255,'ANCASH','CASMA','YAUTAN',1),(131113,'AMAZONAS','CHACHAPOYAS','MARISCAL CASTILLA',1),(131261,'ANCASH','CORONGO','CORONGO',1),(132262,'ANCASH','CORONGO','ACO',1),(133263,'ANCASH','CORONGO','BAMBAS',1),(134264,'ANCASH','CORONGO','CUSCA',1),(135265,'ANCASH','CORONGO','LA PAMPA',1),(136266,'ANCASH','CORONGO','YANAC',1),(137267,'ANCASH','CORONGO','YUPAN',1),(138271,'ANCASH','HUAYLAS','CARAZ',1),(139272,'ANCASH','HUAYLAS','HUALLANCA',1),(140273,'ANCASH','HUAYLAS','HUATA',1),(141114,'AMAZONAS','CHACHAPOYAS','MOLINOPAMPA',1),(141274,'ANCASH','HUAYLAS','HUAYLAS',1),(142275,'ANCASH','HUAYLAS','MATO',1),(143276,'ANCASH','HUAYLAS','PAMPAROMAS',1),(144277,'ANCASH','HUAYLAS','PUEBLO LIBRE',1),(145278,'ANCASH','HUAYLAS','SANTA CRUZ',1),(146279,'ANCASH','HUAYLAS','YURACMARCA',1),(148281,'ANCASH','HUARI','HUARI',1),(149282,'ANCASH','HUARI','CAJAY',1),(150283,'ANCASH','HUARI','CHAVIN DE HUANTAR',1),(151115,'AMAZONAS','CHACHAPOYAS','MONTEVIDEO',1),(151284,'ANCASH','HUARI','HUACACHI',1),(152285,'ANCASH','HUARI','HUACHIS',1),(153286,'ANCASH','HUARI','HUACCHIS',1),(154287,'ANCASH','HUARI','HUANTAR',1),(155288,'ANCASH','HUARI','MASIN',1),(156289,'ANCASH','HUARI','PAUCAS',1),(161116,'AMAZONAS','CHACHAPOYAS','OLLEROS',1),(164291,'ANCASH','MARISCAL LUZURIAGA','PISCOBAMBA',1),(165292,'ANCASH','MARISCAL LUZURIAGA','CASCA',1),(166293,'ANCASH','MARISCAL LUZURIAGA','LUCMA',1),(167294,'ANCASH','MARISCAL LUZURIAGA','FIDEL OLIVAS ESCUDERO',1),(168295,'ANCASH','MARISCAL LUZURIAGA','LLAMA',1),(169296,'ANCASH','MARISCAL LUZURIAGA','LLUMPA',1),(170297,'ANCASH','MARISCAL LUZURIAGA','MUSGA',1),(171117,'AMAZONAS','CHACHAPOYAS','QUINJALCA',1),(171298,'ANCASH','MARISCAL LUZURIAGA','ELEAZAR GUZMAN BARRON',1),(181118,'AMAZONAS','CHACHAPOYAS','SAN FCO DE DAGUAS',1),(191119,'AMAZONAS','CHACHAPOYAS','SAN ISIDRO DE MAINO',1),(201120,'AMAZONAS','CHACHAPOYAS','SOLOCO',1),(211121,'AMAZONAS','CHACHAPOYAS','SONCHE',1),(250311,'APURIMAC','ABANCAY','ABANCAY',1),(251312,'APURIMAC','ABANCAY','CIRCA',1),(252313,'APURIMAC','ABANCAY','CURAHUASI',1),(253314,'APURIMAC','ABANCAY','CHACOCHE',1),(254315,'APURIMAC','ABANCAY','HUANIPACA',1),(255316,'APURIMAC','ABANCAY','LAMBRAMA',1),(256317,'APURIMAC','ABANCAY','PICHIRHUA',1),(257318,'APURIMAC','ABANCAY','SAN PEDRO DE CACHORA',1),(258319,'APURIMAC','ABANCAY','TAMBURCO',1),(259321,'APURIMAC','AYMARAES','CHALHUANCA',1),(260322,'APURIMAC','AYMARAES','CAPAYA',1),(261323,'APURIMAC','AYMARAES','CARAYBAMBA',1),(262324,'APURIMAC','AYMARAES','COLCABAMBA',1),(263325,'APURIMAC','AYMARAES','COTARUSE',1),(264326,'APURIMAC','AYMARAES','CHAPIMARCA',1),(265327,'APURIMAC','AYMARAES','IHUAYLLO',1),(266328,'APURIMAC','AYMARAES','LUCRE',1),(267329,'APURIMAC','AYMARAES','POCOHUANCA',1),(276331,'APURIMAC','ANDAHUAYLAS','ANDAHUAYLAS',1),(277332,'APURIMAC','ANDAHUAYLAS','ANDARAPA',1),(278333,'APURIMAC','ANDAHUAYLAS','CHIARA',1),(279334,'APURIMAC','ANDAHUAYLAS','HUANCARAMA',1),(280335,'APURIMAC','ANDAHUAYLAS','HUANCARAY',1),(281336,'APURIMAC','ANDAHUAYLAS','KISHUARA',1),(282337,'APURIMAC','ANDAHUAYLAS','PACOBAMBA',1),(283338,'APURIMAC','ANDAHUAYLAS','PAMPACHIRI',1),(284339,'APURIMAC','ANDAHUAYLAS','SAN ANTONIO DE CACHI',1),(295341,'APURIMAC','ANTABAMBA','ANTABAMBA',1),(296342,'APURIMAC','ANTABAMBA','EL ORO',1),(297343,'APURIMAC','ANTABAMBA','HUAQUIRCA',1),(298344,'APURIMAC','ANTABAMBA','JUAN ESPINOZA MEDRANO',1),(299345,'APURIMAC','ANTABAMBA','OROPESA',1),(300346,'APURIMAC','ANTABAMBA','PACHACONAS',1),(301347,'APURIMAC','ANTABAMBA','SABAINO',1),(302351,'APURIMAC','COTABAMBAS','TAMBOBAMBA',1),(303352,'APURIMAC','COTABAMBAS','COYLLURQUI',1),(304353,'APURIMAC','COTABAMBAS','COTABAMBAS',1),(305354,'APURIMAC','COTABAMBAS','HAQUIRA',1),(306355,'APURIMAC','COTABAMBAS','MARA',1),(307356,'APURIMAC','COTABAMBAS','CHALLHUAHUACHO',1),(308361,'APURIMAC','GRAU','CHUQUIBAMBILLA',1),(309362,'APURIMAC','GRAU','CURPAHUASI',1),(310363,'APURIMAC','GRAU','HUAILLATI',1),(311364,'APURIMAC','GRAU','MAMARA',1),(312365,'APURIMAC','GRAU','MARISCAL GAMARRA',1),(313366,'APURIMAC','GRAU','MICAELA BASTIDAS',1),(314367,'APURIMAC','GRAU','PROGRESO',1),(315368,'APURIMAC','GRAU','PATAYPAMPA',1),(316369,'APURIMAC','GRAU','SAN ANTONIO',1),(322371,'APURIMAC','CHINCHEROS','CHINCHEROS',1),(323372,'APURIMAC','CHINCHEROS','ONGOY',1),(324373,'APURIMAC','CHINCHEROS','OCOBAMBA',1),(325374,'APURIMAC','CHINCHEROS','COCHARCAS',1),(326375,'APURIMAC','CHINCHEROS','ANCO HUALLO',1),(327376,'APURIMAC','CHINCHEROS','HUACCANA',1),(328377,'APURIMAC','CHINCHEROS','URANMARCA',1),(329378,'APURIMAC','CHINCHEROS','RANRACANCHA',1),(330411,'AREQUIPA','AREQUIPA','AREQUIPA',1),(331412,'AREQUIPA','AREQUIPA','CAYMA',1),(332413,'AREQUIPA','AREQUIPA','CERRO COLORADO',1),(333414,'AREQUIPA','AREQUIPA','CHARACATO',1),(334415,'AREQUIPA','AREQUIPA','CHIGUATA',1),(335416,'AREQUIPA','AREQUIPA','LA JOYA',1),(336417,'AREQUIPA','AREQUIPA','MIRAFLORES',1),(337418,'AREQUIPA','AREQUIPA','MOLLEBAYA',1),(338419,'AREQUIPA','AREQUIPA','PAUCARPATA',1),(359421,'AREQUIPA','CAYLLOMA','CHIVAY',1),(360422,'AREQUIPA','CAYLLOMA','ACHOMA',1),(361310,'AMAZONAS','BONGARA','VALERA',1),(361423,'AREQUIPA','CAYLLOMA','CABANACONDE',1),(362424,'AREQUIPA','CAYLLOMA','CAYLLOMA',1),(363425,'AREQUIPA','CAYLLOMA','CALLALLI',1),(364426,'AREQUIPA','CAYLLOMA','COPORAQUE',1),(365427,'AREQUIPA','CAYLLOMA','HUAMBO',1),(366428,'AREQUIPA','CAYLLOMA','HUANCA',1),(367429,'AREQUIPA','CAYLLOMA','ICHUPAMPA',1),(371311,'AMAZONAS','BONGARA','YAMBRASBAMBA',1),(379431,'AREQUIPA','CAMANA','CAMANA',1),(380432,'AREQUIPA','CAMANA','JOSE MARIA QUIMPER',1),(381312,'AMAZONAS','BONGARA','JAZAN',1),(381433,'AREQUIPA','CAMANA','MARIANO N VALCARCEL',1),(382434,'AREQUIPA','CAMANA','MARISCAL CACERES',1),(383435,'AREQUIPA','CAMANA','NICOLAS DE PIEROLA',1),(384436,'AREQUIPA','CAMANA','OCOÃ‘A',1),(385437,'AREQUIPA','CAMANA','QUILCA',1),(386438,'AREQUIPA','CAMANA','SAMUEL PASTOR',1),(387441,'AREQUIPA','CARAVELI','CARAVELI',1),(388442,'AREQUIPA','CARAVELI','ACARI',1),(389443,'AREQUIPA','CARAVELI','ATICO',1),(390444,'AREQUIPA','CARAVELI','ATIQUIPA',1),(391445,'AREQUIPA','CARAVELI','BELLA UNION',1),(392446,'AREQUIPA','CARAVELI','CAHUACHO',1),(393447,'AREQUIPA','CARAVELI','CHALA',1),(394448,'AREQUIPA','CARAVELI','CHAPARRA',1),(395449,'AREQUIPA','CARAVELI','HUANUHUANU',1),(400451,'AREQUIPA','CASTILLA','APLAO',1),(401452,'AREQUIPA','CASTILLA','ANDAGUA',1),(402453,'AREQUIPA','CASTILLA','AYO',1),(403454,'AREQUIPA','CASTILLA','CHACHAS',1),(404455,'AREQUIPA','CASTILLA','CHILCAYMARCA',1),(405456,'AREQUIPA','CASTILLA','CHOCO',1),(406457,'AREQUIPA','CASTILLA','HUANCARQUI',1),(407458,'AREQUIPA','CASTILLA','MACHAGUAY',1),(408459,'AREQUIPA','CASTILLA','ORCOPAMPA',1),(414461,'AREQUIPA','CONDESUYOS','CHUQUIBAMBA',1),(415462,'AREQUIPA','CONDESUYOS','ANDARAY',1),(416463,'AREQUIPA','CONDESUYOS','CAYARANI',1),(417464,'AREQUIPA','CONDESUYOS','CHICHAS',1),(418465,'AREQUIPA','CONDESUYOS','IRAY',1),(419466,'AREQUIPA','CONDESUYOS','SALAMANCA',1),(420467,'AREQUIPA','CONDESUYOS','YANAQUIHUA',1),(421468,'AREQUIPA','CONDESUYOS','RIO GRANDE',1),(422471,'AREQUIPA','ISLAY','MOLLENDO',1),(423472,'AREQUIPA','ISLAY','COCACHACRA',1),(424473,'AREQUIPA','ISLAY','DEAN VALDIVIA',1),(425474,'AREQUIPA','ISLAY','ISLAY',1),(426475,'AREQUIPA','ISLAY','MEJIA',1),(427476,'AREQUIPA','ISLAY','PUNTA DE BOMBON',1),(428481,'AREQUIPA','LA UNION','COTAHUASI',1),(429482,'AREQUIPA','LA UNION','ALCA',1),(430483,'AREQUIPA','LA UNION','CHARCANA',1),(431484,'AREQUIPA','LA UNION','HUAYNACOTAS',1),(432485,'AREQUIPA','LA UNION','PAMPAMARCA',1),(433486,'AREQUIPA','LA UNION','PUYCA',1),(434487,'AREQUIPA','LA UNION','QUECHUALLA',1),(435488,'AREQUIPA','LA UNION','SAYLA',1),(436489,'AREQUIPA','LA UNION','TAURIA',1),(439511,'AYACUCHO','HUAMANGA','AYACUCHO',1),(440512,'AYACUCHO','HUAMANGA','ACOS VINCHOS',1),(441513,'AYACUCHO','HUAMANGA','CARMEN ALTO',1),(442514,'AYACUCHO','HUAMANGA','CHIARA',1),(443515,'AYACUCHO','HUAMANGA','QUINUA',1),(444516,'AYACUCHO','HUAMANGA','SAN JOSE DE TICLLAS',1),(445517,'AYACUCHO','HUAMANGA','SAN JUAN BAUTISTA',1),(446518,'AYACUCHO','HUAMANGA','SANTIAGO DE PISCHA',1),(447519,'AYACUCHO','HUAMANGA','VINCHOS',1),(454521,'AYACUCHO','CANGALLO','CANGALLO',1),(455524,'AYACUCHO','CANGALLO','CHUSCHI',1),(456526,'AYACUCHO','CANGALLO','LOS MOROCHUCOS',1),(457527,'AYACUCHO','CANGALLO','PARAS',1),(458528,'AYACUCHO','CANGALLO','TOTOS',1),(460531,'AYACUCHO','HUANTA','HUANTA',1),(461532,'AYACUCHO','HUANTA','AYAHUANCO',1),(462533,'AYACUCHO','HUANTA','HUAMANGUILLA',1),(463534,'AYACUCHO','HUANTA','IGUAIN',1),(464535,'AYACUCHO','HUANTA','LURICOCHA',1),(465537,'AYACUCHO','HUANTA','SANTILLANA',1),(466538,'AYACUCHO','HUANTA','SIVIA',1),(467539,'AYACUCHO','HUANTA','LLOCHEGUA',1),(468541,'AYACUCHO','LA MAR','SAN MIGUEL',1),(469542,'AYACUCHO','LA MAR','ANCO',1),(470543,'AYACUCHO','LA MAR','AYNA',1),(471544,'AYACUCHO','LA MAR','CHILCAS',1),(472545,'AYACUCHO','LA MAR','CHUNGUI',1),(473546,'AYACUCHO','LA MAR','TAMBO',1),(474547,'AYACUCHO','LA MAR','LUIS CARRANZA',1),(475548,'AYACUCHO','LA MAR','SANTA ROSA',1),(476551,'AYACUCHO','LUCANAS','PUQUIO',1),(477552,'AYACUCHO','LUCANAS','AUCARA',1),(478553,'AYACUCHO','LUCANAS','CABANA',1),(479554,'AYACUCHO','LUCANAS','CARMEN SALCEDO',1),(480556,'AYACUCHO','LUCANAS','CHAVIÃ‘A',1),(481410,'AMAZONAS','LUYA','LUYA VIEJO',1),(481558,'AYACUCHO','LUCANAS','CHIPAO',1),(491411,'AMAZONAS','LUYA','MARIA',1),(497561,'AYACUCHO','PARINACOCHAS','CORACORA',1),(498564,'AYACUCHO','PARINACOCHAS','CORONEL CASTAÃ‘EDA',1),(499565,'AYACUCHO','PARINACOCHAS','CHUMPI',1),(500568,'AYACUCHO','PARINACOCHAS','PACAPAUSA',1),(501412,'AMAZONAS','LUYA','OCALLI',1),(505571,'AYACUCHO','VICTOR FAJARDO','HUANCAPI',1),(506572,'AYACUCHO','VICTOR FAJARDO','ALCAMENCA',1),(507573,'AYACUCHO','VICTOR FAJARDO','APONGO',1),(508574,'AYACUCHO','VICTOR FAJARDO','CANARIA',1),(509576,'AYACUCHO','VICTOR FAJARDO','CAYARA',1),(510577,'AYACUCHO','VICTOR FAJARDO','COLCA',1),(511413,'AMAZONAS','LUYA','OCUMAL',1),(511578,'AYACUCHO','VICTOR FAJARDO','HUAYA',1),(512579,'AYACUCHO','VICTOR FAJARDO','HUAMANQUIQUIA',1),(517581,'AYACUCHO','HUANCA SANCOS','SANCOS',1),(518582,'AYACUCHO','HUANCA SANCOS','SACSAMARCA',1),(519583,'AYACUCHO','HUANCA SANCOS','SANTIAGO DE LUCANAMARCA',1),(520584,'AYACUCHO','HUANCA SANCOS','CARAPO',1),(521414,'AMAZONAS','LUYA','PISUQUIA',1),(521591,'AYACUCHO','VILCAS HUAMAN','VILCAS HUAMAN',1),(522592,'AYACUCHO','VILCAS HUAMAN','VISCHONGO',1),(523593,'AYACUCHO','VILCAS HUAMAN','ACCOMARCA',1),(524594,'AYACUCHO','VILCAS HUAMAN','CARHUANCA',1),(525595,'AYACUCHO','VILCAS HUAMAN','CONCEPCION',1),(526596,'AYACUCHO','VILCAS HUAMAN','HUAMBALPA',1),(527597,'AYACUCHO','VILCAS HUAMAN','SAURAMA',1),(528598,'AYACUCHO','VILCAS HUAMAN','INDEPENDENCIA',1),(531415,'AMAZONAS','LUYA','SAN CRISTOBAL',1),(541416,'AMAZONAS','LUYA','SAN FRANCISCO DE YESO',1),(550611,'CAJAMARCA','CAJAMARCA','CAJAMARCA',1),(551417,'AMAZONAS','LUYA','SAN JERONIMO',1),(551612,'CAJAMARCA','CAJAMARCA','ASUNCION',1),(552613,'CAJAMARCA','CAJAMARCA','COSPAN',1),(553614,'CAJAMARCA','CAJAMARCA','CHETILLA',1),(554615,'CAJAMARCA','CAJAMARCA','ENCAÃ‘ADA',1),(555616,'CAJAMARCA','CAJAMARCA','JESUS',1),(556617,'CAJAMARCA','CAJAMARCA','LOS BAÃ‘OS DEL INCA',1),(557618,'CAJAMARCA','CAJAMARCA','LLACANORA',1),(558619,'CAJAMARCA','CAJAMARCA','MAGDALENA',1),(561418,'AMAZONAS','LUYA','SAN JUAN DE LOPECANCHA',1),(562621,'CAJAMARCA','CAJABAMBA','CAJABAMBA',1),(563622,'CAJAMARCA','CAJABAMBA','CACHACHI',1),(564623,'CAJAMARCA','CAJABAMBA','CONDEBAMBA',1),(565625,'CAJAMARCA','CAJABAMBA','SITACOCHA',1),(566631,'CAJAMARCA','CELENDIN','CELENDIN',1),(567632,'CAJAMARCA','CELENDIN','CORTEGANA',1),(568633,'CAJAMARCA','CELENDIN','CHUMUCH',1),(569634,'CAJAMARCA','CELENDIN','HUASMIN',1),(570635,'CAJAMARCA','CELENDIN','JORGE CHAVEZ',1),(571419,'AMAZONAS','LUYA','SANTA CATALINA',1),(571636,'CAJAMARCA','CELENDIN','JOSE GALVEZ',1),(572637,'CAJAMARCA','CELENDIN','MIGUEL IGLESIAS',1),(573638,'CAJAMARCA','CELENDIN','OXAMARCA',1),(574639,'CAJAMARCA','CELENDIN','SOROCHUCO',1),(578641,'CAJAMARCA','CONTUMAZA','CONTUMAZA',1),(579643,'CAJAMARCA','CONTUMAZA','CHILETE',1),(580644,'CAJAMARCA','CONTUMAZA','GUZMANGO',1),(581420,'AMAZONAS','LUYA','SANTO TOMAS',1),(581645,'CAJAMARCA','CONTUMAZA','SAN BENITO',1),(582646,'CAJAMARCA','CONTUMAZA','CUPISNIQUE',1),(583647,'CAJAMARCA','CONTUMAZA','TANTARICA',1),(584648,'CAJAMARCA','CONTUMAZA','YONAN',1),(585649,'CAJAMARCA','CONTUMAZA','STA CRUZ DE TOLEDO',1),(586651,'CAJAMARCA','CUTERVO','CUTERVO',1),(587652,'CAJAMARCA','CUTERVO','CALLAYUC',1),(588653,'CAJAMARCA','CUTERVO','CUJILLO',1),(589654,'CAJAMARCA','CUTERVO','CHOROS',1),(590655,'CAJAMARCA','CUTERVO','LA RAMADA',1),(591421,'AMAZONAS','LUYA','TINGO',1),(591656,'CAJAMARCA','CUTERVO','PIMPINGOS',1),(592657,'CAJAMARCA','CUTERVO','QUEROCOTILLO',1),(593658,'CAJAMARCA','CUTERVO','SAN ANDRES DE CUTERVO',1),(594659,'CAJAMARCA','CUTERVO','SAN JUAN DE CUTERVO',1),(601422,'AMAZONAS','LUYA','TRITA',1),(601661,'CAJAMARCA','CHOTA','CHOTA',1),(602662,'CAJAMARCA','CHOTA','ANGUIA',1),(603663,'CAJAMARCA','CHOTA','COCHABAMBA',1),(604664,'CAJAMARCA','CHOTA','CONCHAN',1),(605665,'CAJAMARCA','CHOTA','CHADIN',1),(606666,'CAJAMARCA','CHOTA','CHIGUIRIP',1),(607667,'CAJAMARCA','CHOTA','CHIMBAN',1),(608668,'CAJAMARCA','CHOTA','HUAMBOS',1),(609669,'CAJAMARCA','CHOTA','LAJAS',1),(611423,'AMAZONAS','LUYA','PROVIDENCIA',1),(620671,'CAJAMARCA','HUALGAYOC','BAMBAMARCA',1),(621672,'CAJAMARCA','HUALGAYOC','CHUGUR',1),(622673,'CAJAMARCA','HUALGAYOC','HUALGAYOC',1),(623681,'CAJAMARCA','JAEN','JAEN',1),(624682,'CAJAMARCA','JAEN','BELLAVISTA',1),(625683,'CAJAMARCA','JAEN','COLASAY',1),(626684,'CAJAMARCA','JAEN','CHONTALI',1),(627685,'CAJAMARCA','JAEN','POMAHUACA',1),(628686,'CAJAMARCA','JAEN','PUCARA',1),(629687,'CAJAMARCA','JAEN','SALLIQUE',1),(630688,'CAJAMARCA','JAEN','SAN FELIPE',1),(631689,'CAJAMARCA','JAEN','SAN JOSE DEL ALTO',1),(635691,'CAJAMARCA','SANTA CRUZ','SANTA CRUZ',1),(636692,'CAJAMARCA','SANTA CRUZ','CATACHE',1),(637693,'CAJAMARCA','SANTA CRUZ','CHANCAIBAÃ‘OS',1),(638694,'CAJAMARCA','SANTA CRUZ','LA ESPERANZA',1),(639695,'CAJAMARCA','SANTA CRUZ','NINABAMBA',1),(640696,'CAJAMARCA','SANTA CRUZ','PULAN',1),(641697,'CAJAMARCA','SANTA CRUZ','SEXI',1),(642698,'CAJAMARCA','SANTA CRUZ','UTICYACU',1),(643699,'CAJAMARCA','SANTA CRUZ','YAUYUCAN',1),(677711,'CUSCO','CUSCO','CUSCO',1),(678712,'CUSCO','CUSCO','CCORCA',1),(679713,'CUSCO','CUSCO','POROY',1),(680714,'CUSCO','CUSCO','SAN JERONIMO',1),(681715,'CUSCO','CUSCO','SAN SEBASTIAN',1),(682716,'CUSCO','CUSCO','SANTIAGO',1),(683717,'CUSCO','CUSCO','SAYLLA',1),(684718,'CUSCO','CUSCO','WANCHAQ',1),(685721,'CUSCO','ACOMAYO','ACOMAYO',1),(686722,'CUSCO','ACOMAYO','ACOPIA',1),(687723,'CUSCO','ACOMAYO','ACOS',1),(688724,'CUSCO','ACOMAYO','POMACANCHI',1),(689725,'CUSCO','ACOMAYO','RONDOCAN',1),(690726,'CUSCO','ACOMAYO','SANGARARA',1),(691727,'CUSCO','ACOMAYO','MOSOC LLACTA',1),(692731,'CUSCO','ANTA','ANTA',1),(693732,'CUSCO','ANTA','CHINCHAYPUJIO',1),(694733,'CUSCO','ANTA','HUAROCONDO',1),(695734,'CUSCO','ANTA','LIMATAMBO',1),(696735,'CUSCO','ANTA','MOLLEPATA',1),(697736,'CUSCO','ANTA','PUCYURA',1),(698737,'CUSCO','ANTA','ZURITE',1),(699738,'CUSCO','ANTA','CACHIMAYO',1),(700739,'CUSCO','ANTA','ANCAHUASI',1),(701741,'CUSCO','CALCA','CALCA',1),(702742,'CUSCO','CALCA','COYA',1),(703743,'CUSCO','CALCA','LAMAY',1),(704744,'CUSCO','CALCA','LARES',1),(705745,'CUSCO','CALCA','PISAC',1),(706746,'CUSCO','CALCA','SAN SALVADOR',1),(707747,'CUSCO','CALCA','TARAY',1),(708748,'CUSCO','CALCA','YANATILE',1),(709751,'CUSCO','CANAS','YANAOCA',1),(710752,'CUSCO','CANAS','CHECCA',1),(711510,'AMAZONAS','RODRIGUEZ DE MENDOZA','SANTA ROSA',1),(711753,'CUSCO','CANAS','KUNTURKANKI',1),(712754,'CUSCO','CANAS','LANGUI',1),(713755,'CUSCO','CANAS','LAYO',1),(714756,'CUSCO','CANAS','PAMPAMARCA',1),(715757,'CUSCO','CANAS','QUEHUE',1),(716758,'CUSCO','CANAS','TUPAC AMARU',1),(717761,'CUSCO','CANCHIS','SICUANI',1),(718762,'CUSCO','CANCHIS','COMBAPATA',1),(719763,'CUSCO','CANCHIS','CHECACUPE',1),(720764,'CUSCO','CANCHIS','MARANGANI',1),(721511,'AMAZONAS','RODRIGUEZ DE MENDOZA','TOTORA',1),(721765,'CUSCO','CANCHIS','PITUMARCA',1),(722766,'CUSCO','CANCHIS','SAN PABLO',1),(723767,'CUSCO','CANCHIS','SAN PEDRO',1),(724768,'CUSCO','CANCHIS','TINTA',1),(725771,'CUSCO','CHUMBIVILCAS','SANTO TOMAS',1),(726772,'CUSCO','CHUMBIVILCAS','CAPACMARCA',1),(727773,'CUSCO','CHUMBIVILCAS','COLQUEMARCA',1),(728774,'CUSCO','CHUMBIVILCAS','CHAMACA',1),(729775,'CUSCO','CHUMBIVILCAS','LIVITACA',1),(730776,'CUSCO','CHUMBIVILCAS','LLUSCO',1),(731512,'AMAZONAS','RODRIGUEZ DE MENDOZA','VISTA ALEGRE',1),(731777,'CUSCO','CHUMBIVILCAS','QUIÃ‘OTA',1),(732778,'CUSCO','CHUMBIVILCAS','VELILLE',1),(733781,'CUSCO','ESPINAR','ESPINAR',1),(734782,'CUSCO','ESPINAR','CONDOROMA',1),(735783,'CUSCO','ESPINAR','COPORAQUE',1),(736784,'CUSCO','ESPINAR','OCORURO',1),(737785,'CUSCO','ESPINAR','PALLPATA',1),(738786,'CUSCO','ESPINAR','PICHIGUA',1),(739787,'CUSCO','ESPINAR','SUYKUTAMBO',1),(740788,'CUSCO','ESPINAR','ALTO PICHIGUA',1),(741791,'CUSCO','LA CONVENCION','SANTA ANA',1),(742792,'CUSCO','LA CONVENCION','ECHARATE',1),(743793,'CUSCO','LA CONVENCION','HUAYOPATA',1),(744794,'CUSCO','LA CONVENCION','MARANURA',1),(745795,'CUSCO','LA CONVENCION','OCOBAMBA',1),(746796,'CUSCO','LA CONVENCION','SANTA TERESA',1),(747797,'CUSCO','LA CONVENCION','VILCABAMBA',1),(748798,'CUSCO','LA CONVENCION','QUELLOUNO',1),(749799,'CUSCO','LA CONVENCION','KIMBIRI',1),(785811,'HUANCAVELICA','HUANCAVELICA','HUANCAVELICA',1),(786812,'HUANCAVELICA','HUANCAVELICA','ACOBAMBILLA',1),(787813,'HUANCAVELICA','HUANCAVELICA','ACORIA',1),(788814,'HUANCAVELICA','HUANCAVELICA','CONAYCA',1),(789815,'HUANCAVELICA','HUANCAVELICA','CUENCA',1),(790816,'HUANCAVELICA','HUANCAVELICA','HUACHOCOLPA',1),(791818,'HUANCAVELICA','HUANCAVELICA','HUAYLLAHUARA',1),(792819,'HUANCAVELICA','HUANCAVELICA','IZCUCHACA',1),(804821,'HUANCAVELICA','ACOBAMBA','ACOBAMBA',1),(805822,'HUANCAVELICA','ACOBAMBA','ANTA',1),(806823,'HUANCAVELICA','ACOBAMBA','ANDABAMBA',1),(807824,'HUANCAVELICA','ACOBAMBA','CAJA',1),(808825,'HUANCAVELICA','ACOBAMBA','MARCAS',1),(809826,'HUANCAVELICA','ACOBAMBA','PAUCARA',1),(810827,'HUANCAVELICA','ACOBAMBA','POMACOCHA',1),(811828,'HUANCAVELICA','ACOBAMBA','ROSARIO',1),(812831,'HUANCAVELICA','ANGARAES','LIRCAY',1),(813832,'HUANCAVELICA','ANGARAES','ANCHONGA',1),(814833,'HUANCAVELICA','ANGARAES','CALLANMARCA',1),(815834,'HUANCAVELICA','ANGARAES','CONGALLA',1),(816835,'HUANCAVELICA','ANGARAES','CHINCHO',1),(817836,'HUANCAVELICA','ANGARAES','HUAYLLAY GRANDE',1),(818837,'HUANCAVELICA','ANGARAES','HUANCA HUANCA',1),(819838,'HUANCAVELICA','ANGARAES','JULCAMARCA',1),(820839,'HUANCAVELICA','ANGARAES','SAN ANTONIO DE ANTAPARCO',1),(824841,'HUANCAVELICA','CASTROVIRREYNA','CASTROVIRREYNA',1),(825842,'HUANCAVELICA','CASTROVIRREYNA','ARMA',1),(826843,'HUANCAVELICA','CASTROVIRREYNA','AURAHUA',1),(827845,'HUANCAVELICA','CASTROVIRREYNA','CAPILLAS',1),(828846,'HUANCAVELICA','CASTROVIRREYNA','COCAS',1),(829848,'HUANCAVELICA','CASTROVIRREYNA','CHUPAMARCA',1),(830849,'HUANCAVELICA','CASTROVIRREYNA','HUACHOS',1),(837851,'HUANCAVELICA','TAYACAJA','PAMPAS',1),(838852,'HUANCAVELICA','TAYACAJA','ACOSTAMBO',1),(839853,'HUANCAVELICA','TAYACAJA','ACRAQUIA',1),(840854,'HUANCAVELICA','TAYACAJA','AHUAYCHA',1),(841856,'HUANCAVELICA','TAYACAJA','COLCABAMBA',1),(842859,'HUANCAVELICA','TAYACAJA','DANIEL HERNANDEZ',1),(853861,'HUANCAVELICA','HUAYTARA','AYAVI',1),(854862,'HUANCAVELICA','HUAYTARA','CORDOVA',1),(855863,'HUANCAVELICA','HUAYTARA','HUAYACUNDO ARMA',1),(856864,'HUANCAVELICA','HUAYTARA','HUAYTARA',1),(857865,'HUANCAVELICA','HUAYTARA','LARAMARCA',1),(858866,'HUANCAVELICA','HUAYTARA','OCOYO',1),(859867,'HUANCAVELICA','HUAYTARA','PILPICHACA',1),(860868,'HUANCAVELICA','HUAYTARA','QUERCO',1),(861869,'HUANCAVELICA','HUAYTARA','QUITO ARMA',1),(869871,'HUANCAVELICA','CHURCAMPA','CHURCAMPA',1),(870872,'HUANCAVELICA','CHURCAMPA','ANCO',1),(871873,'HUANCAVELICA','CHURCAMPA','CHINCHIHUASI',1),(872874,'HUANCAVELICA','CHURCAMPA','EL CARMEN',1),(873875,'HUANCAVELICA','CHURCAMPA','LA MERCED',1),(874876,'HUANCAVELICA','CHURCAMPA','LOCROJA',1),(875877,'HUANCAVELICA','CHURCAMPA','PAUCARBAMBA',1),(876878,'HUANCAVELICA','CHURCAMPA','SAN MIGUEL DE MAYOC',1),(877879,'HUANCAVELICA','CHURCAMPA','SAN PEDRO DE CORIS',1),(879911,'HUANUCO','HUANUCO','HUANUCO',1),(880912,'HUANUCO','HUANUCO','CHINCHAO',1),(881913,'HUANUCO','HUANUCO','CHURUBAMBA',1),(882914,'HUANUCO','HUANUCO','MARGOS',1),(883915,'HUANUCO','HUANUCO','QUISQUI',1),(884916,'HUANUCO','HUANUCO','SAN FCO DE CAYRAN',1),(885917,'HUANUCO','HUANUCO','SAN PEDRO DE CHAULAN',1),(886918,'HUANUCO','HUANUCO','STA MARIA DEL VALLE',1),(887919,'HUANUCO','HUANUCO','YARUMAYO',1),(890921,'HUANUCO','AMBO','AMBO',1),(891922,'HUANUCO','AMBO','CAYNA',1),(892923,'HUANUCO','AMBO','COLPAS',1),(893924,'HUANUCO','AMBO','CONCHAMARCA',1),(894925,'HUANUCO','AMBO','HUACAR',1),(895926,'HUANUCO','AMBO','SAN FRANCISCO',1),(896927,'HUANUCO','AMBO','SAN RAFAEL',1),(897928,'HUANUCO','AMBO','TOMAY KICHWA',1),(898931,'HUANUCO','DOS DE MAYO','LA UNION',1),(899937,'HUANUCO','DOS DE MAYO','CHUQUIS',1),(907941,'HUANUCO','HUAMALIES','LLATA',1),(908942,'HUANUCO','HUAMALIES','ARANCAY',1),(909943,'HUANUCO','HUAMALIES','CHAVIN DE PARIARCA',1),(910944,'HUANUCO','HUAMALIES','JACAS GRANDE',1),(911945,'HUANUCO','HUAMALIES','JIRCAN',1),(912946,'HUANUCO','HUAMALIES','MIRAFLORES',1),(913947,'HUANUCO','HUAMALIES','MONZON',1),(914948,'HUANUCO','HUAMALIES','PUNCHAO',1),(915949,'HUANUCO','HUAMALIES','PUÃ‘OS',1),(918951,'HUANUCO','MARAÃ‘ON','HUACRACHUCO',1),(919952,'HUANUCO','MARAÃ‘ON','CHOLON',1),(920955,'HUANUCO','MARAÃ‘ON','SAN BUENAVENTURA',1),(921961,'HUANUCO','LEONCIO PRADO','RUPA RUPA',1),(922962,'HUANUCO','LEONCIO PRADO','DANIEL ALOMIA ROBLES',1),(923963,'HUANUCO','LEONCIO PRADO','HERMILIO VALDIZAN',1),(924964,'HUANUCO','LEONCIO PRADO','LUYANDO',1),(925965,'HUANUCO','LEONCIO PRADO','MARIANO DAMASO BERAUN',1),(926966,'HUANUCO','LEONCIO PRADO','JOSE CRESPO Y CASTILLO',1),(927971,'HUANUCO','PACHITEA','PANAO',1),(928972,'HUANUCO','PACHITEA','CHAGLLA',1),(929974,'HUANUCO','PACHITEA','MOLINO',1),(930976,'HUANUCO','PACHITEA','UMARI',1),(931981,'HUANUCO','PUERTO INCA','HONORIA',1),(932110,'ANCASH','HUARAZ','PARIACOTO',1),(932982,'HUANUCO','PUERTO INCA','PUERTO INCA',1),(933983,'HUANUCO','PUERTO INCA','CODO DEL POZUZO',1),(934984,'HUANUCO','PUERTO INCA','TOURNAVISTA',1),(935985,'HUANUCO','PUERTO INCA','YUYAPICHIS',1),(936991,'HUANUCO','HUACAYBAMBA','HUACAYBAMBA',1),(937992,'HUANUCO','HUACAYBAMBA','PINRA',1),(938993,'HUANUCO','HUACAYBAMBA','CANCHABAMBA',1),(939994,'HUANUCO','HUACAYBAMBA','COCHABAMBA',1),(942111,'ANCASH','HUARAZ','PIRA',1),(952112,'ANCASH','HUARAZ','TARICA',1),(1052310,'ANCASH','BOLOGNESI','HUAYLLACAYAN',1),(1062311,'ANCASH','BOLOGNESI','HUASTA',1),(1072313,'ANCASH','BOLOGNESI','MANGAS',1),(1082315,'ANCASH','BOLOGNESI','PACLLON',1),(1092317,'ANCASH','BOLOGNESI','SAN MIGUEL DE CORPANQUI',1),(1102320,'ANCASH','BOLOGNESI','TICLLOS',1),(1112321,'ANCASH','BOLOGNESI','ANTONIO RAIMONDI',1),(1122322,'ANCASH','BOLOGNESI','CANIS',1),(1132323,'ANCASH','BOLOGNESI','COLQUIOC',1),(1142324,'ANCASH','BOLOGNESI','LA PRIMAVERA',1),(1152325,'ANCASH','BOLOGNESI','HUALLANCA',1),(1252410,'ANCASH','CARHUAZ','TINCO',1),(1262411,'ANCASH','CARHUAZ','YUNGAR',1),(1472710,'ANCASH','HUAYLAS','SANTO TORIBIO',1),(1572810,'ANCASH','HUARI','PONTO',1),(1582811,'ANCASH','HUARI','RAHUAPAMPA',1),(1592812,'ANCASH','HUARI','RAPAYAN',1),(1602813,'ANCASH','HUARI','SAN MARCOS',1),(1612814,'ANCASH','HUARI','SAN PEDRO DE CHANA',1),(1622815,'ANCASH','HUARI','UCO',1),(1632816,'ANCASH','HUARI','ANRA',1),(1722101,'ANCASH','PALLASCA','CABANA',1),(1732102,'ANCASH','PALLASCA','BOLOGNESI',1),(1742103,'ANCASH','PALLASCA','CONCHUCOS',1),(1752104,'ANCASH','PALLASCA','HUACASCHUQUE',1),(1762105,'ANCASH','PALLASCA','HUANDOVAL',1),(1772106,'ANCASH','PALLASCA','LACABAMBA',1),(1782107,'ANCASH','PALLASCA','LLAPO',1),(1792108,'ANCASH','PALLASCA','PALLASCA',1),(1802109,'ANCASH','PALLASCA','PAMPAS',1),(1832111,'ANCASH','POMABAMBA','POMABAMBA',1),(1834125,'AMAZONAS','BAGUA','BAGUA',1),(1842112,'ANCASH','POMABAMBA','HUAYLLAN',1),(1852113,'ANCASH','POMABAMBA','PAROBAMBA',1),(1862114,'ANCASH','POMABAMBA','QUINUABAMBA',1),(1872121,'ANCASH','RECUAY','RECUAY',1),(1882122,'ANCASH','RECUAY','COTAPARACO',1),(1892123,'ANCASH','RECUAY','HUAYLLAPAMPA',1),(1902124,'ANCASH','RECUAY','MARCA',1),(1912125,'ANCASH','RECUAY','PAMPAS CHICO',1),(1922126,'ANCASH','RECUAY','PARARIN',1),(1932127,'ANCASH','RECUAY','TAPACOCHA',1),(1942128,'ANCASH','RECUAY','TICAPAMPA',1),(1952129,'ANCASH','RECUAY','LLACLLIN',1),(1972131,'ANCASH','SANTA','CHIMBOTE',1),(1982132,'ANCASH','SANTA','CACERES DEL PERU',1),(1992133,'ANCASH','SANTA','MACATE',1),(2002134,'ANCASH','SANTA','MORO',1),(2012135,'ANCASH','SANTA','NEPEÃ‘A',1),(2022136,'ANCASH','SANTA','SAMANCO',1),(2032137,'ANCASH','SANTA','SANTA',1),(2042138,'ANCASH','SANTA','COISHCO',1),(2052139,'ANCASH','SANTA','NUEVO CHIMBOTE',1),(2062141,'ANCASH','SIHUAS','SIHUAS',1),(2072142,'ANCASH','SIHUAS','ALFONSO UGARTE',1),(2082143,'ANCASH','SIHUAS','CHINGALPO',1),(2092144,'ANCASH','SIHUAS','HUAYLLABAMBA',1),(2102145,'ANCASH','SIHUAS','QUICHES',1),(2112146,'ANCASH','SIHUAS','SICSIBAMBA',1),(2122147,'ANCASH','SIHUAS','ACOBAMBA',1),(2132148,'ANCASH','SIHUAS','CASHAPAMPA',1),(2142149,'ANCASH','SIHUAS','RAGASH',1),(2162151,'ANCASH','YUNGAY','YUNGAY',1),(2172152,'ANCASH','YUNGAY','CASCAPARA',1),(2182153,'ANCASH','YUNGAY','MANCOS',1),(2192154,'ANCASH','YUNGAY','MATACOTO',1),(2202155,'ANCASH','YUNGAY','QUILLO',1),(2212156,'ANCASH','YUNGAY','RANRAHIRCA',1),(2222157,'ANCASH','YUNGAY','SHUPLUY',1),(2232158,'ANCASH','YUNGAY','YANAMA',1),(2242161,'ANCASH','ANTONIO RAIMONDI','LLAMELLIN',1),(2252162,'ANCASH','ANTONIO RAIMONDI','ACZO',1),(2262163,'ANCASH','ANTONIO RAIMONDI','CHACCHO',1),(2272164,'ANCASH','ANTONIO RAIMONDI','CHINGAS',1),(2282165,'ANCASH','ANTONIO RAIMONDI','MIRGAS',1),(2292166,'ANCASH','ANTONIO RAIMONDI','SAN JUAN DE RONTOY',1),(2302171,'ANCASH','CARLOS FERMIN FITZCARRALD','SAN LUIS',1),(2312172,'ANCASH','CARLOS FERMIN FITZCARRALD','YAUYA',1),(2322173,'ANCASH','CARLOS FERMIN FITZCARRALD','SAN NICOLAS',1),(2332181,'ANCASH','ASUNCION','CHACAS',1),(2342182,'ANCASH','ASUNCION','ACOCHACA',1),(2352191,'ANCASH','HUARMEY','HUARMEY',1),(2362192,'ANCASH','HUARMEY','COCHAPETI',1),(2372193,'ANCASH','HUARMEY','HUAYAN',1),(2382194,'ANCASH','HUARMEY','MALVAS',1),(2392195,'ANCASH','HUARMEY','CULEBRAS',1),(2402201,'ANCASH','OCROS','ACAS',1),(2412202,'ANCASH','OCROS','CAJAMARQUILLA',1),(2422203,'ANCASH','OCROS','CARHUAPAMPA',1),(2432204,'ANCASH','OCROS','COCHAS',1),(2442205,'ANCASH','OCROS','CONGAS',1),(2452206,'ANCASH','OCROS','LLIPA',1),(2462207,'ANCASH','OCROS','OCROS',1),(2472208,'ANCASH','OCROS','SAN CRISTOBAL DE RAJAN',1),(2482209,'ANCASH','OCROS','SAN PEDRO',1),(2683210,'APURIMAC','AYMARAES','SAÃ‘AICA',1),(2693211,'APURIMAC','AYMARAES','SORAYA',1),(2703212,'APURIMAC','AYMARAES','TAPAIRIHUA',1),(2713213,'APURIMAC','AYMARAES','TINTAY',1),(2723214,'APURIMAC','AYMARAES','TORAYA',1),(2733215,'APURIMAC','AYMARAES','YANACA',1),(2743216,'APURIMAC','AYMARAES','SAN JUAN DE CHACÃ‘A',1),(2753217,'APURIMAC','AYMARAES','JUSTO APU SAHUARAURA',1),(2853310,'APURIMAC','ANDAHUAYLAS','SAN JERONIMO',1),(2863311,'APURIMAC','ANDAHUAYLAS','TALAVERA',1),(2873312,'APURIMAC','ANDAHUAYLAS','TURPO',1),(2883313,'APURIMAC','ANDAHUAYLAS','PACUCHA',1),(2893314,'APURIMAC','ANDAHUAYLAS','POMACOCHA',1),(2903315,'APURIMAC','ANDAHUAYLAS','STA MARIA DE CHICMO',1),(2913316,'APURIMAC','ANDAHUAYLAS','TUMAY HUARACA',1),(2923317,'APURIMAC','ANDAHUAYLAS','HUAYANA',1),(2933318,'APURIMAC','ANDAHUAYLAS','SAN MIGUEL DE CHACCRAMPA',1),(2943319,'APURIMAC','ANDAHUAYLAS','KAQUIABAMBA',1),(3173610,'APURIMAC','GRAU','TURPAY',1),(3183611,'APURIMAC','GRAU','VILCABAMBA',1),(3193612,'APURIMAC','GRAU','VIRUNDO',1),(3203613,'APURIMAC','GRAU','SANTA ROSA',1),(3213614,'APURIMAC','GRAU','CURASCO',1),(3394110,'AREQUIPA','AREQUIPA','POCSI',1),(3404111,'AREQUIPA','AREQUIPA','POLOBAYA',1),(3414112,'AREQUIPA','AREQUIPA','QUEQUEÃ‘A',1),(3424113,'AREQUIPA','AREQUIPA','SABANDIA',1),(3434114,'AREQUIPA','AREQUIPA','SACHACA',1),(3444115,'AREQUIPA','AREQUIPA','SAN JUAN DE SIGUAS',1),(3454116,'AREQUIPA','AREQUIPA','SAN JUAN DE TARUCANI',1),(3464117,'AREQUIPA','AREQUIPA','SANTA ISABEL DE SIGUAS',1),(3474118,'AREQUIPA','AREQUIPA','STA RITA DE SIGUAS',1),(3484119,'AREQUIPA','AREQUIPA','SOCABAYA',1),(3494120,'AREQUIPA','AREQUIPA','TIABAYA',1),(3504121,'AREQUIPA','AREQUIPA','UCHUMAYO',1),(3514122,'AREQUIPA','AREQUIPA','VITOR',1),(3524123,'AREQUIPA','AREQUIPA','YANAHUARA',1),(3534124,'AREQUIPA','AREQUIPA','YARABAMBA',1),(3544125,'AREQUIPA','AREQUIPA','YURA',1),(3554126,'AREQUIPA','AREQUIPA','MARIANO MELGAR',1),(3564127,'AREQUIPA','AREQUIPA','JACOBO HUNTER',1),(3574128,'AREQUIPA','AREQUIPA','ALTO SELVA ALEGRE',1),(3584129,'AREQUIPA','AREQUIPA','JOSE LUIS BUSTAMANTE Y RIVERO',1),(3684210,'AREQUIPA','CAYLLOMA','LARI',1),(3694211,'AREQUIPA','CAYLLOMA','LLUTA',1),(3704212,'AREQUIPA','CAYLLOMA','MACA',1),(3714213,'AREQUIPA','CAYLLOMA','MADRIGAL',1),(3724214,'AREQUIPA','CAYLLOMA','SAN ANTONIO DE CHUCA',1),(3734215,'AREQUIPA','CAYLLOMA','SIBAYO',1),(3744216,'AREQUIPA','CAYLLOMA','TAPAY',1),(3754217,'AREQUIPA','CAYLLOMA','TISCO',1),(3764218,'AREQUIPA','CAYLLOMA','TUTI',1),(3774219,'AREQUIPA','CAYLLOMA','YANQUE',1),(3784220,'AREQUIPA','CAYLLOMA','MAJES',1),(3964410,'AREQUIPA','CARAVELI','JAQUI',1),(3974411,'AREQUIPA','CARAVELI','LOMAS',1),(3984412,'AREQUIPA','CARAVELI','QUICACHA',1),(3994413,'AREQUIPA','CARAVELI','YAUCA',1),(4094510,'AREQUIPA','CASTILLA','PAMPACOLCA',1),(4104511,'AREQUIPA','CASTILLA','TIPAN',1),(4114512,'AREQUIPA','CASTILLA','URACA',1),(4124513,'AREQUIPA','CASTILLA','UÃ‘ON',1),(4134514,'AREQUIPA','CASTILLA','VIRACO',1),(4374810,'AREQUIPA','LA UNION','TOMEPAMPA',1),(4384811,'AREQUIPA','LA UNION','TORO',1),(4485110,'AYACUCHO','HUAMANGA','TAMBILLO',1),(4495111,'AYACUCHO','HUAMANGA','ACOCRO',1),(4505112,'AYACUCHO','HUAMANGA','SOCOS',1),(4515113,'AYACUCHO','HUAMANGA','OCROS',1),(4525114,'AYACUCHO','HUAMANGA','PACAYCASA',1),(4535115,'AYACUCHO','HUAMANGA','JESUS NAZARENO',1),(4595211,'AYACUCHO','CANGALLO','MARIA PARADO DE BELLIDO',1),(4825510,'AYACUCHO','LUCANAS','HUAC-HUAS',1),(4835511,'AYACUCHO','LUCANAS','LARAMATE',1),(4845512,'AYACUCHO','LUCANAS','LEONCIO PRADO',1),(4855513,'AYACUCHO','LUCANAS','LUCANAS',1),(4865514,'AYACUCHO','LUCANAS','LLAUTA',1),(4875516,'AYACUCHO','LUCANAS','OCAÃ‘A',1),(4885517,'AYACUCHO','LUCANAS','OTOCA',1),(4895520,'AYACUCHO','LUCANAS','SANCOS',1),(4905521,'AYACUCHO','LUCANAS','SAN JUAN',1),(4915522,'AYACUCHO','LUCANAS','SAN PEDRO',1),(4925524,'AYACUCHO','LUCANAS','STA ANA DE HUAYCAHUACHO',1),(4935525,'AYACUCHO','LUCANAS','SANTA LUCIA',1),(4945529,'AYACUCHO','LUCANAS','SAISA',1),(4955531,'AYACUCHO','LUCANAS','SAN PEDRO DE PALCO',1),(4965532,'AYACUCHO','LUCANAS','SAN CRISTOBAL',1),(5015611,'AYACUCHO','PARINACOCHAS','PULLO',1),(5025612,'AYACUCHO','PARINACOCHAS','PUYUSCA',1),(5035615,'AYACUCHO','PARINACOCHAS','SAN FCO DE RAVACAYCO',1),(5045616,'AYACUCHO','PARINACOCHAS','UPAHUACHO',1),(5135710,'AYACUCHO','VICTOR FAJARDO','HUANCARAYLLA',1),(5145713,'AYACUCHO','VICTOR FAJARDO','SARHUA',1),(5155714,'AYACUCHO','VICTOR FAJARDO','VILCANCHOS',1),(5165715,'AYACUCHO','VICTOR FAJARDO','ASQUIPATA',1),(5295101,'AYACUCHO','PAUCAR DEL SARA SARA','PAUSA',1),(5305102,'AYACUCHO','PAUCAR DEL SARA SARA','COLTA',1),(5315103,'AYACUCHO','PAUCAR DEL SARA SARA','CORCULLA',1),(5325104,'AYACUCHO','PAUCAR DEL SARA SARA','LAMPA',1),(5335105,'AYACUCHO','PAUCAR DEL SARA SARA','MARCABAMBA',1),(5345106,'AYACUCHO','PAUCAR DEL SARA SARA','OYOLO',1),(5355107,'AYACUCHO','PAUCAR DEL SARA SARA','PARARCA',1),(5365108,'AYACUCHO','PAUCAR DEL SARA SARA','SAN JAVIER DE ALPABAMBA',1),(5375109,'AYACUCHO','PAUCAR DEL SARA SARA','SAN JOSE DE USHUA',1),(5395111,'AYACUCHO','SUCRE','QUEROBAMBA',1),(5405112,'AYACUCHO','SUCRE','BELEN',1),(5415113,'AYACUCHO','SUCRE','CHALCOS',1),(5425114,'AYACUCHO','SUCRE','SAN SALVADOR DE QUIJE',1),(5435115,'AYACUCHO','SUCRE','PAICO',1),(5445116,'AYACUCHO','SUCRE','SANTIAGO DE PAUCARAY',1),(5455117,'AYACUCHO','SUCRE','SAN PEDRO DE LARCAY',1),(5465118,'AYACUCHO','SUCRE','SORAS',1),(5475119,'AYACUCHO','SUCRE','HUACAÃ‘A',1),(5596110,'CAJAMARCA','CAJAMARCA','MATARA',1),(5606111,'CAJAMARCA','CAJAMARCA','NAMORA',1),(5616112,'CAJAMARCA','CAJAMARCA','SAN JUAN',1),(5756310,'CAJAMARCA','CELENDIN','SUCRE',1),(5766311,'CAJAMARCA','CELENDIN','UTCO',1),(5776312,'CAJAMARCA','CELENDIN','LA LIBERTAD DE PALLAN',1),(5956510,'CAJAMARCA','CUTERVO','SAN LUIS DE LUCMA',1),(5966511,'CAJAMARCA','CUTERVO','SANTA CRUZ',1),(5976512,'CAJAMARCA','CUTERVO','SANTO DOMINGO DE LA CAPILLA',1),(5986513,'CAJAMARCA','CUTERVO','SANTO TOMAS',1),(5996514,'CAJAMARCA','CUTERVO','SOCOTA',1),(6006515,'CAJAMARCA','CUTERVO','TORIBIO CASANOVA',1),(6106610,'CAJAMARCA','CHOTA','LLAMA',1),(6116611,'CAJAMARCA','CHOTA','MIRACOSTA',1),(6126612,'CAJAMARCA','CHOTA','PACCHA',1),(6136613,'CAJAMARCA','CHOTA','PION',1),(6146614,'CAJAMARCA','CHOTA','QUEROCOTO',1),(6156615,'CAJAMARCA','CHOTA','TACABAMBA',1),(6166616,'CAJAMARCA','CHOTA','TOCMOCHE',1),(6176617,'CAJAMARCA','CHOTA','SAN JUAN DE LICUPIS',1),(6186618,'CAJAMARCA','CHOTA','CHOROPAMPA',1),(6196619,'CAJAMARCA','CHOTA','CHALAMARCA',1),(6326810,'CAJAMARCA','JAEN','SANTA ROSA',1),(6336811,'CAJAMARCA','JAEN','LAS PIRIAS',1),(6346812,'CAJAMARCA','JAEN','HUABAL',1),(6446910,'CAJAMARCA','SANTA CRUZ','ANDABAMBA',1),(6456911,'CAJAMARCA','SANTA CRUZ','SAUCEPAMPA',1),(6466101,'CAJAMARCA','SAN MIGUEL','SAN MIGUEL',1),(6476102,'CAJAMARCA','SAN MIGUEL','CALQUIS',1),(6486103,'CAJAMARCA','SAN MIGUEL','LA FLORIDA',1),(6496104,'CAJAMARCA','SAN MIGUEL','LLAPA',1),(6506105,'CAJAMARCA','SAN MIGUEL','NANCHOC',1),(6516106,'CAJAMARCA','SAN MIGUEL','NIEPOS',1),(6526107,'CAJAMARCA','SAN MIGUEL','SAN GREGORIO',1),(6536108,'CAJAMARCA','SAN MIGUEL','SAN SILVESTRE DE COCHAN',1),(6546109,'CAJAMARCA','SAN MIGUEL','EL PRADO',1),(6596111,'CAJAMARCA','SAN IGNACIO','SAN IGNACIO',1),(6606112,'CAJAMARCA','SAN IGNACIO','CHIRINOS',1),(6616113,'CAJAMARCA','SAN IGNACIO','HUARANGO',1),(6626114,'CAJAMARCA','SAN IGNACIO','NAMBALLE',1),(6636115,'CAJAMARCA','SAN IGNACIO','LA COIPA',1),(6646116,'CAJAMARCA','SAN IGNACIO','SAN JOSE DE LOURDES',1),(6656117,'CAJAMARCA','SAN IGNACIO','TABACONAS',1),(6666121,'CAJAMARCA','SAN MARCOS','PEDRO GALVEZ',1),(6676122,'CAJAMARCA','SAN MARCOS','ICHOCAN',1),(6686123,'CAJAMARCA','SAN MARCOS','GREGORIO PITA',1),(6696124,'CAJAMARCA','SAN MARCOS','JOSE MANUEL QUIROZ',1),(6706125,'CAJAMARCA','SAN MARCOS','EDUARDO VILLANUEVA',1),(6716126,'CAJAMARCA','SAN MARCOS','JOSE SABOGAL',1),(6726127,'CAJAMARCA','SAN MARCOS','CHANCAY',1),(6736131,'CAJAMARCA','SAN PABLO','SAN PABLO',1),(6746132,'CAJAMARCA','SAN PABLO','SAN BERNARDINO',1),(6756133,'CAJAMARCA','SAN PABLO','SAN LUIS',1),(6766134,'CAJAMARCA','SAN PABLO','TUMBADEN',1),(7507910,'CUSCO','LA CONVENCION','PICHARI',1),(7517101,'CUSCO','PARURO','PARURO',1),(7527102,'CUSCO','PARURO','ACCHA',1),(7537103,'CUSCO','PARURO','CCAPI',1),(7547104,'CUSCO','PARURO','COLCHA',1),(7557105,'CUSCO','PARURO','HUANOQUITE',1),(7567106,'CUSCO','PARURO','OMACHA',1),(7577107,'CUSCO','PARURO','YAURISQUE',1),(7587108,'CUSCO','PARURO','PACCARITAMBO',1),(7597109,'CUSCO','PARURO','PILLPINTO',1),(7607111,'CUSCO','PAUCARTAMBO','PAUCARTAMBO',1),(7617112,'CUSCO','PAUCARTAMBO','CAICAY',1),(7627113,'CUSCO','PAUCARTAMBO','COLQUEPATA',1),(7637114,'CUSCO','PAUCARTAMBO','CHALLABAMBA',1),(7647115,'CUSCO','PAUCARTAMBO','COSÃ‘IPATA',1),(7657116,'CUSCO','PAUCARTAMBO','HUANCARANI',1),(7667121,'CUSCO','QUISPICANCHI','URCOS',1),(7677122,'CUSCO','QUISPICANCHI','ANDAHUAYLILLAS',1),(7687123,'CUSCO','QUISPICANCHI','CAMANTI',1),(7697124,'CUSCO','QUISPICANCHI','CCARHUAYO',1),(7707125,'CUSCO','QUISPICANCHI','CCATCA',1),(7717126,'CUSCO','QUISPICANCHI','CUSIPATA',1),(7727127,'CUSCO','QUISPICANCHI','HUARO',1),(7737128,'CUSCO','QUISPICANCHI','LUCRE',1),(7747129,'CUSCO','QUISPICANCHI','MARCAPATA',1),(7787131,'CUSCO','URUBAMBA','URUBAMBA',1),(7797132,'CUSCO','URUBAMBA','CHINCHERO',1),(7807133,'CUSCO','URUBAMBA','HUAYLLABAMBA',1),(7817134,'CUSCO','URUBAMBA','MACHUPICCHU',1),(7827135,'CUSCO','URUBAMBA','MARAS',1),(7837136,'CUSCO','URUBAMBA','OLLANTAYTAMBO',1),(7847137,'CUSCO','URUBAMBA','YUCAY',1),(7938110,'HUANCAVELICA','HUANCAVELICA','LARIA',1),(7948111,'HUANCAVELICA','HUANCAVELICA','MANTA',1),(7958112,'HUANCAVELICA','HUANCAVELICA','MARISCAL CACERES',1),(7968113,'HUANCAVELICA','HUANCAVELICA','MOYA',1),(7978114,'HUANCAVELICA','HUANCAVELICA','NUEVO OCCORO',1),(7988115,'HUANCAVELICA','HUANCAVELICA','PALCA',1),(7998116,'HUANCAVELICA','HUANCAVELICA','PILCHACA',1),(8008117,'HUANCAVELICA','HUANCAVELICA','VILCA',1),(8018118,'HUANCAVELICA','HUANCAVELICA','YAULI',1),(8028119,'HUANCAVELICA','HUANCAVELICA','ASCENSION',1),(8038120,'HUANCAVELICA','HUANCAVELICA','HUANDO',1),(8218310,'HUANCAVELICA','ANGARAES','STO TOMAS DE PATA',1),(8228311,'HUANCAVELICA','ANGARAES','SECCLLA',1),(8238312,'HUANCAVELICA','ANGARAES','CCOCHACCASA',1),(8318410,'HUANCAVELICA','CASTROVIRREYNA','HUAMATAMBO',1),(8328414,'HUANCAVELICA','CASTROVIRREYNA','MOLLEPAMPA',1),(8338422,'HUANCAVELICA','CASTROVIRREYNA','SAN JUAN',1),(8348427,'HUANCAVELICA','CASTROVIRREYNA','TANTARA',1),(8358428,'HUANCAVELICA','CASTROVIRREYNA','TICRAPO',1),(8368429,'HUANCAVELICA','CASTROVIRREYNA','SANTA ANA',1),(8438511,'HUANCAVELICA','TAYACAJA','HUACHOCOLPA',1),(8448512,'HUANCAVELICA','TAYACAJA','HUARIBAMBA',1),(8458515,'HUANCAVELICA','TAYACAJA','Ã‘AHUIMPUQUIO',1),(8468517,'HUANCAVELICA','TAYACAJA','PAZOS',1),(8478518,'HUANCAVELICA','TAYACAJA','QUISHUAR',1),(8488519,'HUANCAVELICA','TAYACAJA','SALCABAMBA',1),(8498520,'HUANCAVELICA','TAYACAJA','SAN MARCOS DE ROCCHAC',1),(8508523,'HUANCAVELICA','TAYACAJA','SURCUBAMBA',1),(8518525,'HUANCAVELICA','TAYACAJA','TINTAY PUNCU',1),(8528526,'HUANCAVELICA','TAYACAJA','SALCAHUASI',1),(8628610,'HUANCAVELICA','HUAYTARA','SAN ANTONIO DE CUSICANCHA',1),(8638611,'HUANCAVELICA','HUAYTARA','SAN FRANCISCO DE SANGAYAICO',1),(8648612,'HUANCAVELICA','HUAYTARA','SAN ISIDRO',1),(8658613,'HUANCAVELICA','HUAYTARA','SANTIAGO DE CHOCORVOS',1),(8668614,'HUANCAVELICA','HUAYTARA','SANTIAGO DE QUIRAHUARA',1),(8678615,'HUANCAVELICA','HUAYTARA','SANTO DOMINGO DE CAPILLAS',1),(8688616,'HUANCAVELICA','HUAYTARA','TAMBO',1),(8788710,'HUANCAVELICA','CHURCAMPA','PACHAMARCA',1),(8889110,'HUANUCO','HUANUCO','AMARILIS',1),(8899111,'HUANUCO','HUANUCO','PILLCO MARCA',1),(9009312,'HUANUCO','DOS DE MAYO','MARIAS',1),(9019314,'HUANUCO','DOS DE MAYO','PACHAS',1),(9029316,'HUANUCO','DOS DE MAYO','QUIVILLA',1),(9039317,'HUANUCO','DOS DE MAYO','RIPAN',1),(9049321,'HUANUCO','DOS DE MAYO','SHUNQUI',1),(9059322,'HUANUCO','DOS DE MAYO','SILLAPATA',1),(9069323,'HUANUCO','DOS DE MAYO','YANAS',1),(9169410,'HUANUCO','HUAMALIES','SINGA',1),(9179411,'HUANUCO','HUAMALIES','TANTAMAYO',1),(9409101,'HUANUCO','LAURICOCHA','JESUS',1),(9419102,'HUANUCO','LAURICOCHA','BAÃ‘OS',1),(9429103,'HUANUCO','LAURICOCHA','SAN FRANCISCO DE ASIS',1),(9439104,'HUANUCO','LAURICOCHA','QUEROPALCA',1),(9449105,'HUANUCO','LAURICOCHA','SAN MIGUEL DE CAURI',1),(9459106,'HUANUCO','LAURICOCHA','RONDOS',1),(9469107,'HUANUCO','LAURICOCHA','JIVIA',1),(9479111,'HUANUCO','YAROWILCA','CHAVINILLO',1),(9489112,'HUANUCO','YAROWILCA','APARICIO POMARES CHUPAN',1),(9499113,'HUANUCO','YAROWILCA','CAHUAC',1),(9509114,'HUANUCO','YAROWILCA','CHACABAMBA',1),(9519115,'HUANUCO','YAROWILCA','JACAS CHICO',1),(9529116,'HUANUCO','YAROWILCA','OBAS',1),(9539117,'HUANUCO','YAROWILCA','PAMPAMARCA',1),(9549118,'HUANUCO','YAROWILCA','CHORAS',1),(9551011,'ICA','ICA','ICA',1),(9561012,'ICA','ICA','LA TINGUIÃ‘A',1),(9571013,'ICA','ICA','LOS AQUIJES',1),(9581014,'ICA','ICA','PARCONA',1),(9591015,'ICA','ICA','PUEBLO NUEVO',1),(9601016,'ICA','ICA','SALAS',1),(9611017,'ICA','ICA','SAN JOSE DE LOS MOLINOS',1),(9621018,'ICA','ICA','SAN JUAN BAUTISTA',1),(9631019,'ICA','ICA','SANTIAGO',1),(9691021,'ICA','CHINCHA','CHINCHA ALTA',1),(9701022,'ICA','CHINCHA','CHAVIN',1),(9711023,'ICA','CHINCHA','CHINCHA BAJA',1),(9721024,'ICA','CHINCHA','EL CARMEN',1),(9731025,'ICA','CHINCHA','GROCIO PRADO',1),(9741026,'ICA','CHINCHA','SAN PEDRO DE HUACARPANA',1),(9751027,'ICA','CHINCHA','SUNAMPE',1),(9761028,'ICA','CHINCHA','TAMBO DE MORA',1),(9771029,'ICA','CHINCHA','ALTO LARAN',1),(9801031,'ICA','NAZCA','NAZCA',1),(9811032,'ICA','NAZCA','CHANGUILLO',1),(9821033,'ICA','NAZCA','EL INGENIO',1),(9831034,'ICA','NAZCA','MARCONA',1),(9841035,'ICA','NAZCA','VISTA ALEGRE',1),(9851041,'ICA','PISCO','PISCO',1),(9861042,'ICA','PISCO','HUANCANO',1),(9871043,'ICA','PISCO','HUMAY',1),(9881044,'ICA','PISCO','INDEPENDENCIA',1),(9891045,'ICA','PISCO','PARACAS',1),(9901046,'ICA','PISCO','SAN ANDRES',1),(9911047,'ICA','PISCO','SAN CLEMENTE',1),(9921048,'ICA','PISCO','TUPAC AMARU INCA',1),(9931051,'ICA','PALPA','PALPA',1),(9941052,'ICA','PALPA','LLIPATA',1),(9951053,'ICA','PALPA','RIO GRANDE',1),(9961054,'ICA','PALPA','SANTA CRUZ',1),(9971055,'ICA','PALPA','TIBILLO',1),(9981111,'JUNIN','HUANCAYO','HUANCAYO',1),(9991113,'JUNIN','HUANCAYO','CARHUACALLANGA',1),(10001114,'JUNIN','HUANCAYO','COLCA',1),(10011115,'JUNIN','HUANCAYO','CULLHUAS',1),(10021116,'JUNIN','HUANCAYO','CHACAPAMPA',1),(10031117,'JUNIN','HUANCAYO','CHICCHE',1),(10041118,'JUNIN','HUANCAYO','CHILCA',1),(10051119,'JUNIN','HUANCAYO','CHONGOS ALTO',1),(10261121,'JUNIN','CONCEPCION','CONCEPCION',1),(10271122,'JUNIN','CONCEPCION','ACO',1),(10281123,'JUNIN','CONCEPCION','ANDAMARCA',1),(10291124,'JUNIN','CONCEPCION','COMAS',1),(10301125,'JUNIN','CONCEPCION','COCHAS',1),(10311126,'JUNIN','CONCEPCION','CHAMBARA',1),(10321127,'JUNIN','CONCEPCION','HEROINAS TOLEDO',1),(10331128,'JUNIN','CONCEPCION','MANZANARES',1),(10341129,'JUNIN','CONCEPCION','MCAL CASTILLA',1),(10411131,'JUNIN','JAUJA','JAUJA',1),(10421132,'JUNIN','JAUJA','ACOLLA',1),(10431133,'JUNIN','JAUJA','APATA',1),(10441134,'JUNIN','JAUJA','ATAURA',1),(10451135,'JUNIN','JAUJA','CANCHAILLO',1),(10461136,'JUNIN','JAUJA','EL MANTARO',1),(10471137,'JUNIN','JAUJA','HUAMALI',1),(10481138,'JUNIN','JAUJA','HUARIPAMPA',1),(10491139,'JUNIN','JAUJA','HUERTAS',1),(10751141,'JUNIN','JUNIN','JUNIN',1),(10761142,'JUNIN','JUNIN','CARHUAMAYO',1),(10771143,'JUNIN','JUNIN','ONDORES',1),(10781144,'JUNIN','JUNIN','ULCUMAYO',1),(10791151,'JUNIN','TARMA','TARMA',1),(10801152,'JUNIN','TARMA','ACOBAMBA',1),(10811153,'JUNIN','TARMA','HUARICOLCA',1),(10821154,'JUNIN','TARMA','HUASAHUASI',1),(10831155,'JUNIN','TARMA','LA UNION',1),(10841156,'JUNIN','TARMA','PALCA',1),(10851157,'JUNIN','TARMA','PALCAMAYO',1),(10861158,'JUNIN','TARMA','SAN PEDRO DE CAJAS',1),(10871159,'JUNIN','TARMA','TAPO',1),(10881161,'JUNIN','YAULI','LA OROYA',1),(10891162,'JUNIN','YAULI','CHACAPALPA',1),(10901163,'JUNIN','YAULI','HUAY HUAY',1),(10911164,'JUNIN','YAULI','MARCAPOMACOCHA',1),(10921165,'JUNIN','YAULI','MOROCOCHA',1),(10931166,'JUNIN','YAULI','PACCHA',1),(10941167,'JUNIN','YAULI','STA BARBARA DE CARHUACAYAN',1),(10951168,'JUNIN','YAULI','SUITUCANCHA',1),(10961169,'JUNIN','YAULI','YAULI',1),(10981171,'JUNIN','SATIPO','SATIPO',1),(10991172,'JUNIN','SATIPO','COVIRIALI',1),(11001173,'JUNIN','SATIPO','LLAYLLA',1),(11011174,'JUNIN','SATIPO','MAZAMARI',1),(11021175,'JUNIN','SATIPO','PAMPA HERMOSA',1),(11031176,'JUNIN','SATIPO','PANGOA',1),(11041177,'JUNIN','SATIPO','RIO NEGRO',1),(11051178,'JUNIN','SATIPO','RIO TAMBO',1),(11061181,'JUNIN','CHANCHAMAYO','CHANCHAMAYO',1),(11071182,'JUNIN','CHANCHAMAYO','SAN RAMON',1),(11081183,'JUNIN','CHANCHAMAYO','VITOC',1),(11091184,'JUNIN','CHANCHAMAYO','SAN LUIS DE SHUARO',1),(11101185,'JUNIN','CHANCHAMAYO','PICHANAQUI',1),(11111186,'JUNIN','CHANCHAMAYO','PERENE',1),(11121191,'JUNIN','CHUPACA','CHUPACA',1),(11131192,'JUNIN','CHUPACA','AHUAC',1),(11141193,'JUNIN','CHUPACA','CHONGOS BAJO',1),(11151194,'JUNIN','CHUPACA','HUACHAC',1),(11161195,'JUNIN','CHUPACA','HUAMANCACA CHICO',1),(11171196,'JUNIN','CHUPACA','SAN JUAN DE ISCOS',1),(11181197,'JUNIN','CHUPACA','SAN JUAN DE JARPA',1),(11191198,'JUNIN','CHUPACA','TRES DE DICIEMBRE',1),(11201199,'JUNIN','CHUPACA','YANACANCHA',1),(11211211,'LA LIBERTAD','TRUJILLO','TRUJILLO',1),(11221212,'LA LIBERTAD','TRUJILLO','HUANCHACO',1),(11231213,'LA LIBERTAD','TRUJILLO','LAREDO',1),(11241214,'LA LIBERTAD','TRUJILLO','MOCHE',1),(11251215,'LA LIBERTAD','TRUJILLO','SALAVERRY',1),(11261216,'LA LIBERTAD','TRUJILLO','SIMBAL',1),(11271217,'LA LIBERTAD','TRUJILLO','VICTOR LARCO HERRERA',1),(11281219,'LA LIBERTAD','TRUJILLO','POROTO',1),(11321221,'LA LIBERTAD','BOLIVAR','BOLIVAR',1),(11331222,'LA LIBERTAD','BOLIVAR','BAMBAMARCA',1),(11341223,'LA LIBERTAD','BOLIVAR','CONDORMARCA',1),(11351224,'LA LIBERTAD','BOLIVAR','LONGOTEA',1),(11361225,'LA LIBERTAD','BOLIVAR','UCUNCHA',1),(11371226,'LA LIBERTAD','BOLIVAR','UCHUMARCA',1),(11381231,'LA LIBERTAD','SANCHEZ CARRION','HUAMACHUCO',1),(11391232,'LA LIBERTAD','SANCHEZ CARRION','COCHORCO',1),(11401233,'LA LIBERTAD','SANCHEZ CARRION','CURGOS',1),(11411234,'LA LIBERTAD','SANCHEZ CARRION','CHUGAY',1),(11421235,'LA LIBERTAD','SANCHEZ CARRION','MARCABAL',1),(11431236,'LA LIBERTAD','SANCHEZ CARRION','SANAGORAN',1),(11441237,'LA LIBERTAD','SANCHEZ CARRION','SARIN',1),(11451238,'LA LIBERTAD','SANCHEZ CARRION','SARTIMBAMBA',1),(11461241,'LA LIBERTAD','OTUZCO','OTUZCO',1),(11471242,'LA LIBERTAD','OTUZCO','AGALLPAMPA',1),(11481243,'LA LIBERTAD','OTUZCO','CHARAT',1),(11491244,'LA LIBERTAD','OTUZCO','HUARANCHAL',1),(11501245,'LA LIBERTAD','OTUZCO','LA CUESTA',1),(11511248,'LA LIBERTAD','OTUZCO','PARANDAY',1),(11521249,'LA LIBERTAD','OTUZCO','SALPO',1),(11561251,'LA LIBERTAD','PACASMAYO','SAN PEDRO DE LLOC',1),(11571253,'LA LIBERTAD','PACASMAYO','GUADALUPE',1),(11581254,'LA LIBERTAD','PACASMAYO','JEQUETEPEQUE',1),(11591256,'LA LIBERTAD','PACASMAYO','PACASMAYO',1),(11601258,'LA LIBERTAD','PACASMAYO','SAN JOSE',1),(11611261,'LA LIBERTAD','PATAZ','TAYABAMBA',1),(11621262,'LA LIBERTAD','PATAZ','BULDIBUYO',1),(11631263,'LA LIBERTAD','PATAZ','CHILLIA',1),(11641264,'LA LIBERTAD','PATAZ','HUAYLILLAS',1),(11651265,'LA LIBERTAD','PATAZ','HUANCASPATA',1),(11661266,'LA LIBERTAD','PATAZ','HUAYO',1),(11671267,'LA LIBERTAD','PATAZ','ONGON',1),(11681268,'LA LIBERTAD','PATAZ','PARCOY',1),(11691269,'LA LIBERTAD','PATAZ','PATAZ',1),(11741271,'LA LIBERTAD','SANTIAGO DE CHUCO','SANTIAGO DE CHUCO',1),(11751272,'LA LIBERTAD','SANTIAGO DE CHUCO','CACHICADAN',1),(11761273,'LA LIBERTAD','SANTIAGO DE CHUCO','MOLLEBAMBA',1),(11771274,'LA LIBERTAD','SANTIAGO DE CHUCO','MOLLEPATA',1),(11781275,'LA LIBERTAD','SANTIAGO DE CHUCO','QUIRUVILCA',1),(11791276,'LA LIBERTAD','SANTIAGO DE CHUCO','SANTA CRUZ DE CHUCA',1),(11801277,'LA LIBERTAD','SANTIAGO DE CHUCO','SITABAMBA',1),(11811278,'LA LIBERTAD','SANTIAGO DE CHUCO','ANGASMARCA',1),(11821281,'LA LIBERTAD','ASCOPE','ASCOPE',1),(11831282,'LA LIBERTAD','ASCOPE','CHICAMA',1),(11841283,'LA LIBERTAD','ASCOPE','CHOCOPE',1),(11851284,'LA LIBERTAD','ASCOPE','SANTIAGO DE CAO',1),(11861285,'LA LIBERTAD','ASCOPE','MAGDALENA DE CAO',1),(11871286,'LA LIBERTAD','ASCOPE','PAIJAN',1),(11881287,'LA LIBERTAD','ASCOPE','RAZURI',1),(11891288,'LA LIBERTAD','ASCOPE','CASA GRANDE',1),(11901291,'LA LIBERTAD','CHEPEN','CHEPEN',1),(11911292,'LA LIBERTAD','CHEPEN','PACANGA',1),(11921293,'LA LIBERTAD','CHEPEN','PUEBLO NUEVO',1),(12041311,'LAMBAYEQUE','CHICLAYO','CHICLAYO',1),(12051312,'LAMBAYEQUE','CHICLAYO','CHONGOYAPE',1),(12061313,'LAMBAYEQUE','CHICLAYO','ETEN',1),(12071314,'LAMBAYEQUE','CHICLAYO','ETEN PUERTO',1),(12081315,'LAMBAYEQUE','CHICLAYO','LAGUNAS',1),(12091316,'LAMBAYEQUE','CHICLAYO','MONSEFU',1),(12101317,'LAMBAYEQUE','CHICLAYO','NUEVA ARICA',1),(12111318,'LAMBAYEQUE','CHICLAYO','OYOTUN',1),(12121319,'LAMBAYEQUE','CHICLAYO','PICSI',1),(12241321,'LAMBAYEQUE','FERREÃ‘AFE','FERREÃ‘AFE',1),(12251322,'LAMBAYEQUE','FERREÃ‘AFE','INCAHUASI',1),(12261323,'LAMBAYEQUE','FERREÃ‘AFE','CAÃ‘ARIS',1),(12271324,'LAMBAYEQUE','FERREÃ‘AFE','PITIPO',1),(12281325,'LAMBAYEQUE','FERREÃ‘AFE','PUEBLO NUEVO',1),(12291326,'LAMBAYEQUE','FERREÃ‘AFE','MANUEL ANTONIO MESONES MURO',1),(12301331,'LAMBAYEQUE','LAMBAYEQUE','LAMBAYEQUE',1),(12311332,'LAMBAYEQUE','LAMBAYEQUE','CHOCHOPE',1),(12321333,'LAMBAYEQUE','LAMBAYEQUE','ILLIMO',1),(12331334,'LAMBAYEQUE','LAMBAYEQUE','JAYANCA',1),(12341335,'LAMBAYEQUE','LAMBAYEQUE','MOCHUMI',1),(12351336,'LAMBAYEQUE','LAMBAYEQUE','MORROPE',1),(12361337,'LAMBAYEQUE','LAMBAYEQUE','MOTUPE',1),(12371338,'LAMBAYEQUE','LAMBAYEQUE','OLMOS',1),(12381339,'LAMBAYEQUE','LAMBAYEQUE','PACORA',1),(12421411,'LIMA','LIMA','LIMA',1),(12431412,'LIMA','LIMA','ANCON',1),(12441413,'LIMA','LIMA','ATE',1),(12451414,'LIMA','LIMA','BREÃ‘A',1),(12461415,'LIMA','LIMA','CARABAYLLO',1),(12471416,'LIMA','LIMA','COMAS',1),(12481417,'LIMA','LIMA','CHACLACAYO',1),(12491418,'LIMA','LIMA','CHORRILLOS',1),(12501419,'LIMA','LIMA','LA VICTORIA',1),(12851421,'LIMA','CAJATAMBO','CAJATAMBO',1),(12861425,'LIMA','CAJATAMBO','COPA',1),(12871426,'LIMA','CAJATAMBO','GORGOR',1),(12881427,'LIMA','CAJATAMBO','HUANCAPON',1),(12891428,'LIMA','CAJATAMBO','MANAS',1),(12901431,'LIMA','CANTA','CANTA',1),(12911432,'LIMA','CANTA','ARAHUAY',1),(12921433,'LIMA','CANTA','HUAMANTANGA',1),(12931434,'LIMA','CANTA','HUAROS',1),(12941435,'LIMA','CANTA','LACHAQUI',1),(12951436,'LIMA','CANTA','SAN BUENAVENTURA',1),(12961437,'LIMA','CANTA','SANTA ROSA DE QUIVES',1),(12971441,'LIMA','CAÃ‘ETE','SAN VICENTE DE CAÃ‘ETE',1),(12981442,'LIMA','CAÃ‘ETE','CALANGO',1),(12991443,'LIMA','CAÃ‘ETE','CERRO AZUL',1),(13001444,'LIMA','CAÃ‘ETE','COAYLLO',1),(13011445,'LIMA','CAÃ‘ETE','CHILCA',1),(13021446,'LIMA','CAÃ‘ETE','IMPERIAL',1),(13031447,'LIMA','CAÃ‘ETE','LUNAHUANA',1),(13041448,'LIMA','CAÃ‘ETE','MALA',1),(13051449,'LIMA','CAÃ‘ETE','NUEVO IMPERIAL',1),(13131451,'LIMA','HUAURA','HUACHO',1),(13141452,'LIMA','HUAURA','AMBAR',1),(13151454,'LIMA','HUAURA','CALETA DE CARQUIN',1),(13161455,'LIMA','HUAURA','CHECRAS',1),(13171456,'LIMA','HUAURA','HUALMAY',1),(13181457,'LIMA','HUAURA','HUAURA',1),(13191458,'LIMA','HUAURA','LEONCIO PRADO',1),(13201459,'LIMA','HUAURA','PACCHO',1),(13251461,'LIMA','HUAROCHIRI','MATUCANA',1),(13261462,'LIMA','HUAROCHIRI','ANTIOQUIA',1),(13271463,'LIMA','HUAROCHIRI','CALLAHUANCA',1),(13281464,'LIMA','HUAROCHIRI','CARAMPOMA',1),(13291465,'LIMA','HUAROCHIRI','CASTA',1),(13301466,'LIMA','HUAROCHIRI','SAN JOSE DE LOS CHORRILLOS',1),(13311467,'LIMA','HUAROCHIRI','CHICLA',1),(13321468,'LIMA','HUAROCHIRI','HUANZA',1),(13331469,'LIMA','HUAROCHIRI','HUAROCHIRI',1),(13571471,'LIMA','YAUYOS','YAUYOS',1),(13581472,'LIMA','YAUYOS','ALIS',1),(13591473,'LIMA','YAUYOS','AYAUCA',1),(13601474,'LIMA','YAUYOS','AYAVIRI',1),(13611475,'LIMA','YAUYOS','AZANGARO',1),(13621476,'LIMA','YAUYOS','CACRA',1),(13631477,'LIMA','YAUYOS','CARANIA',1),(13641478,'LIMA','YAUYOS','COCHAS',1),(13651479,'LIMA','YAUYOS','COLONIA',1),(13901481,'LIMA','HUARAL','HUARAL',1),(13911482,'LIMA','HUARAL','ATAVILLOS ALTO',1),(13921483,'LIMA','HUARAL','ATAVILLOS BAJO',1),(13931484,'LIMA','HUARAL','AUCALLAMA',1),(13941485,'LIMA','HUARAL','CHANCAY',1),(13951486,'LIMA','HUARAL','IHUARI',1),(13961487,'LIMA','HUARAL','LAMPIAN',1),(13971488,'LIMA','HUARAL','PACARAOS',1),(13981489,'LIMA','HUARAL','SAN MIGUEL DE ACOS',1),(14021491,'LIMA','BARRANCA','BARRANCA',1),(14031492,'LIMA','BARRANCA','PARAMONGA',1),(14041493,'LIMA','BARRANCA','PATIVILCA',1),(14051494,'LIMA','BARRANCA','SUPE',1),(14061495,'LIMA','BARRANCA','SUPE PUERTO',1),(14131511,'LORETO','MAYNAS','IQUITOS',1),(14141512,'LORETO','MAYNAS','ALTO NANAY',1),(14151513,'LORETO','MAYNAS','FERNANDO LORES',1),(14161514,'LORETO','MAYNAS','LAS AMAZONAS',1),(14171515,'LORETO','MAYNAS','MAZAN',1),(14181516,'LORETO','MAYNAS','NAPO',1),(14191517,'LORETO','MAYNAS','PUTUMAYO',1),(14201518,'LORETO','MAYNAS','TORRES CAUSANA',1),(14261521,'LORETO','ALTO AMAZONAS','YURIMAGUAS',1),(14271522,'LORETO','ALTO AMAZONAS','BALSAPUERTO',1),(14281525,'LORETO','ALTO AMAZONAS','JEBEROS',1),(14291526,'LORETO','ALTO AMAZONAS','LAGUNAS',1),(14321531,'LORETO','LORETO','NAUTA',1),(14331532,'LORETO','LORETO','PARINARI',1),(14341533,'LORETO','LORETO','TIGRE',1),(14351534,'LORETO','LORETO','URARINAS',1),(14361535,'LORETO','LORETO','TROMPETEROS',1),(14371541,'LORETO','REQUENA','REQUENA',1),(14381542,'LORETO','REQUENA','ALTO TAPICHE',1),(14391543,'LORETO','REQUENA','CAPELO',1),(14401544,'LORETO','REQUENA','EMILIO SAN MARTIN',1),(14411545,'LORETO','REQUENA','MAQUIA',1),(14421546,'LORETO','REQUENA','PUINAHUA',1),(14431547,'LORETO','REQUENA','SAPUENA',1),(14441548,'LORETO','REQUENA','SOPLIN',1),(14451549,'LORETO','REQUENA','TAPICHE',1),(14481551,'LORETO','UCAYALI','CONTAMANA',1),(14491552,'LORETO','UCAYALI','VARGAS GUERRA',1),(14501553,'LORETO','UCAYALI','PADRE MARQUEZ',1),(14511554,'LORETO','UCAYALI','PAMPA HERMOZA',1),(14521555,'LORETO','UCAYALI','SARAYACU',1),(14531556,'LORETO','UCAYALI','INAHUAYA',1),(14541561,'LORETO','MARISCAL RAMON CASTILLA','MARISCAL RAMON CASTILLA',1),(14551562,'LORETO','MARISCAL RAMON CASTILLA','PEBAS',1),(14561563,'LORETO','MARISCAL RAMON CASTILLA','YAVARI',1),(14571564,'LORETO','MARISCAL RAMON CASTILLA','SAN PABLO',1),(14581571,'LORETO','DATEM DEL MARAÃ‘ON','BARRANCA',1),(14591572,'LORETO','DATEM DEL MARAÃ‘ON','ANDOAS',1),(14601573,'LORETO','DATEM DEL MARAÃ‘ON','CAHUAPANAS',1),(14611574,'LORETO','DATEM DEL MARAÃ‘ON','MANSERICHE',1),(14621575,'LORETO','DATEM DEL MARAÃ‘ON','MORONA',1),(14631576,'LORETO','DATEM DEL MARAÃ‘ON','PASTAZA',1),(14641611,'MADRE DE DIOS','TAMBOPATA','TAMBOPATA',1),(14651612,'MADRE DE DIOS','TAMBOPATA','INAMBARI',1),(14661613,'MADRE DE DIOS','TAMBOPATA','LAS PIEDRAS',1),(14671614,'MADRE DE DIOS','TAMBOPATA','LABERINTO',1),(14681621,'MADRE DE DIOS','MANU','MANU',1),(14691622,'MADRE DE DIOS','MANU','FITZCARRALD',1),(14701623,'MADRE DE DIOS','MANU','MADRE DE DIOS',1),(14711624,'MADRE DE DIOS','MANU','HUEPETUHE',1),(14721631,'MADRE DE DIOS','TAHUAMANU','IÃ‘APARI',1),(14731632,'MADRE DE DIOS','TAHUAMANU','IBERIA',1),(14741633,'MADRE DE DIOS','TAHUAMANU','TAHUAMANU',1),(14751711,'MOQUEGUA','MARISCAL NIETO','MOQUEGUA',1),(14761712,'MOQUEGUA','MARISCAL NIETO','CARUMAS',1),(14771713,'MOQUEGUA','MARISCAL NIETO','CUCHUMBAYA',1),(14781714,'MOQUEGUA','MARISCAL NIETO','SAN CRISTOBAL',1),(14791715,'MOQUEGUA','MARISCAL NIETO','TORATA',1),(14801716,'MOQUEGUA','MARISCAL NIETO','SAMEGUA',1),(14811721,'MOQUEGUA','GENERAL SANCHEZ CERRO','OMATE',1),(14821722,'MOQUEGUA','GENERAL SANCHEZ CERRO','COALAQUE',1),(14831723,'MOQUEGUA','GENERAL SANCHEZ CERRO','CHOJATA',1),(14841724,'MOQUEGUA','GENERAL SANCHEZ CERRO','ICHUÃ‘A',1),(14851725,'MOQUEGUA','GENERAL SANCHEZ CERRO','LA CAPILLA',1),(14861726,'MOQUEGUA','GENERAL SANCHEZ CERRO','LLOQUE',1),(14871727,'MOQUEGUA','GENERAL SANCHEZ CERRO','MATALAQUE',1),(14881728,'MOQUEGUA','GENERAL SANCHEZ CERRO','PUQUINA',1),(14891729,'MOQUEGUA','GENERAL SANCHEZ CERRO','QUINISTAQUILLAS',1),(14921731,'MOQUEGUA','ILO','ILO',1),(14931732,'MOQUEGUA','ILO','EL ALGARROBAL',1),(14941733,'MOQUEGUA','ILO','PACOCHA',1),(14951811,'PASCO','PASCO','CHAUPIMARCA',1),(14961813,'PASCO','PASCO','HUACHON',1),(14971814,'PASCO','PASCO','HUARIACA',1),(14981815,'PASCO','PASCO','HUAYLLAY',1),(14991816,'PASCO','PASCO','NINACACA',1),(15001817,'PASCO','PASCO','PALLANCHACRA',1),(15011818,'PASCO','PASCO','PAUCARTAMBO',1),(15021819,'PASCO','PASCO','SAN FCO DE ASIS DE YARUSYACAN',1),(15081821,'PASCO','DANIEL ALCIDES CARRION','YANAHUANCA',1),(15091822,'PASCO','DANIEL ALCIDES CARRION','CHACAYAN',1),(15101823,'PASCO','DANIEL ALCIDES CARRION','GOYLLARISQUIZGA',1),(15111824,'PASCO','DANIEL ALCIDES CARRION','PAUCAR',1),(15121825,'PASCO','DANIEL ALCIDES CARRION','SAN PEDRO DE PILLAO',1),(15131826,'PASCO','DANIEL ALCIDES CARRION','SANTA ANA DE TUSI',1),(15141827,'PASCO','DANIEL ALCIDES CARRION','TAPUC',1),(15151828,'PASCO','DANIEL ALCIDES CARRION','VILCABAMBA',1),(15161831,'PASCO','OXAPAMPA','OXAPAMPA',1),(15171832,'PASCO','OXAPAMPA','CHONTABAMBA',1),(15181833,'PASCO','OXAPAMPA','HUANCABAMBA',1),(15191834,'PASCO','OXAPAMPA','PUERTO BERMUDEZ',1),(15201835,'PASCO','OXAPAMPA','VILLA RICA',1),(15211836,'PASCO','OXAPAMPA','POZUZO',1),(15221837,'PASCO','OXAPAMPA','PALCAZU',1),(15231911,'PIURA','PIURA','PIURA',1),(15241913,'PIURA','PIURA','CASTILLA',1),(15251914,'PIURA','PIURA','CATACAOS',1),(15261915,'PIURA','PIURA','LA ARENA',1),(15271916,'PIURA','PIURA','LA UNION',1),(15281917,'PIURA','PIURA','LAS LOMAS',1),(15291919,'PIURA','PIURA','TAMBO GRANDE',1),(15321921,'PIURA','AYABACA','AYABACA',1),(15331922,'PIURA','AYABACA','FRIAS',1),(15341923,'PIURA','AYABACA','LAGUNAS',1),(15351924,'PIURA','AYABACA','MONTERO',1),(15361925,'PIURA','AYABACA','PACAIPAMPA',1),(15371926,'PIURA','AYABACA','SAPILLICA',1),(15381927,'PIURA','AYABACA','SICCHEZ',1),(15391928,'PIURA','AYABACA','SUYO',1),(15401929,'PIURA','AYABACA','JILILI',1),(15421931,'PIURA','HUANCABAMBA','HUANCABAMBA',1),(15431932,'PIURA','HUANCABAMBA','CANCHAQUE',1),(15441933,'PIURA','HUANCABAMBA','HUARMACA',1),(15451934,'PIURA','HUANCABAMBA','SONDOR',1),(15461935,'PIURA','HUANCABAMBA','SONDORILLO',1),(15471936,'PIURA','HUANCABAMBA','EL CARMEN DE LA FRONTERA',1),(15481937,'PIURA','HUANCABAMBA','SAN MIGUEL DE EL FAIQUE',1),(15491938,'PIURA','HUANCABAMBA','LALAQUIZ',1),(15501941,'PIURA','MORROPON','CHULUCANAS',1),(15511942,'PIURA','MORROPON','BUENOS AIRES',1),(15521943,'PIURA','MORROPON','CHALACO',1),(15531944,'PIURA','MORROPON','MORROPON',1),(15541945,'PIURA','MORROPON','SALITRAL',1),(15551946,'PIURA','MORROPON','SANTA CATALINA DE MOSSA',1),(15561947,'PIURA','MORROPON','SANTO DOMINGO',1),(15571948,'PIURA','MORROPON','LA MATANZA',1),(15581949,'PIURA','MORROPON','YAMANGO',1),(15601951,'PIURA','PAITA','PAITA',1),(15611952,'PIURA','PAITA','AMOTAPE',1),(15621953,'PIURA','PAITA','ARENAL',1),(15631954,'PIURA','PAITA','LA HUACA',1),(15641955,'PIURA','PAITA','PUEBLO NUEVO DE COLAN',1),(15651956,'PIURA','PAITA','TAMARINDO',1),(15661957,'PIURA','PAITA','VICHAYAL',1),(15671961,'PIURA','SULLANA','SULLANA',1),(15681962,'PIURA','SULLANA','BELLAVISTA',1),(15691963,'PIURA','SULLANA','LANCONES',1),(15701964,'PIURA','SULLANA','MARCAVELICA',1),(15711965,'PIURA','SULLANA','MIGUEL CHECA',1),(15721966,'PIURA','SULLANA','QUERECOTILLO',1),(15731967,'PIURA','SULLANA','SALITRAL',1),(15741968,'PIURA','SULLANA','IGNACIO ESCUDERO',1),(15751971,'PIURA','TALARA','PARIÃ‘AS',1),(15761972,'PIURA','TALARA','EL ALTO',1),(15771973,'PIURA','TALARA','LA BREA',1),(15781974,'PIURA','TALARA','LOBITOS',1),(15791975,'PIURA','TALARA','MANCORA',1),(15801976,'PIURA','TALARA','LOS ORGANOS',1),(15811981,'PIURA','SECHURA','SECHURA',1),(15821982,'PIURA','SECHURA','VICE',1),(15831983,'PIURA','SECHURA','BERNAL',1),(15841984,'PIURA','SECHURA','BELLAVISTA DE LA UNION',1),(15851985,'PIURA','SECHURA','CRISTO NOS VALGA',1),(15861986,'PIURA','SECHURA','RINCONADA LLICUAR',1),(15872011,'PUNO','PUNO','PUNO',1),(15882012,'PUNO','PUNO','ACORA',1),(15892013,'PUNO','PUNO','ATUNCOLLA',1),(15902014,'PUNO','PUNO','CAPACHICA',1),(15912015,'PUNO','PUNO','COATA',1),(15922016,'PUNO','PUNO','CHUCUITO',1),(15932017,'PUNO','PUNO','HUATA',1),(15942018,'PUNO','PUNO','MAÃ‘AZO',1),(15952019,'PUNO','PUNO','PAUCARCOLLA',1),(16022021,'PUNO','AZANGARO','AZANGARO',1),(16032022,'PUNO','AZANGARO','ACHAYA',1),(16042023,'PUNO','AZANGARO','ARAPA',1),(16052024,'PUNO','AZANGARO','ASILLO',1),(16062025,'PUNO','AZANGARO','CAMINACA',1),(16072026,'PUNO','AZANGARO','CHUPA',1),(16082027,'PUNO','AZANGARO','JOSE DOMINGO CHOQUEHUANCA',1),(16092028,'PUNO','AZANGARO','MUÃ‘ANI',1),(16172031,'PUNO','CARABAYA','MACUSANI',1),(16182032,'PUNO','CARABAYA','AJOYANI',1),(16192033,'PUNO','CARABAYA','AYAPATA',1),(16202034,'PUNO','CARABAYA','COASA',1),(16212035,'PUNO','CARABAYA','CORANI',1),(16222036,'PUNO','CARABAYA','CRUCERO',1),(16232037,'PUNO','CARABAYA','ITUATA',1),(16242038,'PUNO','CARABAYA','OLLACHEA',1),(16252039,'PUNO','CARABAYA','SAN GABAN',1),(16272041,'PUNO','CHUCUITO','JULI',1),(16282042,'PUNO','CHUCUITO','DESAGUADERO',1),(16292043,'PUNO','CHUCUITO','HUACULLANI',1),(16302046,'PUNO','CHUCUITO','PISACOMA',1),(16312047,'PUNO','CHUCUITO','POMATA',1),(16342051,'PUNO','HUANCANE','HUANCANE',1),(16352052,'PUNO','HUANCANE','COJATA',1),(16362054,'PUNO','HUANCANE','INCHUPALLA',1),(16372056,'PUNO','HUANCANE','PUSI',1),(16382057,'PUNO','HUANCANE','ROSASPATA',1),(16392058,'PUNO','HUANCANE','TARACO',1),(16402059,'PUNO','HUANCANE','VILQUE CHICO',1),(16422061,'PUNO','LAMPA','LAMPA',1),(16432062,'PUNO','LAMPA','CABANILLA',1),(16442063,'PUNO','LAMPA','CALAPUJA',1),(16452064,'PUNO','LAMPA','NICASIO',1),(16462065,'PUNO','LAMPA','OCUVIRI',1),(16472066,'PUNO','LAMPA','PALCA',1),(16482067,'PUNO','LAMPA','PARATIA',1),(16492068,'PUNO','LAMPA','PUCARA',1),(16502069,'PUNO','LAMPA','SANTA LUCIA',1),(16522071,'PUNO','MELGAR','AYAVIRI',1),(16532072,'PUNO','MELGAR','ANTAUTA',1),(16542073,'PUNO','MELGAR','CUPI',1),(16552074,'PUNO','MELGAR','LLALLI',1),(16562075,'PUNO','MELGAR','MACARI',1),(16572076,'PUNO','MELGAR','NUÃ‘OA',1),(16582077,'PUNO','MELGAR','ORURILLO',1),(16592078,'PUNO','MELGAR','SANTA ROSA',1),(16602079,'PUNO','MELGAR','UMACHIRI',1),(16612081,'PUNO','SANDIA','SANDIA',1),(16622083,'PUNO','SANDIA','CUYOCUYO',1),(16632084,'PUNO','SANDIA','LIMBANI',1),(16642085,'PUNO','SANDIA','PHARA',1),(16652086,'PUNO','SANDIA','PATAMBUCO',1),(16662087,'PUNO','SANDIA','QUIACA',1),(16672088,'PUNO','SANDIA','SAN JUAN DEL ORO',1),(16712091,'PUNO','SAN ROMAN','JULIACA',1),(16722092,'PUNO','SAN ROMAN','CABANA',1),(16732093,'PUNO','SAN ROMAN','CABANILLAS',1),(16742094,'PUNO','SAN ROMAN','CARACOTO',1),(16962111,'SAN MARTIN','MOYOBAMBA','MOYOBAMBA',1),(16972112,'SAN MARTIN','MOYOBAMBA','CALZADA',1),(16982113,'SAN MARTIN','MOYOBAMBA','HABANA',1),(16992114,'SAN MARTIN','MOYOBAMBA','JEPELACIO',1),(17002115,'SAN MARTIN','MOYOBAMBA','SORITOR',1),(17012116,'SAN MARTIN','MOYOBAMBA','YANTALO',1),(17022121,'SAN MARTIN','HUALLAGA','SAPOSOA',1),(17032122,'SAN MARTIN','HUALLAGA','PISCOYACU',1),(17042123,'SAN MARTIN','HUALLAGA','SACANCHE',1),(17052124,'SAN MARTIN','HUALLAGA','TINGO DE SAPOSOA',1),(17062125,'SAN MARTIN','HUALLAGA','ALTO SAPOSOA',1),(17072126,'SAN MARTIN','HUALLAGA','EL ESLABON',1),(17082131,'SAN MARTIN','LAMAS','LAMAS',1),(17092133,'SAN MARTIN','LAMAS','BARRANQUITA',1),(17102134,'SAN MARTIN','LAMAS','CAYNARACHI',1),(17112135,'SAN MARTIN','LAMAS','CUÃ‘UMBUQUI',1),(17122136,'SAN MARTIN','LAMAS','PINTO RECODO',1),(17132137,'SAN MARTIN','LAMAS','RUMISAPA',1),(17192141,'SAN MARTIN','MARISCAL CACERES','JUANJUI',1),(17202142,'SAN MARTIN','MARISCAL CACERES','CAMPANILLA',1),(17212143,'SAN MARTIN','MARISCAL CACERES','HUICUNGO',1),(17222144,'SAN MARTIN','MARISCAL CACERES','PACHIZA',1),(17232145,'SAN MARTIN','MARISCAL CACERES','PAJARILLO',1),(17242151,'SAN MARTIN','RIOJA','RIOJA',1),(17252152,'SAN MARTIN','RIOJA','POSIC',1),(17262153,'SAN MARTIN','RIOJA','YORONGOS',1),(17272154,'SAN MARTIN','RIOJA','YURACYACU',1),(17282155,'SAN MARTIN','RIOJA','NUEVA CAJAMARCA',1),(17292156,'SAN MARTIN','RIOJA','ELIAS SOPLIN',1),(17302157,'SAN MARTIN','RIOJA','SAN FERNANDO',1),(17312158,'SAN MARTIN','RIOJA','PARDO MIGUEL',1),(17322159,'SAN MARTIN','RIOJA','AWAJUN',1),(17332161,'SAN MARTIN','SAN MARTIN','TARAPOTO',1),(17342162,'SAN MARTIN','SAN MARTIN','ALBERTO LEVEAU',1),(17352164,'SAN MARTIN','SAN MARTIN','CACATACHI',1),(17362166,'SAN MARTIN','SAN MARTIN','CHAZUTA',1),(17372167,'SAN MARTIN','SAN MARTIN','CHIPURANA',1),(17382168,'SAN MARTIN','SAN MARTIN','EL PORVENIR',1),(17392169,'SAN MARTIN','SAN MARTIN','HUIMBAYOC',1),(17472171,'SAN MARTIN','BELLAVISTA','BELLAVISTA',1),(17482172,'SAN MARTIN','BELLAVISTA','SAN RAFAEL',1),(17492173,'SAN MARTIN','BELLAVISTA','SAN PABLO',1),(17502174,'SAN MARTIN','BELLAVISTA','ALTO BIAVO',1),(17512175,'SAN MARTIN','BELLAVISTA','HUALLAGA',1),(17522176,'SAN MARTIN','BELLAVISTA','BAJO BIAVO',1),(17532181,'SAN MARTIN','TOCACHE','TOCACHE',1),(17542182,'SAN MARTIN','TOCACHE','NUEVO PROGRESO',1),(17552183,'SAN MARTIN','TOCACHE','POLVORA',1),(17562184,'SAN MARTIN','TOCACHE','SHUNTE',1),(17572185,'SAN MARTIN','TOCACHE','UCHIZA',1),(17582191,'SAN MARTIN','PICOTA','PICOTA',1),(17592192,'SAN MARTIN','PICOTA','BUENOS AIRES',1),(17602193,'SAN MARTIN','PICOTA','CASPIZAPA',1),(17612194,'SAN MARTIN','PICOTA','PILLUANA',1),(17622195,'SAN MARTIN','PICOTA','PUCACACA',1),(17632196,'SAN MARTIN','PICOTA','SAN CRISTOBAL',1),(17642197,'SAN MARTIN','PICOTA','SAN HILARION',1),(17652198,'SAN MARTIN','PICOTA','TINGO DE PONASA',1),(17662199,'SAN MARTIN','PICOTA','TRES UNIDOS',1),(17732211,'TACNA','TACNA','TACNA',1),(17742212,'TACNA','TACNA','CALANA',1),(17752214,'TACNA','TACNA','INCLAN',1),(17762217,'TACNA','TACNA','PACHIA',1),(17772218,'TACNA','TACNA','PALCA',1),(17782219,'TACNA','TACNA','POCOLLAY',1),(17832221,'TACNA','TARATA','TARATA',1),(17842225,'TACNA','TARATA','HEROES ALBARRACIN',1),(17852226,'TACNA','TARATA','ESTIQUE',1),(17862227,'TACNA','TARATA','ESTIQUE PAMPA',1),(17912231,'TACNA','JORGE BASADRE','LOCUMBA',1),(17922232,'TACNA','JORGE BASADRE','ITE',1),(17932233,'TACNA','JORGE BASADRE','ILABAYA',1),(17942241,'TACNA','CANDARAVE','CANDARAVE',1),(17952242,'TACNA','CANDARAVE','CAIRANI',1),(17962243,'TACNA','CANDARAVE','CURIBAYA',1),(17972244,'TACNA','CANDARAVE','HUANUARA',1),(17982245,'TACNA','CANDARAVE','QUILAHUANI',1),(17992246,'TACNA','CANDARAVE','CAMILACA',1),(18002311,'TUMBES','TUMBES','TUMBES',1),(18012312,'TUMBES','TUMBES','CORRALES',1),(18022313,'TUMBES','TUMBES','LA CRUZ',1),(18032314,'TUMBES','TUMBES','PAMPAS DE HOSPITAL',1),(18042315,'TUMBES','TUMBES','SAN JACINTO',1),(18052316,'TUMBES','TUMBES','SAN JUAN DE LA VIRGEN',1),(18062321,'TUMBES','CONTRALMIRANTE VILLAR','ZORRITOS',1),(18072322,'TUMBES','CONTRALMIRANTE VILLAR','CASITAS',1),(18082323,'TUMBES','CONTRALMIRANTE VILLAR','CANOAS DE PUNTA SAL',1),(18092331,'TUMBES','ZARUMILLA','ZARUMILLA',1),(18102332,'TUMBES','ZARUMILLA','MATAPALO',1),(18112333,'TUMBES','ZARUMILLA','PAPAYAL',1),(18121010,'ANCASH','PALLASCA','SANTA ROSA',1),(18122334,'TUMBES','ZARUMILLA','AGUAS VERDES',1),(18132411,'REGION CALLAO','CALLAO','CALLAO',1),(18142412,'REGION CALLAO','CALLAO','BELLAVISTA',1),(18152413,'REGION CALLAO','CALLAO','LA PUNTA',1),(18162414,'REGION CALLAO','CALLAO','CARMEN DE LA LEGUA-REYNOSO',1),(18172415,'REGION CALLAO','CALLAO','LA PERLA',1),(18182416,'REGION CALLAO','CALLAO','VENTANILLA',1),(18192511,'UCAYALI','CORONEL PORTILLO','CALLERIA',1),(18202512,'UCAYALI','CORONEL PORTILLO','YARINACOCHA',1),(18212513,'UCAYALI','CORONEL PORTILLO','MASISEA',1),(18221011,'ANCASH','PALLASCA','TAUCA',1),(18222514,'UCAYALI','CORONEL PORTILLO','CAMPOVERDE',1),(18232515,'UCAYALI','CORONEL PORTILLO','IPARIA',1),(18242516,'UCAYALI','CORONEL PORTILLO','NUEVA REQUENA',1),(18252517,'UCAYALI','CORONEL PORTILLO','MANANTAY',1),(18262521,'UCAYALI','PADRE ABAD','PADRE ABAD',1),(18272522,'UCAYALI','PADRE ABAD','YRAZOLA',1),(18282523,'UCAYALI','PADRE ABAD','CURIMANA',1),(18292531,'UCAYALI','ATALAYA','RAIMONDI',1),(18302532,'UCAYALI','ATALAYA','TAHUANIA',1),(18312533,'UCAYALI','ATALAYA','YURUA',1),(18322534,'UCAYALI','ATALAYA','SEPAHUA',1),(18332541,'UCAYALI','PURUS','PURUS',1),(19621210,'ANCASH','RECUAY','CATAC',1),(21521410,'ANCASH','SIHUAS','SAN JUAN',1),(24922010,'ANCASH','OCROS','SANTIAGO DE CHILCAS',1),(53851010,'AYACUCHO','PAUCAR DEL SARA SARA','SARA SARA',1),(54851110,'AYACUCHO','SUCRE','CHILCAYOC',1),(54951111,'AYACUCHO','SUCRE','MORCOLLA',1),(65561010,'CAJAMARCA','SAN MIGUEL','UNION AGUA BLANCA',1),(65661011,'CAJAMARCA','SAN MIGUEL','TONGOD',1),(65761012,'CAJAMARCA','SAN MIGUEL','CATILLUC',1),(65861013,'CAJAMARCA','SAN MIGUEL','BOLIVAR',1),(77571210,'CUSCO','QUISPICANCHI','OCONGATE',1),(77671211,'CUSCO','QUISPICANCHI','OROPESA',1),(77771212,'CUSCO','QUISPICANCHI','QUIQUIJANA',1),(96410110,'ICA','ICA','SUBTANJALLA',1),(96510111,'ICA','ICA','YAUCA DEL ROSARIO',1),(96610112,'ICA','ICA','TATE',1),(96710113,'ICA','ICA','PACHACUTEC',1),(96810114,'ICA','ICA','OCUCAJE',1),(97810210,'ICA','CHINCHA','PUEBLO NUEVO',1),(97910211,'ICA','CHINCHA','SAN JUAN DE YANAC',1),(100611112,'JUNIN','HUANCAYO','CHUPURO',1),(100711113,'JUNIN','HUANCAYO','EL TAMBO',1),(100811114,'JUNIN','HUANCAYO','HUACRAPUQUIO',1),(100911116,'JUNIN','HUANCAYO','HUALHUAS',1),(101011118,'JUNIN','HUANCAYO','HUANCAN',1),(101111119,'JUNIN','HUANCAYO','HUASICANCHA',1),(101211120,'JUNIN','HUANCAYO','HUAYUCACHI',1),(101311121,'JUNIN','HUANCAYO','INGENIO',1),(101411122,'JUNIN','HUANCAYO','PARIAHUANCA',1),(101511123,'JUNIN','HUANCAYO','PILCOMAYO',1),(101611124,'JUNIN','HUANCAYO','PUCARA',1),(101711125,'JUNIN','HUANCAYO','QUICHUAY',1),(101811126,'JUNIN','HUANCAYO','QUILCAS',1),(101911127,'JUNIN','HUANCAYO','SAN AGUSTIN',1),(102011128,'JUNIN','HUANCAYO','SAN JERONIMO DE TUNAN',1),(102111131,'JUNIN','HUANCAYO','STO DOMINGO DE ACOBAMBA',1),(102211132,'JUNIN','HUANCAYO','SAÃ‘O',1),(102311133,'JUNIN','HUANCAYO','SAPALLANGA',1),(102411134,'JUNIN','HUANCAYO','SICAYA',1),(102511136,'JUNIN','HUANCAYO','VIQUES',1),(103511210,'JUNIN','CONCEPCION','MATAHUASI',1),(103611211,'JUNIN','CONCEPCION','MITO',1),(103711212,'JUNIN','CONCEPCION','NUEVE DE JULIO',1),(103811213,'JUNIN','CONCEPCION','ORCOTUNA',1),(103911214,'JUNIN','CONCEPCION','STA ROSA DE OCOPA',1),(104011215,'JUNIN','CONCEPCION','SAN JOSE DE QUERO',1),(105011310,'JUNIN','JAUJA','JANJAILLO',1),(105111311,'JUNIN','JAUJA','JULCAN',1),(105211312,'JUNIN','JAUJA','LEONOR ORDOÃ‘EZ',1),(105311313,'JUNIN','JAUJA','LLOCLLAPAMPA',1),(105411314,'JUNIN','JAUJA','MARCO',1),(105511315,'JUNIN','JAUJA','MASMA',1),(105611316,'JUNIN','JAUJA','MOLINOS',1),(105711317,'JUNIN','JAUJA','MONOBAMBA',1),(105811318,'JUNIN','JAUJA','MUQUI',1),(105911319,'JUNIN','JAUJA','MUQUIYAUYO',1),(106011320,'JUNIN','JAUJA','PACA',1),(106111321,'JUNIN','JAUJA','PACCHA',1),(106211322,'JUNIN','JAUJA','PANCAN',1),(106311323,'JUNIN','JAUJA','PARCO',1),(106411324,'JUNIN','JAUJA','POMACANCHA',1),(106511325,'JUNIN','JAUJA','RICRAN',1),(106611326,'JUNIN','JAUJA','SAN LORENZO',1),(106711327,'JUNIN','JAUJA','SAN PEDRO DE CHUNAN',1),(106811328,'JUNIN','JAUJA','SINCOS',1),(106911329,'JUNIN','JAUJA','TUNAN MARCA',1),(107011330,'JUNIN','JAUJA','YAULI',1),(107111331,'JUNIN','JAUJA','CURICACA',1),(107211332,'JUNIN','JAUJA','MASMA CHICCHE',1),(107311333,'JUNIN','JAUJA','SAUSA',1),(107411334,'JUNIN','JAUJA','YAUYOS',1),(109711610,'JUNIN','YAULI','STA ROSA DE SACCO',1),(112912110,'LA LIBERTAD','TRUJILLO','EL PORVENIR',1),(113012111,'LA LIBERTAD','TRUJILLO','LA ESPERANZA',1),(113112112,'LA LIBERTAD','TRUJILLO','FLORENCIA DE MORA',1),(115312410,'LA LIBERTAD','OTUZCO','SINSICAP',1),(115412411,'LA LIBERTAD','OTUZCO','USQUIL',1),(115512413,'LA LIBERTAD','OTUZCO','MACHE',1),(117012610,'LA LIBERTAD','PATAZ','PIAS',1),(117112611,'LA LIBERTAD','PATAZ','TAURIJA',1),(117212612,'LA LIBERTAD','PATAZ','URPAY',1),(117312613,'LA LIBERTAD','PATAZ','SANTIAGO DE CHALLAS',1),(119312101,'LA LIBERTAD','JULCAN','JULCAN',1),(119412102,'LA LIBERTAD','JULCAN','CARABAMBA',1),(119512103,'LA LIBERTAD','JULCAN','CALAMARCA',1),(119612104,'LA LIBERTAD','JULCAN','HUASO',1),(119712111,'LA LIBERTAD','GRAN CHIMU','CASCAS',1),(119812112,'LA LIBERTAD','GRAN CHIMU','LUCMA',1),(119912113,'LA LIBERTAD','GRAN CHIMU','MARMOT',1),(120012114,'LA LIBERTAD','GRAN CHIMU','SAYAPULLO',1),(120112121,'LA LIBERTAD','VIRU','VIRU',1),(120212122,'LA LIBERTAD','VIRU','CHAO',1),(120312123,'LA LIBERTAD','VIRU','GUADALUPITO',1),(121313110,'LAMBAYEQUE','CHICLAYO','PIMENTEL',1),(121413111,'LAMBAYEQUE','CHICLAYO','REQUE',1),(121513112,'LAMBAYEQUE','CHICLAYO','JOSE LEONARDO ORTIZ',1),(121613113,'LAMBAYEQUE','CHICLAYO','SANTA ROSA',1),(121713114,'LAMBAYEQUE','CHICLAYO','SAÃ‘A',1),(121813115,'LAMBAYEQUE','CHICLAYO','LA VICTORIA',1),(121913116,'LAMBAYEQUE','CHICLAYO','CAYALTI',1),(122013117,'LAMBAYEQUE','CHICLAYO','PATAPO',1),(122113118,'LAMBAYEQUE','CHICLAYO','POMALCA',1),(122213119,'LAMBAYEQUE','CHICLAYO','PUCALA',1),(122313120,'LAMBAYEQUE','CHICLAYO','TUMAN',1),(123913310,'LAMBAYEQUE','LAMBAYEQUE','SALAS',1),(124013311,'LAMBAYEQUE','LAMBAYEQUE','SAN JOSE',1),(124113312,'LAMBAYEQUE','LAMBAYEQUE','TUCUME',1),(125114110,'LIMA','LIMA','LA MOLINA',1),(125214111,'LIMA','LIMA','LINCE',1),(125314112,'LIMA','LIMA','LURIGANCHO',1),(125414113,'LIMA','LIMA','LURIN',1),(125514114,'LIMA','LIMA','MAGDALENA DEL MAR',1),(125614115,'LIMA','LIMA','MIRAFLORES',1),(125714116,'LIMA','LIMA','PACHACAMAC',1),(125814117,'LIMA','LIMA','PUEBLO LIBRE',1),(125914118,'LIMA','LIMA','PUCUSANA',1),(126014119,'LIMA','LIMA','PUENTE PIEDRA',1),(126114120,'LIMA','LIMA','PUNTA HERMOSA',1),(126214121,'LIMA','LIMA','PUNTA NEGRA',1),(126314122,'LIMA','LIMA','RIMAC',1),(126414123,'LIMA','LIMA','SAN BARTOLO',1),(126514124,'LIMA','LIMA','SAN ISIDRO',1),(126614125,'LIMA','LIMA','BARRANCO',1),(126714126,'LIMA','LIMA','SAN MARTIN DE PORRES',1),(126814127,'LIMA','LIMA','SAN MIGUEL',1),(126914128,'LIMA','LIMA','STA MARIA DEL MAR',1),(127014129,'LIMA','LIMA','SANTA ROSA',1),(127114130,'LIMA','LIMA','SANTIAGO DE SURCO',1),(127214131,'LIMA','LIMA','SURQUILLO',1),(127314132,'LIMA','LIMA','VILLA MARIA DEL TRIUNFO',1),(127414133,'LIMA','LIMA','JESUS MARIA',1),(127514134,'LIMA','LIMA','INDEPENDENCIA',1),(127614135,'LIMA','LIMA','EL AGUSTINO',1),(127714136,'LIMA','LIMA','SAN JUAN DE MIRAFLORES',1),(127814137,'LIMA','LIMA','SAN JUAN DE LURIGANCHO',1),(127914138,'LIMA','LIMA','SAN LUIS',1),(128014139,'LIMA','LIMA','CIENEGUILLA',1),(128114140,'LIMA','LIMA','SAN BORJA',1),(128214141,'LIMA','LIMA','VILLA EL SALVADOR',1),(128314142,'LIMA','LIMA','LOS OLIVOS',1),(128414143,'LIMA','LIMA','SANTA ANITA',1),(130614410,'LIMA','CAÃ‘ETE','PACARAN',1),(130714411,'LIMA','CAÃ‘ETE','QUILMANA',1),(130814412,'LIMA','CAÃ‘ETE','SAN ANTONIO',1),(130914413,'LIMA','CAÃ‘ETE','SAN LUIS',1),(131014414,'LIMA','CAÃ‘ETE','SANTA CRUZ DE FLORES',1),(131114415,'LIMA','CAÃ‘ETE','ZUÃ‘IGA',1),(131214416,'LIMA','CAÃ‘ETE','ASIA',1),(132114511,'LIMA','HUAURA','SANTA LEONOR',1),(132214512,'LIMA','HUAURA','SANTA MARIA',1),(132314513,'LIMA','HUAURA','SAYAN',1),(132414516,'LIMA','HUAURA','VEGUETA',1),(133414610,'LIMA','HUAROCHIRI','LAHUAYTAMBO',1),(133514611,'LIMA','HUAROCHIRI','LANGA',1),(133614612,'LIMA','HUAROCHIRI','MARIATANA',1),(133714613,'LIMA','HUAROCHIRI','RICARDO PALMA',1),(133814614,'LIMA','HUAROCHIRI','SAN ANDRES DE TUPICOCHA',1),(133914615,'LIMA','HUAROCHIRI','SAN ANTONIO',1),(134014616,'LIMA','HUAROCHIRI','SAN BARTOLOME',1),(134114617,'LIMA','HUAROCHIRI','SAN DAMIAN',1),(134214618,'LIMA','HUAROCHIRI','SANGALLAYA',1),(134314619,'LIMA','HUAROCHIRI','SAN JUAN DE TANTARANCHE',1),(134414620,'LIMA','HUAROCHIRI','SAN LORENZO DE QUINTI',1),(134514621,'LIMA','HUAROCHIRI','SAN MATEO',1),(134614622,'LIMA','HUAROCHIRI','SAN MATEO DE OTAO',1),(134714623,'LIMA','HUAROCHIRI','SAN PEDRO DE HUANCAYRE',1),(134814624,'LIMA','HUAROCHIRI','SANTA CRUZ DE COCACHACRA',1),(134914625,'LIMA','HUAROCHIRI','SANTA EULALIA',1),(135014626,'LIMA','HUAROCHIRI','SANTIAGO DE ANCHUCAYA',1),(135114627,'LIMA','HUAROCHIRI','SANTIAGO DE TUNA',1),(135214628,'LIMA','HUAROCHIRI','SANTO DOMINGO DE LOS OLLEROS',1),(135314629,'LIMA','HUAROCHIRI','SURCO',1),(135414630,'LIMA','HUAROCHIRI','HUACHUPAMPA',1),(135514631,'LIMA','HUAROCHIRI','LARAOS',1),(135614632,'LIMA','HUAROCHIRI','SAN JUAN DE IRIS',1),(136614710,'LIMA','YAUYOS','CHOCOS',1),(136714711,'LIMA','YAUYOS','HUAMPARA',1),(136814712,'LIMA','YAUYOS','HUANCAYA',1),(136914713,'LIMA','YAUYOS','HUANGASCAR',1),(137014714,'LIMA','YAUYOS','HUANTAN',1),(137114715,'LIMA','YAUYOS','HUAÃ‘EC',1),(137214716,'LIMA','YAUYOS','LARAOS',1),(137314717,'LIMA','YAUYOS','LINCHA',1),(137414718,'LIMA','YAUYOS','MIRAFLORES',1),(137514719,'LIMA','YAUYOS','OMAS',1),(137614720,'LIMA','YAUYOS','QUINCHES',1),(137714721,'LIMA','YAUYOS','QUINOCAY',1),(137814722,'LIMA','YAUYOS','SAN JOAQUIN',1),(137914723,'LIMA','YAUYOS','SAN PEDRO DE PILAS',1),(138014724,'LIMA','YAUYOS','TANTA',1),(138114725,'LIMA','YAUYOS','TAURIPAMPA',1),(138214726,'LIMA','YAUYOS','TUPE',1),(138314727,'LIMA','YAUYOS','TOMAS',1),(138414728,'LIMA','YAUYOS','VIÃ‘AC',1),(138514729,'LIMA','YAUYOS','VITIS',1),(138614730,'LIMA','YAUYOS','HONGOS',1),(138714731,'LIMA','YAUYOS','MADEAN',1),(138814732,'LIMA','YAUYOS','PUTINZA',1),(138914733,'LIMA','YAUYOS','CATAHUASI',1),(139914810,'LIMA','HUARAL','VEINTISIETE DE NOVIEMBRE',1),(140014811,'LIMA','HUARAL','STA CRUZ DE ANDAMARCA',1),(140114812,'LIMA','HUARAL','SUMBILCA',1),(140714101,'LIMA','OYON','OYON',1),(140814102,'LIMA','OYON','NAVAN',1),(140914103,'LIMA','OYON','CAUJUL',1),(141014104,'LIMA','OYON','ANDAJES',1),(141114105,'LIMA','OYON','PACHANGARA',1),(141214106,'LIMA','OYON','COCHAMARCA',1),(142115110,'LORETO','MAYNAS','INDIANA',1),(142215111,'LORETO','MAYNAS','PUNCHANA',1),(142315112,'LORETO','MAYNAS','BELEN',1),(142415113,'LORETO','MAYNAS','SAN JUAN BAUTISTA',1),(142515114,'LORETO','MAYNAS','TNTE MANUEL CLAVERO',1),(143015210,'LORETO','ALTO AMAZONAS','SANTA CRUZ',1),(143115211,'LORETO','ALTO AMAZONAS','TNTE CESAR LOPEZ ROJAS',1),(144615410,'LORETO','REQUENA','JENARO HERRERA',1),(144715411,'LORETO','REQUENA','YAQUERANA',1),(149017210,'MOQUEGUA','GENERAL SANCHEZ CERRO','UBINAS',1),(149117211,'MOQUEGUA','GENERAL SANCHEZ CERRO','YUNGA',1),(150318110,'PASCO','PASCO','SIMON BOLIVAR',1),(150418111,'PASCO','PASCO','TICLACAYAN',1),(150518112,'PASCO','PASCO','TINYAHUARCO',1),(150618113,'PASCO','PASCO','VICCO',1),(150718114,'PASCO','PASCO','YANACANCHA',1),(153019113,'PIURA','PIURA','CURA MORI',1),(153119114,'PIURA','PIURA','EL TALLAN',1),(154119210,'PIURA','AYABACA','PAIMAS',1),(155919410,'PIURA','MORROPON','SAN JUAN DE BIGOTE',1),(159620110,'PUNO','PUNO','PICHACANI',1),(159720111,'PUNO','PUNO','SAN ANTONIO',1),(159820112,'PUNO','PUNO','TIQUILLACA',1),(159920113,'PUNO','PUNO','VILQUE',1),(160020114,'PUNO','PUNO','PLATERIA',1),(160120115,'PUNO','PUNO','AMANTANI',1),(161020210,'PUNO','AZANGARO','POTONI',1),(161120212,'PUNO','AZANGARO','SAMAN',1),(161220213,'PUNO','AZANGARO','SAN ANTON',1),(161320214,'PUNO','AZANGARO','SAN JOSE',1),(161420215,'PUNO','AZANGARO','SAN JUAN DE SALINAS',1),(161520216,'PUNO','AZANGARO','STGO DE PUPUJA',1),(161620217,'PUNO','AZANGARO','TIRAPATA',1),(162620310,'PUNO','CARABAYA','USICAYOS',1),(163220410,'PUNO','CHUCUITO','ZEPITA',1),(163320412,'PUNO','CHUCUITO','KELLUYO',1),(164120511,'PUNO','HUANCANE','HUATASANI',1),(165120610,'PUNO','LAMPA','VILAVILA',1),(166820810,'PUNO','SANDIA','YANAHUAYA',1),(166920811,'PUNO','SANDIA','ALTO INAMBARI',1),(167020812,'PUNO','SANDIA','SAN PEDRO DE PUTINA PUNCO',1),(167520101,'PUNO','YUNGUYO','YUNGUYO',1),(167620102,'PUNO','YUNGUYO','UNICACHI',1),(167720103,'PUNO','YUNGUYO','ANAPIA',1),(167820104,'PUNO','YUNGUYO','COPANI',1),(167920105,'PUNO','YUNGUYO','CUTURAPI',1),(168020106,'PUNO','YUNGUYO','OLLARAYA',1),(168120107,'PUNO','YUNGUYO','TINICACHI',1),(168220111,'PUNO','SAN ANTONIO DE PUTINA','PUTINA',1),(168320112,'PUNO','SAN ANTONIO DE PUTINA','PEDRO VILCA APAZA',1),(168420113,'PUNO','SAN ANTONIO DE PUTINA','QUILCA PUNCU',1),(168520114,'PUNO','SAN ANTONIO DE PUTINA','ANANEA',1),(168620115,'PUNO','SAN ANTONIO DE PUTINA','SINA',1),(168720121,'PUNO','EL COLLAO','ILAVE',1),(168820122,'PUNO','EL COLLAO','PILCUYO',1),(168920123,'PUNO','EL COLLAO','SANTA ROSA',1),(169020124,'PUNO','EL COLLAO','CAPASO',1),(169120125,'PUNO','EL COLLAO','CONDURIRI',1),(169220131,'PUNO','MOHO','MOHO',1),(169320132,'PUNO','MOHO','CONIMA',1),(169420133,'PUNO','MOHO','TILALI',1),(169520134,'PUNO','MOHO','HUAYRAPATA',1),(171421311,'SAN MARTIN','LAMAS','SHANAO',1),(171521313,'SAN MARTIN','LAMAS','TABALOSOS',1),(171621314,'SAN MARTIN','LAMAS','ZAPATERO',1),(171721315,'SAN MARTIN','LAMAS','ALONSO DE ALVARADO',1),(171821316,'SAN MARTIN','LAMAS','SAN ROQUE DE CUMBAZA',1),(174021610,'SAN MARTIN','SAN MARTIN','JUAN GUERRA',1),(174121611,'SAN MARTIN','SAN MARTIN','MORALES',1),(174221612,'SAN MARTIN','SAN MARTIN','PAPAPLAYA',1),(174321616,'SAN MARTIN','SAN MARTIN','SAN ANTONIO',1),(174421619,'SAN MARTIN','SAN MARTIN','SAUCE',1),(174521620,'SAN MARTIN','SAN MARTIN','SHAPAJA',1),(174621621,'SAN MARTIN','SAN MARTIN','LA BANDA DE SHILCAYO',1),(176721910,'SAN MARTIN','PICOTA','SHAMBOYACU',1),(176821101,'SAN MARTIN','EL DORADO','SAN JOSE DE SISA',1),(176921102,'SAN MARTIN','EL DORADO','AGUA BLANCA',1),(177021103,'SAN MARTIN','EL DORADO','SHATOJA',1),(177121104,'SAN MARTIN','EL DORADO','SAN MARTIN',1),(177221105,'SAN MARTIN','EL DORADO','SANTA ROSA',1),(177922110,'TACNA','TACNA','SAMA',1),(178022111,'TACNA','TACNA','ALTO DE LA ALIANZA',1),(178122112,'TACNA','TACNA','CIUDAD NUEVA',1),(178222113,'TACNA','TACNA','CORONEL GREGORIO ALBARRACIN L.',1),(178722210,'TACNA','TARATA','SITAJARA',1),(178822211,'TACNA','TARATA','SUSAPAYA',1),(178922212,'TACNA','TARATA','TARUCACHI',1),(179022213,'TACNA','TARATA','TICACO',1);
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
  `contrasenia_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuario_tipo_usario1` (`id_tipo_usario`),
  CONSTRAINT `fk_usuario_tipo_usario1` FOREIGN KEY (`id_tipo_usario`) REFERENCES `tipo_usario` (`id_tipo_usario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Diego','Torres','Loyola',1,'saudade');
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
  CONSTRAINT `fk_usuario_apiario_temporada1` FOREIGN KEY (`id_temporada`) REFERENCES `temporada` (`id_temporada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_apiario_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_apiario`
--

LOCK TABLES `usuario_apiario` WRITE;
/*!40000 ALTER TABLE `usuario_apiario` DISABLE KEYS */;
INSERT INTO `usuario_apiario` VALUES (1,1,1,1,'asignado','2012-12-01',NULL),(2,1,1,2,'asignado','2012-12-06',NULL),(7,2,1,1,'asignado','2012-12-31',NULL),(20,3,1,2,'asignado','2012-12-31',NULL),(21,3,1,1,'asignado','2013-01-02',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
INSERT INTO `zona` VALUES (1,'Sachal',2112),(2,'Tahua',3113),(3,'Pompeya',5115),(4,'Babilon',4114),(5,'Troya',118243);
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
  CONSTRAINT `fk_zona_Recuso_Natural_recurso_natural1` FOREIGN KEY (`id_recurso_natural`) REFERENCES `recurso_natural` (`id_recurso_natural`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_zona_Recuso_Natural_zona1` FOREIGN KEY (`zona_id_zona`) REFERENCES `zona` (`id_zona`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2013-01-05 23:36:24