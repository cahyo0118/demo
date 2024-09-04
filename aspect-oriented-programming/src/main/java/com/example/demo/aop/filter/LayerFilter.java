package com.example.demo.aop.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;

import java.util.HashMap;

@Component
@Aspect
public class LayerFilter {

    private static final Logger log = LoggerFactory.getLogger(LayerFilter.class);

    @Before("execution(* com.example.demo.aop.filter..*(..))")
    public void doBeforeAOP(JoinPoint joinPoint) {
        log.warn("[AOP][BEFORE][SAME_MODULE][AOP][KIND] {}", joinPoint.getKind());
        log.warn("[AOP][BEFORE][SAME_MODULE][AOP][toShortString] {}", joinPoint.toShortString());
        log.warn("[AOP][BEFORE][SAME_MODULE][AOP][args] {}", joinPoint.getArgs());
    }

    @Before("execution(* com.example.demo.aop.controller..*(..))")
    public void doBeforeController(JoinPoint joinPoint) {
        log.warn("[AOP][BEFORE][SAME_MODULE][CONTROLLER][KIND] {}", joinPoint.getKind());
        log.warn("[AOP][BEFORE][SAME_MODULE][CONTROLLER][toShortString] {}", joinPoint.toShortString());
        log.warn("[AOP][BEFORE][SAME_MODULE][CONTROLLER][args] {}", joinPoint.getArgs());
    }

    @Around("execution(* com.example.demo.aop.controller..*(..))")
    public Object doAroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        log.warn("[AOP][AROUND][SAME_MODULE][CONTROLLER][KIND] {}", joinPoint.getKind());
        log.warn("[AOP][AROUND][SAME_MODULE][CONTROLLER][toShortString] {}", joinPoint.toShortString());
        log.warn("[AOP][AROUND][SAME_MODULE][CONTROLLER][args] {}", joinPoint.getArgs());
        Object result = ResponseEntity.ok(new HashMap<>() {{
            put("message", "AOP SENT THEIR REGARDS");
            put("body", "THIS IS BODY");
        }});
        log.warn("[AOP][AROUND][SAME_MODULE][CONTROLLER][joinPoint.proceed()] {}", result);
        joinPoint.proceed();
        return result;
    }

    @After("execution(* com.example.demo.aop.controller..*(..))")
    public void doAfterController(JoinPoint joinPoint) {
        log.warn("[AOP][AFTER][SAME_MODULE][CONTROLLER][KIND] {}", joinPoint.getKind());
        log.warn("[AOP][AFTER][SAME_MODULE][CONTROLLER][toShortString] {}", joinPoint.toShortString());
        log.warn("[AOP][AFTER][SAME_MODULE][CONTROLLER][args] {}", joinPoint.getArgs());
    }

    @Before("execution(* com.example.demo.aop.utils..*(..))")
    public void doBeforeUtils(JoinPoint joinPoint) {
        log.warn("[AOP][SAME_MODULE][UTILS][KIND] {}", joinPoint.getKind());
        log.warn("[AOP][SAME_MODULE][UTILS][toShortString] {}", joinPoint.toShortString());
    }

    @Before("execution(* com.example.demo.logclient.utils..*(..))")
    public void doBefore(JoinPoint joinPoint) {
        log.warn("[AOP][OTHER_MODULE][UTILS][KIND] {}", joinPoint.getKind());
        log.warn("[AOP][OTHER_MODULE][UTILS][toShortString] {}", joinPoint.toShortString());
    }

}
