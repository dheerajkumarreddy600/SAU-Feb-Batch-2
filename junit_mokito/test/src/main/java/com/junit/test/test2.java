package com.junit.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

public class test2 {
	static Logger log = Logger.getLogger(test2.class.getName());
	   
	   public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      log.info("Going to create HelloWord Obj");
	      test1 obj = (test1) context.getBean("helloWorld");
	      obj.getMessage();
	      
	      log.info("Exiting the program");
	      
	      ((ClassPathXmlApplicationContext) context).close();
	   }

}
