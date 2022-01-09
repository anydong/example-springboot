package com.example.demo.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.infrastructure.po.UserTokenPO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserTokenMapper extends BaseMapper<UserTokenPO> {
}
