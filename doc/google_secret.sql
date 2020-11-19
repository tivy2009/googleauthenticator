/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : googleauth

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-11-18 11:10:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `google_secret`
-- ----------------------------
DROP TABLE IF EXISTS `google_secret`;
CREATE TABLE `google_secret` (
  `id` varchar(32) NOT NULL,
  `account` varchar(250) NOT NULL,
  `issuer` varchar(250) NOT NULL,
  `secret` varchar(250) NOT NULL,
  `status` int(11) NOT NULL,
  `createtime` datetime(3) NOT NULL,
  `updatetime` datetime(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of google_secret
-- ----------------------------
INSERT INTO `google_secret` VALUES ('05da97ef293a11eba8871c1b0d477da9', 'dAdmin', 'Google身份认证器4', '2BCS6AXCLZXW2SVU', '1', '2020-11-17 09:04:34.930', '2020-11-18 09:04:34.930');
INSERT INTO `google_secret` VALUES ('3605bb8a294811eba8871c1b0d477da9', 'gAdmin', 'Google身份认证器', 'J7BDF2KT5WXRX4XA', '1', '2020-11-18 10:46:09.214', '2020-11-18 10:46:09.214');
INSERT INTO `google_secret` VALUES ('3be9c83d28ba11ebb8b91c1b0d477da9', 'cAdmin', 'Google身份认证器33', 'BYDP3WXMQ72M3YGC', '1', '2020-11-16 17:49:50.618', '2020-11-17 17:49:50.618');
INSERT INTO `google_secret` VALUES ('4409e8f7294011eba8871c1b0d477da9', 'dAdmin', 'Google身份认证器5', '7MWUBZ3E6A7B4GRP', '1', '2020-11-18 09:49:16.466', '2020-11-18 09:49:16.466');
INSERT INTO `google_secret` VALUES ('4a0c50f328ad11ebb8b91c1b0d477da9', 'bAdmin', 'Google身份认证器', 'LXRZORJ3JZ6MSBXK', '1', '2020-11-16 16:17:10.723', '2020-11-17 16:17:10.723');
INSERT INTO `google_secret` VALUES ('5f0fa2a7294011eba8871c1b0d477da9', 'eAdmin', 'Google身份认证器', 'F7BFZXHFAJDW3GV2', '1', '2020-11-18 09:50:01.806', '2020-11-18 09:50:01.806');
INSERT INTO `google_secret` VALUES ('85abe9ab294311eba8871c1b0d477da9', 'gAdmin', 'Google身份认证器', 'HIB45FHNKDNSGFWI', '1', '2020-11-18 10:12:35.188', '2020-11-18 10:12:35.188');
INSERT INTO `google_secret` VALUES ('e3ca00c828ac11ebb8b91c1b0d477da9', 'Admin', 'Google身份认证器', 'YSHY2G43JX4KWGPZ', '1', '2020-11-16 16:14:19.000', '2020-11-17 16:14:19.000');
