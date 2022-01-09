package com.example.demo.infrastructure.dataobject;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserTokenDO extends BaseDO {
    private Long userId;
    private String token;
    private LocalDateTime expiredAt;
}
