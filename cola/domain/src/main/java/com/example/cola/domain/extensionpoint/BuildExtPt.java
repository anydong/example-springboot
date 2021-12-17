package com.example.cola.domain.extensionpoint;

import com.alibaba.cola.extension.ExtensionPointI;

public interface BuildExtPt extends ExtensionPointI {
    void build(String varchar);
}
