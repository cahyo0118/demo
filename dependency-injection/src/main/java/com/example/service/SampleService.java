package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SampleService {
    private static final Logger log = LoggerFactory.getLogger(SampleService.class);
    Date date = new Date();

    SampleService() {
      log.info("SampleService created");
    }

    void doSomething() {
    }
}
