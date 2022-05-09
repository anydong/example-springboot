package com.example.flowable;

import com.zaxxer.hikari.HikariDataSource;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.spring.boot.ProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;

import javax.sql.DataSource;

/**
 * @author Where.LIU
 */
@Primary
@Configuration
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
@AutoConfigureAfter(ProcessEngineAutoConfiguration.class)
public class CustomEngineConfiguration {
    @Primary
    @Bean
    @ConfigurationProperties("flowable.datasource")
    public DataSourceProperties flowableDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public HikariDataSource flowableDataSource(@Qualifier("flowableDataSourceProperties") DataSourceProperties flowableDataSourceProperties) {
        return flowableDataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> engineConfigurationConfigurer(@Qualifier("flowableDataSource") DataSource dataSource) {
        return engineConfiguration -> engineConfiguration.setDataSource(dataSource);
    }
}