package com.example.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.infrastructure.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserMapper extends BaseMapper<UserPO> {
}
