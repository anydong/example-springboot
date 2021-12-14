package com.example.cola.extension;

import com.alibaba.cola.extension.Extension;
import com.example.cola.extensionpoint.BuildExtPt;

@Extension(bizId = "build", useCase = "two")
public class BuildTwoExt extends BuildExt implements BuildExtPt {
    @Override
    public void build(String varchar) {
        System.out.print("build two : " + varchar);
    }
}
