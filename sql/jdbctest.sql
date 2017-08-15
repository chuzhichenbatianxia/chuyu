/*
Navicat MySQL Data Transfer

Source Server         : testlocal
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-15 11:59:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jdbctest_tab
-- ----------------------------
DROP TABLE IF EXISTS `jdbctest_tab`;
CREATE TABLE `jdbctest_tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `age` tinyint(6) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `score` float(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jdbctest_tab
-- ----------------------------
INSERT INTO `jdbctest_tab` VALUES ('54', 'zhuyuping3d', '14', '18923.00', '1985-05-09', '123.50');
INSERT INTO `jdbctest_tab` VALUES ('55', 'z', '1', '1.00', '2017-05-08', '1.00');
INSERT INTO `jdbctest_tab` VALUES ('56', 'zhuyuping3', '19', '18923.00', '1985-05-09', '123.50');
INSERT INTO `jdbctest_tab` VALUES ('57', 'zhuyuping', '19', '18923.00', '1985-05-09', '123.50');
INSERT INTO `jdbctest_tab` VALUES ('58', 'zhuyuping', '19', '18923.00', '1985-05-09', '123.50');
INSERT INTO `jdbctest_tab` VALUES ('59', 'zhuyuping', '19', '18923.00', '1985-05-09', '123.50');
INSERT INTO `jdbctest_tab` VALUES ('75', '1sd', '19', '18923.00', '1985-05-09', '123.50');
INSERT INTO `jdbctest_tab` VALUES ('76', '周', '22', '22222.00', '1123-03-04', '455.00');
INSERT INTO `jdbctest_tab` VALUES ('77', 'z', '122', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('78', 'z', '12', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('79', 'z', '12', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('80', 'z', '12', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('81', 'z', '12', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('82', '1s', '12', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('83', '1sdsde', '22', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('84', '223', '12', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('85', '1sdd', '121', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('86', '4www', '4', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('87', '1243d', '12', '12.00', '1997-07-08', '123.00');
INSERT INTO `jdbctest_tab` VALUES ('89', '223', '12', '12.00', '1997-07-08', '123.00');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `town` varchar(25) NOT NULL,
  `factor` varchar(25) NOT NULL,
  `school` varchar(50) NOT NULL,
  `school_id` varchar(10) NOT NULL,
  `clas` varchar(25) NOT NULL,
  `student_name` varchar(5) NOT NULL,
  `student_id` varchar(10) NOT NULL,
  `parents_id` varchar(10) NOT NULL,
  `local_is` tinyint(1) DEFAULT '0' COMMENT '0:是|1:否',
  `town_is` tinyint(1) DEFAULT '0' COMMENT '0:是|1:否',
  `business_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54471', '幼儿园大班(1)班', '陈雨慧', '1923860', '3706869', '0', '0', '和校园5元');
INSERT INTO `school` VALUES ('2', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54471', '幼儿园大班(1)班', '陈雨慧', '1923860', '3706869', '0', '0', '和校园5元');
INSERT INTO `school` VALUES ('3', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54471', '幼儿园大班(1)班', '陈雨慧', '1923860', '3706869', '0', '0', '和校园5元');
INSERT INTO `school` VALUES ('4', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54472', '幼儿园大班(2)班', '陈雨慧', '1923861', '3706870', '0', '0', '和校园6元');
INSERT INTO `school` VALUES ('5', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54473', '幼儿园大班(3)班', '陈雨慧', '1923862', '3706871', '0', '0', '和校园7元');
INSERT INTO `school` VALUES ('6', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54474', '幼儿园大班(4)班', '陈雨慧', '1923863', '3706872', '0', '0', '和校园8元');
INSERT INTO `school` VALUES ('7', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54475', '幼儿园大班(5)班', '陈雨慧', '1923864', '3706873', '0', '0', '和校园9元');
INSERT INTO `school` VALUES ('8', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54476', '幼儿园大班(6)班', '陈雨慧', '1923865', '3706874', '0', '0', '和校园10元');
INSERT INTO `school` VALUES ('9', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54477', '幼儿园大班(7)班', '陈雨慧', '1923866', '3706875', '0', '0', '和校园11元');
INSERT INTO `school` VALUES ('10', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54478', '幼儿园大班(8)班', '陈雨慧', '1923867', '3706876', '0', '0', '和校园12元');
INSERT INTO `school` VALUES ('11', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54479', '幼儿园大班(9)班', '陈雨慧', '1923868', '3706877', '0', '0', '和校园13元');
INSERT INTO `school` VALUES ('12', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54480', '幼儿园大班(10)班', '陈雨慧', '1923869', '3706878', '0', '0', '和校园14元');
INSERT INTO `school` VALUES ('13', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54481', '幼儿园大班(11)班', '陈雨慧', '1923870', '3706879', '0', '0', '和校园15元');
INSERT INTO `school` VALUES ('14', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54482', '幼儿园大班(12)班', '陈雨慧', '1923871', '3706880', '0', '0', '和校园16元');
INSERT INTO `school` VALUES ('15', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54483', '幼儿园大班(13)班', '陈雨慧', '1923872', '3706881', '0', '0', '和校园17元');
INSERT INTO `school` VALUES ('16', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54484', '幼儿园大班(14)班', '陈雨慧', '1923873', '3706882', '0', '0', '和校园18元');
INSERT INTO `school` VALUES ('17', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54485', '幼儿园大班(15)班', '陈雨慧', '1923874', '3706883', '0', '0', '和校园19元');
INSERT INTO `school` VALUES ('18', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54486', '幼儿园大班(16)班', '陈雨慧', '1923875', '3706884', '0', '0', '和校园20元');
INSERT INTO `school` VALUES ('19', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54487', '幼儿园大班(17)班', '陈雨慧', '1923876', '3706885', '0', '0', '和校园21元');
INSERT INTO `school` VALUES ('20', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54488', '幼儿园大班(18)班', '陈雨慧', '1923877', '3706886', '0', '0', '和校园22元');
INSERT INTO `school` VALUES ('21', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54489', '幼儿园大班(19)班', '陈雨慧', '1923878', '3706887', '0', '0', '和校园23元');
INSERT INTO `school` VALUES ('22', '蕉岭', '珠海市龙星信息技术有限公司', '蕉岭县幼儿园', '54490', '幼儿园大班(20)班', '陈雨慧', '1923879', '3706888', '0', '0', '和校园24元');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(16) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '王小军', '1', '17', '北京市东城区');
INSERT INTO `t_student` VALUES ('2', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('3', '张静', '2', '16', '北京市昌平区');
INSERT INTO `t_student` VALUES ('4', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `t_student` VALUES ('5', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('6', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `t_student` VALUES ('7', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('8', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `t_student` VALUES ('9', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('10', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('11', '王海龙', '1', '16', '北京市东城区');
INSERT INTO `t_student` VALUES ('12', '王小军', '1', '17', '北京市东城区');
INSERT INTO `t_student` VALUES ('13', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('14', '张静', '2', '16', '北京市昌平区');
INSERT INTO `t_student` VALUES ('15', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `t_student` VALUES ('16', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('17', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `t_student` VALUES ('18', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('19', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `t_student` VALUES ('20', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('21', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('22', '王海龙', '1', '16', '北京市东城区');
INSERT INTO `t_student` VALUES ('23', '王小军', '1', '17', '北京市东城区');
INSERT INTO `t_student` VALUES ('24', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('25', '张静', '2', '16', '北京市昌平区');
INSERT INTO `t_student` VALUES ('26', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `t_student` VALUES ('27', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('28', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `t_student` VALUES ('29', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('30', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `t_student` VALUES ('31', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('32', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('33', '王海龙', '1', '16', '北京市东城区');
INSERT INTO `t_student` VALUES ('34', 'a', '1', '12', '2');
INSERT INTO `t_student` VALUES ('35', '王小军', '1', '17', '北京市东城区');
INSERT INTO `t_student` VALUES ('36', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('37', '张静', '2', '16', '北京市昌平区');
INSERT INTO `t_student` VALUES ('38', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `t_student` VALUES ('39', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('40', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `t_student` VALUES ('41', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('42', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `t_student` VALUES ('43', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('44', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('45', '王海龙', '1', '16', '北京市东城区');
INSERT INTO `t_student` VALUES ('46', '王小军', '1', '17', '北京市东城区');
INSERT INTO `t_student` VALUES ('47', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('48', '张静', '2', '16', '北京市昌平区');
INSERT INTO `t_student` VALUES ('49', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `t_student` VALUES ('50', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('51', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `t_student` VALUES ('52', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('53', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `t_student` VALUES ('54', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('55', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('56', '王海龙', '1', '16', '北京市东城区');
INSERT INTO `t_student` VALUES ('57', '王小军', '1', '17', '北京市东城区');
INSERT INTO `t_student` VALUES ('58', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('59', '张静', '2', '16', '北京市昌平区');
INSERT INTO `t_student` VALUES ('60', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `t_student` VALUES ('61', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('62', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `t_student` VALUES ('63', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('64', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `t_student` VALUES ('65', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('66', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('67', '王海龙', '1', '16', '北京市东城区');
INSERT INTO `t_student` VALUES ('68', '王小军', '1', '17', '北京市东城区');
INSERT INTO `t_student` VALUES ('69', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('70', '张静', '2', '16', '北京市昌平区');
INSERT INTO `t_student` VALUES ('71', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `t_student` VALUES ('72', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('73', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `t_student` VALUES ('74', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('75', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `t_student` VALUES ('76', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `t_student` VALUES ('77', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `t_student` VALUES ('78', '王海龙', '1', '16', '北京市东城区');
SET FOREIGN_KEY_CHECKS=1;
