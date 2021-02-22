package kh.java.run;

import kh.java.MethodTest.*;
import java.util.Scanner;
public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MethodTest mt = new MethodTest();
		StudentMgr sm = new StudentMgr();
		TV tv = new TV();
		
		Aclass a = new Aclass();
		Bclass b = new Bclass();
//		a.setNum(100);
//		System.out.println(a.getNum());
//		b.setNo(1000);
//		a.setNo(10000);
//		System.out.println(b.getNo());
//		System.out.println(a.getNo());
//		System.out.println("-----------------");
//		Aclass aa = new Aclass(2222,3333);
//		System.out.println(aa.getNum());
//		System.out.println(aa.getNo());
		b.printMsg();
		a.printMsg();
		
		
//		mt.exam1();
//		mt.test11();
//		sm.main();
		/*
		tv.power();
		tv.volUp();
		while(true) {
			System.out.println("1. 볼륨 업");
			System.out.println("2. 볼륨 다운");
			System.out.println("3. 채널 업");
			System.out.println("4. 채널 다운");
			System.out.println("5. 채널 변경");
			System.out.println("0. 전원 끄기");
			System.out.print("선택 > ");
			int sel = sc.nextInt();
			switch(sel) {
			case 1:
				tv.volUp();
				break;
			case 2:
				tv.volDown();
				break;
			case 3:
				tv.chUP();
				break;
			case 4:
				tv.chDown();
				break;
			case 5:
				System.out.println("채널 입력 : ");
				int changeCh = sc.nextInt();
				tv.chChange(changeCh);
				break;
			case 0:
				tv.power();
				return;
			}
		}
		*/
	}
}
