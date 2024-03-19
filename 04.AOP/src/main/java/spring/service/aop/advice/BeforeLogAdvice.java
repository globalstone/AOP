package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {
	
	///Method
	//==> 타겟객체의 Method 를 호출 전 호출되는 before() Method 구현
	public void before(Method method, Object[] args, Object target) throws Throwable {
		//			전처리하는 메소드정보		전처리			target
		System.out.println("=====================================");
		System.out.println("[before Log]" +getClass()+".before() start......");
		System.out.println("[before Log] tagetObject call Method" +method);
		if(args.length != 0) {
			System.out.println("[before Log] targetObject method 전달 argument : "+args[0]);
		}
		System.out.println("[before Log]"+getClass()+".before() end.....");
	}

}
