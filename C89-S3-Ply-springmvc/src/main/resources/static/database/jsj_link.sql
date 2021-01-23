/*
Navicat MySQL Data Transfer

Source Server         : localhost_3305
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : c89-s3-ply-mybatis

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2021-01-22 16:13:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `jsj_link`
-- ----------------------------
DROP TABLE IF EXISTS `jsj_link`;
CREATE TABLE `jsj_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `html` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jsj_link
-- ----------------------------
INSERT INTO jsj_link VALUES ('1', '杂志铺-杂志订阅网', 'http://www.zazhipu.com/');
INSERT INTO jsj_link VALUES ('2', '订制婚礼', 'http://www.izhaowo.com/');
INSERT INTO jsj_link VALUES ('3', '高考志愿填报', 'http://www.xuejiebang.org/');
INSERT INTO jsj_link VALUES ('4', '西葫芦留学', 'http://schoolhulu.com/');
INSERT INTO jsj_link VALUES ('5', '快递查询', 'http://m.kuaidi100.com/');
INSERT INTO jsj_link VALUES ('6', 'steam游戏商城', 'http://47.93.186.28');
