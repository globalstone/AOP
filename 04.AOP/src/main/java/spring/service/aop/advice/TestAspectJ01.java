package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

@Aspect
public class TestAspectJ01 {
	
	///Constructor
	public TestAspectJ01() {
		System.out.println(":: TestAspectJ01 Default Constructor");
	}
	
	@Pointcut("execution(* *.getMessage(..))")
	public void work() {
		System.out.println("work() pointcut call............");
	}
	
	///Method
	//==> Å¸°Ù°´Ã¼ÀÇ Method ¸¦ È£Ãâ Àü È£ÃâµÇ´Â before() Method ±¸Çö
	@Before("work()") //¶Ç´Â @Before(value = "work()")
	public void before(JoinPoint joinPoint) {	
		System.out.println("[before Log]" +getClass()+".before() start......");
		System.out.println("[before Log] tagetObject" +joinPoint.getTarget().getClass().getName());
		System.out.println("[before Log] tagetObject" +joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length != 0) {
			System.out.println("[before Log] Target Object Call method argument"+joinPoint.getArgs()[0]);
		}
		System.out.println("[before Log]"+getClass()+".before() end.....");
	}


	@AfterReturning(pointcut = "work()",returning = "returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) {
		// TODO Auto-generated method stub
		System.out.println("[after Log]"+getClass()+".afterReturning() start.....");
		System.out.println("[after Log] targetObject " +joinPoint.getTarget().getClass().getName());
		System.out.println("[after Log] Å¸°Ù °´Ã¼ÀÇ È£ÃâµÈ method : "+joinPoint.getSignature().getName());
		System.out.println("[after Log] Å¸°Ù °´Ã¼ÀÇ È£ÃâÈÄ return value : " + returnValue);
		System.out.println("[afetr Log] "+getClass()+".afterReturning() end......");

	}
	
	@Around("work()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("[Around before]" + getClass() + ".invoke() start......");
		System.out.println("[Around before] Å¸°Ù °´Ã¼ " +joinPoint.getTarget().getClass().getName());
		System.out.println("[Around before] tagetObject call Method : " + joinPoint.getSignature().getName());
		if(joinPoint.getArgs().length != 0 ) {
			System.out.println("[Around before] tagetObject method Àü´Þ argument : " + joinPoint.getArgs()[0]);
		}
		
		//==> targetObject Method Call
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] Å¸°Ù °´Ã¼ÀÇ È³ÃâÈÄ return value : " + obj);
		System.out.println("[Around after] " +getClass() +"invoke() end....");
		
		return obj;
	}
	
	//==> Target Object Method È£Ãâ Exception ¹ß»ý :¤Ó afterThrowing() Method ±¸Çö
	@AfterThrowing(pointcut="work()",throwing="throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		
		System.out.println("[exception]" +getClass() + ".afterThrowing() start.....");
		System.out.println("[exception] Å¸°Ù°´Ã¼ " +joinPoint.getTarget().getClass().getName());
		System.out.println("[exception] Å¸°Ù°´Ã¼ÀÇ È£ÃâµÈ method "+joinPoint.getSignature().getName());
		System.out.println("[exception] ¹ß»ý");
		System.out.println("[exception] Exception Message" + throwable.getMessage());
		System.out.println("[exception]" +getClass() + ".afterThrowing() end....");
	}


}
