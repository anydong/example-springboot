package com.example.demo.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user")
public class UserPO extends BasePO {
    private String username;
    private String password;
}
