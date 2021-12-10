USE `db_test`;
-- 删除表
DROP TABLE IF EXISTS `user`;
-- 创建表
CREATE TABLE `user`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT     NOT NULL COMMENT '主键',
    `username`   VARCHAR(64)                        NOT NULL COMMENT '用户名',
    `password`   VARCHAR(128)                       NOT NULL COMMENT '密码',
    `type`       VARCHAR(16)                        NULL COMMENT '身份',
    `version`    INT      DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at` DATETIME DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_username` (username),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='用户表';