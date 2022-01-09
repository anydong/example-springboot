package com.example.demo.common.helper;

import com.alibaba.cola.exception.BizException;
import com.example.demo.common.enums.BizExceptionEnums;

/**
 * @author where
 */
public class BizExceptionHelper {
    public static BizException of(BizExceptionEnums bizExceptionEnums) {
        return new BizException(bizExceptionEnums.getErrCode(),
                bizExceptionEnums.getErrMessage());
    }
}
