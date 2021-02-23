package kh.java.MethodTest;

import java.util.Scanner;

//개발자1
public class ClacMain {
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 숫자 입력 : ");
		int num3 = sc.nextInt();
		CalcFunc  cft = new CalcFunc();
		int result = cft.sum(num1, num2, num3);
		System.out.println(result);
		
	}
}
