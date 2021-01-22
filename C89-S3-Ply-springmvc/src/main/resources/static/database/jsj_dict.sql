/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库MYSQL1-root:a
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c89-s3-ply-mybatis

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2021-01-22 16:46:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jsj_dict
-- ----------------------------
DROP TABLE IF EXISTS `jsj_dict`;
CREATE TABLE `jsj_dict` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `type` varchar(20) default NULL,
  `pid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jsj_dict
-- ----------------------------
INSERT INTO `jsj_dict` VALUES ('1', '北京', 'province', null);
INSERT INTO `jsj_dict` VALUES ('2', '上海', 'province', null);
INSERT INTO `jsj_dict` VALUES ('3', '黑龙江', 'province', null);
INSERT INTO `jsj_dict` VALUES ('4', '吉林', 'province', null);
INSERT INTO `jsj_dict` VALUES ('5', '辽宁', 'province', null);
INSERT INTO `jsj_dict` VALUES ('6', '天津', 'province', null);
INSERT INTO `jsj_dict` VALUES ('7', '安徽', 'province', null);
INSERT INTO `jsj_dict` VALUES ('8', '江苏', 'province', null);
INSERT INTO `jsj_dict` VALUES ('9', '浙江', 'province', null);
INSERT INTO `jsj_dict` VALUES ('10', '陕西', 'province', null);
INSERT INTO `jsj_dict` VALUES ('11', '湖北', 'province', null);
INSERT INTO `jsj_dict` VALUES ('12', '广东', 'province', null);
INSERT INTO `jsj_dict` VALUES ('13', '湖南', 'province', null);
INSERT INTO `jsj_dict` VALUES ('14', '甘肃', 'province', null);
INSERT INTO `jsj_dict` VALUES ('15', '四川', 'province', null);
INSERT INTO `jsj_dict` VALUES ('16', '山东', 'province', null);
INSERT INTO `jsj_dict` VALUES ('17', '福建', 'province', null);
INSERT INTO `jsj_dict` VALUES ('18', '河南', 'province', null);
INSERT INTO `jsj_dict` VALUES ('19', '重庆', 'province', null);
INSERT INTO `jsj_dict` VALUES ('20', '云南', 'province', null);
INSERT INTO `jsj_dict` VALUES ('21', '河北', 'province', null);
INSERT INTO `jsj_dict` VALUES ('22', '江西', 'province', null);
INSERT INTO `jsj_dict` VALUES ('23', '山西', 'province', null);
INSERT INTO `jsj_dict` VALUES ('24', '贵州', 'province', null);
INSERT INTO `jsj_dict` VALUES ('25', '广西', 'province', null);
INSERT INTO `jsj_dict` VALUES ('26', '内蒙古', 'province', null);
INSERT INTO `jsj_dict` VALUES ('27', '宁夏', 'province', null);
INSERT INTO `jsj_dict` VALUES ('28', '青海', 'province', null);
INSERT INTO `jsj_dict` VALUES ('29', '新疆', 'province', null);
INSERT INTO `jsj_dict` VALUES ('30', '海南', 'province', null);
INSERT INTO `jsj_dict` VALUES ('31', '西藏', 'province', null);
INSERT INTO `jsj_dict` VALUES ('32', '中国香港', 'province', null);
INSERT INTO `jsj_dict` VALUES ('33', '中国澳门', 'province', null);
INSERT INTO `jsj_dict` VALUES ('34', '中国台湾', 'province', null);
