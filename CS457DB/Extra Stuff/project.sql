-- MySQL dump 10.16  Distrib 10.3.9-MariaDB, for Linux (x86_64)
--
-- Host: terratoast.rocks    Database: dgallup_db
-- ------------------------------------------------------
-- Server version	5.6.41

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
-- Table structure for table `hobby`
--

DROP TABLE IF EXISTS `hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hobby` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `h_desc` varchar(255) NOT NULL,
  `h_name` varchar(150) NOT NULL,
  `ht_id` int(11) NOT NULL,
  PRIMARY KEY (`h_id`),
  KEY `ht_id` (`ht_id`),
  CONSTRAINT `hobby_ibfk_1` FOREIGN KEY (`ht_id`) REFERENCES `hobby_type` (`ht_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobby`
--

LOCK TABLES `hobby` WRITE;
/*!40000 ALTER TABLE `hobby` DISABLE KEYS */;
INSERT INTO `hobby` VALUES (1,'sleeping for bodily needs','sleeping',2),(2,'eating for bodily needs','eating',2),(3,'studies to improve scholarly activities','studying',3),(4,'watching television','television',1),(5,'going to the gym to workout','working out',3),(6,'drawing or coloring pictures','drawing',1),(7,'reading books or articles','reading',1),(8,'surfing or roaming social media','social media',1);
/*!40000 ALTER TABLE `hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hobby_type`
--

DROP TABLE IF EXISTS `hobby_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hobby_type` (
  `ht_id` int(11) NOT NULL AUTO_INCREMENT,
  `ht_desc` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ht_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobby_type`
--

LOCK TABLES `hobby_type` WRITE;
/*!40000 ALTER TABLE `hobby_type` DISABLE KEYS */;
INSERT INTO `hobby_type` VALUES (1,'recreation'),(2,'necessity'),(3,'self-improvement');
/*!40000 ALTER TABLE `hobby_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(150) NOT NULL,
  `dob` varchar(100) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Troy','Schotter','08 / 09 / 1989'),(2,'Zach','Brandenburg','07 / 21 / 1997'),(3,'first','last','01 / 01 / 01'),(4,'test1','test2',''),(5,'test3','test4','01 / 02 / 0001'),(6,'haha','ahah','12 / 08 / 1996'),(7,'Rony','Mascreen','12/26/1987'),(8,'\"><script> alert(\"Hello\") </script>','Beepers','01/01/-4584'),(9,'Matthew','Proehl','03/06/1998'),(10,'Ben','Bledsoe','05/05/1995'),(11,'DantÃ© ','Molback','01-30-99'),(12,'Jared','Hanna','12/26/1997'),(13,'Thomas','Blake','10/06/1993'),(14,'Fillip','Beyl','09/17/1996'),(15,'Brianna','Nichols','11/29/1996'),(16,'Xavier','Xavierington','5/17/2001'),(17,'Chyna','France','03/09/1999'),(18,'Calee','Fulling','11/22/1996'),(19,'Dianne','Waweru','09/07/1997'),(20,'Andrew','Young','02/14/1996'),(21,'A','F','01/01/01'),(22,'Christopher ','Whittington','10/22/1999');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_hobby`
--

DROP TABLE IF EXISTS `person_hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_hobby` (
  `ph_id` int(11) NOT NULL AUTO_INCREMENT,
  `ph_hours` int(11) NOT NULL,
  `h_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`ph_id`),
  KEY `h_id` (`h_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `person_hobby_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hobby` (`h_id`) ON DELETE CASCADE,
  CONSTRAINT `person_hobby_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `person` (`p_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_hobby`
--

LOCK TABLES `person_hobby` WRITE;
/*!40000 ALTER TABLE `person_hobby` DISABLE KEYS */;
INSERT INTO `person_hobby` VALUES (1,100,1,4),(2,1,1,5),(3,2,2,5),(4,3,3,5),(5,4,4,5),(6,5,5,5),(7,6,6,5),(8,7,7,5),(9,8,8,5),(10,9,1,6),(11,9,2,6),(12,9,3,6),(13,9,4,6),(14,9,5,6),(15,9,6,6),(16,9,7,6),(17,9,8,6),(18,42,1,7),(19,12,2,7),(20,24,3,7),(21,5,4,7),(22,5,5,7),(23,1,6,7),(24,10,7,7),(25,15,8,7),(26,7,1,8),(27,3,2,8),(28,20,3,8),(29,5,4,8),(30,0,5,8),(31,0,6,8),(32,10,7,8),(33,5,8,8),(34,46,1,9),(35,18,2,9),(36,0,3,9),(37,4,4,9),(38,0,5,9),(39,6,6,9),(40,21,7,9),(41,14,8,9),(42,56,1,10),(43,10,2,10),(44,0,3,10),(45,12,4,10),(46,0,5,10),(47,0,6,10),(48,0,7,10),(49,9,8,10),(50,56,1,11),(51,10,2,11),(52,0,3,11),(53,9,4,11),(54,4,5,11),(55,0,6,11),(56,7,7,11),(57,8,8,11),(58,56,1,12),(59,5,2,12),(60,21,3,12),(61,9,4,12),(62,3,5,12),(63,0,6,12),(64,7,7,12),(65,18,8,12),(66,35,1,13),(67,12,2,13),(68,7,3,13),(69,15,4,13),(70,14,5,13),(71,0,6,13),(72,10,7,13),(73,6,8,13),(74,43,1,14),(75,50,2,14),(76,16,3,14),(77,20,4,14),(78,4,5,14),(79,0,6,14),(80,6,7,14),(81,30,8,14),(82,4,1,15),(83,2,2,15),(84,3,3,15),(85,0,4,15),(86,0,5,15),(87,2,6,15),(88,6,7,15),(89,2,8,15),(90,22,1,16),(91,15,2,16),(92,24,3,16),(93,7,4,16),(94,0,5,16),(95,0,6,16),(96,15,7,16),(97,10,8,16),(98,40,1,17),(99,14,2,17),(100,23,3,17),(101,0,4,17),(102,6,5,17),(103,0,6,17),(104,1,7,17),(105,25,8,17),(106,49,1,18),(107,7,2,18),(108,25,3,18),(109,0,4,18),(110,2,5,18),(111,0,6,18),(112,4,7,18),(113,8,8,18),(114,50,1,19),(115,7,2,19),(116,30,3,19),(117,2,4,19),(118,0,5,19),(119,0,6,19),(120,1,7,19),(121,5,8,19),(122,42,1,20),(123,12,2,20),(124,14,3,20),(125,2,4,20),(126,0,5,20),(127,0,6,20),(128,1,7,20),(129,3,8,20),(130,20,1,21),(131,8,2,21),(132,3,3,21),(133,0,4,21),(134,0,5,21),(135,0,6,21),(136,0,7,21),(137,2,8,21),(138,28,1,22),(139,6,2,22),(140,4,3,22),(141,1,4,22),(142,0,5,22),(143,1,6,22),(144,0,7,22),(145,100,8,22);
/*!40000 ALTER TABLE `person_hobby` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-13 17:53:49
