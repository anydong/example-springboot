package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.enums.UserTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private UserTypeEnum type;
    @Version
    private Integer version;
    @TableLogic
    private LocalDateTime deletedAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
}
