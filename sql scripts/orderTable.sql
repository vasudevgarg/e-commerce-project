--
-- Table structure for table `order`
--
USE `ecommerceDB`;

DROP TABLE IF EXISTS `parcel`;
CREATE TABLE `parcel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `cost` int NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES product(`id`),
  FOREIGN KEY (`customer_id`) REFERENCES customer(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
