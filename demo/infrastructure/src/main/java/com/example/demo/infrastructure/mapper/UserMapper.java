package com.example.demo.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.infrastructure.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserMapper extends BaseMapper<UserPO> {
}
