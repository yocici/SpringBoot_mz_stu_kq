/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : mz_stu_kq

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-12-07 17:46:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_classes`
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `tid` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_classes
-- ----------------------------
INSERT INTO `t_classes` VALUES ('32', 't1老师的java班', '2020-12-07 17:18:53', '54');
INSERT INTO `t_classes` VALUES ('33', 't2老师UI班级', '2020-12-07 17:19:29', '55');

-- ----------------------------
-- Table structure for `t_leave`
-- ----------------------------
DROP TABLE IF EXISTS `t_leave`;
CREATE TABLE `t_leave` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `userid` bigint(2) DEFAULT NULL,
  `auditid` bigint(2) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `status` bigint(2) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `auditTime` datetime DEFAULT NULL,
  `auditInfo` varchar(255) DEFAULT NULL,
  `num` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_leave
-- ----------------------------
INSERT INTO `t_leave` VALUES ('11', '56', '54', '回家过生', '1', '2020-12-07 17:26:25', '2020-12-07 17:27:08', '同意', '2');
INSERT INTO `t_leave` VALUES ('12', '57', '54', '回家玩', '2', '2020-12-07 17:27:37', '2020-12-07 17:28:11', '请的天数太多 不同意', '5');
INSERT INTO `t_leave` VALUES ('13', '57', '54', '回家玩', '1', '2020-12-07 17:29:19', '2020-12-07 17:29:52', '审核通过', '2');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `pid` bigint(2) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '系统管理', null, null, 'mdi mdi-file-outline');
INSERT INTO `t_menu` VALUES ('2', '用户维护', '/user/index', '1', null);
INSERT INTO `t_menu` VALUES ('3', '角色维护', '/role/index', '1', null);
INSERT INTO `t_menu` VALUES ('4', '权限维护', '/permission/index', '1', null);
INSERT INTO `t_menu` VALUES ('5', '菜单维护', '/menu/index', '1', null);
INSERT INTO `t_menu` VALUES ('6', '班级管理', null, null, 'mdi mdi-palette');
INSERT INTO `t_menu` VALUES ('7', '班级维护', '/classes/index', '6', null);
INSERT INTO `t_menu` VALUES ('10', '学生管理', null, null, 'mdi mdi-account-multiple');
INSERT INTO `t_menu` VALUES ('11', '学生列表', '/student/index', '10', '');
INSERT INTO `t_menu` VALUES ('12', '老师管理', null, null, 'mdi mdi-account-settings-variant');
INSERT INTO `t_menu` VALUES ('13', '老师列表', '/teacher/index', '12', '');
INSERT INTO `t_menu` VALUES ('16', '考勤信息', '', null, 'mdi mdi-file');
INSERT INTO `t_menu` VALUES ('17', '考勤列表', '/kq/index', '16', null);
INSERT INTO `t_menu` VALUES ('18', '请假管理', null, null, 'mdi mdi-account-multiple');
INSERT INTO `t_menu` VALUES ('19', '申请请假', '/leave/add', '18', '');
INSERT INTO `t_menu` VALUES ('20', '审批请假', '/leave/audit', '18', '');
INSERT INTO `t_menu` VALUES ('21', '请假信息', '/leave/index', '18', '');
INSERT INTO `t_menu` VALUES ('22', '审核信息', '/leave/auditlist', '18', '');

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `pid` bigint(2) DEFAULT NULL,
  `menuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', 'user', '用户模块', '0', '2');
INSERT INTO `t_permission` VALUES ('7', 'role', '角色模块', '0', '3');
INSERT INTO `t_permission` VALUES ('8', 'role:add', '新增角色', '7', null);
INSERT INTO `t_permission` VALUES ('9', 'role:delete', '删除角色', '7', null);
INSERT INTO `t_permission` VALUES ('10', 'role:get', '查询角色', '7', null);
INSERT INTO `t_permission` VALUES ('11', 'role:update', '修改角色', '7', null);
INSERT INTO `t_permission` VALUES ('13', 'menu', '菜单管理', '0', '5');
INSERT INTO `t_permission` VALUES ('14', 'menu:add', '新增菜单', '13', null);
INSERT INTO `t_permission` VALUES ('15', 'user:add', '用户新增', '1', null);
INSERT INTO `t_permission` VALUES ('16', 'user:delete', '用户删除', '1', null);
INSERT INTO `t_permission` VALUES ('17', 'user:get', '用户查询', '1', null);
INSERT INTO `t_permission` VALUES ('18', 'user:update', '用户更新', '1', null);
INSERT INTO `t_permission` VALUES ('19', 'menu:delete', '菜单删除', '13', null);
INSERT INTO `t_permission` VALUES ('20', 'menu:query', '菜单查询', '13', null);
INSERT INTO `t_permission` VALUES ('21', 'menu:get', '菜单获取', '13', null);
INSERT INTO `t_permission` VALUES ('22', 'permission', '权限列表', '0', '4');
INSERT INTO `t_permission` VALUES ('23', 'classes', '班级信息', '0', '7');
INSERT INTO `t_permission` VALUES ('24', 'student', '学生列表', '0', '11');
INSERT INTO `t_permission` VALUES ('25', 'teacher', '老师列表', '0', '13');
INSERT INTO `t_permission` VALUES ('27', 'kq', '考勤列表', '27', '17');
INSERT INTO `t_permission` VALUES ('28', 'leave', '申请请假', '0', '19');
INSERT INTO `t_permission` VALUES ('29', 'leaveaudit', '审批请假', '0', '20');
INSERT INTO `t_permission` VALUES ('30', 'leavelist', '请假记录', '0', '21');
INSERT INTO `t_permission` VALUES ('31', 'auditlist', '审核信息', '0', '22');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', null, null);
INSERT INTO `t_role` VALUES ('2', '老师权限', null, null);
INSERT INTO `t_role` VALUES ('3', '学生权限', '', '<p>学生权限</p>\n');

-- ----------------------------
-- Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(2) DEFAULT NULL,
  `permissionid` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=316 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('273', '1', '1');
INSERT INTO `t_role_permission` VALUES ('274', '1', '7');
INSERT INTO `t_role_permission` VALUES ('275', '1', '8');
INSERT INTO `t_role_permission` VALUES ('276', '1', '9');
INSERT INTO `t_role_permission` VALUES ('277', '1', '10');
INSERT INTO `t_role_permission` VALUES ('278', '1', '11');
INSERT INTO `t_role_permission` VALUES ('279', '1', '13');
INSERT INTO `t_role_permission` VALUES ('280', '1', '14');
INSERT INTO `t_role_permission` VALUES ('281', '1', '15');
INSERT INTO `t_role_permission` VALUES ('282', '1', '16');
INSERT INTO `t_role_permission` VALUES ('283', '1', '17');
INSERT INTO `t_role_permission` VALUES ('284', '1', '18');
INSERT INTO `t_role_permission` VALUES ('285', '1', '19');
INSERT INTO `t_role_permission` VALUES ('286', '1', '20');
INSERT INTO `t_role_permission` VALUES ('287', '1', '21');
INSERT INTO `t_role_permission` VALUES ('288', '1', '22');
INSERT INTO `t_role_permission` VALUES ('307', '3', '23');
INSERT INTO `t_role_permission` VALUES ('308', '3', '27');
INSERT INTO `t_role_permission` VALUES ('309', '3', '28');
INSERT INTO `t_role_permission` VALUES ('310', '3', '30');
INSERT INTO `t_role_permission` VALUES ('311', '2', '23');
INSERT INTO `t_role_permission` VALUES ('312', '2', '24');
INSERT INTO `t_role_permission` VALUES ('313', '2', '27');
INSERT INTO `t_role_permission` VALUES ('314', '2', '29');
INSERT INTO `t_role_permission` VALUES ('315', '2', '31');

-- ----------------------------
-- Table structure for `t_stu_kq`
-- ----------------------------
DROP TABLE IF EXISTS `t_stu_kq`;
CREATE TABLE `t_stu_kq` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `userid` bigint(2) DEFAULT NULL,
  `upClassTime` datetime DEFAULT NULL,
  `downClassTime` datetime DEFAULT NULL,
  `currentTime` date DEFAULT NULL,
  `tid` bigint(2) DEFAULT NULL,
  `isup` bigint(2) DEFAULT NULL,
  `isdown` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stu_kq
-- ----------------------------
INSERT INTO `t_stu_kq` VALUES ('21', '56', '2020-12-07 17:23:30', '2020-12-07 17:24:04', '2020-12-07', '54', '1', '1');
INSERT INTO `t_stu_kq` VALUES ('22', '58', '2020-12-07 17:24:37', null, '2020-12-07', '55', '1', null);
INSERT INTO `t_stu_kq` VALUES ('23', '57', '2020-12-07 17:24:50', null, '2020-12-07', '54', '1', null);

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `sex` bit(1) DEFAULT NULL,
  `headImg` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `stunum` varchar(255) DEFAULT NULL,
  `type` bigint(2) DEFAULT NULL,
  `classesid` bigint(2) DEFAULT NULL,
  `courseid` bigint(2) DEFAULT NULL,
  `tid` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '$2a$10$YITYi7HjqT2gh8jEF6eyquR/Og0qmYBNT8cQLaEjjS92jcZHwsI9G', 'admin@qq.com', '18000010002', '', '229caa82-17c6-4515-9bd6-edbf10212099.png', '2020-05-15 13:49:07', null, '1', null, null, null);
INSERT INTO `t_user` VALUES ('2', 'admin2', '$2a$10$YITYi7HjqT2gh8jEF6eyquR/Og0qmYBNT8cQLaEjjS92jcZHwsI9G', 'test112244@qq.com', '18000020003', '', 'f879da1c-b376-40a2-a5a0-68b656fad44a.jpg', '2020-05-13 13:49:11', null, '1', null, null, null);
INSERT INTO `t_user` VALUES ('54', 't1', '$2a$10$OorZRHszzvvQWayHdWOX5u5FS5kmMh4Zx6D5CAsb4SJZquHmBo30K', 't1@163.com', '18800010001', '', '149f5434-615e-48cb-b0e9-b1b573452540.jpg', '2020-12-07 17:15:42', '', '2', null, null, null);
INSERT INTO `t_user` VALUES ('55', 't2', '$2a$10$3Mv/1rCK0/oQR0kMS6hrvuZh7ij0ttXHQAPyeAH.mkBh0TFfTCcLi', 't2@163.com', '18800010002', '', 'cc848832-f188-432c-b594-fc2492a03395.jpg', '2020-12-07 17:16:12', '', '2', null, null, null);
INSERT INTO `t_user` VALUES ('56', 'stu1', '$2a$10$sYyk1pVidnk11/dOYth9G./MwKn7YgTPA0zl2THW9rhDAT1TyS4WW', 'stu1@qq.com', '18820011016', '', '81d23a29-c77b-492a-abb3-4a0c4eac48a8.jpg', '2020-12-07 17:20:41', '10101118', '3', '32', null, '54');
INSERT INTO `t_user` VALUES ('57', 'stu3', '$2a$10$cvd1hP/ZrOoBa.ovV7SFMeKLmVT/3ZUI0IwgW.//bItu6ansitX2.', 'stu3@qq.com', '18820011017', '', 'e2121917-19e5-4a4b-8ad3-5f4d82707bfd.png', '2020-12-07 17:21:10', '10101119', '3', '32', null, '54');
INSERT INTO `t_user` VALUES ('58', 'stu2', '$2a$10$.uqbvovqr3.8h4hjLcDgou5RZokcOoA1HOYYI5d3n3GsICraakciO', 'stu2@qq.com', '18820011018', '', '0ab2d915-fe98-4761-8fe9-8d200432b383.png', '2020-12-07 17:21:39', '10101120', '3', '33', null, '55');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(2) NOT NULL AUTO_INCREMENT,
  `userid` bigint(2) DEFAULT NULL,
  `roleid` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('30', '36', '2');
INSERT INTO `t_user_role` VALUES ('31', '37', '3');
INSERT INTO `t_user_role` VALUES ('32', '38', '2');
INSERT INTO `t_user_role` VALUES ('33', '39', '3');
INSERT INTO `t_user_role` VALUES ('34', '41', '2');
INSERT INTO `t_user_role` VALUES ('35', '42', '3');
INSERT INTO `t_user_role` VALUES ('36', '44', '2');
INSERT INTO `t_user_role` VALUES ('37', '43', '2');
INSERT INTO `t_user_role` VALUES ('38', '45', '3');
INSERT INTO `t_user_role` VALUES ('39', '46', '3');
INSERT INTO `t_user_role` VALUES ('40', '47', '3');
INSERT INTO `t_user_role` VALUES ('41', '50', '2');
INSERT INTO `t_user_role` VALUES ('42', '49', '2');
INSERT INTO `t_user_role` VALUES ('43', '51', '3');
INSERT INTO `t_user_role` VALUES ('44', '52', '3');
INSERT INTO `t_user_role` VALUES ('45', '53', '3');
INSERT INTO `t_user_role` VALUES ('46', '54', '2');
INSERT INTO `t_user_role` VALUES ('47', '55', '2');
INSERT INTO `t_user_role` VALUES ('48', '56', '3');
INSERT INTO `t_user_role` VALUES ('49', '57', '3');
INSERT INTO `t_user_role` VALUES ('50', '58', '3');
