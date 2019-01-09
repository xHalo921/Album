/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : album

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 09/01/2019 19:41:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album`  (
  `AlbumId` int(11) NOT NULL AUTO_INCREMENT,
  `AlbumName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UserId` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `categoryName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreateTime` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`AlbumId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `categoryId` int(4) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`categoryId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `CommentId` int(8) NOT NULL AUTO_INCREMENT,
  `PhotoId` int(8) NOT NULL,
  `User` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Comments` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`CommentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for friends
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends`  (
  `User` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FriendId` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`User`, `FriendId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo`  (
  `PhotoId` int(11) NOT NULL AUTO_INCREMENT,
  `PhotoName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `AlbumId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PhotoURL` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `UploadTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`PhotoId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `User` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`User`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Triggers structure for table album
-- ----------------------------
DROP TRIGGER IF EXISTS `dela`;
delimiter ;;
CREATE TRIGGER `dela` AFTER DELETE ON `album` FOR EACH ROW BEGIN
DELETE FROM photo WHERE photo.AlbumId=OLD.AlbumId;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table category
-- ----------------------------
DROP TRIGGER IF EXISTS `d1`;
delimiter ;;
CREATE TRIGGER `d1` AFTER DELETE ON `category` FOR EACH ROW begin
update album set album.categoryName='未分类' where album.categoryName=old.categoryName;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table photo
-- ----------------------------
DROP TRIGGER IF EXISTS `del`;
delimiter ;;
CREATE TRIGGER `del` AFTER DELETE ON `photo` FOR EACH ROW BEGIN
DELETE FROM discuss WHERE discuss.PhotoID=OLD.PhotoID;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
