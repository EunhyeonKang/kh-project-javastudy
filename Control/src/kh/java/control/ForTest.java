package kh.java.control;
import java.util.Scanner;
public class ForTest {
	public void test1() {
		for(int i=0;i<5;i++) {
			System.out.println(i+"번재 출력");
		}
		for(int i=4;i>=0;i--) {
			System.out.println(i+"번재 출력");
		}
	}
	public void exam1() {
		for(int i=0;i<5;i++) {
			System.out.println("안녕하세요");
		}
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0;i<num;i++) {
			System.out.println("안녕하세요");
		}
	}
	public void exam3() {
		System.out.println("2단 입니다.");
		for(int i=1;i<=9;i++) {
			System.out.println("2 * "+i+" = "+2*i);
		}
	}
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단을 출력하시겠습니까? : ");
		int num = sc.nextInt();
		System.out.printf("%d단 입니다.\n",num);
		for(int i=1;i<=9;i++) {
			System.out.println(num+" * "+i+" = "+num*i);
		}
	}
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		for(int i=0;i<5;i++) {
			System.out.print("정수 값을 입력하시오 : ");
			int num = sc.nextInt();
			sum += num;
		}
		System.out.println("입력한 5개의 정수의 합 : "+sum);
	}
	public void exam6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		int sum=0;
		for(int i=num1;i<=num2;i++) {
			sum+=i;
		}
		System.out.println(num1+" ~ "+num2+"의 정수의 합 : "+sum);
	}
	public void exam7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num1 = sc.nextInt();
		int sum=0;
		for(int i=1;i<=num1;i++) {
			if(i%2==0) {
				sum+=i;
			}
		}
		System.out.println("짝수들의 합은 : "+sum);
	}
}
