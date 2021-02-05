package kh.java.oper;
import java.util.Scanner;
public class Oper {
	public void test1() {
		int num1 = 10; //정수형 변수 num1을 선언하고 10 대입
		System.out.println("num1 : "+num1);
		num1=100; //num1변수에 100대입
		System.out.println("num1 : "+num1);
		//현재 num1값에 +1을 해서 다시 num1에 대입
		num1 = num1  + 1;
		System.out.println("num1 : "+num1);
		num1 = num1 + 15;
		num1 = num1-16;
		num1+=100;
		System.out.println("num1 : "+num1);
		num1-=100;
		System.out.println("num1 : "+num1);
		num1*=10;
		System.out.println("num1 : "+num1);
		num1/=3;
		System.out.println("num1 : "+num1);
		num1%=5;
		System.out.println("num1 : "+num1);
	}
	public void test2() {
		int num = 10;
		System.out.println("num : "+num);
		num++; //현재 변수에 있는 값에+1
		System.out.println("num : "+num);
		++num;
		System.out.println("num : "+num);
		num--;
		System.out.println("num : "+num);
		--num;
		System.out.println("num : "+num);
		int num1 = 10;
		int num2 = (num1++)+2;
		System.out.println(num1);
		System.out.println(num2);
	}
	public void test3() {
		//비트연산자
		int a=15;
		int b=20;
		//둘 다 1일 때 1
		int c =a&b;
		//하나라도 1일때 1
		int d = a|b;
		//같으면 1 아니면 0
		int e = a^b;
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("영어 대문자 1개 입력 : ");
		char ch =sc.next().charAt(0);
		System.out.println("소문자로 변환 : "+(char)(ch+32));
		System.out.println("영어 소문자 1개 입력 : ");
		char ch1 =sc.next().charAt(0);
		System.out.println("소문자로 변환 : "+(char)(ch1-32));
	}
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("영어 대문자 1개 입력 : ");
		char ch =sc.next().charAt(0);
		System.out.println("대/소문자 변환 : "+(char)(ch^32));

	}
	public void test6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 업력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번재 정수 입력 : ");
		int num2 = sc.nextInt();
		String str = num1 < num2 ? "num2가 더 큰 수 입니다." : "num1이 더 큰 수 입니다.";
		System.out.println(str);
	}
	public void test7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("==========결과=========");
		System.out.printf("두 수를 더한 수 : %d\n",num1+num2);
		System.out.printf("두 수를 뺀 수 : %d\n",num1-num2);
		System.out.printf("두 수를 곱한 수 : %d\n",num1*num2);
		System.out.printf("두 수를 나눈 수 : %.2f\n",(double)num1/num2);
		
		
	}
	public void test8() {
		int a = 40,b = 20;
		a+=b;
		System.out.printf("a의 값: %d , b의 값: %d \n",a,b);
		a-=b;
		System.out.printf("a의 값: %d , b의 값: %d \n",a,b);
		b*=a;
		System.out.printf("a의 값: %d , b의 값: %d \n",a,b);
		b/=a;
		System.out.printf("a의 값: %d , b의 값: %d \n",a,b);
	}
	public void test9() {
		int a = 40,b = 20, c = 30 , d = 40;
		boolean result1, result2;
		result1 = ((a<20&&b>10)&&(c==20||d==40));

		result2 = ((a==10 && b!=2*10)||(c==30||d!=40));
		System.out.printf("첫번째 결과값 : %b \n",result1);
		System.out.printf("두번째 결과값 : %b \n",result2);
	}
	public void test10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		String str = age >= 19 ? "성인입니다.어서오세요" : "미성년자는 입장불가입니다";
		System.out.println(str);
	}
	public void exam1() {
		Scanner sc= new Scanner(System.in);
		System.out.print("국어 점수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int num3 = sc.nextInt();
		System.out.printf("합계 : %d\n",num1+num2+num3);
		double avg = (num1+num2+num3)/3.0; 
		System.out.printf("평균 : %.2f\n",avg);
		String result = num1>=40 && num2>=40&& num3>=40 && avg>=60 ? "합격" : "불합격"; 
		System.out.println(result);
	}
	public void exam2() {
		Scanner sc= new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		String str = num1%2==0 ? "짝수!":"홀수!";
		System.out.println(str);
	}
}
