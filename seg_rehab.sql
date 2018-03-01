CREATE DATABASE  IF NOT EXISTS `rehab` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rehab`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rehab
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `contractors`
--

DROP TABLE IF EXISTS `contractors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractors` (
  `contractor_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_company_name` varchar(45) DEFAULT NULL,
  `c_contact_last_name` varchar(45) DEFAULT NULL,
  `c_contact_first_name` varchar(45) DEFAULT NULL,
  `c_email` varchar(45) DEFAULT NULL,
  `c_phone` varchar(45) DEFAULT NULL,
  `c_street_address1` varchar(45) DEFAULT NULL,
  `c_street_address2` varchar(45) DEFAULT NULL,
  `c_city` varchar(45) DEFAULT NULL,
  `c_state` varchar(45) DEFAULT NULL,
  `c_zipcode` varchar(45) DEFAULT NULL,
  `c_license` varchar(45) DEFAULT NULL,
  `c_insurance` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`contractor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contractors`
--

LOCK TABLES `contractors` WRITE;
/*!40000 ALTER TABLE `contractors` DISABLE KEYS */;
INSERT INTO `contractors` VALUES (1,'Parker  Builds LCC','Parker','Neil','neil.parker@noemail.com','717-719-2346','1009 Cordelia Road','','Lancaster','PA','17605','DE 75-7051702','StatePlace\r'),(2,'Clutten Works','Clutten','Aaron','aclutten@chron.com','610-222-2370','29 Forest Dale Court','','Philadelphia','PA','19178','DE 17-2219115','NoState Insurance\r'),(3,'CH Construction','Hancox','Chase','chancoxu@purevolume.com','302-449-1596','4976 Little Fleur Center','','Wilmington','DE','19886','DE 42-4996259','Nationnarrow\r'),(4,'Yats Builds','Yatman','Sloan','syatman12@vistaprint.com','302-118-9465','47131 Pepper Wood Terrace','','Wilmington','DE','19897','DE 23-9926890','STG Insurance\r'),(5,'JW Repairs','Witchard','Jerome','jwitchard1d@businesswire.com','302-849-2871','1 Gulseth Trail','','Wilmington','DE','19886','DE 09-0137088','Empire Light\r'),(6,'Spenton LLC','Spenton','Ben','bspenton26@studiopress.com','410-381-9239','82 Fulton Center','','Elkton','MD','21921','DE 87-9398282','Nationnarrow\r'),(7,'MH Builds LLC','Morch','Herbert','hmorch2v@goo.gl','215-296-8115','06451 Park Meadow Parkway','','Philadelphia','PA','19136','DE 09-8466559','Empire Light\r'),(8,'Patch Repairs LLC','Harman','Tabina','tharman2y@patch.com','302-562-8324','5 Mayfield Plaza','','Newark','DE','19714','DE 66-0961418','STG Insurance\r'),(9,'Bonelle Construction','Bonelle','James','jbonelle43@biglobe.ne.jp','302-507-1438','2 Bayside Park','','Wilmington','DE','19897','DE 15-2873834','Empire Light\r'),(10,'Mitch Landscape & More','Mitchenson','Fernando','fmitchenson48@theglobeandmail.com','302-113-9898','061 Florence Road','','Newark','DE','19725','DE 64-4601767','NoState Insurance');
/*!40000 ALTER TABLE `contractors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contractors_specialities`
--

DROP TABLE IF EXISTS `contractors_specialities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contractors_specialities` (
  `contractor_speciality_id` int(11) NOT NULL AUTO_INCREMENT,
  `cs_contractor` int(11) DEFAULT NULL,
  `cs_speciality` int(11) DEFAULT NULL,
  PRIMARY KEY (`contractor_speciality_id`),
  KEY `contractor_idx` (`cs_contractor`),
  KEY `speciality_idx` (`cs_speciality`),
  CONSTRAINT `contractor` FOREIGN KEY (`cs_contractor`) REFERENCES `contractors` (`contractor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `speciality` FOREIGN KEY (`cs_speciality`) REFERENCES `specialities` (`speciality_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contractors_specialities`
--

LOCK TABLES `contractors_specialities` WRITE;
/*!40000 ALTER TABLE `contractors_specialities` DISABLE KEYS */;
INSERT INTO `contractors_specialities` VALUES (1,10,7),(2,10,5),(3,10,1),(4,1,1),(5,1,2),(6,1,3),(7,1,4),(8,1,5),(9,1,6),(10,1,7),(11,1,8),(12,2,2),(13,2,3),(14,2,5),(15,3,1),(16,3,2),(17,3,5),(18,3,8),(19,3,7),(20,4,2),(21,4,3),(22,4,4),(23,4,5),(24,4,6),(25,4,8),(26,6,4),(27,6,6),(28,5,2),(29,5,3),(30,5,5),(31,7,1),(32,7,2),(33,7,3),(34,7,4),(35,7,5),(36,7,6),(37,7,8),(38,8,4),(39,8,5),(40,8,6),(41,9,1),(42,9,4),(43,9,6);
/*!40000 ALTER TABLE `contractors_specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estimates`
--

DROP TABLE IF EXISTS `estimates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estimates` (
  `estimate_id` int(11) NOT NULL AUTO_INCREMENT,
  `e_task` int(11) DEFAULT NULL,
  `e_contractor` int(11) DEFAULT NULL,
  `e_quote` double DEFAULT NULL,
  `e_deadline` date DEFAULT NULL,
  PRIMARY KEY (`estimate_id`),
  KEY `task_idx` (`e_task`),
  KEY `contractor_idx` (`e_contractor`),
  CONSTRAINT `es_contractor` FOREIGN KEY (`e_contractor`) REFERENCES `contractors` (`contractor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `task` FOREIGN KEY (`e_task`) REFERENCES `tasks` (`task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estimates`
--

LOCK TABLES `estimates` WRITE;
/*!40000 ALTER TABLE `estimates` DISABLE KEYS */;
/*!40000 ALTER TABLE `estimates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `properties`
--

DROP TABLE IF EXISTS `properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `properties` (
  `property_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(255) NOT NULL,
  `p_street_address1` varchar(45) NOT NULL,
  `p_street_address2` varchar(45) DEFAULT NULL,
  `p_city` varchar(45) DEFAULT NULL,
  `p_state` varchar(45) DEFAULT NULL,
  `p_zipcode` varchar(45) DEFAULT NULL,
  `p_purchase_date` date DEFAULT NULL,
  `p_purchase_price` double DEFAULT NULL,
  `p_goal_complete_date` date DEFAULT NULL,
  `p_total_budget` double DEFAULT NULL,
  PRIMARY KEY (`property_id`),
  UNIQUE KEY `p_name_UNIQUE` (`p_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` VALUES (1,'Anderson','1871 Anderson Point','','Newark','DE','19714','2017-11-02',219000,'2018-06-30',40000),(2,'Bobwhite','19 Bobwhite Alley','','Newark','DE','19716','2017-10-05',90000,'2018-05-31',25000),(3,'Marquette','3904 Marquette Drive','','Wilmington','DE','19886','2017-07-25',175000,'2018-09-01',70000),(4,'Elgar','5803 Elgar Terrace','','Wilmington','DE','19810','2017-12-15',110000,'2018-04-30',12000);
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialities`
--

DROP TABLE IF EXISTS `specialities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialities` (
  `speciality_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`speciality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialities`
--

LOCK TABLES `specialities` WRITE;
/*!40000 ALTER TABLE `specialities` DISABLE KEYS */;
INSERT INTO `specialities` VALUES (1,'Roofing and Siding\r'),(2,'Plumbing\r'),(3,'Flooring\r'),(4,'Electrical\r'),(5,'Painting and Drywall\r'),(6,'HVAC\r'),(7,'Landscaping\r'),(8,'Kitchen');
/*!40000 ALTER TABLE `specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_property` int(11) NOT NULL,
  `t_specialty` int(11) DEFAULT NULL,
  `t_estimate_selected` int(11) DEFAULT NULL,
  `t_budget_price` double DEFAULT NULL,
  `t_acutal_price` double DEFAULT NULL,
  `t_goal_complete_date` date DEFAULT NULL,
  `t_acutal_complete_date` date DEFAULT NULL,
  `t_detail_description` varchar(255) DEFAULT NULL,
  `t_notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `property_idx` (`t_property`),
  KEY `specialty_idx` (`t_specialty`),
  KEY `estimate_selected_idx` (`t_estimate_selected`),
  CONSTRAINT `estimate_selected` FOREIGN KEY (`t_estimate_selected`) REFERENCES `estimates` (`estimate_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `property` FOREIGN KEY (`t_property`) REFERENCES `properties` (`property_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `specialty` FOREIGN KEY (`t_specialty`) REFERENCES `specialities` (`speciality_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-01 17:59:36
