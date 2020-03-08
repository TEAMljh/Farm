/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : farm

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-03-08 22:36:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `about`
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about` (
  `id` int(11) NOT NULL,
  `mail` varchar(30) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of about
-- ----------------------------

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '标题',
  `img` varchar(200) DEFAULT NULL COMMENT '图片展示',
  `content` varchar(1000) NOT NULL COMMENT '详细文章',
  `creat_time` varchar(12) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------

-- ----------------------------
-- Table structure for `product_center`
-- ----------------------------
DROP TABLE IF EXISTS `product_center`;
CREATE TABLE `product_center` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_center
-- ----------------------------
INSERT INTO `product_center` VALUES ('1', '水果类');
INSERT INTO `product_center` VALUES ('2', '蔬菜类');
INSERT INTO `product_center` VALUES ('3', '果实籽仁类');
INSERT INTO `product_center` VALUES ('4', '五谷杂粮');
INSERT INTO `product_center` VALUES ('5', '食用油');
INSERT INTO `product_center` VALUES ('6', '调味品');
INSERT INTO `product_center` VALUES ('7', '酒茶冲饮');
INSERT INTO `product_center` VALUES ('8', '肉蛋类');
INSERT INTO `product_center` VALUES ('9', '零食特产');

-- ----------------------------
-- Table structure for `product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '标题',
  `img` varchar(200) DEFAULT NULL COMMENT '展示图',
  `pri` int(10) NOT NULL COMMENT '新价',
  `oldpri` int(10) NOT NULL COMMENT '原价',
  `discount` varchar(5) DEFAULT NULL COMMENT '折扣',
  `single` varchar(12) NOT NULL COMMENT '单品规格',
  `img_detail` varchar(500) DEFAULT NULL COMMENT '详情大图',
  `creat_time` varchar(12) DEFAULT NULL COMMENT '创建时间',
  `typeid` int(11) NOT NULL COMMENT '所属类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_detail
-- ----------------------------
INSERT INTO `product_detail` VALUES ('1', '红心火龙果', null, '44', '55', '8', '44元4个', null, null, '1');
INSERT INTO `product_detail` VALUES ('2', '苹果', null, '44', '55', '8', '44元15个', null, null, '1');
INSERT INTO `product_detail` VALUES ('3', '四季豆', null, '15', '15', '0', '15元二斤', null, null, '2');
INSERT INTO `product_detail` VALUES ('4', '夏威夷果', null, '30', '33', '9', '30元一斤', null, null, '3');
INSERT INTO `product_detail` VALUES ('5', '碧根果', null, '28', '28', '0', '28元一斤', null, null, '3');
INSERT INTO `product_detail` VALUES ('6', '香蕉', null, '7', '10', '7', '7元一斤', null, null, '1');
INSERT INTO `product_detail` VALUES ('7', '百香果', null, '12', '12', '0', '12元4个', null, null, '1');
INSERT INTO `product_detail` VALUES ('8', '高粱', null, '20', '22', '9', '20元十斤', null, null, '4');
INSERT INTO `product_detail` VALUES ('9', '燕麦米', null, '13', '14', '9', '13元一斤', null, null, '4');
INSERT INTO `product_detail` VALUES ('10', '大豆油', null, '40', '50', '8', '40元一桶', null, null, '5');
INSERT INTO `product_detail` VALUES ('11', '菜籽油', null, '46', '58', '8', '46元一桶', null, null, '5');
INSERT INTO `product_detail` VALUES ('12', '花椒', null, '50', '62', '8', '50元一斤', null, null, '6');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '用户名',
  `pass` int(6) unsigned NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'cyy', '123');
INSERT INTO `user` VALUES ('2', 'ljh', '456');
INSERT INTO `user` VALUES ('3', 'hhh', '789');
