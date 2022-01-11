package com.example.demo.base.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class JSONUtilsTests {
    @Test
    public void toJSONString() {
        User user = new User();
        user.setUsername("username");
        user.setLocalDateTime(LocalDateTime.now());
        user.setDate(new Date());
        String json = JSONUtils.toJSONString(user);
        log.info(json);
        Assertions.assertNotNull(json);
    }

    @Test
    public void parseObject() {
        String json = "{\"username\":\"username\",\"localDateTime\":\"2022-01-01T18:00:00\",\"date\":1640225398162}";
        User user = JSONUtils.parseObject(json, User.class);
        log.info("{}", user);
        Assertions.assertNotNull(user);
    }

    @Test
    public void parseArray() {
        List<User> users = new ArrayList<>();
        users.add(User.builder().username("username").build());
        String json = JSONUtils.toJSONString(users);
        log.info(json);
        List<User> parseResult = JSONUtils.parseArray(json, User.class);
        assert parseResult != null;
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
