package springdemo.springdemo1.helloworld.impl;

import springdemo.springdemo1.helloworld.HelloWorld;;

public class SpringHelloWorld implements HelloWorld{
	
	@Override
	public void sayHello() {
		System.out.println("Spring Say Hello!!");
	}
}
