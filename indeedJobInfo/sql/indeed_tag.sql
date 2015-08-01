/*
Navicat MySQL Data Transfer

Source Server         : webmagic
Source Server Version : 50537
Source Host           : 127.0.0.1:3306
Source Database       : lbx

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2015-04-16 08:18:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for indeed_tag
-- ----------------------------
DROP TABLE IF EXISTS `indeed_tag`;
CREATE TABLE `indeed_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tag` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indeed_tag
-- ----------------------------
INSERT INTO `indeed_tag` VALUES ('1', 'MySql', null, '42383');
INSERT INTO `indeed_tag` VALUES ('2', 'MongoDB', '1428591384', '3442');
INSERT INTO `indeed_tag` VALUES ('3', 'PostgreSQL', '1428591402', '1145');
INSERT INTO `indeed_tag` VALUES ('4', 'Cassandra', '1428591408', '269');
INSERT INTO `indeed_tag` VALUES ('5', 'SQLite', '1428591432', '1893');
INSERT INTO `indeed_tag` VALUES ('6', 'Redis', '1428591494', '5075');
INSERT INTO `indeed_tag` VALUES ('7', 'Solr', '1428591505', '531');
INSERT INTO `indeed_tag` VALUES ('8', 'Elasticsearch', '1428591511', '167');
INSERT INTO `indeed_tag` VALUES ('9', 'HBase', '1428591535', '1665');
INSERT INTO `indeed_tag` VALUES ('10', 'Hive', '1428591553', '1499');
INSERT INTO `indeed_tag` VALUES ('11', 'Memcached', '1428591581', '2015');
INSERT INTO `indeed_tag` VALUES ('12', 'Neo4j', '1428591587', '53');
INSERT INTO `indeed_tag` VALUES ('13', 'CouchDB', '1428591593', '36');
INSERT INTO `indeed_tag` VALUES ('14', 'Couchbase', '1428591598', '16');
INSERT INTO `indeed_tag` VALUES ('15', 'MariaDB', '1428591604', '53');
INSERT INTO `indeed_tag` VALUES ('16', 'Firebird', '1428591610', '18');
INSERT INTO `indeed_tag` VALUES ('17', 'Riak', '1428591615', '15');
INSERT INTO `indeed_tag` VALUES ('18', 'Sphinx', '1428591621', '183');
INSERT INTO `indeed_tag` VALUES ('19', 'Ehcache', '1428591627', '118');
INSERT INTO `indeed_tag` VALUES ('20', 'Hazelcast', '1428591633', '4');
INSERT INTO `indeed_tag` VALUES ('21', 'Impala', '1428591638', '83');
INSERT INTO `indeed_tag` VALUES ('22', 'Derby', '1428591644', '2');
INSERT INTO `indeed_tag` VALUES ('23', 'Jackrabbit', '1428591650', '1');
INSERT INTO `indeed_tag` VALUES ('24', 'Berkeley DB', '1428591650', '4');
INSERT INTO `indeed_tag` VALUES ('25', 'OrientDB', '1428591655', '1');
INSERT INTO `indeed_tag` VALUES ('26', 'Accumulo', '1428591661', '1');
INSERT INTO `indeed_tag` VALUES ('27', 'Virtuoso', '1428591666', '59');
INSERT INTO `indeed_tag` VALUES ('28', 'Db4o', '1428591672', '4');
INSERT INTO `indeed_tag` VALUES ('29', 'RethinkDB', '1428591678', '2');
INSERT INTO `indeed_tag` VALUES ('30', 'LevelDB', '1428591683', '9');
INSERT INTO `indeed_tag` VALUES ('31', 'Jena', '1428591689', '2');
INSERT INTO `indeed_tag` VALUES ('32', 'VoltDB', '1428591694', '3');
INSERT INTO `indeed_tag` VALUES ('33', 'Infobright', '1428591700', '4');
INSERT INTO `indeed_tag` VALUES ('34', 'Mnesia', '1428591706', '2');
