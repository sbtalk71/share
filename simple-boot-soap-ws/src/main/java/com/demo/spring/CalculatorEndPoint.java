package com.demo.spring;

import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ws.spring.demo.com.calculator.GetAddRequest;
import ws.spring.demo.com.calculator.GetAddResponse;

@Endpoint

public class CalculatorEndPoint {

	@PayloadRoot(namespace ="http://com.demo.spring.ws/calculator/",localPart = "getAddRequest")
	@ResponsePayload
	public GetAddResponse addnums(@RequestPayload GetAddRequest req) {
		int sum = req.getA() + req.getB();
		GetAddResponse result = new GetAddResponse();
		result.setResult(sum);
		return result;
	}
}
