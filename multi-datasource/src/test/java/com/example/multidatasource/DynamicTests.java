package com.example.multidatasource;

import com.example.multidatasource.entity.MasterDO;
import com.example.multidatasource.mapper.master.MasterMapper;
import com.example.multidatasource.mapper.slave.SlaveMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author Where.LIU
 * @since 2022/5/6
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DynamicTests {
    @Autowired
    private MasterMapper masterMapper;
    @Autowired
    private SlaveMapper slaveMapper;

    @Test
    public void load() {
        MasterDO masterDO = new MasterDO();
        masterDO.setCreatedAt(LocalDateTime.now());
        masterDO.setUpdatedAt(LocalDateTime.now());

        masterMapper.insert(masterDO);
    }
}
