package com.example.cola.extensionpoint;

import com.alibaba.cola.extension.ExtensionPointI;

public interface BuildExtPt extends ExtensionPointI {
    void build(String varchar);
}
