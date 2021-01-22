/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : mybaties

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2021-01-22 16:57:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jsj_admin
-- ----------------------------
DROP TABLE IF EXISTS `jsj_admin`;
CREATE TABLE `jsj_admin` (
  `id` int(11) NOT NULL auto_increment,
  `account` varchar(255) default NULL,
  `pwd` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `status` int(11) default NULL COMMENT '0是冻结，1是未冻结',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jsj_admin
-- ----------------------------
