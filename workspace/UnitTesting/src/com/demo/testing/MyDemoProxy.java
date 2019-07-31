package com.demo.testing;

public class MyDemoProxy extends Demo {
@Override
public void sayHi() {
	System.out.println("Good Morning ");
	super.sayHi();
	System.out.println(" How are you today?");
}
}
