/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : newdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-03-17 08:21:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sgspunish
-- ----------------------------
DROP TABLE IF EXISTS `sgspunish`;
CREATE TABLE `sgspunish` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `causeTitle` varchar(500) DEFAULT NULL,
  `detailUrl` varchar(255) DEFAULT NULL,
  `punishFileNo` varchar(255) DEFAULT NULL,
  `unitTitle` varchar(255) DEFAULT NULL,
  `unitRegNo` varchar(255) DEFAULT NULL,
  `unitPerson` varchar(255) DEFAULT NULL,
  `actType` varchar(500) DEFAULT NULL,
  `punishOffice` varchar(255) DEFAULT NULL,
  `punishContent` text,
  `punishDate` varchar(255) DEFAULT NULL,
  `punishDocUrl` varchar(255) DEFAULT NULL,
  `timestamp` varchar(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `check` (`detailUrl`)
) ENGINE=MyISAM AUTO_INCREMENT=5231 DEFAULT CHARSET=utf8;
