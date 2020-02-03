package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp,Integer>{

	@Query("select o from Emp o where o.city like ?1")
	public List<Emp> getAllWIthCity(String city);
}
