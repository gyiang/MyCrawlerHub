/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : lbx

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-04-16 08:18:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for indeed
-- ----------------------------
DROP TABLE IF EXISTS `indeed`;
CREATE TABLE `indeed` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(255) DEFAULT NULL,
  `jobTitle` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `jobSummary` text,
  `jobSrc` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `collectedTime` datetime DEFAULT NULL,
  `jobSrcUrl` text,
  `urlMd5` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3325 DEFAULT CHARSET=utf8;
