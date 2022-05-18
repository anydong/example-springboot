package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Data
@TableName("role_permission")
public class RolePermissionDO {
    private Long id;
    private Long roleId;
    private Long permissionId;
    private Integer version;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
