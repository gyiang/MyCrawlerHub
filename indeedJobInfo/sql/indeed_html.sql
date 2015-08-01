/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : lbx

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-04-16 08:18:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for indeed_html
-- ----------------------------
DROP TABLE IF EXISTS `indeed_html`;
CREATE TABLE `indeed_html` (
  `urlMd5` varchar(255) NOT NULL,
  `url` text,
  `html` mediumtext,
  `timestamp` varchar(255) DEFAULT NULL,
  `urlTrue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`urlMd5`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
