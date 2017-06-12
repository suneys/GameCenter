CREATE TABLE `t_folder` (
  `fId` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `pId` BIGINT(11) DEFAULT 0 COMMENT '父文件ID',
  `name` VARCHAR(50) DEFAULT NULL COMMENT '文件名',
  `uId` BIGINT(11) DEFAULT 0 COMMENT '用户ID',
  `createDate` DATE DEFAULT NULL COMMENT '创建日期',
  `updateDate` DATE DEFAULT NULL COMMENT '修改日期',
  `is_delete` TINYINT(4) DEFAULT NULL COMMENT '是否删除，0-未删除；1-已删除',
  PRIMARY KEY  (`fId`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='资源文件夹表';