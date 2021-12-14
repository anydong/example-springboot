package com.example.cola.extension;

import com.alibaba.cola.extension.Extension;
import com.example.cola.extensionpoint.BuildExtPt;

@Extension(bizId = "build", useCase = "one")
public class BuildOneExt extends BuildExt implements BuildExtPt {
}
