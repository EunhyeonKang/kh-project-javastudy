package kr.or.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		//around는 매개변수를 JoinPoint가 아닌 ProceedingJoinPoint
		//pjp는 JoinPoint를 상속해서 만들어진 객체로 proceed();메소드가 추가로 존재
		String methodName = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		//proceed() 메소드 수행 전이 해당 메소드 수행 전
		stopWatch.start();
		Object obj = pjp.proceed();	//proceed메소드가 해당 메소드를 수행하고 리턴결과를 Object로 반환
		//proceed() 메소드 수행 전이 해당 메소드 수행 이후
		stopWatch.stop();
		System.out.println(methodName+" 메소드 수행 시간 : "+stopWatch.getTotalTimeMillis()+"(ms)초");
		return obj;
		
	}
}
