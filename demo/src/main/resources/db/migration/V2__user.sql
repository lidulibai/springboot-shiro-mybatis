CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL,
  `state` varchar(1) DEFAULT '1' COMMENT '状态 0: 禁用; 1: 启用',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `state` varchar(1) DEFAULT '1' COMMENT '0: 禁用; 1: 启用',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `state` varchar(1) DEFAULT '1' COMMENT '0: 禁用; 1: 启用',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `state` varchar(1) DEFAULT '1' COMMENT '0: 禁用; 1: 启用',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  KEY `FKdec2ggmqwgdhhb59jw7o488wx` (`role_id`),
  KEY `FKsrs64lo4ci4xyu3da9clbiv8r` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `role_permission` (
  `permission_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `state` varchar(1) DEFAULT '1' COMMENT '0: 禁用; 1: 启用',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `updator` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  KEY `FKgjoqa6ydj46cv836mn9nadg96` (`role_id`),
  KEY `FK5uek5kqcd6l5dgc1qlm0s7us0` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;










