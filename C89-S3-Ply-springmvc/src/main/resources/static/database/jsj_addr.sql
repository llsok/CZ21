/*
Navicat MySQL Data Transfer

Source Server         : 111
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c89-s3-ply-mybatis

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2021-01-22 21:52:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jsj_addr
-- ----------------------------
DROP TABLE IF EXISTS `jsj_addr`;
CREATE TABLE `jsj_addr` (
  `id` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL COMMENT '用户id',
  `addr_name` varchar(40) default NULL COMMENT '收货人姓名',
  `addr_phone` varchar(40) default NULL,
  `addr_post` varchar(20) default NULL COMMENT '邮编',
  `addr_province` varchar(20) default NULL COMMENT '省份',
  `addr_desc` varchar(50) default NULL COMMENT '详细地址',
  `code` int(11) default '0' COMMENT '1为默认地址 0其他',
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `jsj_addr_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `jsj_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jsj_addr
-- ----------------------------
INSERT INTO `jsj_addr` VALUES ('12', '35256', '伟神', '15543461120', '123456', '湖南', '衡阳', '0');
INSERT INTO `jsj_addr` VALUES ('14', '35256', '八神', '1234567891', '123456', '湖南', '湘潭', '1');
INSERT INTO `jsj_addr` VALUES ('16', '35256', '张三', '15543461120', '123456', '湖北', '武汉', '0');
