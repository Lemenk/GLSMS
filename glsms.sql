/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : glsms

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 07/06/2020 19:34:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comm_apply_handle
-- ----------------------------
DROP TABLE IF EXISTS `comm_apply_handle`;
CREATE TABLE `comm_apply_handle`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `csp_id` int(255) NULL DEFAULT NULL COMMENT 'csp表的主键id',
  `status` int(2) NOT NULL COMMENT '状态码。0未处理，1成功，2失败',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for comm_student_process
-- ----------------------------
DROP TABLE IF EXISTS `comm_student_process`;
CREATE TABLE `comm_student_process`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `proc_id` int(255) NOT NULL COMMENT '流程id',
  `stu_id` int(7) NOT NULL COMMENT '学生表id',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态码',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `handle_time` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  `handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(11) NOT NULL COMMENT '父菜单id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `spread` int(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '是否展开。1为true展开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '离校管理系统', NULL, '&#xe68e;', 1);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', '', '&#xe613;', 0);
INSERT INTO `sys_menu` VALUES (4, 1, '系统管理', NULL, '&#xe716;', 0);
INSERT INTO `sys_menu` VALUES (5, 1, '统计分析', NULL, '&#xe656;', 0);
INSERT INTO `sys_menu` VALUES (6, 2, '学生管理', '../sys/toStudentManager', '&#xe612;', 0);
INSERT INTO `sys_menu` VALUES (7, 2, '教师管理', '../sys/toTeacherManager', '&#xe66f;', 0);
INSERT INTO `sys_menu` VALUES (8, 2, '工作人员管理', '../sys/toStaffManager', '&#xe770;', 0);
INSERT INTO `sys_menu` VALUES (9, 4, '部门管理', '../sys/toDeptManager', '&#xe691;', 0);
INSERT INTO `sys_menu` VALUES (11, 4, '菜单管理', '../sys/toMenuManager', '&#xe62d;', 0);
INSERT INTO `sys_menu` VALUES (12, 4, '公告管理', '../sys/toNewsManager', '&#xe705;', 0);
INSERT INTO `sys_menu` VALUES (13, 5, '离校申请统计', '../sys/toStudentApplyStat', '&#xe62c;', 0);
INSERT INTO `sys_menu` VALUES (14, 5, '部门处理申请统计', '../sys/toHandleStat', '&#xe629;', 0);
INSERT INTO `sys_menu` VALUES (15, 1, '学生离校申请', '../sys/toProcessManager', '&#xe629;', 0);
INSERT INTO `sys_menu` VALUES (21, 1, '辅导员离校统计', '', '&#xe629;', 1);
INSERT INTO `sys_menu` VALUES (22, 21, '学生离校确认', '../sys/toTeacherHandleManager', '&#xe629;', 0);
INSERT INTO `sys_menu` VALUES (23, 21, '学生离校情况查看', '../sys/toLeaveStatTable', '表', 0);
INSERT INTO `sys_menu` VALUES (24, 21, '学生离校统计', '../sys/toStudentLeaveStat', '&#xe629;', 0);
INSERT INTO `sys_menu` VALUES (25, 1, '财务处离校确认', '', '财', 1);
INSERT INTO `sys_menu` VALUES (26, 25, '学生离校确认', '../sys/toStaffHandleManager', '财', 0);
INSERT INTO `sys_menu` VALUES (28, 1, '宿管处离校统计', '', '宿', 1);
INSERT INTO `sys_menu` VALUES (29, 28, '学生离校确认', '../sys/toStaffHandleManager', '宿', 0);
INSERT INTO `sys_menu` VALUES (31, 1, '组织部离校统计', '', '组', 1);
INSERT INTO `sys_menu` VALUES (32, 31, '学生离校确认', '../sys/toStaffHandleManager', '组', 0);
INSERT INTO `sys_menu` VALUES (43, 4, '日志管理', '../sys/toLoginLogManager', '&#xe68d;', 0);
INSERT INTO `sys_menu` VALUES (48, 4, '数据源监控', '../druid/', 'D', 0);
INSERT INTO `sys_menu` VALUES (49, 1, '教务处离校确认', '', '教', 1);
INSERT INTO `sys_menu` VALUES (50, 49, '学生离校确认', '../sys/toStaffHandleManager', '教', 0);
INSERT INTO `sys_menu` VALUES (51, 5, '学生离校情况统计', '../sys/toLeaveInfoStatTable', '', 0);

-- ----------------------------
-- Table structure for sys_process
-- ----------------------------
DROP TABLE IF EXISTS `sys_process`;
CREATE TABLE `sys_process`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `proc_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '流程名',
  `available` int(2) NOT NULL COMMENT '是否可用。0为不可用，1为可用。',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_process
-- ----------------------------
INSERT INTO `sys_process` VALUES (1, '教务处离校确认', 1);
INSERT INTO `sys_process` VALUES (2, '宿管处离校确认', 1);
INSERT INTO `sys_process` VALUES (3, '财务处离校确认', 1);
INSERT INTO `sys_process` VALUES (4, '组织部离校确认', 1);
INSERT INTO `sys_process` VALUES (5, '辅导员离校确认', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `rid` int(11) NOT NULL COMMENT '角色id',
  `mid` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`rid`, `mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (0, 1);
INSERT INTO `sys_role_menu` VALUES (0, 2);
INSERT INTO `sys_role_menu` VALUES (0, 4);
INSERT INTO `sys_role_menu` VALUES (0, 5);
INSERT INTO `sys_role_menu` VALUES (0, 6);
INSERT INTO `sys_role_menu` VALUES (0, 7);
INSERT INTO `sys_role_menu` VALUES (0, 8);
INSERT INTO `sys_role_menu` VALUES (0, 9);
INSERT INTO `sys_role_menu` VALUES (0, 11);
INSERT INTO `sys_role_menu` VALUES (0, 12);
INSERT INTO `sys_role_menu` VALUES (0, 13);
INSERT INTO `sys_role_menu` VALUES (0, 14);
INSERT INTO `sys_role_menu` VALUES (0, 43);
INSERT INTO `sys_role_menu` VALUES (0, 48);
INSERT INTO `sys_role_menu` VALUES (0, 51);
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 15);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 21);
INSERT INTO `sys_role_menu` VALUES (2, 22);
INSERT INTO `sys_role_menu` VALUES (2, 23);
INSERT INTO `sys_role_menu` VALUES (2, 24);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (3, 25);
INSERT INTO `sys_role_menu` VALUES (3, 26);
INSERT INTO `sys_role_menu` VALUES (4, 28);
INSERT INTO `sys_role_menu` VALUES (4, 29);
INSERT INTO `sys_role_menu` VALUES (5, 49);
INSERT INTO `sys_role_menu` VALUES (5, 50);
INSERT INTO `sys_role_menu` VALUES (6, 31);
INSERT INTO `sys_role_menu` VALUES (6, 32);

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `deptId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门号',
  `deptName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES (1, '1', '教务处');
INSERT INTO `tb_dept` VALUES (2, '2', '住宿管理处');
INSERT INTO `tb_dept` VALUES (3, '3', '财务处');
INSERT INTO `tb_dept` VALUES (4, '4', '组织部');
INSERT INTO `tb_dept` VALUES (5, '5', '计算机科学与技术学院');
INSERT INTO `tb_dept` VALUES (6, '6', '理学院');
INSERT INTO `tb_dept` VALUES (7, '7', '化工学院');
INSERT INTO `tb_dept` VALUES (8, '8', '测绘学院');
INSERT INTO `tb_dept` VALUES (9, '9', '管理学院');
INSERT INTO `tb_dept` VALUES (10, '10', '安全学院');
INSERT INTO `tb_dept` VALUES (11, '11', '电控学院');
INSERT INTO `tb_dept` VALUES (12, '12', '通信学院');
INSERT INTO `tb_dept` VALUES (13, '13', '艺术学院');
INSERT INTO `tb_dept` VALUES (15, '14', '人文学院');
INSERT INTO `tb_dept` VALUES (16, '15', '体育学院');

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻内容',
  `oper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES (1, '这是一个测试公告', '<p><b>这是一个测试公告！</b></p><p><i>这是一个测试公告！</i></p><p><u>这是一个测试公告！</u></p><p><strike>这是一个测试公告！</strike></p><p><a target=\"_blank\" href=\"https://www.baidu.com\" style=\"\">https://www.baidu.com</a><br></p><p><img src=\"http://localhost:8080/GLSMS_war_exploded/resources/layui/images/face/36.gif\" alt=\"[酷]\"><img src=\"http://localhost:8080/GLSMS_war_exploded/resources/layui/images/face/36.gif\" alt=\"[酷]\"><img src=\"http://localhost:8080/GLSMS_war_exploded/resources/layui/images/face/36.gif\" alt=\"[酷]\"><br></p>', '系统', '2020-05-04 00:50:57');
INSERT INTO `tb_news` VALUES (2, '关于落实2020届毕业生离校工作的安排', '<p>这是一个测试！</p><p>关于落实2020届毕业生离校工作的安排</p><p>关于落实2020届毕业生离校工作的安排</p><p>关于落实2020届毕业生离校工作的安排</p><p>关于落实2020届毕业生离校工作的安排</p>', '系统', '2020-05-04 05:39:01');
INSERT INTO `tb_news` VALUES (3, '第二个测试公告', '<p>第二个测试公告第二个测试公告第二个测试公告</p><p>第二个测试公告第二个测试公告第二个测试公告</p><p>第二个测试公告第二个测试公告</p>', '系统', '2020-05-05 00:54:58');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES (0, '超级管理员');
INSERT INTO `tb_role` VALUES (1, '学生');
INSERT INTO `tb_role` VALUES (2, '教师');
INSERT INTO `tb_role` VALUES (3, '财务处');
INSERT INTO `tb_role` VALUES (4, '住宿管理处');
INSERT INTO `tb_role` VALUES (5, '教务处');
INSERT INTO `tb_role` VALUES (6, '组织部');

-- ----------------------------
-- Table structure for tb_staff
-- ----------------------------
DROP TABLE IF EXISTS `tb_staff`;
CREATE TABLE `tb_staff`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `staId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作人员ID',
  `staName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作人员名称',
  `staDept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作人员所属部门',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_staff
-- ----------------------------
INSERT INTO `tb_staff` VALUES (1, '31234567890', '李四', '1', NULL);
INSERT INTO `tb_staff` VALUES (2, '001', '王菲', '4', 'wangfei@qq.com');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` int(7) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stu_no` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `stu_dept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `home_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sutId`(`stu_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (14, '33333', '老三', '3333', '33333333333333', '10', '666', '');
INSERT INTO `tb_student` VALUES (15, '555', '小泽', '332', '1515151515', '5', '网工二班', '');
INSERT INTO `tb_student` VALUES (16, '416131', '弟弟', 'fff@qq.com', '15129088771', '6', '113135', '');
INSERT INTO `tb_student` VALUES (17, '111111', '我是学生', '111111@qq.com', '11111111111', '7', '软工一班', '');
INSERT INTO `tb_student` VALUES (18, '666666', '晓东', 'Lemenk@163.com', '15129088771', '5', '网工2班', '');
INSERT INTO `tb_student` VALUES (19, '96291', '老李', '96291@qq.com', '15129088771', '10', '安全1班', '');
INSERT INTO `tb_student` VALUES (20, '1111111100', '测试', 'ceshi@163.com', '15129088771', '5', '网络工程1602班', '');
INSERT INTO `tb_student` VALUES (21, '16408070625', '李佳桁', '16408070625@163.com', '16408070625', '5', '网络工程1601班', '');
INSERT INTO `tb_student` VALUES (22, '16408070601', '王宏', '16408070601@qq.com', '16408070601', '5', '网络工程1602班', '');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `id` int(7) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `techId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师号',
  `techName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `techDept` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属部门',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tId`(`techId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES (1, '21234567890', '王浩', '5', '123456@qq.com');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(6) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '用户状态：0正常 1锁定',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '用户创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '用户信息更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userId`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (0, 'root', '123456', 0, '2020-04-22 13:05:26', '2020-04-22 13:06:47');
INSERT INTO `tb_user` VALUES (2, '21234567890', '123456789', 0, '2020-04-16 09:12:57', '2020-04-16 09:12:57');
INSERT INTO `tb_user` VALUES (3, '31234567890', '123456789', 0, '2020-04-16 09:13:29', '2020-04-16 09:13:29');
INSERT INTO `tb_user` VALUES (10, '33333', '123456', 0, '2020-04-29 12:55:18', '2020-04-29 12:55:18');
INSERT INTO `tb_user` VALUES (11, '555', '123456', 0, '2020-04-29 15:12:46', '2020-04-29 16:59:50');
INSERT INTO `tb_user` VALUES (12, '416131', '123456', 0, '2020-04-29 17:22:24', '2020-04-29 17:22:24');
INSERT INTO `tb_user` VALUES (14, '001', '123456', 0, '2020-05-01 18:00:17', '2020-05-01 18:00:17');
INSERT INTO `tb_user` VALUES (15, '111111', '123456', 0, '2020-05-01 23:34:19', '2020-05-01 23:34:19');
INSERT INTO `tb_user` VALUES (16, '666666', '123456', 0, '2020-05-09 16:02:39', '2020-05-09 16:02:39');
INSERT INTO `tb_user` VALUES (17, '96291', '123456', 0, '2020-05-12 17:48:13', '2020-05-12 17:48:13');
INSERT INTO `tb_user` VALUES (18, '1111111100', '123456', 0, '2020-05-26 09:32:45', '2020-05-26 09:32:45');
INSERT INTO `tb_user` VALUES (19, '16408070625', '123456', 0, '2020-06-02 12:55:16', '2020-06-02 12:55:16');
INSERT INTO `tb_user` VALUES (20, '16408070601', '123456', 0, '2020-06-02 13:35:00', '2020-06-02 13:35:00');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`  (
  `userId` int(20) NOT NULL COMMENT '用户ID',
  `roleId` int(20) NOT NULL COMMENT '角色ID',
  INDEX `role_id`(`roleId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES (1, 1);
INSERT INTO `tb_user_role` VALUES (2, 2);
INSERT INTO `tb_user_role` VALUES (3, 5);
INSERT INTO `tb_user_role` VALUES (0, 0);
INSERT INTO `tb_user_role` VALUES (9, 1);
INSERT INTO `tb_user_role` VALUES (10, 1);
INSERT INTO `tb_user_role` VALUES (11, 1);
INSERT INTO `tb_user_role` VALUES (12, 1);
INSERT INTO `tb_user_role` VALUES (14, 6);
INSERT INTO `tb_user_role` VALUES (15, 1);
INSERT INTO `tb_user_role` VALUES (16, 1);
INSERT INTO `tb_user_role` VALUES (17, 1);
INSERT INTO `tb_user_role` VALUES (18, 1);
INSERT INTO `tb_user_role` VALUES (19, 1);
INSERT INTO `tb_user_role` VALUES (20, 1);

SET FOREIGN_KEY_CHECKS = 1;
