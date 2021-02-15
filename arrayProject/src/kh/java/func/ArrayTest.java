package kh.java.func;
import java.util.Scanner;
import java.util.Random;
public class ArrayTest {
	public void test1() {
		//정수형 변수 5개를 선언하여 순서대로 1,2,3,4,5를 대입
		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		int num4 = 4;
		int num5 = 5;
		//길이 5인 정수형 배열 선언 후 순서대로 1,2,3,4,5를 대입
		int[] arr1 = new int[5]; //길이가 5인 정수형 배열 선언
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4;
		arr1[4] = 5;
		//길이 5인 정수형 배열 선언 후 순서대로 1,2,3,4,5를 대입
		int[] arr2 = {1,2,3,4,5};
		//길이 5인 정수형 배열 선언 후 순서대로 1,2,3,4,5를 대입
		int[] arr3 = new int[5]; //new int[길이] 0초기화 
		for(int i=0;i<5;i++) {
			arr3[i] = i+1;
		}
		for(int i=0;i<5;i++) {
			System.out.println(arr3[i]);
		}
		String[] arr4 = new String[3];
		arr4[0]="Hello";
		arr4[1]="my name";
		arr4[2]="is eunhyeon";
		
		for(int i=0;i<3;i++) {
			System.out.println(arr4[i]);
		}
		
	}
	public void exam1() {
		String[]fuit = new String[5];
		fuit[0] = "딸기";
		fuit[1] = "복숭아";
		fuit[2] = "키위";
		fuit[3] = "사과";
		fuit[4] = "바나나";
		System.out.println(fuit[4]);
		System.out.println();
		System.out.println(fuit[0]);
		System.out.println(fuit[1]);
		System.out.println(fuit[2]);
		System.out.println(fuit[3]);
		System.out.println(fuit[4]);
		System.out.println();
		for(int i=0;i<5;i++) {
			System.out.println(fuit[i]);
		}
	}
	public void exam2() {
		int[] arrNum = new int[100];
		for(int i=0;i<100;i++) {
			arrNum[i]=i+1;
			System.out.println(arrNum[i]);
		}
	}
	public void exam3() {
		int[] arrNum1 = new int[4];
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 입력 : ");
		arrNum1[0] = sc.nextInt();
		System.out.print("영어점수 입력 : ");
		arrNum1[1] = sc.nextInt();
		System.out.print("수학점수 입력 : ");
		arrNum1[2] = sc.nextInt();
		arrNum1[3] = arrNum1[0]+arrNum1[1]+arrNum1[2];
		System.out.print("점수 합계 : ");
		for(int i=0;i<4;i++) {
			System.out.println(arrNum1[i]);
		}
		System.out.printf("평균 : %.2f",arrNum1[3]/3.0);
	}
	public void bobble() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			System.out.print((i+1)+"번째 숫자 입력 : ");
			arr[i]=sc.nextInt();
		}
		//버블정렬 선택정렬 삽입정렬 < 퀵정렬
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0;i<5;i++) {
			System.out.print(arr[i]);
		}
	}
	public void lottoProgram() {
		int cnt=0;
		System.out.println("사용자 숫자 6개 입력 : ");
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int[] arr = new int[6];
		int[] carr = new int[6];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
			while(true) {
				if(!(arr[i]>=1&&arr[i]<=45)) {
					System.out.println("입력범위를 벗어났습니다. 다시 입력해주세요 : ");
					arr[i] = sc.nextInt();	
				}
				else {
					for(int j=0;j<i;j++) {
						while(true) {
							if(arr[i]==arr[j]) {			
								System.out.println("중복된 값입니다. 다시 입력해주세요 : ");
								break;							
							}
							
						}
					}
					break;
				}
			}
		}	
//		for(int i=0;i<arr.length;i++) {
//			carr[i] = r.nextInt(45)+1;
//			for(int j=0;j<i;j++) {
//				if(arr[i]==arr[j]) {
//					System.out.println("중복된 값");
//				}
//			}	
//		}	
	}
	public void lottoProgram1() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("===== 로또 ======");
		int[] userNum = new int[6];	//길이 6
		int[] comNum = new int[6];	//길이 6
		for(int i=0;i<userNum.length;i++) {
			//입력 값이 1~45 사이인지
			//중복된 값인지
			System.out.println((i+1)+"번째 번호 입력(1~45) : ");
			int inputNum = sc.nextInt();
			if(1<=inputNum && inputNum<=45) {
				//입력 범위가 정상인 경우
				boolean bool = true;
				for(int j=0;j<i;j++) {
					if(inputNum==userNum[j]) {
						//입력값과 중복된 숫자가 배열에 존재하는 경우
						System.out.println("중복된 번호입니다. 다시입력하세요.");
						i--;
						bool = false;
						break;
					}
					
				}
				if(bool) {
					userNum[i] = inputNum;
				}
			}else {
				//입력 범위가 벗어난 경우
				System.out.println("잘못 입력하셨습니다. 1~45 중 한개를 입력해주세요.");
				i--;
			}
		}
	
		//컴퓨터 
		for(int i=0;i<comNum.length;i++) {
			//입력 값이 1~45 사이인지
			//중복된 값인지	
			int inputNum = r.nextInt(45)+1;
			//입력 범위가 정상인 경우
				boolean bool = true;
				for(int j=0;j<i;j++) {
					if(inputNum==comNum[j]) {
						//입력값과 중복된 숫자가 배열에 존재하는 경우
						System.out.println("중복된 번호입니다. 다시입력하세요.");
						i--;
						bool = false;
						break;
					}
				}
				if(bool) {
					comNum[i] = inputNum;
				}
			}
			for(int i=0;i<comNum.length;i++) {
				System.out.println((i+1)+"번째 번호는 > "+comNum[i]);
			}
			//결과 처리
			
			for(int i=0;i<comNum.length;i++) {
				for(int j=0;j<comNum.length-i-1;j++) {
					if(comNum[j+1] < comNum[j]) {
						int temp = comNum[j];
						comNum[j]=comNum[j+1];
						comNum[j+1]=temp;
					}
				}
				for(int j=0;j<userNum.length-i-1;j++) {
					if(userNum[j+1] < userNum[j]) {
						int temp = userNum[j];
						userNum[j]=userNum[j+1];
						userNum[j+1]=temp;
					}
				}

			}
			int cnt=0;
			if(cnt==6) {
				System.out.println("1등");
			}else if(cnt==5){
				System.out.println("2등");
			}
			else if(cnt==4){
				System.out.println("3등");
			}else {
				System.out.println("꽝");
			}
			
		}
	
	}

