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

@Component 
public class RestPostRunner implements CommandLineRunner {

	@Value("${empid}") 
	String empno;
	
	@Value("${base.url}")
	String baseUrl;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(empno);
		RestTemplate restTemplate=new RestTemplate();
		
		Emp e=new Emp(300, "Ranjan", "Pune", 80000);
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE);
		headers.add("Accept", MediaType.TEXT_PLAIN_VALUE);
		
		HttpEntity request=new HttpEntity<>(e,headers);
		
		ResponseEntity<String> resp2=restTemplate.exchange(baseUrl+"/save", HttpMethod.POST, request, String.class);
		
		System.out.println(resp2.getBody());
	}

}
