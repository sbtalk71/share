package com.demo.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.demo.entity.Emp;

//@Component 
public class RestClientRunner implements CommandLineRunner {

	@Value("${empid}") 
	String empno;
	
	@Value("${base.url}")
	String baseUrl;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(empno);
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<String> resp=restTemplate.getForEntity(baseUrl+"/find/"+empno, String.class);
		System.out.println(resp.getBody());
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		
		HttpEntity request=new HttpEntity<>(headers);
		
		
		ResponseEntity<String> resp1=restTemplate.exchange(baseUrl+"/find/"+empno, HttpMethod.GET, request, String.class);
	
		System.out.println(resp1.getBody());
		
		ResponseEntity<Emp> resp2=restTemplate.exchange(baseUrl+"/find/"+empno, HttpMethod.GET, request, Emp.class);
		
		System.out.println(resp2.getBody().getName());
	}

}
