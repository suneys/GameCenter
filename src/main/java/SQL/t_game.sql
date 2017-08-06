CREATE TABLE t_game(
  `gId` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `gameName` NVARCHAR(50) DEFAULT NULL COMMENT '游戏名称',
  `path` NVARCHAR(300) DEFAULT NULL COMMENT '游戏下载路径',
  `thumbPath` NVARCHAR(300) DEFAULT NULL COMMENT '游戏缩略图路径',
  `g_isDelete` TINYINT(4) DEFAULT 0 COMMENT '是否删除 0-未删除，1-删除',
  `package` NVARCHAR(50) DEFAULT NULL COMMENT '游戏包名',
  `uId` BIGINT(11) DEFAULT NULL COMMENT '外键，绑定用户id',
  `gAttribute` TINYINT(4) DEFAULT 0 COMMENT '是否删除 0-未删除，1-删除',
  PRIMARY KEY  (`gId`)
);