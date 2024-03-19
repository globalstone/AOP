package spring.service.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.aop.Message;

public class MessageTestAppUseSpringAOP01 {

	///Main Method
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/messageservice01.xml");
		
		//==> IoC Container 로 부터 Look Up 한 인스턴스는 ProxyFactoryBean 객체가 생성해
		//==> Message interface 구현한 Dynamic Proxy
		Message message = (Message)context.getBean("message");
		
		message.setMessage("Hello");
		
		System.out.println("\n 리턴 받은 메세지 : "+message.getMessage());
		

	}

}
