package kh.java.func;

public class Func {
	public void func1() {
		System.out.println(1+1);
		System.out.println(1.0+1.0);
		System.out.println('1'+'1');
		System.out.println('2'+'2');
		System.out.println("1"+"1"+"3");
	}
	public void func2() {
		//게산결과 : 2.1
		//정수 + 실수 => 실수
		System.out.println(1+1.1);
		//정수 + 실수 -> 실수+실수 -> 실수
		//1.0 + 1.1 = 2.1
		System.out.println(1+'1');
		//정수 + 문자 -> 정수 + 정수 -> 정수
		System.out.println(1.0+'1');
		//실수 + 문자 -> 실수 + 정수 -> 실수 + 실수 => 실수
		System.out.println("1"+20);
		//문자열과 더하기 연산을 하는 경우는 모두 문자열로 변환하여 더함
		//문자열 + 정수 -> 문자열 + 문자열 => 문자열
		System.out.println("1"+1.0);
		System.out.println("1"+'a');
		System.out.println("1"+1+1);
		//문자열 + 정수 + 정수 
		//문자열 + 정수 -> 문자열 + 문자열 => 문자열 "11"
		//"11" + 1 -> 문자열 + 정수 -> 문자열 + 문자열 => 문자열 "111"
	}
}
