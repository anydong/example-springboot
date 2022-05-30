package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 对标 fastjson 添加 jackson 静态工具类
 * <p>
 * ！！！已知问题！！！<br>
 * 1. 因为 jackson 对属性名大小写的处理方法和 fastjson 不同，所以部分场景下同一个对象序列化出来的结果会不一致 <br>
 * fastjson 对于连续大些字母只把第一个大些字母转为小写字母作为属性名 <br>
 * jackson 则把大写字母开始的连续字母全部转为小写字母 <br>
 * 解决办法是手动在属性名上添加 @JsonProperty(value = "xXXX") 指定序列化名称 <br>
 * </p>
 *
 * @author Where.LIU
 * @since 2022/5/18
 */
@Slf4j
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel", "unused"})
public class JSONUtil {
    public static final JsonMapper MAPPER;

    static {
        // 通过测试的配置
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        // 2022-01-07
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
        // 15:13:55.604
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ISO_LOCAL_TIME));
        // 2022-01-07T15:13:55.604
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));

        MAPPER = JsonMapper.builder()
                // 属性按字母表排序输出
                .enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
                // Date 序列化为 13 位数字，这个是默认设置为了强调而添加
                .enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                // 忽略反序列化中出现的未知属性
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .addModule(javaTimeModule)
                .build();
    }

    /**
     * 将对象转为 JSON 字符串
     *
     * @param object 待转化的对象
     * @return 字符串
     */
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    @Nullable
    public static String toJSONString(@Nullable Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("toJSONString error", e);
        }
        return null;
    }

    /**
     * 将对象转为 JSON 字符串
     *
     * @param object       待转化的对象
     * @param prettyFormat 带空格格式化输出
     * @return 字符串
     */
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    @Nullable
    public static String toJSONString(@Nullable Object object, boolean prettyFormat) {
        try {
            return prettyFormat ? MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object) : MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("toJSONString error", e);
        }
        return null;
    }

    /**
     * 将 JSON 字符串解析为指定对象
     *
     * @param json  JSON 字符串
     * @param clazz 目标类
     * @param <T>   目标类
     * @return 结果
     */
    @Nullable
    public static <T> T parseObject(String json, Class<T> clazz) {
        if (null == json || 0 == json.trim().length()) {
            return null;
        }
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("parseObject error", e);
        }
        return null;
    }

    /**
     * 将 JSON 字符串转为数组结果对象
     *
     * @param json  JSON 字符串
     * @param clazz 目标类
     * @param <T>   目标类
     * @return 结果
     */
    @Nullable
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        if (null == json || 0 == json.trim().length()) {
            return null;
        }
        try {
            JavaType type = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            log.error("parseArray error", e);
        }
        return null;
    }
}