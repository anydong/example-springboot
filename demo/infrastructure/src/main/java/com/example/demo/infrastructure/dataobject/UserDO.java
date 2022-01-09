package com.example.demo.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user")
public class UserDO extends BaseDO {
    private String username;
    private String password;
}
