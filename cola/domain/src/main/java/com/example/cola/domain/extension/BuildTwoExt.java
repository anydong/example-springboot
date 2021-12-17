package com.example.cola.domain.extension;

import com.example.cola.domain.extensionpoint.BuildExtPt;
import com.alibaba.cola.extension.Extension;

@Extension(bizId = "build", useCase = "two")
public class BuildTwoExt extends BuildExt implements BuildExtPt {
    @Override
    public void build(String varchar) {
        System.out.print("build two : " + varchar);
    }
}
