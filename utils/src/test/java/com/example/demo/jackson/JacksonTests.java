package com.example.demo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class JacksonTests {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Timer {
        private Date date;
        private LocalDate localDate;
        private LocalTime localTime;
        private LocalDateTime localDateTime;
        private ZonedDateTime zonedDateTime;
    }

    /**
     * Date 转 String
     */
    @Test
    public void testDateToString() throws JsonProcessingException {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
        javaTimeModule.addSerializer(Date.class, new DateSerializer(false, dateFormat));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);

        Timer timer = Timer.builder().date(new Date()).build();
        String json = mapper.writeValueAsString(timer);
        log.info("{}", json);
    }

    /**
     * Date 转 10 位 timestamp
     */
    @Test
    public void testDateToEpochSecond() throws JsonProcessingException {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(Date.class, new DateToEpochSecondSerializer());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);

        Timer timer = Timer.builder().date(new Date()).build();
        String json = mapper.writeValueAsString(timer);
        log.info("{}", json);
    }

    /**
     * Date 转 13 位 timestamp
     */
    @Test
    public void testDateToEpochMilli() throws JsonProcessingException {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(Date.class, new DateSerializer(true, null));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);

        Timer timer = Timer.builder().date(new Date()).build();
        String json = mapper.writeValueAsString(timer);
        log.info("{}", json);
    }

    /**
     * LocalDateTime 转 String
     */
    @Test
    public void testLocalDatetimeToString() throws JsonProcessingException {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(javaTimeModule);

        Timer timer = Timer.builder().localDateTime(LocalDateTime.now()).build();
        String json = mapper.writeValueAsString(timer);
        log.info("{}", json);
    }
}
