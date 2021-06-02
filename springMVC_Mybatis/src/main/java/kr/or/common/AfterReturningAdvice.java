package kr.or.common;

import org.aspectj.lang.JoinPoint;

import kr.or.member.model.vo.Member;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		if(returnObj instanceof Member) { // returnObj의 데이터 타입이 Member인 경우 true
			Member m = (Member)returnObj;
			System.out.println("[사후처리] "+methodName+" / 이름 : "+m.getMemberName()+"처리완료");
		}
	}
}
