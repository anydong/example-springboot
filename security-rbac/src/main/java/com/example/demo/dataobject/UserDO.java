package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user")
public class UserDO extends BasicDO {
    private String username;
    private String password;
}
