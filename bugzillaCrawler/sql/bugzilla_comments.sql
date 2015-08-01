/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : others_task

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-03-19 13:02:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bugzilla_comments
-- ----------------------------
DROP TABLE IF EXISTS `bugzilla_comments`;
CREATE TABLE `bugzilla_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bugID` int(11) DEFAULT NULL,
  `commentUser` varchar(255) DEFAULT NULL,
  `commentText` text,
  `commentPT` varchar(32) DEFAULT NULL,
  `commentUserUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=523 DEFAULT CHARSET=utf8;
