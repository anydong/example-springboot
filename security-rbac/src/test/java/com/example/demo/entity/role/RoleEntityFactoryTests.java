package com.example.demo.entity.role;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RoleEntityFactoryTests {
    @Test
    public void create() {
        String name = "管理员";
        CreateRoleEntity entity = RoleEntityFactory.create(name, null);
        entity.save();
        Assertions.assertNotNull(entity.getId());
    }

    @Test
    public void createChildren() {
        String name = "子管理员";
        Long pid = 1L;
        CreateRoleEntity entity = RoleEntityFactory.create(name, pid);
        entity.save();
        Assertions.assertNotNull(entity.getId());
    }
}
