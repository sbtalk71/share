package com.demo.testing.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.demo.testing.HappyTesting;

@RunWith(JUnit4ClassRunner.class)
public class AppTest {

	HappyTesting happy;

	@Before
	public void setUp() {
		HappyTesting happy = new HappyTesting();
		this.happy = happy;
	}

	@Test
	public void testHappy() {
		assertEquals("happy", happy.beHappy());
	}
}
