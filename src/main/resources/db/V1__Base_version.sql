/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-05-24 10:01:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(32) CHARACTER SET utf8 NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `realName` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '真实名称',
  `pwd` varchar(32) CHARACTER SET utf8 NOT NULL,
  `email` varchar(20) CHARACTER SET utf8 NOT NULL,
  `mobile` varchar(11) CHARACTER SET utf8 NOT NULL COMMENT '手机号码',
  `age` int(11) NOT NULL COMMENT '年龄',
  `birth` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '生日',
  `roleId` int(11) NOT NULL COMMENT '角色Id',
  `career` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '职业',
  `isActive` tinyint(4) NOT NULL COMMENT '是否激活0.未激活,1.已激活',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'ins1', '插入1', '123456', '345@qq.com', '12345678901', '25', '2019-05-16 09:07:18', '1', '测试', '1');
INSERT INTO `tb_user` VALUES ('2', 'ins2', '插入2', '123456', '456@qq.com', '12345678901', '26', '2019-05-16 09:07:18', '1', '测试', '1');
INSERT INTO `tb_user` VALUES ('3', 'ins3', '插入3', '123456', '567@qq.com', '12345678901', '27', '2019-05-16 09:07:18', '1', '测试', '0');
INSERT INTO `tb_user` VALUES ('4', 'ins4', '插入4', '123456', '678@qq.com', '12345678901', '28', '2019-05-16 09:07:18', '1', '测试', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) NOT NULL COMMENT '名称',
  `age` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'li', '29');
INSERT INTO `user` VALUES ('5', 'wang', '29');
INSERT INTO `user` VALUES ('6', 'cheng', '20');
