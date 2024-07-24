package com.example.demo.logclient.utils;

public class Layer1 {
    public void callLayer2() {
        Layer2 layer2 = new Layer2();
        layer2.printSomething();
    }
}
