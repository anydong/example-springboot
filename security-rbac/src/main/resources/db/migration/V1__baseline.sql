CREATE TABLE `user`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT     NOT NULL COMMENT '主键',
    `username`   VARCHAR(64)                        NOT NULL COMMENT '用户名',
    `password`   VARCHAR(128)                       NOT NULL COMMENT '密码',
    `version`    INT      DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at` DATETIME DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_username` (`username`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='用户表';

CREATE TABLE `role`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT            NOT NULL COMMENT '主键',
    `pid`        BIGINT UNSIGNED DEFAULT 0                 NOT NULL COMMENT '父 ID',
    `name`       VARCHAR(64)                               NOT NULL COMMENT '角色名',
    `version`    INT             DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at` DATETIME        DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at` DATETIME        DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` DATETIME        DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='角色表';

CREATE TABLE `permission`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT            NOT NULL COMMENT '主键',
    `pid`        BIGINT UNSIGNED DEFAULT 0                 NOT NULL COMMENT '父 ID',
    `oid`        VARCHAR(32)     DEFAULT ''                NOT NULL COMMENT 'ObjectID',
    `name`       VARCHAR(64)                               NOT NULL COMMENT '权限名',
    `path`       VARCHAR(128)    DEFAULT '/'               NOT NULL COMMENT '请求路径',
    `method`     VARCHAR(32)     DEFAULT 'GET'             NOT NULL COMMENT '请求方法',
    `version`    INT             DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at` DATETIME        DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at` DATETIME        DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` DATETIME        DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='权限表';

CREATE TABLE `user_role`
(
    `id`         BIGINT UNSIGNED AUTO_INCREMENT     NOT NULL COMMENT '主键',
    `user_id`    BIGINT UNSIGNED                    NOT NULL COMMENT '用户 ID',
    `role_id`    BIGINT UNSIGNED                    NOT NULL COMMENT '角色 ID',
    `version`    INT      DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at` DATETIME DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='用户-角色表';

CREATE TABLE `role_permission`
(
    `id`            BIGINT UNSIGNED AUTO_INCREMENT     NOT NULL COMMENT '主键',
    `role_id`       BIGINT UNSIGNED                    NOT NULL COMMENT '角色 ID',
    `permission_id` BIGINT UNSIGNED                    NOT NULL COMMENT '权限 ID',
    `version`       INT      DEFAULT 0                 NOT NULL COMMENT '乐观锁',
    `deleted_at`    DATETIME DEFAULT NULL              NULL COMMENT '删除时间',
    `updated_at`    DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_at`    DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    INDEX `idx_role_id` (`role_id`),
    INDEX `idx_permission_id` (`permission_id`),
    INDEX `idx_created_at` (`created_at`),
    INDEX `idx_updated_at` (`updated_at`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4`
  COLLATE = `utf8mb4_unicode_ci` COMMENT ='角色-权限表';