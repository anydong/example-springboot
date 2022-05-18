package com.example.demo.entity.role;

import com.alibaba.cola.domain.DomainFactory;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Component
public class RoleEntityFactory {
    public static CreateRoleEntity create(String name, Long pid) {
        CreateRoleEntity entity = DomainFactory.create(CreateRoleEntity.class);
        entity.setName(name);
        entity.setPid(null != pid && pid >= 0L ? pid : 0L);
        return entity;
    }
}
