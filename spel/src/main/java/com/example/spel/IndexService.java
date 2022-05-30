package com.example.spel;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Where.LIU
 * @since 2022/5/30
 */
@Service
public class IndexService {
    public String randomString() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    public static String staticRandomString() {
        return RandomStringUtils.randomAlphanumeric(8);
    }
}
