package com.bridgeit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
		HelloWorld world = (HelloWorld) context.getBean("helloBean");
		world.printHello();
	}

}
