package kh.java.control;
import java.util.Scanner;
public class SwitchTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3 사이에 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			System.out.println("1입력");
			break;
		case 2:
			System.out.println("2입력");
			break;
		case 3:
			System.out.println("3입력");
			break;
		default :
			System.out.println("1~3 숫자가 아닙니다.");
			break;
		}
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("장학금 지불 시스템입니다");
		System.out.print("학점을 입력하세요(A,B,C,D,F) : ");
		char str = sc.next().charAt(0);
		switch(str) {
		case 'A':
			System.out.println("수고하셨습니다. 장학금을 100%지급해드리겠습니다.");
			break;
		case 'B':
			System.out.println("아쉽군요. 장학금을 50%지급해드리겠습니다.");
			break;
		case 'C':
			System.out.println("장학금을 바라시면 좀더 열심히 해주세요.");
			break;
		case 'D':
			System.out.println("크흠.......");
			break;
		case 'F':
			System.out.println("학사경고입니다!!!!");
			break;
		}
			
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("일수를 알고싶은 달을 입력하세요 : ");
		int month = sc.nextInt();
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
				System.out.printf("%d월달은 31일까지 있습니다.",month);
				break;
		case 4:
		case 6:
		case 9:
		case 11:
				System.out.printf("%d월달은 30일까지 있습니다.",month);
				break;
		case 2:
				System.out.printf("%d월달은 28일까지 있습니다.",month);
				break;
		}			
	}
}
