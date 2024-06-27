package com.example.wsdltopojo.ws.service;

import com.example.wsdltopojo.ack.CheckConnection;
import com.example.wsdltopojo.ack.CheckConnectionResponse;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface AckDataInvestorService {

    @WebMethod
    CheckConnectionResponse checkConnection(CheckConnection checkConnection);

}
