package com.example.wsdltopojo.ws.service;

import com.example.wsdltopojo.ack.CheckConnection;
import com.example.wsdltopojo.ack.CheckConnectionResponse;
import com.example.wsdltopojo.ack.ReceiveAck;
import com.example.wsdltopojo.ack.ReceiveAckResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "ServiceSoap", serviceName = "Service")
public class AckDataInvestorServiceImpl{

    @WebMethod(operationName = "CheckConnection")
    public CheckConnectionResponse checkConnection(CheckConnection checkConnection) {
        System.out.println("CHECK_CONNECTION ==> " + checkConnection.getMemberCode());
        CheckConnectionResponse response = new CheckConnectionResponse();
        response.setCheckConnectionResult(11);
        return response;
    }

    @WebMethod(operationName = "ReceiveAck")
    public ReceiveAckResponse receiveAck(ReceiveAck receiveAck) {
        ReceiveAckResponse response = new ReceiveAckResponse();
        response.setReceiveAckResult(12);
        return response;
    }
//    @WebMethod(operationName = "CheckConnection")
//    public CheckConnectionResponse checkConnection(@WebParam(name = "memberCode") String memberCode) {
//        CheckConnectionResponse response = new CheckConnectionResponse();
//        response.setCheckConnectionResult(11);
//        return response;
//    }
//
//    @WebMethod(operationName = "CheckConnection")
//    public String checkConnection(@WebParam(name = "memberCode") String memberCode) {
//        return "tayooo";
//    }
}
