package com.example.cola.extensionpoint;

import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BuildExtPtTests {
    @Autowired
    private ExtensionExecutor extensionExecutor;

    @Test
    public void build() {
        extensionExecutor.executeVoid(BuildExtPt.class, BizScenario.valueOf("build", "one"), extensionExecutor -> extensionExecutor.build("build"));
        extensionExecutor.executeVoid(BuildExtPt.class, BizScenario.valueOf("build", "two"), extensionExecutor -> extensionExecutor.build("build"));
    }
}
