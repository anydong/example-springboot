package com.example.cola.domain.extensionpoint;

import com.alibaba.cola.extension.ExtensionPointI;

/**
 * @author where
 */
public interface ShowExtPt extends ExtensionPointI {
    /**
     * 打印
     *
     * @param varchar 打印内容
     */
    void print(String varchar);
}
