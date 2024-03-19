package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {
	
	///Method
	//==> Ÿ�ٰ�ü�� Method �� ȣ�� �� ȣ��Ǵ� before() Method ����
	public void before(Method method, Object[] args, Object target) throws Throwable {
		//			��ó���ϴ� �޼ҵ�����		��ó��			target
		System.out.println("=====================================");
		System.out.println("[before Log]" +getClass()+".before() start......");
		System.out.println("[before Log] tagetObject call Method" +method);
		if(args.length != 0) {
			System.out.println("[before Log] targetObject method ���� argument : "+args[0]);
		}
		System.out.println("[before Log]"+getClass()+".before() end.....");
	}

}
