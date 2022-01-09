package com.example.demo.logic;

import com.alibaba.cola.dto.Response;
import com.example.demo.common.enums.BizExceptionEnums;
import com.example.demo.common.helper.ResponseHelper;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.domain.auth.service.AuthService;
import com.example.demo.domain.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
public class AuthLogic {
    public AuthService authService;

    @Autowired
    public AuthLogic(AuthService authService) {
        this.authService = authService;
    }

    public Response register(UserRegisterCmd cmd) {
        UserDTO userDTO = authService.register(cmd);
        if (null != userDTO) {
            return Response.buildSuccess();
        }
        return ResponseHelper.buildFailure(BizExceptionEnums.USER_REGISTER_FAILURE);
    }
}
