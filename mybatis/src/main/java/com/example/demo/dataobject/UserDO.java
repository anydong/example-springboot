package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    @Version
    private Integer version;
    @TableLogic
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
