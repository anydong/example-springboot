package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Data
@TableName("user_role")
public class UserRoleDO {
    private Long id;
    private Long userId;
    private Long roleId;
    private Integer version;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
