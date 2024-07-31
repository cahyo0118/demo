package com.example.demo.aop.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoService {
    public void setSomethingUsingService() {
        log.info("EXECUTE setSomethingUsingService()");
    }
}
