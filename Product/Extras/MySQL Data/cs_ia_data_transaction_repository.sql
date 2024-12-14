-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: cs_ia_data
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `transaction_repository`
--

DROP TABLE IF EXISTS `transaction_repository`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_repository` (
  `Inventory_ID` int NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) DEFAULT NULL,
  `Inventory_In` int DEFAULT NULL,
  `Inventory_Out` int DEFAULT NULL,
  `Number_Damaged` int DEFAULT NULL,
  `Dates` date DEFAULT NULL,
  `Source` varchar(45) DEFAULT NULL,
  `Destination` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Inventory_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_repository`
--

LOCK TABLES `transaction_repository` WRITE;
/*!40000 ALTER TABLE `transaction_repository` DISABLE KEYS */;
INSERT INTO `transaction_repository` VALUES (1,'978-81-8190-033-3',23,0,4,'2021-01-31','xyz','-'),(2,'978-81-8190-036-4',19,0,4,'2021-01-31','xyz','-'),(3,'978-81-8190-130-9',42,0,5,'2021-01-31','xyz','-'),(4,'978-81-8190-033-3',0,5,0,'2021-01-31','-','xyz'),(5,'978-81-8190-036-4',0,8,0,'2021-01-31','-','xyz'),(6,'978-81-8190-130-9',0,20,0,'2021-01-31','-','xyz'),(7,'978-81-8190-033-3',65,0,18,'2021-02-08','xyz','-'),(8,'978-81-8190-033-3',0,30,0,'2021-02-08','-','xyz'),(9,'978-81-8190-033-3',51,0,12,'2021-02-16','Chennai Warehouse','-'),(10,'978-81-8190-033-3',75,0,24,'2021-02-20','Chennai Warehouse','-'),(11,'978-81-8190-033-3',0,20,0,'2021-02-20','-','Chennai'),(12,'978-81-8190-033-3',34,0,12,'2021-02-26','xyz','-'),(13,'978-81-8190-033-3',0,23,0,'2021-02-26','-','xyz'),(14,'978-81-8190-033-3',56,0,2,'2021-02-26','xyz','-'),(15,'978-81-8190-033-3',0,86,0,'2021-02-26','-','xyz'),(16,'978-81-8190-033-3',56,0,21,'2021-02-26','xyz','-'),(17,'978-81-8190-033-3',0,65,0,'2021-02-26','-','xyz'),(18,'978-81-8190-033-3',89,0,12,'2021-02-26','xyz','-'),(19,'978-81-8190-033-3',0,98,0,'2021-02-26','-','xyz'),(20,'978-81-8190-033-3',78,0,12,'2021-02-26','xyz','-'),(21,'978-81-8190-033-3',0,56,0,'2021-02-26','-','xyz'),(22,'978-81-8190-033-3',89,0,20,'2021-03-09','Stores','-'),(23,'978-81-8190-033-3',0,67,0,'2021-03-09','-','xyz'),(24,'978-81-8190-033-3',89,0,12,'2021-03-09','stores','-'),(25,'978-81-8190-033-3',0,100,0,'2021-03-09','-','xyz'),(26,'978-81-8190-033-3',89,0,17,'2021-03-09','xyz','-'),(27,'978-81-8190-033-3',0,70,0,'2021-03-09','-','xyz'),(28,'978-81-8190-033-3',89,0,12,'2021-03-10','xyz','-'),(29,'978-81-8190-033-3',0,75,0,'2021-03-10','-','xyz'),(30,'978-81-8190-033-3',76,0,12,'2021-03-10','xyz','-'),(31,'978-81-8190-033-3',0,70,0,'2021-03-10','-','xyz'),(32,'978-81-8190-033-3',90,0,12,'2021-03-10','xyz','-'),(33,'978-81-8190-033-3',0,70,0,'2021-03-10','-','xyz'),(34,'978-81-8190-033-3',90,0,10,'2021-03-13','Chennai','-'),(35,'978-81-8190-033-3',0,80,0,'2021-03-13','-','Dheli'),(36,'978-81-8190-033-3',90,0,10,'2021-03-13','CH','-'),(37,'978-81-8190-033-3',0,80,0,'2021-03-13','-','DH'),(38,'978-81-8190-033-3',90,0,10,'2021-03-13','CH','-'),(39,'978-81-8190-033-3',0,80,0,'2021-03-13','-','DH');
/*!40000 ALTER TABLE `transaction_repository` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 18:53:08
