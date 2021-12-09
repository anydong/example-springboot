package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.dataobject.UserDO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserMapper extends BaseMapper<UserDO> {
    /**
     * 根据 ID 查询
     *
     * @param id ID
     * @return nullable
     */
    UserDO find(Long id);
}
