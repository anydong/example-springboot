package com.example.cola.domain.extension;

import com.example.cola.domain.extensionpoint.BuildExtPt;

public abstract class BuildExt implements BuildExtPt {
    @Override
    public void build(String varchar) {
        System.out.print("build: " + varchar);
    }
}
