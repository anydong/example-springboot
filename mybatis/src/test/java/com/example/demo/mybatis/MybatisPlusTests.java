package com.example.demo.mybatis;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.dao.UserDaoImpl;
import com.example.demo.dataobject.UserDO;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MybatisPlusTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void mapper() {
        UserDO userDO = new UserDO();
        userDO.setUsername("username");
        userDO.setPassword("password");
        userMapper.insert(userDO);
        List<UserDO> userDOList = userMapper.selectList(null);
        log.info("{}", userDOList);
    }

    /**
     * 乐观锁只在 updateById 这种场景会生效
     */
    @Test
    public void entityUpdate() {
        UserDO userDO = userDao.getLastOne();
        if (null == userDO) {
            userDO = userDao.createRandomOne();
        }
        userDO.setPassword(RandomStringUtils.random(6));
        userMapper.updateById(userDO);
    }

    /**
     * 纯 UpdateWrapper 更新不会更新乐观锁
     */
    @Test
    public void mapperUpdate() {
        UserDO userDO = userDao.createRandomOne();
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(UserDO::getId, userDO.getId());
        updateWrapper.set(UserDO::getPassword, RandomStringUtils.randomAlphabetic(6));
        userMapper.update(null, updateWrapper);
    }

    @Test
    public void entityAndMapperUpdate() {
        UserDO userDO = userDao.createRandomOne();
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper.eq(UserDO::getId, userDO.getId());
        UserDO updateEntity = new UserDO();
        updateEntity.setPassword(RandomStringUtils.randomAlphabetic(6));
        userMapper.update(updateEntity, updateWrapper);
    }
}
