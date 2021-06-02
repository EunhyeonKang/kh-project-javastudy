package kr.or.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.vo.Member;

@Service
@Aspect
public class PasswordEnc {
	@Autowired
	private SHA256Enc enc;
	
	//MemberService에서 메소드명이 Member로 끝나면서 매개변수가 Member타입인 메소드
	@Pointcut("execution(* kr.or.member.model.service.MemberService.*Member(kr.or.member.model.vo.Member))")
	public void encPointcut() {
		
	}
	@Before("encPointcut()")
	public void encPass(JoinPoint jp) throws Exception {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		Member m = (Member)args[0];
		String passwd = m.getMemberPw();
		String encPw = enc.encData(passwd);
		System.out.println("매소드명 : "+methodName);
		System.out.println("암호화 패스워드 : "+encPw);
		m.setMemberPw(encPw);
	}
}
