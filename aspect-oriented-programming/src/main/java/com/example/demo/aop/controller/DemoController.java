package com.example.demo.aop.controller;

import com.example.demo.aop.utils.DemoService;
import com.example.demo.logclient.utils.Layer1;
import com.example.demo.logclient.utils.LogClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {

    //    DemoService demoService = new DemoService();
    @Autowired
    DemoService demoService;

    @Autowired
    LogClientService logClientService;

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getSomething(@RequestParam("aaa") String aaaText) {
        Layer1 layer1 = new Layer1();
        layer1.callLayer2();

        LocalLayer1 localLayer1 = new LocalLayer1();
        localLayer1.callLayer2("aaaaa");

        demoService.setSomethingUsingService();
        logClientService.setSomethingUsingService();

        return ResponseEntity.ok(new HashMap<>() {{
            put("controllerBody", "CONTROLLER SENT THEIR REGARDS");
        }});
    }

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> postSomething(@RequestBody HashMap<String, Object> body) {
        Layer1 layer1 = new Layer1();
        layer1.callLayer2();

        LocalLayer1 localLayer1 = new LocalLayer1();
        localLayer1.callLayer2("aaaaa");

        demoService.setSomethingUsingService();
        logClientService.setSomethingUsingService();

        return ResponseEntity.ok(new HashMap<>());
    }
}
