package com.example.cola.extensionpoint;

import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ShowExtPtTests {
    @Autowired
    private ExtensionExecutor extensionExecutor;

    @Test
    public void print() {
        BizScenario bizScenario = BizScenario.newDefault();

        extensionExecutor.executeVoid(ShowExtPt.class, bizScenario, extensionExecutor -> extensionExecutor.print("bbb"));
    }
}
