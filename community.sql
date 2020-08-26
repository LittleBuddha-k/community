/*
SQLyog Ultimate v8.32 
MySQL - 5.5.34 : Database - community
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`community` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `community`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `comment_by` varchar(64) DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  `fabulous` int(11) DEFAULT '0',
  `comment_content` text,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `comment` */

insert  into `comment`(`id`,`parent_id`,`type`,`comment_by`,`comment_count`,`fabulous`,`comment_content`,`create_date`,`create_by`,`update_date`,`update_by`) values ('3412ccf5e43445bdac81216f38f0eb9f','8190c01e6ac7431b993a4b391ef56242','2',NULL,0,NULL,'dghkdgy','2020-08-13 15:12:09','caa700ba2daf48c8988847ffbbd0067e','2020-08-13 15:12:09','caa700ba2daf48c8988847ffbbd0067e'),('8190c01e6ac7431b993a4b391ef56242','defdb301f00d42e8b13240820d7ee821','1',NULL,2,NULL,'gegeg','2020-08-13 15:09:33','caa700ba2daf48c8988847ffbbd0067e','2020-08-13 15:09:33','caa700ba2daf48c8988847ffbbd0067e'),('8bdb499d28c14e95b76f7cc5b26595ca','8190c01e6ac7431b993a4b391ef56242','2',NULL,0,NULL,'sdsdsdsd','2020-08-13 15:09:37','caa700ba2daf48c8988847ffbbd0067e','2020-08-13 15:09:37','caa700ba2daf48c8988847ffbbd0067e'),('8c71a746a3c34637b5cc77e6cf3f828a','44d268fdc8c344d2a0ab59780162a82f','1',NULL,0,NULL,'卧槽','2020-06-18 09:40:46','caa700ba2daf48c8988847ffbbd0067e','2020-06-18 09:40:46','caa700ba2daf48c8988847ffbbd0067e');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` varchar(64) NOT NULL,
  `notice_user` varchar(64) DEFAULT NULL,
  `receive_user` varchar(64) DEFAULT NULL,
  `notice_project` varchar(64) DEFAULT NULL,
  `notice_type` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `notice` */

insert  into `notice`(`id`,`notice_user`,`receive_user`,`notice_project`,`notice_type`,`status`,`create_date`) values ('141aeeef608b40f3ac9c9a8cd77f15ca','caa700ba2daf48c8988847ffbbd0067e','caa700ba2daf48c8988847ffbbd0067e','8190c01e6ac7431b993a4b391ef56242',1,0,'2020-08-13 15:09:37'),('9f2375fe9b8548b68dd0e9402a6466c6','caa700ba2daf48c8988847ffbbd0067e','caa700ba2daf48c8988847ffbbd0067e','8190c01e6ac7431b993a4b391ef56242',1,0,'2020-08-13 15:12:09'),('baa494f55e054063b5b05cd5d0eaac4a','caa700ba2daf48c8988847ffbbd0067e','caa700ba2daf48c8988847ffbbd0067e','44d268fdc8c344d2a0ab59780162a82f',0,0,'2020-06-18 09:40:46'),('c3c7a8f3bd73493ba06ae8ee53a2f078','caa700ba2daf48c8988847ffbbd0067e','caa700ba2daf48c8988847ffbbd0067e','defdb301f00d42e8b13240820d7ee821',0,0,'2020-08-13 15:09:33');

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` varchar(64) NOT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `permission` */

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` varchar(64) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `content` text,
  `enclosure` varchar(64) DEFAULT NULL,
  `tags` varchar(64) DEFAULT NULL,
  `anonymous` varchar(64) DEFAULT NULL,
  `comments` int(11) DEFAULT '0',
  `view` int(11) DEFAULT '0',
  `attention` int(11) DEFAULT '0',
  `reply` int(11) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `question` */

insert  into `question`(`id`,`title`,`type`,`content`,`enclosure`,`tags`,`anonymous`,`comments`,`view`,`attention`,`reply`,`create_date`,`create_by`,`update_date`,`update_by`) values ('defdb301f00d42e8b13240820d7ee821','测试/community',NULL,'![![](/community/upload/cf4a6067-b76b-4ab6-93a7-6b9d70f70c16.jpg)](/community/upload/e353b870-521b-4a14-a6e1-46019c25b1ab.jpg)','','Spring、Java、SpringMVC',NULL,1,12,0,0,'2020-06-19 15:47:49','caa700ba2daf48c8988847ffbbd0067e','2020-06-19 15:47:49','caa700ba2daf48c8988847ffbbd0067e');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `role` */

/*Table structure for table `role_permission` */

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission` (
  `id` varchar(64) NOT NULL,
  `role_id` varchar(64) DEFAULT NULL,
  `permission_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `role_permission` */

/*Table structure for table `tags_name` */

DROP TABLE IF EXISTS `tags_name`;

CREATE TABLE `tags_name` (
  `id` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `tags_name` */

/*Table structure for table `tags_value` */

DROP TABLE IF EXISTS `tags_value`;

CREATE TABLE `tags_value` (
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `tags_value` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(64) NOT NULL,
  `account` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `picture` varchar(100) DEFAULT '无',
  `sex` varchar(64) DEFAULT NULL,
  `age` varchar(64) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `github_id` varchar(64) DEFAULT NULL,
  `token` varchar(64) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `ip_name` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(64) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `user` */

insert  into `user`(`id`,`account`,`name`,`password`,`picture`,`sex`,`age`,`address`,`github_id`,`token`,`ip`,`ip_name`,`create_date`,`create_by`,`update_date`,`update_by`) values ('caa700ba2daf48c8988847ffbbd0067e','admin',NULL,'admin','/community/upload/285610d9-74de-4074-9ad4-b096a9f3cfd2.jpg',NULL,NULL,NULL,NULL,NULL,'192.168.43.215','DESKTOP-OH494IN','2020-05-19 16:28:33',NULL,'2020-05-19 16:28:33',NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `role_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
