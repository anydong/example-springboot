package com.example.spel.spel;

import com.example.spel.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/5/30
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
@Component
public class SpelTests implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private IndexService indexService;

    private String str;

    @Autowired
    public SpelTests() {
        this.str = RandomStringUtils.randomAlphanumeric(8);
    }

    @Test
    public void string() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        log.info(exp.getValue(String.class));
    }

    @Test
    public void staticMethod() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("T(com.example.spel.IndexService).staticRandomString()");
        log.info(exp.getValue(String.class));
    }

    @Test
    public void propertyObject() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(applicationContext));

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("@indexService.randomString()");
        log.info(exp.getValue(context, String.class));
    }

    @Test
    public void property() {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(applicationContext));
        context.setVariable("str", str);

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("#str");
        log.info(str);
        log.info(exp.getValue(context, String.class));
    }


    @Test
    public void selfInstance() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("selfMethod()");
        log.info(exp.getValue(String.class));
    }


    private String selfMethod() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
