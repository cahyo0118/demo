package com.example.demo.jtpmmock.controller.soap;

import com.example.demo.jtpmmock.wsdl.CheckConnection;
import com.example.demo.jtpmmock.wsdl.CheckConnectionResponse;
import com.example.demo.jtpmmock.wsdl.ReceiveAck;
import com.example.demo.jtpmmock.wsdl.ReceiveAckResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(name = "ServiceSoap", serviceName = "Service", targetNamespace = "http://tempuri.org/")
public class ReceiveAckController {

    @WebMethod(operationName = "CheckConnection")
    public CheckConnectionResponse checkConnection(CheckConnection checkConnection) {
        System.out.println("CHECK_CONNECTION ==> " + checkConnection);
//        System.out.println("CHECK_CONNECTION ==> " + checkConnection.getMemberCode());
        CheckConnectionResponse response = new CheckConnectionResponse();
        response.setCheckConnectionResult(11);
        return response;
    }

    @WebMethod(operationName = "ReceiveAck")
    public ReceiveAckResponse receiveAck(ReceiveAck receiveAck) {
        System.out.println("RECEIVE_ACK ==> " + receiveAck);
//        System.out.println("RECEIVE_ACK ==> " + receiveAck.getMemberCode());
        ReceiveAckResponse response = new ReceiveAckResponse();
        response.setReceiveAckResult(1);
        return response;
    }

}
