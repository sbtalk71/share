package com.demo.spring.app2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestEmpApp {

	@Autowired
	EmpApp empApp;

	@Test
	public void testSave() {
		empApp.regsiterEmp();
		assertTrue("Test Passed", true);
	}
}
