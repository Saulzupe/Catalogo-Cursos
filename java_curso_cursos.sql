-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: java_curso
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) DEFAULT NULL,
  `descripcion` varchar(120) DEFAULT NULL,
  `instructor_id` int DEFAULT NULL,
  `duracion` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cursos_instructores_fk_idx` (`instructor_id`),
  CONSTRAINT `fk_cursos_instructores` FOREIGN KEY (`instructor_id`) REFERENCES `instructores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Máster Completo en Java de cero a experto con IntelliJ','Aprende JAVA SE, Jakarta EE, Hibarnate',1,98.53),(2,'Spring Framework 5: Creando Webapp de cero a experto','Construye aplicaciones web con Spring Framework 5 & Spring Boot',1,41.51),(3,'Angular & Spring Boot: Creando Web app full stack','Desarrollo frontend con Angular y backend Spring Boot 2',1,23.54),(4,'JavaScript moderno','JavaScript Completo 0 a experto ',2,42.40),(5,'Guia Completa JUNIT y Mockito incluye Spring Boot Test','Aprende desde cero JUNIT 5 y Mockito en Spring Boot 2',1,15.12),(6,'Desarrollo Web','Crea sitios web elegantes',2,42.50),(7,'Java developer','Aprende java completo ',2,42.40),(8,'JavaScript',' Aprende otro lengujae de programacion',4,72.30),(9,'Cisco Redes','Aprende todo lo de redes ',4,73.00),(11,'Bases de datos','Aprende todo lo de base de datos relacionales',2,42.00),(13,'Oracle DB','Bases de datos Oracle',2,50.00),(14,'Gestion de proyectos','Aprende a gestionar proyectos y equipos',3,204.55),(15,'Spring cloud','Spring cloud microservicios',1,25.00),(16,'Microservicios con Spring Cloud','Eureka cloud',1,25.00);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 12:17:56
