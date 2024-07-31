package com.example.demo.aop.controller;


public class LocalLayer1 {

    public String callLayer2(String randomString) {
        LocalLayer2 layer2 = new LocalLayer2();
        layer2.printSomething();
        return randomString + "Suffix";
    }

}
