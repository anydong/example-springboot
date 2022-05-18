package com.example.demo.bson;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class ObjectIdTests {
    @Test
    public void toHexString() {
        log.info("{}", ObjectId.get().toHexString());
        log.info("{}", ObjectId.get().toHexString());
        log.info("{}", ObjectId.get().toHexString());
        log.info("{}", ObjectId.get().toHexString());
    }
}
