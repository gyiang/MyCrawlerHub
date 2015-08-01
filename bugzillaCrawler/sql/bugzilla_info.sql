/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : others_task

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-03-19 13:02:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bugzilla_info
-- ----------------------------
DROP TABLE IF EXISTS `bugzilla_info`;
CREATE TABLE `bugzilla_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bugID` int(11) DEFAULT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `whiteboard` varchar(255) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `importance` varchar(255) DEFAULT NULL,
  `targetMilestone` varchar(255) DEFAULT NULL,
  `assignedTo` varchar(255) DEFAULT NULL,
  `qaContact` varchar(255) DEFAULT NULL,
  `mentors` varchar(255) DEFAULT NULL,
  `urlAssociated` varchar(255) DEFAULT NULL,
  `dependsOn` varchar(255) DEFAULT NULL,
  `duplicates` text,
  `blocks` varchar(255) DEFAULT NULL,
  `reportedPT` varchar(32) DEFAULT NULL,
  `modifiedPT` varchar(32) DEFAULT NULL,
  `ccList` int(2) DEFAULT NULL,
  `seeAlso` varchar(255) DEFAULT NULL,
  `crashSignature` varchar(255) DEFAULT NULL,
  `qaWhiteboard` varchar(255) DEFAULT NULL,
  `iteration` varchar(255) DEFAULT NULL,
  `points` varchar(255) DEFAULT NULL,
  `trackingFlags` varchar(255) DEFAULT NULL,
  `projectFlags` varchar(255) DEFAULT NULL,
  `reportedUser` varchar(255) DEFAULT NULL,
  `reportedUserUrl` varchar(255) DEFAULT NULL,
  `description` text,
  `url` varchar(255) DEFAULT NULL,
  `urlMD5` varchar(32) DEFAULT NULL,
  `pageMD5` varchar(64) DEFAULT '',
  `history` tinyint(2) DEFAULT NULL,
  `crawledTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index` (`bugID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;
