/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : others_task

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-03-19 13:01:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bugzilla_attachments
-- ----------------------------
DROP TABLE IF EXISTS `bugzilla_attachments`;
CREATE TABLE `bugzilla_attachments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bugID` int(11) DEFAULT NULL,
  `html` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
