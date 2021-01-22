/*
Navicat MySQL Data Transfer

Source Server         : 刘俊
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c89-s3-ply-mybatis

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2021-01-22 17:02:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jsj_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `jsj_order_detail`;
CREATE TABLE `jsj_order_detail` (
  `id` int(11) NOT NULL auto_increment,
  `oid` bigint(11) default NULL,
  `bid` bigint(11) default NULL,
  `count` int(11) default NULL,
  `price` double default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
