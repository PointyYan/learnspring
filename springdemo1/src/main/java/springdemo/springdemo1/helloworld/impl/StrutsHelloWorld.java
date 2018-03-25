package springdemo.springdemo1.helloworld.impl;

import springdemo.springdemo1.helloworld.HelloWorld;

public class StrutsHelloWorld implements HelloWorld{

	@Override
	public void sayHello() {
		System.out.println("Struts Say Hello!");
		
	}
	
}
