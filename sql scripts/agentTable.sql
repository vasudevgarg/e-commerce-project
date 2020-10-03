USE `ecommerceDB`;

DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

