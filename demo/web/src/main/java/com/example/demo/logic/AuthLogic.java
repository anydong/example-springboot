package com.example.demo.logic;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.common.enums.BizExceptionEnums;
import com.example.demo.common.helper.ResponseHelper;
import com.example.demo.convertor.UsernameLoginQryConvertor;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.domain.auth.service.AuthService;
import com.example.demo.domain.auth.service.UsernameLoginService;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.model.request.UsernameLoginCmd;
import com.example.demo.model.response.LoginTokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
public class AuthLogic {
    private final AuthService authService;
    private final UsernameLoginService usernameLoginService;
    private final UsernameLoginQryConvertor usernameLoginQryConvertor;

    @Autowired
    public AuthLogic(AuthService authService,
                     UsernameLoginService usernameLoginService,
                     UsernameLoginQryConvertor usernameLoginQryConvertor) {
        this.authService = authService;
        this.usernameLoginService = usernameLoginService;
        this.usernameLoginQryConvertor = usernameLoginQryConvertor;
    }

    public Response register(UserRegisterCmd cmd) {
        UserDTO userDTO = authService.register(cmd);
        if (null != userDTO) {
            return Response.buildSuccess();
        }
        return ResponseHelper.buildFailure(BizExceptionEnums.USER_REGISTER_FAILURE);
    }

    public SingleResponse<LoginTokenVO> login(UsernameLoginCmd cmd) {
        String token = usernameLoginService.login(usernameLoginQryConvertor.of(cmd));

        return SingleResponse.of(LoginTokenVO.builder().token(token).build());
    }
}
