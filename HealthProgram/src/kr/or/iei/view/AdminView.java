package kr.or.iei.view;

import java.util.Scanner;

import kr.or.iei.model.vo.Exercise;
import kr.or.iei.model.vo.PT;
import kr.or.iei.model.vo.Pilates;
import kr.or.iei.model.vo.Spinning;
import kr.or.iei.model.vo.Swim;

public class AdminView {
	Scanner sc;

	public AdminView() {
		super();
		sc = new Scanner(System.in);
	}

	public int manageMenu() {
		System.out.println("==========관리자 메뉴 프로그램==========");
		System.out.println("1. 프로그램 등록");
		System.out.println("2. 프로그램 조회");
		System.out.println("3. 특정 프로그램 조회");
		System.out.println("4. 프로그램 변경(수정)");
		System.out.println("5. 프로그램 탈퇴");
		System.out.println("0. 뒤로가기");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;

	}

	public Exercise getName(String msg) {
		System.out.print(msg + "할 프로그램명 종류 입력[필라테스 / PT / 스피닝 / 수영] :");
		String progrName = sc.next();
		System.out.print(msg + "할 프로그램명 입력 : ");
		String subName = sc.next();
		System.out.print(msg + "할 프로그램 강의실명 : ");
		String roomName = sc.next();
		System.out.print(msg + "할 프로그램 강사명  :");
		String teachName = sc.next();
		System.out.print(msg + "할 프로그램 수강인원 : ");
		int totalNum = sc.nextInt();
		System.out.print(msg + "할 프로그램 개월 : ");
		int month = sc.nextInt();
		Exercise exr = null;
		switch (progrName) {
		case "필라테스":
			exr = new Pilates(progrName, subName, roomName, teachName, totalNum, month);
			break;
		case "PT":
			exr = new PT(progrName, subName, roomName, teachName, totalNum, month);
			break;
		case "스피닝":
			exr = new Spinning(progrName, subName, roomName, teachName, totalNum, month);
			break;
		case "수영":
			exr = new Swim(progrName, subName, roomName, teachName, totalNum, month);
		}
		return exr;
	}

	public void printAllProgram(Exercise[] ex, int index) {
		System.out.println("==========전체 프로그램 출력==========");
		System.out.println("==========필라테스==========");
		System.out.println("프로그램명\t방이름\t강사\t수강인원\t수강기간");
		for (int i = 0; i < index; i++) {
			if(ex[i].getProgrName().equals("필라테스")){
				System.out.println(ex[i].getSubName() + "\t" + ex[i].getRoomName() + "\t" + ex[i].getTeachName()
						+ "\t" +ex[i].getTotalNum() + "\t" + ex[i].getMonth());
			}
		}
		System.out.println("==========P   T==========");
		System.out.println("프로그램명\t방이름\t강사\t수강인원\t수강기간");
		for (int i = 0; i < index; i++) {
			if(ex[i].getProgrName().equals("PT")){
				System.out.println(ex[i].getSubName() + "\t" + ex[i].getRoomName() + "\t" + ex[i].getTeachName()
						+ "\t" +ex[i].getTotalNum() + "\t" + ex[i].getMonth());
			}
		}
		System.out.println("==========스피닝==========");
		System.out.println("프로그램명\t방이름\t강사\t수강인원\t수강기간");
		for (int i = 0; i < index; i++) {
			if(ex[i].getProgrName().equals("스피닝")){
				System.out.println(ex[i].getSubName() + "\t" + ex[i].getRoomName() + "\t" + ex[i].getTeachName()
						+ "\t" +ex[i].getTotalNum() + "\t" + ex[i].getMonth());
			}
		}
		System.out.println("==========수영==========");
		System.out.println("프로그램명\t방이름\t강사\t수강인원\t수강기간");
		for (int i = 0; i < index; i++) {
			if(ex[i].getProgrName().equals("수영")){
				System.out.println(ex[i].getSubName() + "\t" + ex[i].getRoomName() + "\t" + ex[i].getTeachName()
						+ "\t" +ex[i].getTotalNum() + "\t" + ex[i].getMonth());
			}
		}
	}

	public String inputName(String msg) {
		System.out.print(msg + "할 프로그램 이름 입력 : ");
		String name = sc.next();
		return name;
	}

	public void printMsg(String msg) {
		System.out.println(msg);
	}

	public void printOneProgram(Exercise ex) {
		System.out.println("프로그램 종류 : " + ex.getProgrName());
		System.out.println("프로그램 이름: " + ex.getSubName());
		System.out.println("방 이름 : " + ex.getRoomName());
		System.out.println("강사 이름 : " + ex.getTeachName());
		System.out.println("수강 인원 : " + ex.getTotalNum());

	}
}