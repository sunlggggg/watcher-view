/*
Navicat MySQL Data Transfer

Source Server         : sunlggggg
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : firewalllog

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-03-26 19:20:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accessflowresult
-- ----------------------------
DROP TABLE IF EXISTS `accessflowresult`;
CREATE TABLE `accessflowresult` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `endTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'endtime是从endtime-1秒到endtime的记录条数',
  `count` int(11) NOT NULL COMMENT '该秒内的记录条数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=425 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `startTime` datetime DEFAULT NULL,
  `lastTime` datetime DEFAULT NULL,
  `isFinished` tinyint(1) DEFAULT NULL,
  `type` enum('sameSrcAttack','sameDestAttack','sensitivePortAccess') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=345 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for fwlog
-- ----------------------------
DROP TABLE IF EXISTS `fwlog`;
CREATE TABLE `fwlog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `internalIp` varchar(15) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `anotherTimestamp` datetime DEFAULT NULL,
  `mathedStrategy` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `originalSrcIp` varchar(15) DEFAULT NULL,
  `originalSrcPort` varchar(6) DEFAULT NULL,
  `originalDestIP` varchar(15) DEFAULT NULL,
  `originalDestPort` varchar(6) DEFAULT NULL,
  `convertedSrcIP` varchar(15) DEFAULT NULL,
  `convertedSrcPort` varchar(6) DEFAULT NULL,
  `convertedDestIp` varchar(15) DEFAULT NULL,
  `convertedDestPort` varchar(6) DEFAULT NULL,
  `protocolNumber` int(3) DEFAULT NULL,
  `safefymargin` varchar(30) DEFAULT NULL,
  `aciton` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240784 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `fwlogId` bigint(20) NOT NULL,
  `eventId` bigint(20) NOT NULL,
  KEY `FKl4u8urt1erctoo4m1pbvp17xl` (`fwlogId`),
  KEY `FK5v2wn5l5ymrdnnsu8eq7ohpwk` (`eventId`),
  CONSTRAINT `FK5v2wn5l5ymrdnnsu8eq7ohpwk` FOREIGN KEY (`eventId`) REFERENCES `event` (`id`),
  CONSTRAINT `FKl4u8urt1erctoo4m1pbvp17xl` FOREIGN KEY (`fwlogId`) REFERENCES `fwlog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for sensitiveport
-- ----------------------------
DROP TABLE IF EXISTS `sensitiveport`;
CREATE TABLE `sensitiveport` (
  `port` int(6) NOT NULL,
  `desc` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`port`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `sensitiveport` VALUES ('23', '疑似请求TELNENT');

-- ----------------------------
-- Table structure for statisticslog
-- ----------------------------
DROP TABLE IF EXISTS `statisticslog`;
CREATE TABLE `statisticslog` (
  `startTime` datetime NOT NULL COMMENT '该此统计开始时间， 源IP对应的访问次数',
  `statisticsValue` varchar(15) NOT NULL,
  `count` int(7) NOT NULL DEFAULT '0',
  `type` enum('originalSrcIp','originalSrcPort','originalDestIp','originalDestPort') NOT NULL,
  `endTime` datetime NOT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `abnormal` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `originalSrcIp` (`statisticsValue`,`startTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for statisticsresult
-- ----------------------------
DROP TABLE IF EXISTS `statisticsresult`;
CREATE TABLE `statisticsresult` (
  `id` int(10) NOT NULL,
  `endTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '统计结束时间',
  `startTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `t_user_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
