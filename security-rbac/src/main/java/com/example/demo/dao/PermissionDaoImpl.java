package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.PermissionDO;
import com.example.demo.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class PermissionDaoImpl extends ServiceImpl<PermissionMapper, PermissionDO>
        implements IService<PermissionDO> {
}
