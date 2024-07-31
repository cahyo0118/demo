package com.example.demo.jtpmmock;

import com.example.demo.jtpmmock.controller.soap.ReceiveAckController;
import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.soap.SOAPBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.demo"})
public class JtpmMockApplication {
    public static void main(String[] args) {
        SpringApplication.run(JtpmMockApplication.class, args);

        String address = "http://0.0.0.0:7776/OSB_AKSES/ProxyService/ProxyServiceOSB2";

        ReceiveAckController implementor = new ReceiveAckController();
//        Endpoint endpoint11 = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING, implementor);
//        endpoint11.publish(address);
        Endpoint endpoint12 = Endpoint.create(SOAPBinding.SOAP12HTTP_BINDING, implementor);
        endpoint12.publish(address);

    }
}
