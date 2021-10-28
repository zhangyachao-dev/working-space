/*
 Navicat Premium Data Transfer

 Source Server         : 19.10VM
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 192.168.19.10:3306
 Source Schema         : mp_template

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 02/01/2021 15:50:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mp_user
-- ----------------------------
DROP TABLE IF EXISTS `mp_user`;
CREATE TABLE `mp_user`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '主键ID',
  `NAME` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_user
-- ----------------------------
INSERT INTO `mp_user` VALUES ('1', 'Jone', 18, 'test1@baomidou.com');
INSERT INTO `mp_user` VALUES ('2', 'Jack', 20, 'test2@baomidou.com');
INSERT INTO `mp_user` VALUES ('3', 'Tom', 28, 'test3@baomidou.com');
INSERT INTO `mp_user` VALUES ('4', 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO `mp_user` VALUES ('5', 'Billie', 24, 'test5@baomidou.com');

SET FOREIGN_KEY_CHECKS = 1;
