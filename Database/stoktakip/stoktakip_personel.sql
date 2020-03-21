-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: stoktakip
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `personel`
--

DROP TABLE IF EXISTS `personel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personel` (
  `PersonelId` int NOT NULL,
  `personelTC` varchar(45) NOT NULL,
  `PersonelIsim` varchar(45) NOT NULL,
  `PersonelSoyIsim` varchar(45) NOT NULL,
  `PersonelCinsiyet` varchar(45) NOT NULL,
  `PersonelEmail` varchar(45) NOT NULL,
  `PersonelDogumTarihi` datetime NOT NULL,
  `PersonelTelefonNo` varchar(45) NOT NULL,
  `PersonelAdres` varchar(45) NOT NULL,
  `PersonelYetki` int NOT NULL,
  `PersonelUsername` varchar(45) NOT NULL,
  `PersonelPassword` varchar(45) NOT NULL,
  PRIMARY KEY (`PersonelId`),
  KEY `fk_personel_yetki` (`PersonelYetki`),
  CONSTRAINT `fk_personel_yetki` FOREIGN KEY (`PersonelYetki`) REFERENCES `yetki` (`idyetki`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personel`
--

LOCK TABLES `personel` WRITE;
/*!40000 ALTER TABLE `personel` DISABLE KEYS */;
INSERT INTO `personel` VALUES (1,'123456789','Mert','Kilic','Erkek','mwert09@gmail.com','1999-06-03 00:00:00','05427413834','Beylikduzu',1,'mwert','123456789'),(2,'123456788','Mertiki','Kiliciki','Kadin','mwert009@gmail.com','1999-09-30 00:00:00','05427413835','Besiktas',2,'mwert2','123456789'),(3,'123456777','Corona','Korona','Erkek','mwertcorona@gmail.com','1999-06-02 00:00:00','05427413834','corona kor ona',2,'corona','123456789'),(7,'qweads','ayhan','hatipo','Kadin','qweasd','2020-03-04 00:00:00','qweasd','12123',2,'qweasd','qweasd'),(9,'123123','slm','nr','Erkek','naber@gmail.com','2020-03-04 00:00:00','123123','123q',3,'qwe','qwe');
/*!40000 ALTER TABLE `personel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-21 16:33:56
