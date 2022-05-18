package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Data
public abstract class BasicDO {
    @TableId(type = IdType.AUTO)
    protected Long id;
    @Version
    protected Integer version;
    @TableLogic
    protected LocalDateTime deletedAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updatedAt;
    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createdAt;
}
