package kr.or.iei.view;

import java.util.Scanner;

public class MainView {
	Scanner sc;
	public MainView() {
		super();
		sc = new Scanner(System.in);
	}
	public int selectMember() {
		System.out.println("===== 헬스클럽 프로그램 =====");
		System.out.println("1. 관리자");
		System.out.println("2. 수강생");
		System.out.println("0. 종료");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}
	public void printMsg(String msg) {
		System.out.println(msg);
	}
}
