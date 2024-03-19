package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class TestAdvice implements MethodBeforeAdvice, 
									AfterReturningAdvice,
									ThrowsAdvice,
									MethodInterceptor {
	
	///Method
	//==> 타겟객체의 Method 를 호출 전 호출되는 before() Method 구현
	public void before(Method method, Object[] args, Object target) throws Throwable {	
		//			전처리하는 메소드정보		전처리			target
		System.out.println("[before Log]" +getClass()+".before() start......");
		System.out.println("[before Log] tagetObject call Method" +method);
		if(args.length != 0) {
			System.out.println("[before Log] targetObject method 전달 argument : "+args[0]);
		}
		System.out.println("[before Log]"+getClass()+".before() end.....");
	}


	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("[after Log]"+getClass()+".afterReturning() start.....");
		System.out.println("[after Log] targetObject call Method : " +method);
		System.out.println("[after Log] 타겟 객체의 호출후 return value : " + returnValue);
		System.out.println("[afetr Log] "+getClass()+".afterReturning() end......");

	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("[Around before]" + getClass() + ".invoke() start......");
		System.out.println("[Around before] tagetObject call Method : " + invocation.getMethod());
		if(invocation.getArguments().length != 0 ) {
			System.out.println("[Around before] tagetObject method 전달 argument : " + invocation.getArguments()[0]);
		}
		
		//==> targetObject Method Call
		Object obj = invocation.proceed();
		
		System.out.println("[Around after] 타겟 객체의 홰출후 return value : " + obj);
		System.out.println("[Around after] " +getClass() +"invoke() end....");
		
		return obj;
	}
	
	//==> Target Object Method 호출 Exception 발생 :ㅣ afterThrowing() Method 구현
	public void afterThrowing(Throwable throwable) {
		
		System.out.println("[exception]" +getClass() + ".afterThrowing() start.....");
		System.out.println("[exception] Exception 발생");
		System.out.println("[exception] Exception Message" + throwable.getMessage());
		System.out.println("[exception]" +getClass() + ".afterThrowing() end....");
	}


}
