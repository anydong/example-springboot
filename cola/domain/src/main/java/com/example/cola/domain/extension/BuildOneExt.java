package com.example.cola.domain.extension;

import com.example.cola.domain.extensionpoint.BuildExtPt;
import com.alibaba.cola.extension.Extension;

@Extension(bizId = "build", useCase = "one")
public class BuildOneExt extends BuildExt implements BuildExtPt {
}
