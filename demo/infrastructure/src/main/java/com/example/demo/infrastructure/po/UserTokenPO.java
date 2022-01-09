package com.example.demo.infrastructure.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserTokenPO extends BasePO {
    private Long userId;
    private String token;
    private LocalDateTime expiredAt;
}
