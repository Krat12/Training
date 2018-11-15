-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: company
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
  CONSTRAINT `Regio_City_Fk` FOREIGN KEY (`Region_id`) REFERENCES `region` (`region_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Новокузнецк',1),(2,'Кемерово',1),(3,'Осиники',1);
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
  `client_id` varchar(100) NOT NULL,
  `entry_id` int(11) NOT NULL,
  `contract_status_id` int(11) NOT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `Contract_User_FK_idx` (`client_id`),
  KEY `Contract_Entry_FK_idx` (`entry_id`),
  KEY `Contract_Status_FK_idx` (`contract_status_id`),
  CONSTRAINT `Contract_Entry_FK` FOREIGN KEY (`entry_id`) REFERENCES `entry` (`entry_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Contract_Status_FK` FOREIGN KEY (`contract_status_id`) REFERENCES `contract_status` (`contract_status_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Contract_User_FK` FOREIGN KEY (`client_id`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `contract_status`
--

DROP TABLE IF EXISTS `contract_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract_status` (
  `contract_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_status_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`contract_status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_status`
--

LOCK TABLES `contract_status` WRITE;
/*!40000 ALTER TABLE `contract_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract_status` ENABLE KEYS */;
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
  `realtor_id` int(11) NOT NULL,
  `fullname` varchar(70) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`entry_id`),
  KEY `Entry_Realty_FK_idx` (`realty_id`),
  KEY `Entry_User_FK_idx` (`client`),
  KEY `Entry_Realtor_FK_idx` (`realtor_id`),
  CONSTRAINT `Entry_Realtor_FK` FOREIGN KEY (`realtor_id`) REFERENCES `realtor` (`realtor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Entry_Realty_FK` FOREIGN KEY (`realty_id`) REFERENCES `realty` (`realty_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Entry_User_FK` FOREIGN KEY (`client`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entry`
--

LOCK TABLES `entry` WRITE;
/*!40000 ALTER TABLE `entry` DISABLE KEYS */;
/*!40000 ALTER TABLE `entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realtor`
--

DROP TABLE IF EXISTS `realtor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `realtor` (
  `realtor_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`realtor_id`),
  KEY `Realor_City_id_idx` (`email`),
  CONSTRAINT `Realtor_user_FK` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realtor`
--

LOCK TABLES `realtor` WRITE;
/*!40000 ALTER TABLE `realtor` DISABLE KEYS */;
/*!40000 ALTER TABLE `realtor` ENABLE KEYS */;
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
  `cost` decimal(10,0) DEFAULT NULL,
  `info` text,
  `image` blob,
  `area` float DEFAULT NULL,
  `number_floors` int(11) DEFAULT NULL,
  PRIMARY KEY (`realty_id`),
  KEY `Realty_city_id_idx` (`city_id`),
  CONSTRAINT `Realty_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`City_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Кемеровская Область');
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
INSERT INTO `role` VALUES ('A','Admin'),('R','Realor'),('U','User');
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
INSERT INTO `user` VALUES ('predator.1195@mail.ru','18lulego123','jon','Romanov','U','7-951-577-83-52'),('predator.1196@mail.ru','18lulego123','jon','Romanov','U','7-951-577-83-52'),('predator.1197@mail.ru','18lulego123','jon','Romanov','U','7-951-577-83-52'),('predator.1198@mail.ru','18lulego123','Игорь','Романов','U','79515778352'),('predator.1199@mail.ru','18lulego123','jon','Romanov','A','7-951-577-83-52'),('predator.11@mail.ru','18lulego123','Igor','Romanov','U','79515778352');
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

-- Dump completed on 2018-11-15  7:31:29
