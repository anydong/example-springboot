package com.example.cola.extension;

import com.example.cola.extensionpoint.BuildExtPt;

public abstract class BuildExt implements BuildExtPt {
    @Override
    public void build(String varchar) {
        System.out.print("build: " + varchar);
    }
}
