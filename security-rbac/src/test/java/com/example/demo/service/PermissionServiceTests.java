package com.example.demo.service;

import com.example.demo.entity.permission.PermissionEntity;
import com.example.demo.util.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author Where.LIU
 * @since 2022/5/19
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class PermissionServiceTests {
    private final PermissionService permissionService;

    @Autowired
    public PermissionServiceTests(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Test
    public void getWithChildrenByPermissionId() {
        Long permissionId = 1L;
        Optional<PermissionEntity> entityOptional = permissionService.getWithChildrenByPermissionId(permissionId);
        Assertions.assertTrue(entityOptional.isPresent());
        log.info("{}", JSONUtil.toJSONString(entityOptional.get()));
    }
}
