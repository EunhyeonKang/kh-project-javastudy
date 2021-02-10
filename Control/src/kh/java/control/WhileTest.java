package kh.java.control;
import java.util.Scanner;
public class WhileTest {
	public void test1() {
		int i=0;
		while(i<5) {
			System.out.println(i+"번째 출력");
			i++;
		}
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단을 출력하시겠습니까? : ");
		int dan = sc.nextInt();
		int i=1;
		while(i<10) {
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
			i++;
		}
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("한번 더 출력할까요(1.yes / 2.no)");
			int sel = sc.nextInt();
			if(sel ==1) {
				System.out.println("OK");
			}
			else {
				break;
				//continue이면 while문 앞으로 감,
				//break하면 반복문 while문 마지막 코드 출력
			}
			System.out.println("반복문 마지막부분에서 출력테스트");
		}
		System.out.println("반복문끝!!");
	}
	public void loop1() {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.println("i : "+i);
			System.out.println("1 / 2 / 3 중 선택하세요");
			int sel = sc.nextInt();
			if(sel==1) {
				continue; //for문에서 사용하면 증감문
			}
			else if(sel==2) {
				break;
			}
			else {
				System.out.println("나머지");
			}
			System.out.println("반복문 마지막 코드");
		}
	}
}
