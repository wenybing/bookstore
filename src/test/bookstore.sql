/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `bookstore`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_bin NOT NULL,
  `author` varchar(100) COLLATE utf8_bin NOT NULL,
  `price` varchar(100) COLLATE utf8_bin NOT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `imgPath` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`author`,`price`,`sales`,`stock`,`imgPath`) values (1,'三国演义','罗贯中','80.00',500,1000,NULL),(2,'西游记','吴承恩','78.00',500,800,NULL),(18,'红楼梦','曹雪芹','89.00',800,1000,NULL),(33,'葫芦娃兄弟','葫芦','20.0',500,100,NULL),(34,'诛仙','萧鼎','50.0',1000,2000,NULL),(35,'AA','DD','50.0',400,800,NULL),(36,'BB','SS','20.0',300,500,NULL),(37,'解忧杂货店','东野圭吾','27.20',100,100,'static/img/default.jpg'),(38,'边城','沈从文','23.00',100,100,'static/img/default.jpg'),(39,'中国哲学史','冯友兰','44.5',100,100,'static/img/default.jpg'),(40,'忽然七日',' 劳伦','19.33',100,100,'static/img/default.jpg'),(41,'苏东坡传','林语堂','19.30',100,100,'static/img/default.jpg'),(42,'百年孤独','马尔克斯','29.50',100,100,'static/img/default.jpg'),(43,'扶桑','严歌苓','19.8',100,100,'static/img/default.jpg'),(44,'教父','马里奥·普佐','29.00',100,100,'static/img/default.jpg'),(45,'给孩子的诗','北岛','22.20',100,100,'static/img/default.jpg'),(46,'为奴十二年','所罗门','16.5',100,100,'static/img/default.jpg'),(47,'平凡的世界','路遥','55.00',100,100,'static/img/default.jpg'),(48,'悟空传','今何在','14.00',100,100,'static/img/default.jpg'),(49,'硬派健身','斌卡','31.20',100,100,'static/img/default.jpg'),(51,'三体','刘慈欣','56.5',100,100,'static/img/default.jpg'),(52,'看见','柴静','19.50',100,100,'static/img/default.jpg'),(53,'活着','余华','11.00',100,100,'static/img/default.jpg'),(65,'AA','AA','24',200,200,NULL),(66,'AA','SS','22',333,444,NULL),(67,'SS','FF','55',55,55,NULL),(68,'DD','SS','44',55,66,NULL),(69,'KK','YY','33.0',55,66,NULL),(70,'GG','MM','44.0',55,66,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`) values (1,'admin','ac77580d5690fbd251e6ca594c9846a6','admin@qq.com'),(2,'user','a34e858a182ac9e977de1a042728bc2f','user@163.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
