package com.example.demo.keypairvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.example.demo"})
public class KeyPairValidator {
    public static void main(String[] args) {
        SpringApplication.run(KeyPairValidator.class, args);
    }
}
