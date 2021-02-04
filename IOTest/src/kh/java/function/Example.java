package kh.java.function;
import java.util.Scanner;
public class Example {
	public void exam1() {
		Scanner sc = new Scanner(System.in); //키보드 입력받기 위한 준비
		System.out.print("첫번 째 정 수 입력 : ");
		int num1 = sc.nextInt(); //정수 입력
		System.out.print("첫번 째 정 수 입력 : ");
		int num2 = sc.nextInt(); //정수 입력
		System.out.println("=========결과=========");
		System.out.printf("더하기 결과 :  %d\n", num1+num2); //더하기
		System.out.printf("빼기 결과 : %d\n",num1-num2); //빼기
		System.out.printf("곱하기 결과 : %d\n",num1*num2); //곱하기
		System.out.printf("나누기 몫 : %d\n",num1/num2); //나누기 
		System.out.printf("나누기 나머지 : %d\n",num1%num2); //나눈 몫
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in); //키보드 입력받기 위한 준비
		System.out.print("가로 길이 입력 : ");
		double weight = sc.nextDouble(); //실수 입력
		System.out.print("세로 길이 입력 : "); 
		double height = sc.nextDouble(); //실수 입력
		System.out.println("=========결과=========");
		System.out.printf("면적 : %.1f\n",weight*height ); //첫번째 자리 반올림하고 (가로*세로) 실수 출력
		System.out.printf("둘레 : %.1f",2*(weight+height)); //첫번째 자리 반올림하고 2*(가로+세로) 실수 출력
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in); //키보드 입력받기 위한 준비
		System.out.print("영어단어 입력 : ");
		String ch = sc.next(); //띄어쓰기 전까지 문자 입력 받기
		System.out.println("첫번째 문자 : "+ch.charAt(0)); //첫번째 문자만 출력
		System.out.println("두번째 문자 : "+ch.charAt(1)); //두번째 문자만 출력
		System.out.println("세번째 문자 : "+ch.charAt(2)); //세번째 문자만 출력
	}
	public void sample() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);
		System.out.printf("%c의 유니코드 값 : %d\n", ch,(int)ch);
	}
	public void sample3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		double kor = sc.nextDouble();
		System.out.print("수학 점수 입력 : ");
		double math = sc.nextDouble();
		System.out.print("영어 점수 입력 : ");
		double eng = sc.nextDouble();
		System.out.println("=========결과=========");
		System.out.printf("총점 : %d\n",(int)(kor+math+eng));
		System.out.printf("평균 : %d",(int)(kor+math+eng)/3);
	}
}
