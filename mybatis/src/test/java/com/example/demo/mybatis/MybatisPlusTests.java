package com.example.demo.mybatis;

import com.example.demo.dataobject.UserDO;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MybatisPlusTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapper() {
        UserDO userDO = new UserDO();
        userDO.setUsername("username");
        userDO.setPassword("password");
        userMapper.insert(userDO);
        List<UserDO> userDOList = userMapper.selectList(null);
        log.info("{}", userDOList);
    }
}
