package com.example.demo.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "permission")
public class PermissionDO extends BasicDO {
    private Long pid;
    private String oid;
    private String name;
    private String path;
    private String method;
}
