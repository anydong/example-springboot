package com.example.multidatasource.mapper.master;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.multidatasource.entity.MasterDO;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/5/6
 */
@DS("master")
@Component
public interface MasterMapper extends BaseMapper<MasterDO> {
}
