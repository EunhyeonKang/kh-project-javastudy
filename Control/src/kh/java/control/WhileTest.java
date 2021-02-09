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
}
