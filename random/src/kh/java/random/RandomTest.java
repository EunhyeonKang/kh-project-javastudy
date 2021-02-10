package kh.java.random;
import java.util.Random;
import java.util.Scanner;
public class RandomTest {
	public void random1() {
		Scanner sc= new Scanner(System.in);
		Random r =new Random();
		//0부터 셈 
		//r.nextInt(개수)+시작숫자
		int randomNumber = r.nextInt(10);
		System.out.println(randomNumber);
		int randnumber1 = r.nextInt(2);//0 1
		System.out.println(randnumber1);
		int randNumber2 = r.nextInt(16);//0~15
		System.out.println(randNumber2);
		int randNumber3 = r.nextInt(10)+1;//1~10
		System.out.println(randNumber3);
		int randNumber4 = r.nextInt(16)+20; //2-~35
		System.out.println(randNumber4);
		sc.nextInt();
		r.nextInt();
	}
	public void coin() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		//게임선택 변수
		int select=0;
		//게임하는 도중 초기화되지 않도록 반복문 밖에 위치한다.
		int win = 0;
		int lose =0;
		boolean bool = true;
		while(bool) {	
			System.out.println("==== 동전 앞/뒤 맞추기 ====");
			System.out.println("1. 게임시작");
			System.out.println("2. Score");
			System.out.println("3. 게임 종료");
			System.out.println("선택 > ");
			select = sc.nextInt(); 
			switch(select) {
			case 1: //Game Start
				int coin = r.nextInt(2)+1; 
				System.out.print("[앞/뒤]선택해주세요(1.앞면 / 2.뒷면) : ");
				while(true) {
					select = sc.nextInt(); 
					if(select ==1 || select ==2) {
						break;
					}
					System.out.println("1 또는 2를 입력해주세요.");
					
				}
				System.out.println("결과확인 : "+(coin ==1 ?"앞면":"뒷면"));
				if(coin == select) {
					System.out.println("정답");
					win++;
				}
				else {
					System.out.println("땡");
					lose++;
				}
				break;
			case 2: //Score
				System.out.println("<< 전적 >>");
				System.out.println("WIN : "+win);
				System.out.println("LOSE : "+lose);
				break;
			case 3: //Game Exit
				//1. return 으로 종료
				bool=false;
				//bool = true;
				break;
			}//switch문 종료
//			if(bool == true) { //bool
//				break;
//			}
		}//while문 종료
	}
	public void game() {
		System.out.println("=== 가위 바위 보 게임 ===");
		System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int myNumber = sc.nextInt();
		int randomNumber = r.nextInt(3)+1;
		System.out.println("======== 결과 ========");

		if(myNumber==1) {
			System.out.println("당신은 가위를 냈습니다.");
		}else if(myNumber==2) {
			System.out.println("당신은 바위를 냈습니다.");
		}else {
			System.out.println("당신은 보를 냈습니다.");
		}
		if(randomNumber==1) {
			System.out.println("컴퓨터는 가위를 냈습니다.");
		}else if(randomNumber==2) {
			System.out.println("컴퓨터는 바위를 냈습니다.");
		}else {
			System.out.println("컴퓨터는 보를 냈습니다.");
		}
		System.out.println("====================");
		if(myNumber==1 && randomNumber==3||myNumber==2 && randomNumber==1||myNumber==3&&randomNumber==2) {
			System.out.println("당신이 이겼습니다.ㅠㅠ");
		}
		else if(myNumber==1 && randomNumber==1||myNumber==2 && randomNumber==2||myNumber==3&&randomNumber==3){
			System.out.println("비겼습니다!!!");
		}
		else {
			System.out.println("컴퓨터가 이겼습니다!!!");
		}
		
	}
}
