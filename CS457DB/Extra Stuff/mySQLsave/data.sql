-- MySQL dump 10.16  Distrib 10.3.9-MariaDB, for Linux (x86_64)
--
-- Host: www.terratoast.rocks    Database: temp_db
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
-- Table structure for table `customer_bicknell`
--

DROP TABLE IF EXISTS `customer_bicknell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_bicknell` (
  `cID` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(255) NOT NULL,
  PRIMARY KEY (`cID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_bicknell`
--

LOCK TABLES `customer_bicknell` WRITE;
/*!40000 ALTER TABLE `customer_bicknell` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_bicknell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_patil`
--

DROP TABLE IF EXISTS `customer_patil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_patil` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(255) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_patil`
--

LOCK TABLES `customer_patil` WRITE;
/*!40000 ALTER TABLE `customer_patil` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_patil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_schotter`
--

DROP TABLE IF EXISTS `customer_schotter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_schotter` (
  `cID` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(255) NOT NULL,
  PRIMARY KEY (`cID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_schotter`
--

LOCK TABLES `customer_schotter` WRITE;
/*!40000 ALTER TABLE `customer_schotter` DISABLE KEYS */;
INSERT INTO `customer_schotter` VALUES (1,'troy','schotter'),(2,'brody','little'),(3,'Neha','Swarup'),(4,'leroy','jenkins'),(5,'Zheyun','Feng'),(6,'Troy','Schotter'),(7,'Esdras','Simervil'),(8,'nick','barrow'),(9,'Joshua','Worthington'),(10,'joseph','harris'),(11,'Huey','Lewis'),(12,'Pierre','Allen'),(13,'Jamal','Jones'),(14,'Shravani','Bommisetty'),(15,'Tyler','Bicknell'),(16,'Zach','Brandenburg');
/*!40000 ALTER TABLE `customer_schotter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-02 11:56:16
