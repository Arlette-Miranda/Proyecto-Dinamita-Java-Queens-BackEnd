CREATE DATABASE  IF NOT EXISTS `yoatzin` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `yoatzin`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: yoatzin
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id_address` bigint NOT NULL AUTO_INCREMENT,
  `state` varchar(20) NOT NULL,
  `city` varchar(50) NOT NULL,
  `colony` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  `zipcode` varchar(5) NOT NULL,
  `reference` varchar(45) DEFAULT NULL,
  `fk_id_user` bigint NOT NULL,
  PRIMARY KEY (`id_address`),
  KEY `addresses_has_user_idx` (`fk_id_user`),
  CONSTRAINT `addresses_has_user` FOREIGN KEY (`fk_id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'Ciudad de México','Cuauhtémoc','Roma Norte','Avenida Insurgentes','6700','Cerca de Plaza Insurgentes',2),(2,'Jalisco','Guadalajara','Zapata','Avenida Vallarta','44100','A un lado de Starbucks',2),(3,'Nuevo León','Monterrey','San Pedro','Avenida Alfonso Reyes','66260','Cerca de Parque Hundido',5),(4,'Yucatán','Mérida','Centro','Calle 60','97000','Cruzando la Plaza Principal',5),(5,'Puebla','Puebla','Angelópolis','Boulevard Atlixco','72570','Junto a la Plaza Angelópolis',6);
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards` (
  `id_card` bigint NOT NULL AUTO_INCREMENT,
  `number` varchar(16) NOT NULL,
  `owner_card` varchar(100) NOT NULL,
  `month` varchar(2) NOT NULL,
  `year` varchar(4) NOT NULL,
  `cvc` varchar(4) NOT NULL,
  `fk_id_user` bigint NOT NULL,
  PRIMARY KEY (`id_card`),
  KEY `cards_has_users_idx` (`fk_id_user`),
  CONSTRAINT `cards_has_users` FOREIGN KEY (`fk_id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (1,'1234567812345678','Laura Gómez Pérez','12','2025','123',2),(2,'8765432187654321','Julieta Fierro Domínguez','6','2024','456',2),(3,'2345678923456789','Ana Cruz Atienza','3','2026','789',5),(4,'3456789034567890','Juan Roberto Fernández Rodríguez','11','2024','12',6),(5,'4567890145678901','Emily Pérez Sánchez','8','2025','345',5);
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id_comment` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(280) DEFAULT NULL,
  `fk_id_user` bigint NOT NULL,
  PRIMARY KEY (`id_comment`),
  KEY `comments_has_user_idx` (`fk_id_user`),
  CONSTRAINT `comments_has_user` FOREIGN KEY (`fk_id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Gran producto. Compra muy rápida',2),(2,'Voy a compartir este producto a todos mis conocidos. Está genial!',2),(3,'Excelente servicio. Me encantó el color azul. 5 estrellas',5),(4,'Me encanta el diseño de esta bolsa artesanal',5),(5,'Recomiendo este producto',6);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id_order` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `date` datetime NOT NULL,
  `fk_id_user` bigint NOT NULL,
  `fk_id_card` bigint NOT NULL,
  `fk_id_address` bigint NOT NULL,
  PRIMARY KEY (`id_order`,`fk_id_card`,`fk_id_address`),
  KEY `orders_has_cards_idx` (`fk_id_card`),
  KEY `orders_has_users_idx` (`fk_id_user`),
  KEY `orders_has_addresses_idx` (`fk_id_address`),
  CONSTRAINT `orders_has_addresses` FOREIGN KEY (`fk_id_address`) REFERENCES `addresses` (`id_address`),
  CONSTRAINT `orders_has_cards` FOREIGN KEY (`fk_id_card`) REFERENCES `cards` (`id_card`),
  CONSTRAINT `orders_has_users` FOREIGN KEY (`fk_id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'2024-07-30 08:00:00',2,1,1),(2,2,'2024-07-30 09:30:00',5,3,4),(3,1,'2024-07-30 11:00:00',6,4,5),(4,3,'2024-07-30 12:30:00',2,1,1),(5,1,'2024-07-30 14:00:00',5,3,4);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privileges`
--

DROP TABLE IF EXISTS `privileges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `privileges` (
  `id_privilege` bigint NOT NULL AUTO_INCREMENT,
  `privilege` varchar(20) NOT NULL,
  `description` longtext,
  PRIMARY KEY (`id_privilege`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privileges`
--

LOCK TABLES `privileges` WRITE;
/*!40000 ALTER TABLE `privileges` DISABLE KEYS */;
INSERT INTO `privileges` VALUES (1,'gerencia','Persona que está a cargo de la dirección y coordinación de la empresa/organización, tendrá acceso a la visualización de todos los datos generados en la aplicación.'),(2,'cliente','Persona que ingresa a al aplicación para adquirir productos a traves del registro, así como a dejar comentarios.'),(3,'admin_almacen','Persona encargada de actualizar el inventario de productos en existencia.'),(4,'admin_general','Persona encargada de la administración de todos los departamentos, así como actualización de precios.'),(5,'desarrollador','Persona encargada de el desarrollo y funcionalidad del sitio web.');
/*!40000 ALTER TABLE `privileges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id_product` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `image` varchar(250) NOT NULL,
  `origin` varchar(70) DEFAULT NULL,
  `stock` int NOT NULL,
  `description` longtext,
  `fk_id_size` bigint NOT NULL,
  PRIMARY KEY (`id_product`,`fk_id_size`),
  KEY `products_has_sizes_idx` (`fk_id_size`),
  CONSTRAINT `products_has_sizes` FOREIGN KEY (`fk_id_size`) REFERENCES `sizes` (`id_size`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Vaso de Barro','Cerámica',15.00,'/img/vaso de barro negro.jpg','Oaxaca, México',50,'Elegante vaso de barro negro meticulosamente decorado con delicadas flores, creando una obra de arte funcional que combina tradición y belleza. Cada flor está cuidadosamente pintada a mano por nuestros artesanos oaxaqueños, resaltando detalles vívidos y colores contrastantes que resaltan sobre el fondo. Ofrece una experiencia táctil única que es ideal tanto como pieza decorativa como para su uso diario, este vaso añadirá un toque de distinción y autenticidad a cualquier ambiente.',6),(2,'Sombrero de Palma','Textiles',20.00,'/img/sombrero de palma.jpg','Yucatán, México',50,'Este encantador sombrero está tejido a mano con palma natural de las regiones de Yucatán, ofreciendo un estilo clásico y funcionalidad ideal para días soleados. Su diseño ligero y transpirable proporciona comodidad durante horas, mientras que el tejido artesanalmente asegura durabilidad y resistencia. Elaborado con materiales naturales y un cuidado artesanal, cada sombrero es único, reflejando la habilidad y la tradición de los artesanos que lo crearon.',6),(3,'Bolsa de Mimbre','Textiles',25.00,'/img/bolsa de mimbre.jpg','Chiapas, México',50,'Esta encantadora bolsa de mimbre fusiona elegancia y tradición con su diseño mexicano auténtico de Chiapas. El mimbre tejido a mano ofrece una estructura robusta y ligera, perfecta para llevar tus pertenencias con estilo. Decorada con detalles típicos mexicanos como bordados vibrantes, pompones coloridos y figuras geométricas inspiradas en la artesanía tradicional, cada bolsa es una obra de arte única. Su tamaño espacioso y práctico la convierte en un accesorio versátil para el día a día.',6),(4,'Tapete de Lana','Textiles',50.00,'/img/tapete de lana.jpg','Zacatecas, México',50,'Este exquisito tapete de lana combina la calidez y la suavidad natural con un diseño decorativo que realza cualquier espacio. Tejido a mano con técnicas tradicionales de Zacatecas, cada detalle en su patrón está meticulosamente trabajado para crear una obra de arte funcional. Los colores ricos y las texturas sutiles resaltan el trabajo artesanal, mientras que el decorativo de flores, añade un toque de elegancia y estilo. Este tapete no solo proporciona confort bajo los pies, sino que también se convierte en el punto focal de cualquier habitación, reflejando el cuidado y la habilidad de los artesanos que lo crearon. Perfecto para añadir calidez y personalidad a tu hogar.',6),(5,'Máscara de Madera','Decoración',30.00,'/img/mascara de madera.jpg','Guerrero, México',50,'Esta impresionante máscara de madera mexicana es una expresión vibrante de la rica cultura y tradición artesanal del Estado de Guerrero. Tallada a mano por hábiles artesanos, cada detalle de esta máscara refleja el profundo simbolismo y la historia que envuelve la iconografía mexicana. Los colores brillantes y los patrones intrincados pintados a mano resaltan contra el fondo de madera natural, creando una obra de arte única y cautivadora.',3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_has_orders`
--

DROP TABLE IF EXISTS `products_has_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_has_orders` (
  `id_product` bigint NOT NULL,
  `id_order` bigint NOT NULL,
  `partial_amount` decimal(10,2) NOT NULL,
  `discount` decimal(10,2) NOT NULL,
  `shipment` decimal(10,2) NOT NULL,
  `final_amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_product`,`id_order`),
  KEY `fk_products_has_orders_orders1_idx` (`id_order`),
  KEY `fk_products_has_orders_products1_idx` (`id_product`),
  CONSTRAINT `fk_products_has_orders_orders1` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`),
  CONSTRAINT `fk_products_has_orders_products1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id_product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_has_orders`
--

LOCK TABLES `products_has_orders` WRITE;
/*!40000 ALTER TABLE `products_has_orders` DISABLE KEYS */;
INSERT INTO `products_has_orders` VALUES (1,1,15.00,1.50,0.00,13.50),(1,4,15.00,1.50,0.00,13.50),(2,2,20.00,2.00,0.00,18.00),(2,5,20.00,2.00,0.00,18.00),(3,2,25.00,2.50,0.00,22.50),(3,4,25.00,2.50,0.00,22.50),(4,3,50.00,5.00,0.00,45.00),(4,4,50.00,5.00,0.00,45.00);
/*!40000 ALTER TABLE `products_has_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes` (
  `id_size` bigint NOT NULL AUTO_INCREMENT,
  `size` varchar(10) NOT NULL,
  PRIMARY KEY (`id_size`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (1,'XS'),(2,'S'),(3,'M'),(4,'L'),(5,'XL'),(6,'Unitalla');
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  `fk_id_privilege` bigint NOT NULL,
  PRIMARY KEY (`id_user`,`fk_id_privilege`),
  KEY `user_has_privilege_idx` (`fk_id_privilege`),
  CONSTRAINT `user_has_privilege` FOREIGN KEY (`fk_id_privilege`) REFERENCES `privileges` (`id_privilege`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Carlos','Mendoza Ruíz','5551234567','carlos.mendoza@example.com','password1',1),(2,'Laura','Gómez Pérez','5552345678','laura.gomez@example.com','password2',2),(3,'Sofia','Martínez Pineda','5553456789','sofia.martinez@example.com','password3',3),(4,'Jorge','Ramírez Sánchez','5554567890','jorge.ramirez@example.com','password4',4),(5,'Ana','Cruz Atienza','5555678901','ana.cruz@example.com','password5',2),(6,'Juan Roberto','Fernández Rodríguez','5556789012','roberto.fernandez@example.com','password6',2),(7,'María','Gonzalez López','5567852618','maria.gonzalez@example.com','password7',5);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-29 20:28:37
