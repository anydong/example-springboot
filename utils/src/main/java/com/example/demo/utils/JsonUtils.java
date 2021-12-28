package com.example.demo.utils;

import com.example.demo.jackson.LocalDateTimeFromEpochMilliDeserializer;
import com.example.demo.jackson.LocalDateTimeToEpochMilliSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 仿照 FastJSON 的接口，生成 Jackson 的静态调用方法
 *
 * @author where
 */
public class JsonUtils {
    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeToEpochMilliSerializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeFromEpochMilliDeserializer());

        MAPPER.registerModule(new SimpleModule());
        MAPPER.registerModule(javaTimeModule);
        // https://github.com/FasterXML/jackson-databind/wiki/Serialization-Features#:~:text=Generic%20output%20features-,WRAP_ROOT_VALUE,-(default%3A%20false)
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // https://github.com/FasterXML/jackson-databind/wiki/Serialization-Features#:~:text=WRITE_DATES_AS_TIMESTAMPS
        MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        // https://github.com/FasterXML/jackson-databind/wiki/Serialization-Features#:~:text=WRITE_DATES_AS_TIMESTAMPS
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        // https://github.com/FasterXML/jackson-databind/wiki/Deserialization-Features#:~:text=FAIL_ON_UNKNOWN_PROPERTIES
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(MapperFeature.USE_ANNOTATIONS, true);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static String toJSONString(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("toJSONString error", e);
        }
        return null;
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("parseObject error", e);
        }
        return null;
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        try {
            JavaType type = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            log.error("parseArray error", e);
        }
        return null;
    }
}
