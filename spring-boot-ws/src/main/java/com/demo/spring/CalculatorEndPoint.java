package com.demo.spring;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.demo.spring.ws.calculator.GetAddRequest;
import com.demo.spring.ws.calculator.GetAddResponse;

@Endpoint
public class CalculatorEndPoint {

	@PayloadRoot(namespace = "http://ws.spring.demo.com/calculator",localPart = "getAddRequest")
	@ResponsePayload
	public GetAddResponse add(@RequestPayload GetAddRequest request) {
		int sum = request.getA() + request.getB();
		GetAddResponse resp = new GetAddResponse();
		resp.setResult(sum);
		return resp;
	}
}
