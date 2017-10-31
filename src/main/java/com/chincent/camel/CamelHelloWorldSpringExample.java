package com.chincent.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelHelloWorldSpringExample {
	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
		CamelContext camelContext = new SpringCamelContext(appContext) ;
		try {
			ProducerTemplate template = camelContext.createProducerTemplate();
			camelContext.start();
			template.sendBody("activemq:test.queue", "Hello World");
		} finally {
			camelContext.stop();
		}
	}
}