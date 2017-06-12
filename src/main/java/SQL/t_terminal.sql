CREATE TABLE t_terminal(
  `tId` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `terminalNo` NVARCHAR(50) DEFAULT NULL COMMENT '终端编号',
  `terminalName` NVARCHAR(50) DEFAULT NULL COMMENT '终端名称',
  `publishState` TINYINT(4) DEFAULT NULL COMMENT '发布状态：0-失败，1-成功，2-发布中',
  `isUpdate` TINYINT(4) DEFAULT 0 COMMENT '有无内容更新',
  `createDate` DATE DEFAULT NULL COMMENT '注册日期',
  `uId` BIGINT(11) DEFAULT NULL COMMENT '绑定用户id',
  `activation` TINYINT(4) DEFAULT 0 COMMENT '绑定状态',
  `activationDate` DATE DEFAULT NULL COMMENT '绑定日期',
  `endDate` DATE DEFAULT NULL COMMENT '截止日期(未注册默认7天有效，预留功能)',
  `agentId` BIGINT(11) DEFAULT NULL COMMENT '代理商ID',
  `isDelete` TINYINT(4) DEFAULT 0 COMMENT '是否删除 0-未删除，1-删除',
  `isOverdue` TINYINT(4) DEFAULT 0 COMMENT '是否过期 0-未过期，1-过期',
  `version` NVARCHAR(50) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY  (`tId`)
);