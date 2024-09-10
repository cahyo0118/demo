package com.example.demo.otel2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.demo"})
public class OtelClient2Application {
    public static void main(String[] args) {
        SpringApplication.run(OtelClient2Application.class, args);
    }
}
