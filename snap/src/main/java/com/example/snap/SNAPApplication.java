package com.example.snap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SNAPApplication {
    public static void main(String[] args) {
        SpringApplication.run(SNAPApplication.class, args);
    }
}
