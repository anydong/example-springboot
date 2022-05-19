package com.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.PermissionDO;
import com.example.demo.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class PermissionDaoImpl extends ServiceImpl<PermissionMapper, PermissionDO>
        implements IService<PermissionDO> {

    /**
     * 根据 pid 获取子权限列表
     *
     * @param pid 父 ID
     * @return 子权限列表
     */
    public List<PermissionDO> listByPid(Long pid) {
        LambdaQueryWrapper<PermissionDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(PermissionDO::getPid, pid);
        return list(queryWrapper);
    }
}
