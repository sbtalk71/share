package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hr")
public class HrRestController {

	@Autowired
	RestTemplate rt;

	@GetMapping(path = "/info", produces = "application/json")
	// http://localhost:8081/hr/info?id=xx
	public ResponseEntity<String> getEmpInfo(@RequestParam("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity request = new HttpEntity<>(headers);

		ResponseEntity<String> resp1 = rt.exchange("http://localhost:8081/emp" + "/find/" + id, HttpMethod.GET, request,
				String.class);
		return resp1;
	}
}
