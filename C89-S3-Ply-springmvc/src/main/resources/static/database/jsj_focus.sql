/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c89-s3-ply-mybatis

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2021-01-23 17:23:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jsj_focus
-- ----------------------------
DROP TABLE IF EXISTS `jsj_focus`;
CREATE TABLE `jsj_focus` (
  `id` int(2) NOT NULL auto_increment,
  `img` varchar(255) default NULL,
  `name` varchar(50) default NULL,
  `state` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jsj_focus
-- ----------------------------
INSERT INTO `jsj_focus` VALUES ('1', 'http://cdnfile.shujie.me/focus_img/focus_0.jpg', '图片0', '1');
INSERT INTO `jsj_focus` VALUES ('2', 'http://cdnfile.shujie.me/focus_img/focus_1.jpg', '图片1', '1');
INSERT INTO `jsj_focus` VALUES ('3', 'http://cdnfile.shujie.me/focus_img/focus_2.jpg', '图片2', '1');
INSERT INTO `jsj_focus` VALUES ('4', 'http://cdnfile.shujie.me/focus_img/focus_3.jpg', '图片3', '1');
INSERT INTO `jsj_focus` VALUES ('5', 'http://cdnfile.shujie.me/focus_img/focus_4.jpg', '图片4', '1');
