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
		public void reserveProgram() {
			Scanner sc = new Scanner(System.in);
			boolean bool = true;
			int[] rNum = new int[10]; // boolean[] room = new boolean[10];
			for(int i=0;i<10;i++) {
				rNum[i]=0;	
			}
			while(bool) {
				System.out.println("=====호텔 관리 프로그램=====");
				System.out.print("1.입실\t2.퇴실\t3.방보기\t4.종료\n");
				System.out.print("선택 > ");
				//1~4입력
				int num = sc.nextInt();						
				switch(num) {
				case 1:
					//입실
					System.out.print("몇 번방에 입실하시겠습니까? ");
					int checkin = sc.nextInt();
					for(int i=0;i<rNum.length;i++){	
						if(rNum[i]==0) { //room[i]==flase
							if(i+1==checkin) {
								System.out.println(i+1+"번방에 입실하셨습니다.");
								rNum[i]=1;
								break;
							}	
						}
						else {
							System.out.println(i+1+"번방은 현재 손님이 있습니다.");
						}
					}
					break;
				case 2:
					//퇴실
					System.out.print("몇 번방에 퇴실하시겠습니까? ");
					int checkout = sc.nextInt();
					for(int i=0;i<rNum.length;i++){	
						if(rNum[i]==1) {
							if(i+1==checkout) {
								System.out.println(i+1+"번방을 퇴실하셨습니다.");
								rNum[i]=0;
								break;
							}	
						}
						else {
							System.out.println(i+1+"번방이 비어있습니다.");
							break;
						}
					}
					break;
				case 3:
					for(int i=0;i<rNum.length;i++) {
						if(rNum[i]==0) { //!room[i]	  0:false 1:true
							System.out.println(i+1+"번방이 현재 비어있습니다.");
						}
						else if(rNum[i]==1){
							System.out.println(i+1+"번방에는 현재 손님이 있습니다.");
							
						}
					}
					//방보기
					break;
				case 4:
					bool=false;
					return;
					
				}
			}
		}
		public void arrrayCopy() {
			//얕은 복사
			int[]arr1 = {1,2,3,4,5};
			int[]arr2=arr1;
			arr1[1]=10;
			arr2[2]=30;
			//깊은 복사1)
			int[]arr3=arr1.clone();
			arr1[1] =100;
			int[]arr4 = new int[5];
			//깊은 복사2)
			//일부만 잘라서 복사할때
			//복사될 원본배열 , 인덱스 시작번호, 새데이터배열, 복사시작번호, 5개복사
			System.arraycopy(arr1, 0, arr4, 0, arr1.length);
			//깊은 복사3)
			int[] arr5 = new int[5];
			for(int i=0;i<arr1.length;i++) {
				arr5[i] = arr1[i];
			}
			
			for(int i=0;i<arr1.length;i++) {
				System.out.print(arr1[i]+" ");
			}
			System.out.println();
			for(int i=0;i<arr2.length;i++) {
				System.out.print(arr2[i]+" ");
			}
			System.out.println();
			for(int i=0;i<arr3.length;i++) {
				System.out.print(arr3[i]+" ");
			}
			System.out.println();
			for(int i=0;i<arr4.length;i++) {
				System.out.print(arr4[i]+" ");
			}
		}
		public void arraytest1() {
			int [][] arr = new int[2][3];
			arr[0][0]=1;
			arr[0][1]=3;
			arr[0][2]=5;
			arr[1][0]=7;
			arr[1][1]=9;
			arr[1][2]=11;
			for(int i=0;i<arr.length;i++) { //행
				for(int j=0;j<arr[i].length;j++) { //열
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		public void exam11() {
			int [][] arr = new int[5][5];
			int cnt=0;
			for(int i=0;i<arr.length;i++) { //행
				for(int j=0;j<arr[i].length;j++) { //열
					cnt++;
					arr[i][j]=cnt;
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

