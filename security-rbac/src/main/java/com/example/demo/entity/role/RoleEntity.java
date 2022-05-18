package com.example.demo.entity.role;

import com.alibaba.cola.domain.Entity;
import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.entity.permission.PermissionEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Entity
@Data
public class RoleEntity {
    private Long id;
    private Long pid;
    private String name;
    private Integer version;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    private List<RoleEntity> children;
    private List<PermissionEntity> permissions;
}
