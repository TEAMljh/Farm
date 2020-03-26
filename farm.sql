/*
Navicat MySQL Data Transfer

Source Server         : MySQL_RQY
Source Server Version : 80016
Source Host           : rm-bp131m4ox666gbwnm7o.mysql.rds.aliyuncs.com:3306
Source Database       : farm

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-03-26 12:09:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `about`
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about` (
  `id` int(11) NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `banner_img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of about
-- ----------------------------
INSERT INTO `about` VALUES ('1', '1234567@qq.com', '13012345678', null, '0');

-- ----------------------------
-- Table structure for `img_suffix`
-- ----------------------------
DROP TABLE IF EXISTS `img_suffix`;
CREATE TABLE `img_suffix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `suffix_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '后缀名',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img_suffix
-- ----------------------------
INSERT INTO `img_suffix` VALUES ('1', '.jpg', '0');
INSERT INTO `img_suffix` VALUES ('2', '.jpeg', '0');
INSERT INTO `img_suffix` VALUES ('3', '.png', '0');
INSERT INTO `img_suffix` VALUES ('4', '.bmp', '0');
INSERT INTO `img_suffix` VALUES ('5', '.gif', '0');

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片展示',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详细文章',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', '检验鸡蛋是否新鲜', null, '验证鸡蛋是否新鲜,只需把它放在盐水里,新鲜鸡蛋会下沉,不新鲜的会漂浮。', '2020-03-12 08:56:32', '0');
INSERT INTO `information` VALUES ('2', '如何炒出鲜嫩的鸡蛋', null, '将鸡蛋打入碗中，加入少许温水搅拌均匀，倒入油锅里炒。炒时往锅里滴少许酒，这样炒出的鸡蛋蓬松、鲜嫩、可口。', '2020-03-12 08:56:32', '0');
INSERT INTO `information` VALUES ('3', '炒藕丝不变黑', null, '炒藕丝时，一边炒一边加些水，能防止藕变黑。', '2020-03-12 08:56:33', '0');
INSERT INTO `information` VALUES ('4', '测试', null, 'xxxxxx', '2020-03-23 15:05:45', '1');

-- ----------------------------
-- Table structure for `max_class`
-- ----------------------------
DROP TABLE IF EXISTS `max_class`;
CREATE TABLE `max_class` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of max_class
-- ----------------------------
INSERT INTO `max_class` VALUES ('1', '水果蔬菜类', '0');
INSERT INTO `max_class` VALUES ('2', '米面粮油', '0');
INSERT INTO `max_class` VALUES ('3', '农副产品', '0');

-- ----------------------------
-- Table structure for `product_center`
-- ----------------------------
DROP TABLE IF EXISTS `product_center`;
CREATE TABLE `product_center` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `type_id` int(10) DEFAULT NULL COMMENT '所属大类',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_center
-- ----------------------------
INSERT INTO `product_center` VALUES ('1', '水果类', '1', '0');
INSERT INTO `product_center` VALUES ('2', '蔬菜类', '1', '0');
INSERT INTO `product_center` VALUES ('3', '果实籽仁类', '1', '0');
INSERT INTO `product_center` VALUES ('4', '五谷杂粮', '2', '0');
INSERT INTO `product_center` VALUES ('5', '食用油', '2', '0');
INSERT INTO `product_center` VALUES ('6', '调味品', '2', '0');
INSERT INTO `product_center` VALUES ('7', '酒茶冲饮', '3', '0');
INSERT INTO `product_center` VALUES ('8', '肉蛋类', '3', '0');
INSERT INTO `product_center` VALUES ('9', '零食特产', '3', '0');

-- ----------------------------
-- Table structure for `product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鏍囬',
  `img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '展示图',
  `pri` double(10,2) DEFAULT NULL COMMENT '闂佸搫鍊块。锕傛偝?',
  `old_pri` double(10,2) DEFAULT NULL COMMENT '闂佸憡顭囬崰宥夋偝?',
  `discount` int(5) DEFAULT NULL COMMENT '閹舵ɑ澧?',
  `single` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鍗曞搧瑙勬牸',
  `img_detail` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详情大图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `type_id` int(11) DEFAULT NULL COMMENT '所属类型',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_detail
-- ----------------------------
INSERT INTO `product_detail` VALUES ('1', '红心火龙果', '/upload/b9eaaf05-26d0-48ba-8f31-82336e06ccf1.jpg', '44.00', '55.00', '8', '44元4个', '/upload/8c7c7198-f800-491a-873b-f0c72d0a6bc5.jpg', '2020-03-12 08:54:47', '1', '0');
INSERT INTO `product_detail` VALUES ('2', '苹果', '/upload/1cab9f24-09cd-4ef8-b7eb-034c72df73f6.jpg', '44.00', '55.00', '8', '44元15个', '/upload/20fbbf8f-6499-475e-91b4-7bb3bf1bb880.jpg', '2020-03-12 08:54:48', '1', '0');
INSERT INTO `product_detail` VALUES ('3', '四季豆', '/upload/633a932a-7649-4768-bb46-6628361fb842.jpg', '15.00', '15.00', '0', '15元二斤', '/upload/e2c1fe89-8565-43eb-a411-675ccda34ae7.jpg', '2020-03-12 08:54:48', '2', '0');
INSERT INTO `product_detail` VALUES ('4', '夏威夷果', null, '30.00', '33.00', '9', '30元一斤', null, '2020-03-12 08:54:48', '3', '0');
INSERT INTO `product_detail` VALUES ('5', '碧根果', '', '46.00', '46.00', '2', '28元一斤', '/upload/c10bbd80-c295-4404-b03c-7bbfca7206be.png', '2020-03-12 08:54:49', '1', '0');
INSERT INTO `product_detail` VALUES ('6', '香蕉', null, '7.00', '10.00', '7', '7元一斤', null, '2020-03-12 08:54:52', '1', '0');
INSERT INTO `product_detail` VALUES ('7', '百香果', null, '12.00', '12.00', '0', '12元4个', null, '2020-03-12 08:54:52', '1', '0');
INSERT INTO `product_detail` VALUES ('8', '高粱', null, '20.00', '22.00', '9', '20元十斤', null, '2020-03-12 08:54:55', '4', '0');
INSERT INTO `product_detail` VALUES ('9', '燕麦米', '', '13.00', '14.00', '9', '13元一斤', '', '2020-03-12 08:54:55', '4', '0');
INSERT INTO `product_detail` VALUES ('10', '大豆油', null, '40.00', '50.00', '8', '40元一桶', null, '2020-03-18 16:46:40', '5', '0');
INSERT INTO `product_detail` VALUES ('11', '菜籽油', null, '46.00', '58.00', '8', '46元一桶', null, '2020-03-12 08:54:59', '5', '0');
INSERT INTO `product_detail` VALUES ('12', '花椒', null, '50.00', '62.00', '8', '50元一斤', null, '2020-03-12 08:55:00', '6', '0');
INSERT INTO `product_detail` VALUES ('14', '红毛丹', null, '15.00', '15.00', '0', '15元8个', null, '2020-03-12 08:55:00', '1', '0');
INSERT INTO `product_detail` VALUES ('15', '椰子', null, '80.00', '100.00', '8', '80元9个', null, '2020-03-12 08:55:01', '1', '0');
INSERT INTO `product_detail` VALUES ('16', '脐橙', null, '9.00', '10.00', '9', '9元一斤', null, '2020-03-12 08:55:01', '1', '0');
INSERT INTO `product_detail` VALUES ('17', '西瓜', '/upload/7fa09ad1-6104-474d-8822-c434bd100c5e.jpg', '3.00', '3.00', '0', '3元一斤', '/upload/5c4f681c-4eff-4d25-a577-36df5189f82e.jpg', '2020-03-12 08:55:03', '1', '0');
INSERT INTO `product_detail` VALUES ('18', '咸鸭蛋', '/assets/img/egg.jpg', '1.00', '1.00', '0', '1元1个', null, '2020-03-13 16:19:38', '8', '0');
INSERT INTO `product_detail` VALUES ('20', '测试水水水水水水水水', '/upload/98f75dd2-2454-4acf-87db-31c9ff4aa25d.jpg', '12.00', '123.00', '11', '测试', '/upload/6001f526-7a2f-495d-a46b-ed5141e25b09.jpg', '2020-03-19 17:39:09', '1', '0');
INSERT INTO `product_detail` VALUES ('59', '8', '/upload/08d03371-27d1-4b4b-8056-d931c4763fe8.jpg', '8.00', '8.00', '8', '888', '/upload/08109242-16ca-4bfd-ba06-42877e245fee.jpg', '2020-03-23 16:59:41', '1', '0');
INSERT INTO `product_detail` VALUES ('61', '商品9', '/upload/daa9e1c3-6a8a-473f-8f65-c2377c6d7d67.jpg', '9.00', '11.25', '8', '这就是一个商品9,规格9.', '/upload/e9f0aed1-deb8-4744-905a-582b61f6796c.jpg', '2020-03-24 08:47:49', '1', '0');
INSERT INTO `product_detail` VALUES ('62', '商品10', '/upload/471071f7-7471-4fb8-9a07-71bffb0103d1.jpg', '11.00', '13.75', '8', '这是商品10的规格。', '/upload/d4407246-9fea-4c69-8fbd-4213d093115e.jpg', '2020-03-24 15:35:38', '2', '0');

-- ----------------------------
-- Table structure for `shopcart`
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `single` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pri` int(10) DEFAULT NULL,
  `num` int(10) DEFAULT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '买方',
  `user_tel` varchar(11) DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `user_address` varchar(50) DEFAULT NULL,
  `order_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `goods_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcart
-- ----------------------------
INSERT INTO `shopcart` VALUES ('17', '/upload/4dbe72ef-92d6-4f1d-9bc6-35d85f97116c.jpg', '234213', '微软微软', '2432', '4', 'hhh', null, '0', null, '0', '0');
INSERT INTO `shopcart` VALUES ('41', '/upload/98f75dd2-2454-4acf-87db-31c9ff4aa25d.jpg', '测试水水水水水水水水', '测试', '12', '2', 'cyy', '13036595068', '0', '四川省四川省四川省四川省', '0', '0');
INSERT INTO `shopcart` VALUES ('42', '/upload/7fa09ad1-6104-474d-8822-c434bd100c5e.jpg', '西瓜', '3元一斤', '3', '1', 'cyy', '13036595068', '0', '四川省四川省四川省四川省', '1', '0');
INSERT INTO `shopcart` VALUES ('43', '/upload/08d03371-27d1-4b4b-8056-d931c4763fe8.jpg', '8', '888', '8', '2', 'cyy', '13036595068', '0', '四川省四川省四川省四川省', '0', '0');
INSERT INTO `shopcart` VALUES ('44', '/upload/471071f7-7471-4fb8-9a07-71bffb0103d1.jpg', '商品10', '这是商品10的规格。', '11', '1', 'cyy', '13036595068', '0', '四川省四川省四川省四川省', '1', '0');
INSERT INTO `shopcart` VALUES ('45', '/assets/img/egg.jpg', '咸鸭蛋', '1元1个', '1', '5', 'cyy', '13036595068', '0', '四川省四川省四川省四川省', '0', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `pass` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `province` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在省',
  `city` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `county` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `detail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '删除标志',
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'cyy', '888', '四川省', '四川省', '四川省', '四川省四川省四川省四川省', '0', '13036595068');
INSERT INTO `user` VALUES ('2', 'ljh', '456', '四川省', '内江市', '威远县', '四川省内江市威远县', '0', '13012345678');
INSERT INTO `user` VALUES ('3', 'hhh', '789', '陕西省', ' 西安市', '长安区', '陕西省西安市长安区', '0', '13012345678');
INSERT INTO `user` VALUES ('21', '大宝', 'dabao', '上海市', '嘉定区', '嘉定镇街道', '上海市嘉定区嘉定镇街道', '0', '13012345678');
INSERT INTO `user` VALUES ('23', '小宝', '111', '地球', '地球', '地球', '地球', '0', '13012345678');
INSERT INTO `user` VALUES ('25', '当当当', '111', '地球', '地球', '地球', '地球地球地球地球地球地球地球地球地球地球地球', '0', '13012345678');
INSERT INTO `user` VALUES ('26', '大大', '789', '重庆', '重庆', '重庆', '重庆', '0', '13012345678');
INSERT INTO `user` VALUES ('47', 'CYY', '123sdf', '四川省', '四川省', '四川省', '四川省四川省四川省四川省四川省', '0', '12345678910');
