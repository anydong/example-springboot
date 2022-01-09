package com.example.demo.domain.auth.service;

import com.example.demo.base.utils.NumberUtils;
import com.example.demo.common.enums.BizExceptionEnums;
import com.example.demo.common.exception.BizException;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.dto.UserTokenDTO;
import com.example.demo.domain.gateway.UserTokenGatewayI;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author where
 */
@Slf4j
@Service
public class UserTokenService {
    private final UserTokenGatewayI userTokenGatewayI;

    @Autowired
    public UserTokenService(UserTokenGatewayI userTokenGatewayI) {
        this.userTokenGatewayI = userTokenGatewayI;
    }

    @NonNull
    public UserTokenDTO createToken(@NonNull UserDTO userDTO) {
        String token = RandomStringUtils.randomAlphanumeric(16);
        UserTokenDTO userTokenDTO = new UserTokenDTO();
        userTokenDTO.setUserId(userDTO.getId());
        userTokenDTO.setToken(token);
        userTokenDTO.setExpiredAt(LocalDateTime.now().plus(1, ChronoUnit.MONTHS));
        userTokenGatewayI.createToken(userTokenDTO);
        if (NumberUtils.isPositive(userTokenDTO.getId())) {
            return userTokenDTO;
        }
        log.error("user token create failure {}", userTokenDTO);
        throw new BizException(BizExceptionEnums.SYSTEM_EXECUTE_ERROR);
    }
}
