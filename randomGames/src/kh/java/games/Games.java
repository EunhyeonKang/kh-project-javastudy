package kh.java.games;
import java.util.Random;
import java.util.Scanner;

public class Games {
	public void exam1() {	
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int rNum = r.nextInt(99)+1;
		System.out.println(rNum+"정답인디");
		int count =0;
		boolean bool = true;
		while(bool) {
			System.out.println("== Up & Down Game ==");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			int num = sc.nextInt();
			if(num==1||num==2||num==3) {
				switch(num) {
				case 1:  
					while(true) {
						System.out.println(" << Game Start >>");
						System.out.print("Input Number : ");
						int mNum = sc.nextInt();
						count++;
						if(rNum == mNum ) {
							System.out.println("<< 정답 >>");
							break;
						}
						else if(rNum < mNum) {
							System.out.println("<< DOWN >>");
						}
						else if(rNum > mNum) {
							System.out.println("<< UP >>");
						}
					}			
					break;
				case 2 :
					//게임 스코어
					System.out.println("현재 최고 기록은 "+count+" 입니다");
					break;
				case 3 :
					//게임 종료
					bool=false;	
				}
			}
			else {
				System.out.println("1,2,3중에 입력해주세요");
			}	
		}
	}
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int count=1;
		int count1=0;
		int k=0;
		int win=0;
		int lose=0;
		int temp=0;
		boolean bool= true;
		boolean bool1 = true;
		while(bool) {
			System.out.println("Baskin Robbins31 Game");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");		
			System.out.print(">");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("<<  Game Start >>");
					while(true) {
						int j=0;
						System.out.println("<< YOUR GAME >>");
						System.out.print("Input Number : ");
						int gameNum = sc.nextInt(); 
						int comNum = r.nextInt(3)+1;
						if(gameNum==1||gameNum==2||gameNum==3) {
							if(bool==true) {
								for(j=count1+1;j<=gameNum+count1;j++) {
									System.out.println(j+"i");
									count++;
									count=j;
									bool=false;	
									if(count==31) {
										lose++;
										System.out.println("패배!!! ㅠㅠㅠ");
										temp++;
										bool=true;	
										count=0;
										count1=0;
										break;
									}
								}
							}
							if(bool==false) {
								System.out.println("<< 컴퓨터 >>");	
								for(j=count;j<comNum+count;j++) {
									System.out.println(j+1+"i");
									count1++;
									count1=j+1;
									bool=true;
									if(count1==31) {
										win++;
										System.out.println("이겼다아~~");
										temp++;
										count=0;
										count1=0;
										break;
									}
								}
							}
							if(temp==1) {
								temp=0;
								break;
							}
						}
						else {
							System.out.println("1~3사이 숫자를 입력해주세요");
						}
					}
					
				break;
			case 2:
				System.out.println("<< 당신의 전적 >>");
				System.out.println("W I N : "+win);
				System.out.println("L O S E : "+lose);
				break;
			case 3:
				bool = false;
				return;
			}
			if(!(num==1||num==2||num==3)) {
				System.out.println("1~3사이 숫자를 입력해주세요");
			}
		}		
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int win=0;
		int lose=0;
		int draw =0;
		int rSum=0;
		int cSum =0;
		int money =10000;
		boolean bool = true;
		while(bool) {
			System.out.println("== Dice Game ==");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Gamd");
			System.out.print(">");
			int num = sc.nextInt();
			int rNum1 = r.nextInt(6)+1;
			int rNum2 = r.nextInt(6)+1;
			int rNum3 = r.nextInt(6)+1;
			switch(num) {
			case 1:
				while(true) {
					System.out.println("<<Game Start>>");
					
					//랜덤 주사위
					rSum = rNum1 + rNum2 + rNum3;
					System.out.println("1번째 주사위 값 : "+rNum1);
					System.out.println("2번째 주사위 값 : "+rNum2);
					System.out.println("3번째 주사위 값 : "+rNum3);
					System.out.println("내  주사위 총 합 : "+rSum);
					System.out.print("배팅을 하겠습니까[y/n] : ");
					char ch = sc.next().charAt(0);
					
					if(ch=='y') {
						System.out.printf("얼마를 배팅하시겠습니까(현재 내 소지금 %d원) : ",money);
						//배팅금액
						int bat = sc.nextInt();
						//컴퓨터 주사위
						int cNum1 = r.nextInt(6)+1;
						int cNum2 = r.nextInt(6)+1;
						int cNum3 = r.nextInt(6)+1;
						cSum = cNum1 + cNum2 + cNum3;
						System.out.println("컴퓨터 1번째 주사위 값 : "+cNum1);
						System.out.println("컴퓨터 2번째 주사위 값 : "+cNum2);
						System.out.println("컴퓨터 3번째 주사위 값 : "+cNum3);
						System.out.println("컴퓨터 주사위 총 합 : "+cSum);
					
						System.out.println("<< 결과 >>");
						
						if(rSum < cSum) {
							System.out.println("패배!!!!!");
							System.out.println("-"+bat+"원!!");
							lose++;
							money-=bat;	
						}else if(rSum > cSum) {
							System.out.println("승리!!!!!");
							System.out.println("+"+bat+"원!!");
							win++;
							money+=bat;
						}
						else if(rSum==cSum) {
							System.out.println("비겼습니다.");
							draw++;
						}
						if(money <=0) {
							System.out.println("파산!! ㅠㅠㅠ");
							break;
						}
						System.out.print("한번 더 하시겠습니까[y/n] : ");
						ch = sc.next().charAt(0);
						if(ch=='y') {
							bool=true;
						}else {
							break;
						}
					}
					else if(ch=='n') {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}
					
				}
				break;
			case 2:
				System.out.println("<< 당신의 전적 >>");
				System.out.println("win"+win);
				System.out.println("lose"+lose);
				break;
			case 3:
				return;
			}
			
			
			if(!(num==1||num==2||num==3)) {
				System.out.println("1~3 사이 숫자를 입력해주세요");
			}
		}
	}
}
