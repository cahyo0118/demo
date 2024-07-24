package com.example.demo.aop.filter;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.*;

@Component
@Aspect
public class LayerFilter {

    private static final Logger log = LoggerFactory.getLogger(LayerFilter.class);

//    @Pointcut("within(com.example.demo.aop.controller..*Controller)")
//    public void controllerPointCut() {
//    }

    @Before("execution(* com.example.demo.aop.controller..*(..))")
    public void doBeforeController(JoinPoint joinPoint) {
//        log.info("SOMETHING FROM CONTROLLER AOP, {}", joinPoint.getArgs());
        log.info("SOMETHING FROM CONTROLLER AOP, kind, {}", joinPoint.getKind());
        log.info("SOMETHING FROM CONTROLLER AOP, toShortString, {}", joinPoint.toShortString());
    }

    @Before("execution(* com.example.demo.aop.utils..*(..))")
    public void doBeforeUtils(JoinPoint joinPoint) {
        log.info("SOMETHING FROM LOCAL UTILS AOP, kind, {}", joinPoint.getKind());
        log.info("SOMETHING FROM LOCAL UTILS AOP, toShortString, {}", joinPoint.toShortString());
    }

    @Before("execution(* com.example.demo.logclient.utils..*(..))")
    public void doBefore(JoinPoint joinPoint) {
        log.info("LOG CLIENT - SOMETHING FROM LOCAL UTILS AOP, kind, {}", joinPoint.getKind());
        log.info("LOG CLIENT - SOMETHING FROM LOCAL UTILS AOP, toShortString, {}", joinPoint.toShortString());
    }

}
