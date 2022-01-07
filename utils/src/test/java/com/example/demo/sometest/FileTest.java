package com.example.demo.sometest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class FileTest {
    @Test
    public void some() throws IOException {
        File file = File.createTempFile("Test-", ".go");
        log.info("filepath: {}", file.getParent());
        log.info("name: {}", file.getName());
    }
}
