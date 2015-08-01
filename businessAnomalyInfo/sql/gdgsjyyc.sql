/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : newdb

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-03-19 09:07:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gdgsjyyc
-- ----------------------------
DROP TABLE IF EXISTS `gdgsjyyc`;
CREATE TABLE `gdgsjyyc` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `entName` varchar(255) DEFAULT NULL,
  `entNameUrl` varchar(500) DEFAULT NULL,
  `regNO` varchar(255) DEFAULT NULL,
  `auditingFileNo` varchar(255) DEFAULT NULL,
  `abnTime` varchar(255) DEFAULT NULL,
  `decOrg` varchar(255) DEFAULT NULL,
  `entNo` varchar(255) DEFAULT NULL,
  `entType` varchar(255) DEFAULT NULL,
  `speCause` varchar(255) DEFAULT NULL,
  `unuAbnId` varchar(255) DEFAULT NULL,
  `timestamp` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2616 DEFAULT CHARSET=utf8;
