package com.example.consumingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.wsd.calculator.GetAddRequest;
import com.demo.spring.wsd.calculator.GetAddResponse;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	CalculatorClient client;

	@Override
	public void run(String... args) throws Exception {

		GetAddRequest req=new GetAddRequest();
		req.setA(34);
		req.setB(89);
		GetAddResponse resp=client.add(req);
		System.out.println(resp.getResult());
	}

}
