package kr.or.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	//포인트컷 만들기
	@Pointcut("execution(* kr.or.member.model.service..*Service.*(*,..))")
	public void allPointcut() {
		
	}
	@Before("allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); //호출된 비지니스 메소드 이름 가져옴
		Object[] args = jp.getArgs();
		System.out.println("[사전처리]"+methodName+" : / 매개변수 정보 : "+args[0].toString());
	}
	
}
