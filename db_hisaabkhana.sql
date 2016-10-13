-- MySQL dump 10.13  Distrib 5.5.30, for Win64 (x86)
--
-- Host: localhost    Database: hisaabkhana
-- ------------------------------------------------------
-- Server version	5.5.30

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
-- Table structure for table `hk_menu_master`
--

DROP TABLE IF EXISTS `hk_menu_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hk_menu_master` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `display_text` varchar(60) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `action_url` varchar(200) DEFAULT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hk_menu_master`
--

LOCK TABLES `hk_menu_master` WRITE;
/*!40000 ALTER TABLE `hk_menu_master` DISABLE KEYS */;
INSERT INTO `hk_menu_master` VALUES (1,'User Management',0,NULL,'ACTIVE',NULL),(2,'Role management',0,NULL,'ACTIVE',NULL),(3,'Cashier',0,NULL,'ACTIVE',NULL),(4,'Reports',0,NULL,'ACTIVE',NULL),(5,'Add User',1,NULL,'ACTIVE',NULL),(6,'Edit User',1,NULL,'ACTIVE',NULL),(7,'Process Withdrawal',3,NULL,'ACTIVE',NULL),(8,'Process Deposit',3,NULL,'ACTIVE',NULL),(9,'Settlement Initiate',3,NULL,'ACTIVE',NULL),(10,'User Report',4,NULL,'ACTIVE',NULL),(11,'Deposit Report',4,NULL,'ACTIVE',NULL),(12,'Withdrawal Report',4,NULL,'ACTIVE',NULL),(13,'Show Player Details',1,'http://www.sdfsdf.com/playerdetails','ACTIVE','Just for player details'),(14,'Show Player Details',1,'http://www.sdfsdf.com/playerdetails','ACTIVE','Just for player details'),(15,'Show Player age',14,'http://www.sdfsdf.com/playerdetails','ACTIVE','Just for player details'),(16,'Show Player balance',15,'http://www.sdfsdf.com/playerdetails','ACTIVE','Just for player details'),(17,'Show Player country',16,'http://www.sdfsdf.com/playerdetails','ACTIVE','Just for player details'),(18,'Show Player wallet',17,'http://www.sdfsdf.com/playerdetails','ACTIVE','Just for player details'),(19,'Show Player game',18,'http://www.sdfsdf.com/playerdetails','ACTIVE','Just for player details');
/*!40000 ALTER TABLE `hk_menu_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hk_share_map`
--

DROP TABLE IF EXISTS `hk_share_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hk_share_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `txn_id` int(11) NOT NULL,
  `share_type` enum('PROVIDE','CONSUME') NOT NULL,
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hk_share_map`
--

LOCK TABLES `hk_share_map` WRITE;
/*!40000 ALTER TABLE `hk_share_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `hk_share_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hk_transaction`
--

DROP TABLE IF EXISTS `hk_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hk_transaction` (
  `txn_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(10) unsigned NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` enum('SETTLED','UNSETTLED') NOT NULL,
  PRIMARY KEY (`txn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hk_transaction`
--

LOCK TABLES `hk_transaction` WRITE;
/*!40000 ALTER TABLE `hk_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `hk_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hk_user`
--

DROP TABLE IF EXISTS `hk_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hk_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` int(15) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `user_type` enum('ADMIN','NUTRAL') DEFAULT NULL,
  `avatar` varchar(150) DEFAULT 'default.jpg',
  `gender` enum('M','F') DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `regstration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hk_user`
--

LOCK TABLES `hk_user` WRITE;
/*!40000 ALTER TABLE `hk_user` DISABLE KEYS */;
INSERT INTO `hk_user` VALUES (17,'lokesh',NULL,NULL,'loki@gmail.com',NULL,NULL,NULL,NULL,NULL,'74c08208d605a5c7081ccc4b788e8240','2016-06-25 09:40:48','ACTIVE'),(18,'preetam',NULL,NULL,'preetam.damend@gmail.com',NULL,NULL,NULL,NULL,NULL,'9b4837151e9d6393c8e7e182a04fafd6','2016-06-25 21:21:53','ACTIVE'),(19,'Nannhe',NULL,NULL,'nannhe@gmail.com',NULL,NULL,NULL,NULL,NULL,'58ba96c886bee36ea51c59430b4ce9e7','2016-06-26 11:33:02','ACTIVE'),(20,'Kadar',NULL,NULL,'kadar@yahoo.com',NULL,NULL,NULL,NULL,NULL,'a4d6bbba5fff9122c96823bca4baabd5','2016-09-18 17:26:57','ACTIVE');
/*!40000 ALTER TABLE `hk_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hk_user_login_status`
--

DROP TABLE IF EXISTS `hk_user_login_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hk_user_login_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `login_status` enum('LOGGED_IN','LOGGED_OUT') NOT NULL,
  `activity_date` timestamp NULL DEFAULT NULL,
  `session_id` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hk_user_login_status`
--

LOCK TABLES `hk_user_login_status` WRITE;
/*!40000 ALTER TABLE `hk_user_login_status` DISABLE KEYS */;
INSERT INTO `hk_user_login_status` VALUES (1,17,'LOGGED_IN','2016-09-18 17:25:26','7BCE7D6B8F891E3E9B54421EDE12C3FD'),(5,18,'LOGGED_IN','2016-06-25 21:22:28','6415C6A3B0A77DC706D52A8CC15BE90E'),(6,19,'LOGGED_IN','2016-06-26 15:05:25','26EC40E6BD063D917AF40907DC59CE47');
/*!40000 ALTER TABLE `hk_user_login_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-14  1:46:22
