package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Data
@TableName(value = "role")
public class RoleDO {
    private Long id;
    private Long pid;
    private String name;
    private Integer version;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
