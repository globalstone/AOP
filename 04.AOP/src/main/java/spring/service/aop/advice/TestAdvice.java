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
	//==> Ÿ�ٰ�ü�� Method �� ȣ�� �� ȣ��Ǵ� before() Method ����
	public void before(Method method, Object[] args, Object target) throws Throwable {	
		//			��ó���ϴ� �޼ҵ�����		��ó��			target
		System.out.println("[before Log]" +getClass()+".before() start......");
		System.out.println("[before Log] tagetObject call Method" +method);
		if(args.length != 0) {
			System.out.println("[before Log] targetObject method ���� argument : "+args[0]);
		}
		System.out.println("[before Log]"+getClass()+".before() end.....");
	}


	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("[after Log]"+getClass()+".afterReturning() start.....");
		System.out.println("[after Log] targetObject call Method : " +method);
		System.out.println("[after Log] Ÿ�� ��ü�� ȣ���� return value : " + returnValue);
		System.out.println("[afetr Log] "+getClass()+".afterReturning() end......");

	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("[Around before]" + getClass() + ".invoke() start......");
		System.out.println("[Around before] tagetObject call Method : " + invocation.getMethod());
		if(invocation.getArguments().length != 0 ) {
			System.out.println("[Around before] tagetObject method ���� argument : " + invocation.getArguments()[0]);
		}
		
		//==> targetObject Method Call
		Object obj = invocation.proceed();
		
		System.out.println("[Around after] Ÿ�� ��ü�� ȳ���� return value : " + obj);
		System.out.println("[Around after] " +getClass() +"invoke() end....");
		
		return obj;
	}
	
	//==> Target Object Method ȣ�� Exception �߻� :�� afterThrowing() Method ����
	public void afterThrowing(Throwable throwable) {
		
		System.out.println("[exception]" +getClass() + ".afterThrowing() start.....");
		System.out.println("[exception] Exception �߻�");
		System.out.println("[exception] Exception Message" + throwable.getMessage());
		System.out.println("[exception]" +getClass() + ".afterThrowing() end....");
	}


}
