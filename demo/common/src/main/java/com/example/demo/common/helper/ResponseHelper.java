package com.example.demo.common.helper;

import com.alibaba.cola.dto.Response;
import com.example.demo.common.enums.BizExceptionEnums;

/**
 * @author where
 */
public class ResponseHelper {
    public static Response buildFailure(BizExceptionEnums bizExceptionEnums) {
        return Response.buildFailure(bizExceptionEnums.getErrCode(),
                bizExceptionEnums.getErrMessage());
    }
}
