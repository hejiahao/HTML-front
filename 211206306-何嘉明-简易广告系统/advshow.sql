/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : advshow

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2017-06-05 22:23:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `turnadv`
-- ----------------------------
DROP TABLE IF EXISTS `turnadv`;
CREATE TABLE `turnadv` (
  `advNote` text CHARACTER SET utf8,
  `advImg` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `advUrl` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `timeout` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of turnadv
-- ----------------------------
INSERT INTO `turnadv` VALUES ('访问网易', 'banner-1.png', 'http://www.163.com', '100');
INSERT INTO `turnadv` VALUES ('访问福州大学', 'banner-2.png', 'http://www.fzu.edu.cn', '200');
INSERT INTO `turnadv` VALUES ('访问京东商城', 'banner-3.png', 'www.jd.com', '300');
INSERT INTO `turnadv` VALUES ('访问亚马逊', 'jd-1.png', 'http://www.amazon.com', '400');
INSERT INTO `turnadv` VALUES ('访问苹果美国', 'jd-2.png', 'http://www.apple.com', '500');
