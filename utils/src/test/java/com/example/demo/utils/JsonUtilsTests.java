package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class JsonUtilsTests {
    @Test
    public void toJSONString() {
        User user = new User();
        user.setUsername("username");
        user.setLocalDateTime(LocalDateTime.now());
        user.setDate(new Date());
        String json = JsonUtils.toJSONString(user);
        log.info(json);
        Assertions.assertNotNull(json);
    }

    @Test
    public void parseObject() {
        String json = "{\"username\":\"username\",\"localDateTime\":1640225398162,\"date\":1640225398162}";
        User user = JsonUtils.parseObject(json, User.class);
        log.info("{}", user);
        Assertions.assertNotNull(user);
    }

    @Test
    public void parseArray() {
        List<User> users = new ArrayList<>();
        users.add(User.builder().username("username").build());
        String json = JsonUtils.toJSONString(users);
        log.info(json);
        List<User> parseResult = JsonUtils.parseArray(json, User.class);
        log.info(parseResult.get(0).getUsername());
        Assertions.assertEquals(1, parseResult.size());
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private Long id;
        private String username;
        private String password;
        private LocalDateTime localDateTime;
        private Date date;
    }
}
