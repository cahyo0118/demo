package com.example.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CustomLoggerProperties.class)
@ConditionalOnProperty(prefix = "custom.logger", name = "enabled", havingValue = "true", matchIfMissing = true)
public class CustomLoggerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CustomLogger customLogger(CustomLoggerProperties properties) {
        return new CustomLogger(properties.getPrefix());
    }
}
