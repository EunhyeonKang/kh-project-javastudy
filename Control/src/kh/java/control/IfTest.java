package kh.java.control;
import java.util.Scanner;
public class IfTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 10을 입력해보세요 : ");
		int number = sc.nextInt();
		if(number == 10) {
			System.out.println("잘했어요");
		}
		System.out.println("끝!");
	}
	public void test2(){
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 숫자 구별 프로그램 =======");
		System.out.print("임의의 정수를 입력 하세요 : ");
		int num = sc.nextInt();
		if(num>0) {
			System.out.printf("당신이 입력한 수 %d은(는) 양수입니다.",num);
		}
		else if(num<0) {
			System.out.printf("당신이 입력한 수 %d은(는) 음수입니다.",num);
		}
		else {
			System.out.printf("당신이 입력한 수 %d은(는) 0입니다.",num);
		}
	}
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 두수 비교 프로그램 =======");
		System.out.print("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();
		if(num1<num2) {
			System.out.printf("%d<%d\n",num1,num2);
			System.out.printf("두번째 수가 더 큽니다.");
		}
		else if(num1>num2) {
			System.out.printf("%d>%d\n",num1,num2);
			System.out.printf("첫번째 수가 더 큽니다.");
		}
		else {
			System.out.printf("%d=%d\n",num1,num2);
			System.out.printf("두 수가 같습니다.");
		}
	}
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 계산기 프로그램 =======");
		System.out.print("연산자를 입력하세요(+,-,*,/) : ");
		char oper = sc.next().charAt(0);
		System.out.print("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();
		if(oper == '+') {
			System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
		}
		else if(oper == '-') {
			System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
		}
		else if(oper == '*'){
			System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
		}
		else {
			System.out.printf("%d/%d=%f\n",num1,num2,(double)num1/num2);
		}
	}
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 정수를 입력하세요 : ");
		int number = sc.nextInt();
		if(number%2==1) {
			System.out.println(number + "은(는) 홀수 입니다.");
		}
		else {
			System.out.println(number + "은(는) 짝수 입니다.");
		}
	}
	public void test6() {
		Scanner sc = new Scanner(System.in);
		int adultPrice = 15000;
		int kidPrice = 5000;
		System.out.println("======= 놀이공원 프로그램 =======");
		System.out.print("입장하실 총 인원은 몇명입니까? : ");
		int total = sc.nextInt();
		System.out.print("어른은 몇명입니까?(1인" +adultPrice+"당 15000원): ");
		int adult = sc.nextInt();
		System.out.print("아이는 몇명입니까?(1인" +kidPrice+"당 5000원) : ");
		int kid = sc.nextInt();	
		if(total==adult+kid) {
			//총인원수와 어른 아이 합친값이 값은경우
			int totalPrice = (15000*adult)+(5000*kid);
			System.out.printf("지불하실 총 금액은 %d원 입니다.\n",totalPrice);
		}
		else {
			//총인원수와 어른 아이 합친값이 다른경우
			System.out.println("인원이 맞지 않습니다.");
		}
	}
	public void test7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 퀴즈 프로그램 =======");
		System.out.println("첫번째 퀴즈");
		System.out.print("사과는 영어로 무엇일까요(1.apple,2.스티브 잡스)? : ");
		int cnt=0;
		int n = sc.nextInt();
		if(n==1) {
			cnt++;
			System.out.println("정답!!");
		}else {
			System.out.println("땡!!");
		}
		System.out.println("두번째 퀴즈");
		System.out.print("바나나는 길어 길으면 기차 기차는(1.비싸,2.빨라)? : ");
		int n1 = sc.nextInt();
		if(n1==1) {
			System.out.println("땡!!");
		}else {
			cnt++;
			System.out.println("정답!!");
		}
		System.out.println("총 "+cnt+"문제를 맞췄습니다.");
	}
	public void test8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= 심리 프로그램 =======");
		System.out.print("당신은 술을 종아하십니까(1.yes,2.no)? : ");
		int question1 = sc.nextInt();
		if(question1==1) {
			System.out.print("당신은 담배를 종아하십니까(1.yes,2.no)? : ");
			int question2 = sc.nextInt();
			if(question2==1) {
				System.out.println("담배는 건강에 좋지 않습니다.");
			}else {
				System.out.println("술은 간에 좋지 않습니다.");
			}
		}
		else {
			System.out.print("당신은 이성친구가 있습니까(1.yes,2.no)? : ");
			int question2 = sc.nextInt();
			if(question2==1) {
				System.out.println("올..ㅋ");
			}
			else {
				System.out.println("힘내요ㅠㅠ");
			}
		}
	}
	public void test9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~3 사이 정수를 입력하세요 : ");
		int number = sc.nextInt();
		if(number%2==0) {
			System.out.println("짝수");
		}
		else if(number%2!=0) {
			System.out.println("홀수");
		}
		else {
			System.out.println("0입니다");
		}
	}
	public void test10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======== 대/소문자 변환 프로그램 ========");
		System.out.print("문자입력 : ");
		char str = sc.next().charAt(0);
		System.out.println("======== 결 과 ========");
	
		if(str >='a' &&str <='z') {
			System.out.println("소문자를 입력하였습니다.");
			System.out.println("대문자로 변환 : "+(char)(str-32));
		}
		else if(str>='A'&&str<='Z') {
			System.out.println("대문자를 입력하였습니다.");
			System.out.println("소문자로 변환 : "+(char)(str+32));
		}
		else {
			System.out.println("잘못입력하셨습니다. 영문자를 입력해주세요.");
		}
	}
	public void test11() {
		System.out.print("정수입력 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("======== 결 과 ========");
		if(num==0) {
			System.out.println("["+num+"]은(는) 3의 배수도 4의 배수도 아닙니다.");
		}
		else if(num%3==0&&num%4==0) {
			System.out.println("["+num+"]은(는) 3의 배수면서 4의 배수입니다.");
		}
		else if(num%3==0){
			System.out.println("["+num+"]은(는) 3의 배수입니다.");
		}
		else if(num%4==0) {
			System.out.println("["+num+"]은(는) 4의 배수입니다.");
		}
		else if(!(num%3==0&&num%4==0)){
			System.out.println("["+num+"]은(는) 3의 배수도 4의 배수도 아닙니다.");
		}
	}
}
