package kh.java.func;

public class Variable {
	public void test1() {
		//정수형 변수 선언
		int num;
		//정수형 변수 num 정수값 10 대입
		// = : 대입연산자 -> 오른쪽의 값을 왼쪽에 대입한다.
		num=10;
		num=100;
		System.out.println(num);
		int num1 = 100; //정수형 변수 num1을 선언하면서 100으로 초기화
		System.out.println(num1);
	}
	public void test2() {
		//논리형변수 선언 후 true 대입
		boolean bool = true;
		//문자형 변수 선언 문자 A 대입
		char ch = 'A';
		//byte형 변수 선언 후 값 대입
		byte bNum =100;
		//short형 변수 선언 후 값 대입
		short sNum = 150;
		//int형 변수 선언 후 값 개입
		int iNum = 1000;
		//long형 변수 선언 후 값 대입
		long lNum = 100000000000l;
		//실수형 변수 선언 후 값 대입
		//float형 변수 선언 후 값 대입
		float fNum =123.12f;
		//double형 변수 선언 후 값 대입
		double dNum = 3.14;
		//문자열 변수 선언 후 값 대입
		String str = "Hello Java";
		//상수형 변수 선언 후 값 대입
		final double PI = 3.14; //고정된 상수 ,대문자로 선언

		System.out.println("논리형 변수의 값 : " + bool);
		System.out.println("문자형 변수의 값 : " + ch);
	}
	public void test3() {
		//byte데이터타입의 표현 범위 : -128 ~127
		byte bNum =10;
		int iNum = bNum;
		System.out.println(iNum);
		
		iNum = 128;	
		bNum =(byte)iNum;
		System.out.println(iNum);
		System.out.println(bNum);
		
		int num1 = 2147483647;
		long num2 = (long)num1 + 1;
		System.out.println(num2);
	}
	public void test4() {
		System.out.println("안녕하세요");
		System.out.println("저는");
		System.out.println("강은현입니다.");
	}
	public void test5() {
		System.out.print("안녕하세요");
		System.out.print("저는");
		System.out.print("강은현입니다.");
	}
	public void test6() {
		//1. 문자열 변수 name 생성 후 본인이름 대입
		String name = "강은현";
		//2. 정수형 변수 age 생성 후 본인 나이 대입
		int age = 25;
		//3. 문자열 변수 addr 생성 후 주소 대입(서울 인천 부산)
		String addr = "인천";
		//4. 최종출력문
		System.out.println("안녕하세요 " + name + "입니다. 제 나이는 "+age+"살이고 주소는 "+addr+"입니다." );
		System.out.printf("안녕하세요 %s입니다. 제 나이는 %d살이고 주소는 %s입니다.",name,age,addr);
		System.out.println();
		System.out.printf("실수값 : %f",3.11554455);
	}
	public void test7() {
		/*
		 * */
		System.out.println("안녕하세요 강은현입니다.");
		System.out.println("제 나이는 20살이고");
		System.out.println("주소는 인천입니다.");
		System.out.println("으아아 \n아아아 \\\\");
		System.out.println("강\t은\t현");
		System.out.println("자바에서 문자열을 표현하기 위해서는 쌍따옴표(\")를 사용합니다");
	}
	public void test8() {
		byte bNum=100;
		long iNum=9999000000000l;
		float fNum = 486.520f;
		double dNum = 5697.890123;
		char ch = 'A';
		String str = "Hello JAVA";
		boolean bool = true;
		System.out.println(bNum);
		System.out.println(iNum);
		System.out.println(fNum);
		System.out.println(dNum);
		System.out.println(ch);
		System.out.println(str);
		System.out.println(bool);
	}
	public void test9() {
		String str = "강은현";
		String str1 = "홍길동";
		int age = 25;
		int age1 = 20;
		char gender = '여';
		char gender1 = '남';
		String area = "인천";
		String area1 = "서울";
		String tel = "01093660469";
		String tel1 = "0100000000";
		String email = "test1@naver.com";
		String email1 = "test2@naver.com";
		System.out.println("이름\t나이\t성별\t지역\t전화번호\t\t이메일\t");
		System.out.println("---------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\t\n",str,age,gender,area,tel,email);
		System.out.println("---------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\t\n",str1,age1,gender1,area1,tel1,email1);
	}
}
