/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云数据库
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : rm-cn-7yj3ip4xz0004jmo.rwlb.rds.aliyuncs.com:3306
 Source Schema         : library_db

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 04/01/2024 21:21:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for absent_tb
-- ----------------------------
DROP TABLE IF EXISTS `absent_tb`;
CREATE TABLE `absent_tb`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `absent_num` int NOT NULL,
  `absent_time` date NULL DEFAULT NULL,
  `stu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rebook_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of absent_tb
-- ----------------------------
INSERT INTO `absent_tb` VALUES (1, 4, '2023-01-10', '2023451164', '2023-01-15');
INSERT INTO `absent_tb` VALUES (2, 3, '2023-02-20', '2021451346', '2023-02-25');

-- ----------------------------
-- Table structure for book_tb
-- ----------------------------
DROP TABLE IF EXISTS `book_tb`;
CREATE TABLE `book_tb`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_time` datetime NOT NULL,
  `stu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_seat_id` int NOT NULL,
  `book_arrive` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_tb
-- ----------------------------
INSERT INTO `book_tb` VALUES (1, '2024-01-01 12:34:56', '2023451164', 1, 1);
INSERT INTO `book_tb` VALUES (2, '2024-01-02 12:11:21', '2021451346', 2, 2);
INSERT INTO `book_tb` VALUES (3, '2023-12-30 18:21:02', '2022458912', 3, 2);
INSERT INTO `book_tb` VALUES (4, '2023-12-31 18:21:02', '2020465788', 7, -1);
INSERT INTO `book_tb` VALUES (5, '2023-12-31 18:21:02', '2024512486', 5, 2);
INSERT INTO `book_tb` VALUES (6, '2024-01-01 18:21:02', '2023451164', 1, 1);
INSERT INTO `book_tb` VALUES (7, '2024-01-02 18:21:02', '2021451346', 2, 2);
INSERT INTO `book_tb` VALUES (8, '2024-01-03 18:21:02', '2021451346', 3, 2);
INSERT INTO `book_tb` VALUES (9, '2024-01-04 18:21:02', '2022458912', 7, -1);
INSERT INTO `book_tb` VALUES (10, '2024-01-04 18:21:02', '2023451164', 5, 2);
INSERT INTO `book_tb` VALUES (11, '2024-01-02 18:21:02', '2021451346', 2, 2);
INSERT INTO `book_tb` VALUES (12, '2024-01-03 18:21:02', '2021451346', 3, 2);
INSERT INTO `book_tb` VALUES (13, '2024-01-04 18:21:02', '2022458912', 7, -1);
INSERT INTO `book_tb` VALUES (14, '2024-01-04 18:21:02', '2022458912', 7, -1);

-- ----------------------------
-- Table structure for manager_tb
-- ----------------------------
DROP TABLE IF EXISTS `manager_tb`;
CREATE TABLE `manager_tb`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号（自增）',
  `manager_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `manager_password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `manager_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `manager_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `manager_addtime` date NULL DEFAULT NULL,
  `manager_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager_tb
-- ----------------------------
INSERT INTO `manager_tb` VALUES (1, '1234567890', 'password11', '张三', '女', '2023-01-01', '13823831820');
INSERT INTO `manager_tb` VALUES (2, '2345678901', 'password2', '李四', '女', '2023-02-01', '13998765432');
INSERT INTO `manager_tb` VALUES (3, '3456789012', 'password3', '王五', '男', '2023-03-01', '13655557777');
INSERT INTO `manager_tb` VALUES (4, '4567890123', 'password4', '赵六', '女', '2023-04-01', '13511112222');
INSERT INTO `manager_tb` VALUES (5, '5678901234', 'password5', '钱七', '男', '2023-05-01', '13299998888');

-- ----------------------------
-- Table structure for room_tb
-- ----------------------------
DROP TABLE IF EXISTS `room_tb`;
CREATE TABLE `room_tb`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `room_state` tinyint(1) NOT NULL,
  `room_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `room_create_time` date NOT NULL,
  `room_seat_num` int NOT NULL,
  `room_booked_seat_num` int NOT NULL,
  `room_seat_row_num` int NOT NULL,
  `room_seat_column_num` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_tb
-- ----------------------------
INSERT INTO `room_tb` VALUES (6, 'room678', 1, '理科类', '2023-11-01', 80, 2, 10, 8);

-- ----------------------------
-- Table structure for seat_tb
-- ----------------------------
DROP TABLE IF EXISTS `seat_tb`;
CREATE TABLE `seat_tb`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `seat_state` int NOT NULL,
  `seat_position_id` int NOT NULL COMMENT '所在阅览室id',
  `seat_row_id` int NULL DEFAULT NULL,
  `seat_column_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat_tb
-- ----------------------------
INSERT INTO `seat_tb` VALUES (2, 1, 1, 2, 3);
INSERT INTO `seat_tb` VALUES (3, 1, 2, 2, 2);
INSERT INTO `seat_tb` VALUES (4, 0, 3, 2, 1);
INSERT INTO `seat_tb` VALUES (5, 1, 1, 1, 3);
INSERT INTO `seat_tb` VALUES (6, 1, 1, 1, 2);
INSERT INTO `seat_tb` VALUES (7, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for student_tb
-- ----------------------------
DROP TABLE IF EXISTS `student_tb`;
CREATE TABLE `student_tb`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_addtime` date NULL DEFAULT NULL,
  `stu_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_score` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_tb
-- ----------------------------
INSERT INTO `student_tb` VALUES (2, '2021451346', 'password2', '周杰伦', '女', '2023-02-01', '13998765432', 100);
INSERT INTO `student_tb` VALUES (3, '2022458912', 'password3', '王五', '男', '2023-03-01', '13655557777', 50);
INSERT INTO `student_tb` VALUES (4, '2020465788', 'password4', '赵六', '女', '2023-04-01', '13511112222', 60);
INSERT INTO `student_tb` VALUES (5, '2024512486', 'password5', '钱七', '男', '2023-05-01', '13299998888', 100);

SET FOREIGN_KEY_CHECKS = 1;
