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
@TableName(value = "role")
public class RoleDO extends BasicDO {
    private Long pid;
    private String name;
}
