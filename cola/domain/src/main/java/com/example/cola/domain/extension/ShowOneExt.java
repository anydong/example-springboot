package com.example.cola.domain.extension;

import com.alibaba.cola.extension.Extension;
import com.example.cola.domain.extensionpoint.ShowExtPt;

/**
 * @author where
 */
@Extension(bizId = "show", useCase = "one")
public class ShowOneExt implements ShowExtPt {
    @Override
    public void print(String varchar) {
        System.out.print("ShowOne: " + varchar);
    }
}
