-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: springbootdb
-- ------------------------------------------------------
-- Server version	5.7.40-log

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
-- Table structure for table `t_habit`
--

DROP TABLE IF EXISTS `t_habit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_habit` (
  `habit_idx` int(11) NOT NULL AUTO_INCREMENT,
  `habit_content` varchar(50) NOT NULL,
  `regist_dt` datetime DEFAULT NULL,
  `delete_yn` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`habit_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_habit`
--

LOCK TABLES `t_habit` WRITE;
/*!40000 ALTER TABLE `t_habit` DISABLE KEYS */;
INSERT INTO `t_habit` VALUES (1,'','2023-05-02 13:14:08','Y'),(2,'안녕!','2023-05-02 13:14:19','Y'),(3,'미니','2023-04-01 12:11:11','N'),(4,'하나 더!','2023-05-02 15:57:36','Y'),(5,'둘 더!','2023-05-02 15:57:40','Y'),(6,'셋 더!','2023-05-02 15:57:44','Y'),(7,'셋','2023-05-03 15:36:06','Y'),(8,'넷','2023-05-03 15:36:07','Y'),(9,'된다!','2023-05-03 15:45:52','Y'),(10,'헤빗트래커','2023-05-03 16:09:25','N');
/*!40000 ALTER TABLE `t_habit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-04  9:57:33
DELIMITER $$
CREATE TRIGGER trg_insert_habit AFTER INSERT ON t_habit
FOR EACH ROW
BEGIN
DECLARE last_day DATE;
DECLARE t_dt DATE;

SET t_dt = DATE_FORMAT(NEW.regist_dt, '%Y-%m-01');
SET last_day = LAST_DAY(t_dt);

WHILE t_dt <= last_day DO
INSERT INTO t_habit_history (habit_idx, done_dt, done_yn)
VALUES (NEW.habit_idx, t_dt, false);
SET t_dt = DATE_ADD(t_dt, INTERVAL 1 DAY);
END WHILE;
END $$
DELIMITER ;