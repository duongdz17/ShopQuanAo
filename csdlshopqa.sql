-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: shopqa
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `anhnhataitro`
--

DROP TABLE IF EXISTS `anhnhataitro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anhnhataitro` (
  `maanhntt` int NOT NULL AUTO_INCREMENT,
  `tenanh` varchar(45) DEFAULT NULL,
  `anhnhatt` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`maanhntt`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anhnhataitro`
--

LOCK TABLES `anhnhataitro` WRITE;
/*!40000 ALTER TABLE `anhnhataitro` DISABLE KEYS */;
INSERT INTO `anhnhataitro` VALUES (1,'Ảnh 1','vendor-1.jpg'),(2,'Ảnh 2','vendor-2.jpg'),(3,'Ảnh 3','vendor-3.jpg'),(4,'Ảnh 4','vendor-4.jpg'),(5,'Ảnh 5','vendor-5.jpg'),(6,'Ảnh 6','vendor-6.jpg'),(7,'Ảnh 7','vendor-7.jpg'),(8,'Ảnh 8 ','vendor-8.jpg');
/*!40000 ALTER TABLE `anhnhataitro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhmuc` (
  `madanhmuc` int NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(50) DEFAULT NULL,
  `anhdanhmuc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (1,'Thời trang nam','cat-1.jpg'),(2,'Thời trang nữ','cat-2.jpg'),(3,'Thời trang trẻ em','cat-3.jpg');
/*!40000 ALTER TABLE `danhmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `madonhang` int NOT NULL AUTO_INCREMENT,
  `masanpham` int DEFAULT NULL,
  `userid` int NOT NULL,
  `hoten` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sodienthoai` varchar(45) DEFAULT NULL,
  `diachi` varchar(450) DEFAULT NULL,
  `soluong` int NOT NULL,
  `ngaydat` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`madonhang`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES (25,3,5,'Nguyễn Văn Dương','vanduong@gmail.com','0336401099','Quảng Ninh',1,'2023-11-12'),(26,4,5,'Nguyễn Văn Dương','vanduong@gmail.com','0336401099','Quảng Ninh',1,'2023-11-12'),(27,1,5,'Nguyễn Văn Dương','vanduong@gmail.com','0336401099','Quảng Ninh',1,'2023-11-12'),(28,2,5,'Nguyễn Văn Dương','vanduong@gmail.com','0336401099','Quảng Ninh',1,'2023-11-12'),(29,1,2,'Nguyễn Khải','khai@gmail.com','0123456789','Bắc Ninh',2,'2023-11-13'),(30,4,2,'Nguyễn Khải','khai@gmail.com','0123456789','Bắc Ninh',1,'2023-11-13'),(31,5,4,'Ngô Huyền Trang','nguyenduong171002@gmail.com','0838551086','Quảng Ninh',1,'2023-11-14');
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `mafeedback` int NOT NULL AUTO_INCREMENT,
  `phanhoi` varchar(500) NOT NULL,
  PRIMARY KEY (`mafeedback`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'Quần áo đẹp lắm'),(2,'Ship nhanh');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyentruycap`
--

DROP TABLE IF EXISTS `quyentruycap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quyentruycap` (
  `maquyentruycap` int NOT NULL AUTO_INCREMENT,
  `tenquyentruycap` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`maquyentruycap`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyentruycap`
--

LOCK TABLES `quyentruycap` WRITE;
/*!40000 ALTER TABLE `quyentruycap` DISABLE KEYS */;
INSERT INTO `quyentruycap` VALUES (1,'Admin'),(2,'Khách hàng');
/*!40000 ALTER TABLE `quyentruycap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `masanpham` int NOT NULL AUTO_INCREMENT,
  `tensanpham` varchar(50) DEFAULT NULL,
  `mota` varchar(500) DEFAULT NULL,
  `gia` double DEFAULT NULL,
  `giamgia` double DEFAULT NULL,
  `hinhanh` varchar(100) DEFAULT NULL,
  `madanhmuc` int DEFAULT NULL,
  `ngaytao` date DEFAULT NULL,
  PRIMARY KEY (`masanpham`),
  KEY `madanhmuc` (`madanhmuc`),
  CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`madanhmuc`) REFERENCES `danhmuc` (`madanhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Vest trắng','Đẹp',500000,5,'thoitrangnam-3.jpg',1,'2023-10-18'),(2,'Váy trắng','Đẹp',600000,6,'product-1.jpg',2,'2023-10-25'),(3,'Áo sơ mi - Quần bò ','Đẹp',500000,5,'product-8.jpg',3,'2023-10-09'),(4,'Vest đen nam','Đẹp',50000,5,'product-6.jpg',1,'2023-10-13'),(5,'Váy đen nữ','Đẹp',6000000,5,'product-7.jpg',2,'2023-10-02');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `hoten` varchar(50) DEFAULT NULL,
  `tendangnhap` varchar(50) DEFAULT NULL,
  `matkhau` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sodienthoai` varchar(45) DEFAULT NULL,
  `diachi` varchar(100) DEFAULT NULL,
  `ngaysinh` datetime DEFAULT NULL,
  `maquyentruycap` int DEFAULT NULL,
  `anhnguoidung` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `maquyentruycap` (`maquyentruycap`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`maquyentruycap`) REFERENCES `quyentruycap` (`maquyentruycap`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Nguyễn Đức Dương','admin','admin','nguyenduong@gmail.com','0336401099','Hạ Long','2023-11-17 00:00:00',1,''),(2,'Nguyễn Khải','khai','1234','khai@gmail.com','0123456789','Bắc Ninh','2023-11-16 00:00:00',2,''),(3,'Ngô Huyền Trang','nht ','nht123','ngohuyentrang086@gmail.com','0838551086','123','2002-02-27 00:00:00',2,NULL),(4,'Ngô Huyền Trang','nht','123','nguyenduong171002@gmail.com','0838551086','Quảng Ninh','2023-10-12 00:00:00',2,NULL),(5,'Nguyễn Văn Dương','vanduong','1234','vanduong@gmail.com','0336401099','Quảng Ninh','2023-10-27 00:00:00',2,NULL);
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

-- Dump completed on 2023-11-16 21:55:11
