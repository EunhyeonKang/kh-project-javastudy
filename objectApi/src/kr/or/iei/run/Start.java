package kr.or.iei.run;

import kr.or.iei.func.ApiClass;

public class Start {

	public static void main(String[] args) throws CloneNotSupportedException {
//		String str = "test";
//		TestClass tc1 = new TestClass();
//		TestClass tc2 = new TestClass();
//		System.out.println(tc1);	//객체(인스턴스)이름을 출력하는 경우 자동으로 toString메소드 호출
//		System.out.println(tc1.toString());
//		System.out.println(str);	
//		System.out.println(tc1.hashCode());
//		System.out.println(tc2.hashCode());
//		int[] arr1 = {1,2,3,4,5};
//		int[] arr2 = arr1.clone();
//		tc2 = (TestClass)tc1.clone();
		//다형성 -> 부모타입변수에 자식타입객체가 저장되는것
		//StringClass sc = new StringClass();
		//sc.test1();
		//sc.test2();
		//sc.exam1();
		ApiClass ac = new ApiClass();
		//ac.math();
		//ac.calendar();
		//ac.date();
		//ac.exam2();
		ac.wrapper();
	}

}
