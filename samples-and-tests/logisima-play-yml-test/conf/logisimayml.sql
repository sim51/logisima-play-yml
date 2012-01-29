-- MySQL dump 10.13  Distrib 5.5.15, for Linux (x86_64)
--
-- Host: localhost    Database: logisimayml
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `content` longtext,
  `postedAt` datetime DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9BDE863F388562DE` (`post_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
INSERT INTO `Comment` VALUES (1,'Guest','You are right !\n',NULL,1),(2,'Mike','I knew that ...\n',NULL,1),(3,'Tom','This post is useless ?\n',NULL,2);
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comment2`
--

DROP TABLE IF EXISTS `Comment2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Comment2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `content` longtext,
  `postedAt` datetime DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDFF241D3407F0A34` (`post_id`),
  CONSTRAINT `FKDFF241D3407F0A34` FOREIGN KEY (`post_id`) REFERENCES `Post2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment2`
--

LOCK TABLES `Comment2` WRITE;
/*!40000 ALTER TABLE `Comment2` DISABLE KEYS */;
INSERT INTO `Comment2` VALUES (1,'Tom','This post is useless ?\n',NULL,3),(2,'Mike','I knew that ...\n',NULL,2),(3,'Guest','You are right !\n',NULL,2);
/*!40000 ALTER TABLE `Comment2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Date`
--

DROP TABLE IF EXISTS `Date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Date` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cal1` datetime DEFAULT NULL,
  `cal2` date DEFAULT NULL,
  `cal4` datetime DEFAULT NULL,
  `date1` datetime DEFAULT NULL,
  `date2` date DEFAULT NULL,
  `date3` time DEFAULT NULL,
  `date4` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Date`
--

LOCK TABLES `Date` WRITE;
/*!40000 ALTER TABLE `Date` DISABLE KEYS */;
INSERT INTO `Date` VALUES (1,'2009-07-25 13:42:51','2010-07-26','2011-07-25 13:42:51','2012-07-25 13:49:42','2013-07-25','13:49:42','2014-07-25 13:49:42');
/*!40000 ALTER TABLE `Date` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Date2`
--

DROP TABLE IF EXISTS `Date2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Date2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cal1` datetime DEFAULT NULL,
  `cal2` date DEFAULT NULL,
  `cal4` datetime DEFAULT NULL,
  `date1` datetime DEFAULT NULL,
  `date2` date DEFAULT NULL,
  `date3` time DEFAULT NULL,
  `date4` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Date2`
--

LOCK TABLES `Date2` WRITE;
/*!40000 ALTER TABLE `Date2` DISABLE KEYS */;
INSERT INTO `Date2` VALUES (1,'2009-07-25 13:42:51','2010-07-26','2011-07-25 13:42:51','2012-07-25 13:49:42','2013-07-25','13:49:42','2014-07-25 13:49:42');
/*!40000 ALTER TABLE `Date2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post`
--

DROP TABLE IF EXISTS `Post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `postedAt` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK260CC074CA5CD7` (`author_email`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post`
--

LOCK TABLES `Post` WRITE;
/*!40000 ALTER TABLE `Post` DISABLE KEYS */;
INSERT INTO `Post` VALUES (1,'The model has a central position in a Play! application. It is the domain-specific representation of the information on which the application operates.\nMartin fowler defines it as :\nResponsible for representing concepts of the business, information about the business situation, and business rules. State that reflects the business situation is controlled and used here, even though the technical details of storing it are delegated to the infrastructure. This layer is the heart of business software.\n','2009-06-14 02:00:00','About the model layer','bob@gmail.com'),(2,'Well, it\'s just a test.\n','2009-03-25 01:00:00','Just a test of YABE','bob@gmail.com'),(3,'A Play! application follows the MVC architectural pattern as applied to the architecture of the Web.\nThis pattern splits the application into separate layers: the Presentation layer and the Model layer. The Presentation layer is further split into a View and a Controller layer.\n','2009-06-06 02:00:00','The MVC application','jeff@gmail.com');
/*!40000 ALTER TABLE `Post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post2`
--

DROP TABLE IF EXISTS `Post2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Post2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `postedAt` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK49B8B727D09C337` (`author_email`),
  CONSTRAINT `FK49B8B727D09C337` FOREIGN KEY (`author_email`) REFERENCES `User2` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post2`
--

LOCK TABLES `Post2` WRITE;
/*!40000 ALTER TABLE `Post2` DISABLE KEYS */;
INSERT INTO `Post2` VALUES (1,'A Play! application follows the MVC architectural pattern as applied to the architecture of the Web.\nThis pattern splits the application into separate layers: the Presentation layer and the Model layer. The Presentation layer is further split into a View and a Controller layer.\n','2009-06-06 02:00:00','The MVC application','jeff@gmail.com'),(2,'The model has a central position in a Play! application. It is the domain-specific representation of the information on which the application operates.\nMartin fowler defines it as :\nResponsible for representing concepts of the business, information about the business situation, and business rules. State that reflects the business situation is controlled and used here, even though the technical details of storing it are delegated to the infrastructure. This layer is the heart of business software.\n','2009-06-14 02:00:00','About the model layer','bob@gmail.com'),(3,'Well, it\'s just a test.\n','2009-03-25 01:00:00','Just a test of YABE','bob@gmail.com');
/*!40000 ALTER TABLE `Post2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post2_Tag2`
--

DROP TABLE IF EXISTS `Post2_Tag2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Post2_Tag2` (
  `Post2_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Post2_id`,`tags_id`),
  KEY `FK9DCE2CA584DFEA02` (`Post2_id`),
  KEY `FK9DCE2CA5B7150451` (`tags_id`),
  CONSTRAINT `FK9DCE2CA5B7150451` FOREIGN KEY (`tags_id`) REFERENCES `Tag2` (`id`),
  CONSTRAINT `FK9DCE2CA584DFEA02` FOREIGN KEY (`Post2_id`) REFERENCES `Post2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post2_Tag2`
--

LOCK TABLES `Post2_Tag2` WRITE;
/*!40000 ALTER TABLE `Post2_Tag2` DISABLE KEYS */;
/*!40000 ALTER TABLE `Post2_Tag2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Post_Tag`
--

DROP TABLE IF EXISTS `Post_Tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Post_Tag` (
  `Post_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Post_id`,`tags_id`),
  KEY `FK30FE237B222C70F7` (`tags_id`),
  KEY `FK30FE237B388562DE` (`Post_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Post_Tag`
--

LOCK TABLES `Post_Tag` WRITE;
/*!40000 ALTER TABLE `Post_Tag` DISABLE KEYS */;
INSERT INTO `Post_Tag` VALUES (1,5),(1,6),(2,7),(3,5),(3,6),(3,8);
/*!40000 ALTER TABLE `Post_Tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tag`
--

DROP TABLE IF EXISTS `Tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tag`
--

LOCK TABLES `Tag` WRITE;
/*!40000 ALTER TABLE `Tag` DISABLE KEYS */;
INSERT INTO `Tag` VALUES (1,'Play'),(2,'Architecture'),(3,'Test'),(4,'MVC');
/*!40000 ALTER TABLE `Tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tag2`
--

DROP TABLE IF EXISTS `Tag2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tag2` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tag2`
--

LOCK TABLES `Tag2` WRITE;
/*!40000 ALTER TABLE `Tag2` DISABLE KEYS */;
INSERT INTO `Tag2` VALUES (1,'Test'),(2,'MVC'),(3,'Play'),(4,'Architecture');
/*!40000 ALTER TABLE `Tag2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `email` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `isAdmin` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('bob@gmail.com','NANTES','FRANCE',21,'Paul Bellamy',44000,'Bob','\0','secret'),('jeff@gmail.com','NANTES','FRANCE',42,'Guichard',44100,'Jeff','\0','secret'),('paul@gmail.com','PARSI','FRANCE',51,'Hauffman',75000,'Paul','\0','secret');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User2`
--

DROP TABLE IF EXISTS `User2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User2` (
  `email` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `isAdmin` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User2`
--

LOCK TABLES `User2` WRITE;
/*!40000 ALTER TABLE `User2` DISABLE KEYS */;
INSERT INTO `User2` VALUES ('bob@gmail.com','NANTES','FRANCE',21,'Paul Bellamy',44000,'Bob','\0','secret'),('jeff@gmail.com','NANTES','FRANCE',42,'Guichard',44100,'Jeff','\0','secret'),('paul@gmail.com','PARSI','FRANCE',51,'Hauffman',75000,'Paul','\0','secret');
/*!40000 ALTER TABLE `User2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-01-29 21:57:27
