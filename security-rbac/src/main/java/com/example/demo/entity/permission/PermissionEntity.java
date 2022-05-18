package com.example.demo.entity.permission;

import com.alibaba.cola.domain.Entity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Entity
@Data
public class PermissionEntity implements GrantedAuthority {
    private Long id;
    private Long pid;
    private String oid;
    private String name;
    private String path;
    private String method;
    private Integer version;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private List<PermissionEntity> children;

    @Override
    public String getAuthority() {
        return this.oid;
    }
}
