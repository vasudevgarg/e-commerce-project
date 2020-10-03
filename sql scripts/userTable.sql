--
-- Table structure for table `customer`
--
USE `ecommerceDB`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `mobile_no` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `customer` 
VALUES 
(1,'john','wick','1234567890'),
(2,'mary','lee','7894561230'),
(3,'susan','potter','4567891230');
