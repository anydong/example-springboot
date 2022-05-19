package com.example.demo.entity.permission;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class PermissionEntityFactoryTests {
    @Test
    public void create() {
        String name = "test";
        String path = "/auth/login";
        String method = RequestMethod.GET.name();
        CreatePermissionEntity entity = PermissionEntityFactory.create(name, path, method, null);
        entity.save();
        Assertions.assertNotNull(entity.getId());
        log.info("{}", entity);
    }

    @Test
    public void createChildren() {
        String name = "test-children";
        String path = "/auth/logout";
        String method = RequestMethod.GET.name();
        CreatePermissionEntity entity = PermissionEntityFactory.create(name, path, method, 2L);
        entity.save();
        Assertions.assertNotNull(entity.getId());
        log.info("{}", entity);
    }
}
