-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: companyup
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `buyrealty`
--

DROP TABLE IF EXISTS `buyrealty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyrealty` (
  `bay_id` int(11) NOT NULL AUTO_INCREMENT,
  `entry_id` int(11) NOT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `client` varchar(100) NOT NULL,
  PRIMARY KEY (`bay_id`),
  KEY `Bay_Entry_FK_idx` (`entry_id`),
  KEY `Bay_Client_FK_idx` (`client`),
  CONSTRAINT `BayRealty_Client_FK` FOREIGN KEY (`client`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `BayRealty_Entry_FK` FOREIGN KEY (`entry_id`) REFERENCES `entry` (`entry_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyrealty`
--

LOCK TABLES `buyrealty` WRITE;
/*!40000 ALTER TABLE `buyrealty` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyrealty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `City_id` int(11) NOT NULL AUTO_INCREMENT,
  `City_name` varchar(60) DEFAULT NULL,
  `Region_id` int(11) NOT NULL,
  PRIMARY KEY (`City_id`),
  KEY `Regio_City_Fk_idx` (`Region_id`),
  CONSTRAINT `Regio_City_Fk` FOREIGN KEY (`Region_id`) REFERENCES `region` (`region_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `contract_id` int(11) NOT NULL AUTO_INCREMENT,
  `bay_id` int(11) NOT NULL,
  `entry_id` int(11) NOT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `procent` float DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `Contract_Entry_FK_idx` (`entry_id`),
  KEY `Contract_Bay_FK_idx` (`bay_id`),
  CONSTRAINT `Contract_BayRealty_FK` FOREIGN KEY (`bay_id`) REFERENCES `buyrealty` (`bay_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Contract_Entry_FK` FOREIGN KEY (`entry_id`) REFERENCES `entry` (`entry_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entry` (
  `entry_id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_date` datetime DEFAULT NULL,
  `type_entry` varchar(45) DEFAULT NULL,
  `realty_id` int(11) NOT NULL,
  `status_entry` varchar(45) DEFAULT NULL,
  `client` varchar(100) NOT NULL,
  `realtor` varchar(100) DEFAULT NULL,
  `fullname` varchar(70) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`entry_id`),
  KEY `Entry_Realty_FK_idx` (`realty_id`),
  KEY `Entry_User_FK_idx` (`client`),
  KEY `Entry_Realtor_FK_idx` (`realtor`),
  CONSTRAINT `Entry_Realtor_FK` FOREIGN KEY (`realtor`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Entry_Realty_FK` FOREIGN KEY (`realty_id`) REFERENCES `realty` (`realty_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Entry_User_FK` FOREIGN KEY (`client`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realty`
--

DROP TABLE IF EXISTS `realty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `realty` (
  `realty_id` int(11) NOT NULL AUTO_INCREMENT,
  `rooms` int(11) DEFAULT NULL,
  `type_realty` varchar(45) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  `info` text,
  `image` mediumblob,
  `area` float DEFAULT NULL,
  `number_floors` int(11) DEFAULT NULL,
  PRIMARY KEY (`realty_id`),
  KEY `Realty_city_id_idx` (`city_id`),
  CONSTRAINT `Realty_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`City_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realty`
--

LOCK TABLES `realty` WRITE;
/*!40000 ALTER TABLE `realty` DISABLE KEYS */;
/*!40000 ALTER TABLE `realty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `region_id` int(11) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` char(1) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `email` varchar(100) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `role_id` char(1) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `image` mediumblob,
  PRIMARY KEY (`email`),
  KEY `User_Role_FK_idx` (`role_id`),
  CONSTRAINT `User_Role_FK` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-20  8:37:21
