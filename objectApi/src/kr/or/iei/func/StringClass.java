package kr.or.iei.func;

import java.util.Random;
import java.util.StringTokenizer;

public class StringClass {
	public void test1() {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length());	//저장된 문자열의길이
		sb.append("hi");					//현재 문자열 끝에 매개변수로 전잘된 값 추가
		System.out.println(sb);
		sb.append(" 안녕");
		System.out.println(sb);
		sb.append(" test");
		System.out.println(sb);
		sb.insert(3,"삽입구문 ");
		System.out.println(sb);
		sb.insert(7, " 여기 ");
		System.out.println(sb);
		sb.replace(0, 2, "수정구문");
		System.out.println(sb);
		sb.delete(5, 8);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		StringBuffer joinCode = new StringBuffer();
		Random r = new Random();
		for(int i=0;i<6;i++) {
			joinCode.append(r.nextInt(10));
		}
		System.out.println(joinCode);
	}
	public void test2() {
		//문자열을 분석해서 토큰으로 분리시킴
		String str ="강은현/서울/학생";
		StringTokenizer sT = new StringTokenizer(str,"/");
		
		while(sT.hasMoreTokens()) {
			System.out.println(sT.nextToken());
		}
		
	/*	
		sT.hasMoreTokens();//현재 토큰이 남아있는지 확인 true/false
		//sT.countTokens() == 0
		System.out.println(sT.hasMoreTokens());
		//강은현 서울 학생
		System.out.println(sT.countTokens());//현재토큰의 수
		System.out.println(sT.hasMoreTokens());
		String name = sT.nextToken();		//토큰을 1개 꺼내옴
		System.out.println(name);
		System.out.println(sT.countTokens());
		System.out.println(sT.hasMoreTokens());
		String addr = sT.nextToken();
		System.out.println(addr);
		System.out.println(sT.countTokens());
		System.out.println(sT.nextToken());
		System.out.println(sT.hasMoreTokens());
	*/
	}
	public void exam1() {
		String str = "J a v a P r o g r a m";
		//StringTokenizer를 이용해서 공백을 통해 토큰으로 분리
		StringTokenizer sT = new StringTokenizer(str," ");
		int cnt=sT.countTokens();
		char[] ch = new char[cnt];
		StringBuffer sb =new StringBuffer();
		int i=0;
		/**
		 * 방법1
		 */
		//1. 분리된 토큰을 char[]에 저장
		while(sT.hasMoreTokens()) {
			ch[i] = sT.nextToken().charAt(0);
			i++;
		}
		//2. char[]에 저장된 값을 모두 대문자로 변환하여 문자열로 저장하여 출력
		for(i=0;i<cnt;i++) {
			if(ch[i]>='a'&&ch[i]<='z') {	
				sb.insert(i,(char)(ch[i]-32));
			}else {
				sb.insert(i,ch[i]);	
			}
		}
		System.out.println(sb);
		
		/**
		 * 방법2
		  	for(int i=0;i<ch.length;i++) {
				ch[i] = sT.nextToken().charAt(0);
				if(ch[i]>='a'&&ch[i]<='z') {
					ch[i]-=32;
				}
				sb.append(ch[i]);
			}
			System.out.println(sb);
		 */
		
	}
}
