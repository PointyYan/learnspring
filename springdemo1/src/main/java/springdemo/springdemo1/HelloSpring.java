package springdemo.springdemo1;

import springdemo.springdemo1.helloworld.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("beans.xml");
         
        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
          
        HelloWorld hw= service.getHelloWorld();
         
        hw.sayHello();
	}
}
