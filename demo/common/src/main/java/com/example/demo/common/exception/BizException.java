package com.example.demo.common.exception;

import com.example.demo.common.enums.BizExceptionEnums;

/**
 * @author where
 */
public class BizException extends com.alibaba.cola.exception.BizException {
    public BizException(BizExceptionEnums bizExceptionEnums) {
        super(bizExceptionEnums.getErrCode(), bizExceptionEnums.getErrMessage());
    }
}
