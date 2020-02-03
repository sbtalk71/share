
package com.example.consumingwebservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.demo.spring.wsd.calculator.GetAddRequest;
import com.demo.spring.wsd.calculator.GetAddResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

	public GetAddResponse add(GetAddRequest req) {

		

		GetAddResponse response = (GetAddResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws", req,
						new SoapActionCallback(
								"http://ws.spring.demo.com/calculator/GetAddRequest"));

		return response;
	}

}
