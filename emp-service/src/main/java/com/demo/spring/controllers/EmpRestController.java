package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpRoot;
import com.demo.spring.MyResponse;
import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repo.EmpRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("emp")
@Api
public class EmpRestController {

	@Autowired
	EmpRepository repo;

	@GetMapping(path = "/find/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity findEmp(@PathVariable("id") int id) {
		System.out.println(repo.getClass().getName());
		Optional<Emp> op = repo.findById(id);
		if (op.isPresent()) {
			Emp e = op.get();
			return ResponseEntity.ok(e);
		} else {
			//MyResponse resp = new MyResponse();
			//resp.setStatus("Emp Not Found");
			// return ResponseEntity.ok("{\"status\":\"No Emp Found\"}");
			//return ResponseEntity.status(404).build();
			throw new EmpNotFoundException("Emp Hai mila");
		}

	}
	
	@GetMapping(path = "/list", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<EmpRoot> getAllEmps(){
		List<Emp> emps=repo.findAll();
		EmpRoot emp=new EmpRoot();
		emp.setEmps(emps);
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping(path="/save",produces = {MediaType.TEXT_PLAIN_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> saveEmp(@RequestBody Emp e){
		
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Employee exists");
		}else {
			repo.save(e);
			return ResponseEntity.ok("Employee Saved");
		}
	}
	
	
	@PutMapping(path="/update",produces = MediaType.TEXT_PLAIN_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmp(@RequestBody Emp e){
		
	
			repo.save(e);
			return ResponseEntity.ok("Employee updated");
	
	}
	@DeleteMapping(path="/delete",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteEmp(@RequestParam("id")int id){
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("Emp Deleted..");
		}else {
			return ResponseEntity.ok("Emp Does not exist..");
		}
	}
	
	@ExceptionHandler(value=EmpNotFoundException.class)
	public ResponseEntity<String> handleEmpNotFound(RuntimeException e){
		return ResponseEntity.ok(e.getMessage());
	}
}
