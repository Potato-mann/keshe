/*
 Navicat MySQL Data Transfer

 Source Server         : study
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : keshe

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 15/06/2021 10:18:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sponsor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `number_limit` int(255) NOT NULL,
  `register_start_time` date NOT NULL,
  `register_end_time` date NOT NULL,
  `contest_start_time` date NOT NULL,
  `contest_end_time` date NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contest
-- ----------------------------
INSERT INTO `contest` VALUES (1001, 'lanqiao', 'zy', 10, '2021-05-23', '2021-05-24', '2021-05-25', '2021-05-26', 'zytxdy');
INSERT INTO `contest` VALUES (1002, '浙江省摸鱼大赛', 'yjf', 3, '2021-05-25', '2021-06-20', '2021-08-01', '2021-09-01', 'moyu');
INSERT INTO `contest` VALUES (1003, '浙江省老年人手速大赛', 'yjf', 2, '2021-05-25', '2021-06-25', '2021-08-01', '2021-09-01', 'iamfive');
INSERT INTO `contest` VALUES (1004, '中国大学生程序设计竞赛', 'zy', 3, '2021-05-25', '2021-06-25', '2021-08-01', '2021-09-01', 'ccpc');
INSERT INTO `contest` VALUES (1005, 'icpc上海站', 'zy', 3, '2021-05-25', '2021-06-25', '2021-09-01', '2021-10-01', 'icpc');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (66);

-- ----------------------------
-- Table structure for s2t
-- ----------------------------
DROP TABLE IF EXISTS `s2t`;
CREATE TABLE `s2t`  (
  `id` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `scheck` int(255) NOT NULL,
  `sid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s2t
-- ----------------------------
INSERT INTO `s2t` VALUES (18, 17, 1, 1180199152);
INSERT INTO `s2t` VALUES (19, 17, 1, 1);
INSERT INTO `s2t` VALUES (26, 25, 1, 2);
INSERT INTO `s2t` VALUES (27, 25, 1, 3);
INSERT INTO `s2t` VALUES (28, 25, -1, 4);
INSERT INTO `s2t` VALUES (51, 50, 1, 1);
INSERT INTO `s2t` VALUES (52, 50, 0, 1180199152);
INSERT INTO `s2t` VALUES (55, 54, 1, 1);
INSERT INTO `s2t` VALUES (56, 54, 0, 1180199152);
INSERT INTO `s2t` VALUES (62, 61, 1, 1180199152);
INSERT INTO `s2t` VALUES (63, 61, 1, 1);
INSERT INTO `s2t` VALUES (64, 61, 0, 2);
INSERT INTO `s2t` VALUES (1001, 1001, 1, 1180199152);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `true_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clazz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '123456', '王狗蛋', '男', '信息学院', '软件工程', '183', '120');
INSERT INTO `student` VALUES (2, '123456', '张三', '男', '信息学院', '软件工程', '183', '130');
INSERT INTO `student` VALUES (3, '123456', '李四', '男', '信息学院', '软件工程', '183', '140');
INSERT INTO `student` VALUES (4, '123456', '王五', '男', '信息学院', '软件工程', '183', '150');
INSERT INTO `student` VALUES (1180199152, '123456', 'yjf', '男', '信息学院', '软件工程', '183', '110');

-- ----------------------------
-- Table structure for t2t
-- ----------------------------
DROP TABLE IF EXISTS `t2t`;
CREATE TABLE `t2t`  (
  `id` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t2t
-- ----------------------------
INSERT INTO `t2t` VALUES (20, 17, 1001);
INSERT INTO `t2t` VALUES (29, 25, 1001);
INSERT INTO `t2t` VALUES (53, 50, 1001);
INSERT INTO `t2t` VALUES (57, 54, 1001);
INSERT INTO `t2t` VALUES (65, 61, 1001);
INSERT INTO `t2t` VALUES (1001, 1001, 1001);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `true_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `professional_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1001, '123456', '张三', '男', '信息学院', '不知道', '123');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `team_number` int(11) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `cid` int(11) NOT NULL,
  `s_check` int(11) NOT NULL,
  `t_check` int(11) NOT NULL,
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (17, 'yyyyjjjjfff', 2, 'yyyjjjfff', 1002, 2, 0, '暂未公布成绩');
INSERT INTO `team` VALUES (25, 'yyyjjjjfff', 3, 'yyyjjjfff', 1002, -1, 0, '暂未公布成绩');
INSERT INTO `team` VALUES (50, 'yyff', 2, 'yyf', 1004, 1, 0, '暂未公布成绩');
INSERT INTO `team` VALUES (54, 'yyff', 2, 'yyf', 1003, 1, 0, '暂未公布成绩');
INSERT INTO `team` VALUES (61, '我就是来摸鱼的', 3, '江南打铁王', 1005, 2, 0, '暂未公布成绩');
INSERT INTO `team` VALUES (1001, 'yjf说的都队', 1, 'yjftxdy', 1001, 1, 1, '暂未公布成绩');

SET FOREIGN_KEY_CHECKS = 1;
