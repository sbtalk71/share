package com.demo.spring.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
@RequestMapping("/emp")
public class EmpRestController {
	
	@Autowired
	EmpRepository repo;
	
	@GetMapping(path="/find/{id}",
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity findEmp(@PathVariable("id")int id) {
		Optional<Emp> o=repo.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.ok(o.get());
		}else {
			return ResponseEntity.status(404).build();
		}
	}
	
	@PostMapping(path="/save",
			produces= {MediaType.TEXT_XML_VALUE},consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveEmp(@RequestBody Emp e){
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Employee exists with id "+e.getEmpId());
		}else {
			repo.save(e);
			return ResponseEntity.ok("Employee saved with id "+e.getEmpId());
		}
		
	}

}
