package com.example.demo.entity.permission;

import com.alibaba.cola.domain.DomainFactory;
import org.bson.types.ObjectId;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Component
public class PermissionEntityFactory {
    public static CreatePermissionEntity create(String name, String path, String method, @Nullable Long pid) {
        CreatePermissionEntity entity = DomainFactory.create(CreatePermissionEntity.class);
        entity.setPid(null != pid && pid >= 0L ? pid : 0L);
        entity.setOid(ObjectId.get().toHexString());
        entity.setName(name);
        entity.setPath(path);
        entity.setMethod(method);
        return entity;
    }
}
