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
-- Table structure for table `book_identification`
--

DROP TABLE IF EXISTS `book_identification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_identification` (
  `ISBN` varchar(25) NOT NULL,
  `Book_Name` varchar(255) DEFAULT NULL,
  `Type_Of_Book` varchar(12) DEFAULT NULL,
  `PriceRs` int NOT NULL,
  `Stock` int DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `PriceRs_index` (`PriceRs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_identification`
--

LOCK TABLES `book_identification` WRITE;
/*!40000 ALTER TABLE `book_identification` DISABLE KEYS */;
INSERT INTO `book_identification` VALUES ('978-81-8190-033-3','The Monkey King','Hardcover',399,12),('978-81-8190-036-4','Birth of Krshna &Krishna Conquest / Young Hanuman & Hanuman the Mighty','Hardcover',398,7),('978-81-8190-130-9','Hungry Caterpillar Billingual','Paper Back',350,17),('978-81-8190-131-6','Tiny Seed Billingual','Paper Back',250,0),('978-81-8190-132-3','Mixed Up Chameleon Billingual','Paper Back',350,0),('978-81-8190-147-7','Little Vinayak','Hardcover',399,0),('978-81-8190-150-7','Lizards Tail','Paper Back',250,0),('978-81-8190-156-9','Monkeys on A Fast','Hardcover',399,0),('978-81-8190-159-0','The Boy Who Drew Cats','Paper Back',250,0),('978-81-8190-160-6','Whose lovely child can you be','Paper Back',199,0),('978-81-8190-165-1','The Rumour','Hardcover',399,0),('978-81-8190-168-2','The Last Bargain','Hardcover',399,0),('978-81-8190-177-4','The Tallest Tale','Paper Back',250,0),('978-81-8190-180-4','Book worm','Paper Back',199,0),('978-81-8190-183-5','Tak tak','Paper Back',199,0),('978-81-8190-186-6','The Moustache Man','Paper Back',199,0),('978-81-8190-192-7','When the Earth Lost Its Shapes','Hardcover',399,0),('978-81-8190-193-4','Dorje\'s Stripes','Paper Back',250,0),('978-81-8190-197-2','Revenge of Puppets','Paper Back',199,0),('978-81-8190-200-9','The Dancing Bear','Paper Back',199,0),('978-81-8190-240-5','An Elephant in my backyard','Paper Back',250,0),('978-81-8190-258-0','A Big Mouth','Paper Back',250,0),('978-81-8190-259-7','Tit for tat','Paper Back',250,0),('978-81-8190-260-3','The Tiger Eater\'s','Paper Back',250,0),('978-81-8190-261-0','The Crocodile\'s Tail','Paper Back',250,0),('978-81-8190-273-3','The Story and the song','Paper Back',199,0),('978-81-8190-277-1','The Case of the Stolen Smells','Paper Back',250,0),('978-81-8190-284-9','What Will I Be','Paper Back',250,0),('978-81-8190-285-6','What Could It Be?','Paper Back',250,0),('978-81-8190-286-3','What Will You Give Me','Paper Back',250,0),('978-81-8190-287-0','Where Shall We Go','Paper Back',250,0),('978-81-8190-289-4','Fetch That Colour','Hardcover',399,0),('978-81-8190-290-0','Let\'s Roll Out a Circle','Hardcover',399,0),('978-81-8190-295-5','The Wednesday Bazaar','Paper Back',250,0),('978-81-8190-296-2','Bela Misses Her Train','Paper Back',250,0),('978-81-8190-297-9','Thea\'s Tree','Hardcover',399,0),('978-81-8190-302-0','A Pair of Twins','Paper Back',250,0),('978-81-8190-303-7','The Fox and the Crow','Hardcover',399,0),('978-81-8190-305-1','Whimsy','Paper Back',250,0),('978-81-8190-306-8','The Dragon\'s Toothache','Hardcover',399,0),('978-81-8190-311-2','Farmer Falgu Goes On A Trip','Paper Back',250,0),('978-81-8190-312-9','Farmer Falgu Goes To The Market','Paper Back',250,0),('978-81-8190-313-6','The Lions Feast','Paper Back',250,0),('978-81-8190-331-0','The Night Monster','Paper Back',250,0),('978-81-8190-332-7','What did the monster child eat today','Paper Back',350,0),('978-81-8190-335-8','Princess Easy Pleasy','Hardcover',399,0),('978-81-8190-355-6','Farmer Falgu Goes to the Kumbh Mela','Paper Back',250,0),('978-81-8190-356-3','Farmer Falgu Goes kite Flying','Paper Back',250,0),('978-81-8190-359-4','Dada\'s Useless Present','Paper Back',250,0),('978-81-8190-360-0','A Tangle of Brungles','Hardcover',399,0),('978-81-8190-361-7','The Insect Boy','Hardcover',499,0),('978-81-8190-382-2','Fly Little Fish','Hardcover',399,0),('978-81-9338-890-7','The Clever Tailor','Hardcover',399,0),('978-81-9338-891-4','Sadiq Wants to Stitch','Hardcover',399,0),('978-81-9338-892-1','Babban Hajjam','Hardcover',399,0),('978-81-9338-893-8','Letter to Ammi','Hardcover',399,0),('978-81-9338-894-5','Papa\'s Marathon','Paper Back',250,0),('978-81-9338-896-9','Star Struck','Hardcover',499,0),('978-81-9338-897-6','The Truth about the Tooth','Hardcover',399,0),('978-81-9338-898-3','Thukpa for All','Hardcover',399,0),('978-81-9365-421-7','The Brave Parrot','Hardcover',399,0),('978-81-9365-422-4','Cat\'s Egg-Indian','Hardcover',399,0),('978-81-9365-424-8','Daisy Doll','Hardcover',399,0),('978-81-9365-425-5','Sion Misfortune','Hardcover',399,0),('978-81-9365-428-6','One Rainy Day','Boardbook',499,0),('978-81-9365-429-3','Mountain of Mumbai','Hardcover',499,0),('978-81-9390-331-5','Get OFF that Camel','Hardcover',399,0),('978-81-9390-337-7','Thatha\'s Pumpkin New Title 2020','Paper Back',250,0),('978-81-9440-711-9','Rats Bigger than Cats New Title 2020','Paper Back',250,0);
/*!40000 ALTER TABLE `book_identification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 18:53:09
