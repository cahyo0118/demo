package com.example;

import com.example.autoconfig.CustomLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CustomLogger logger = context.getBean(CustomLogger.class);
        logger.log("Hello from auto-configured logger!");
    }
}
