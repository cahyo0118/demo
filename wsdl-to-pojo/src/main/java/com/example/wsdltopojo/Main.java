package com.example.wsdltopojo;

import com.example.wsdltopojo.ws.service.AckDataInvestorServiceImpl;
import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.soap.SOAPBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        String address = "http://localhost:7776/employeeservicetopdown";
        AckDataInvestorServiceImpl implementor = new AckDataInvestorServiceImpl();
//        Endpoint endpoint11 = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING, implementor);
//        endpoint11.publish(address);
        Endpoint endpoint12 = Endpoint.create(SOAPBinding.SOAP12HTTP_BINDING, implementor);
        endpoint12.publish(address);

    }
}