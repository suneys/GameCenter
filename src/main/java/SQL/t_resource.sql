CREATE TABLE t_resource(
  `rId` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `fileName` NVARCHAR(50) DEFAULT NULL COMMENT '文件名称',
  `fileSize` INT DEFAULT 0 COMMENT '文件大小',
  `path` NVARCHAR(300) DEFAULT NULL COMMENT '原始图路径',
  `thumbPath` NVARCHAR(300) DEFAULT NULL COMMENT '缩略图路径',
  `createTime` DATETIME DEFAULT NULL COMMENT '创建时间',
  `isDelete` TINYINT(4) DEFAULT 0 COMMENT '是否删除 0-未删除，1-删除',
  `souceType` INT DEFAULT 0 COMMENT '文件类型，0-图片，1-视频',
  `uId` BIGINT(11) DEFAULT NULL COMMENT '外键，绑定用户id',
  PRIMARY KEY  (`rId`)
);