package com.example.demo.autoconfig;

public class CustomLogger {
    private final String prefix;

    public CustomLogger(String prefix) {
        this.prefix = prefix;
    }

    public void log(String message) {
        System.out.println(prefix + " " + message);
    }
}
