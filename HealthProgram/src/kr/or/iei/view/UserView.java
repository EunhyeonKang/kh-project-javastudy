package kr.or.iei.view;

import java.util.Scanner;

import kr.or.iei.model.vo.Exercise;
import kr.or.iei.model.vo.PT;
import kr.or.iei.model.vo.Pilates;
import kr.or.iei.model.vo.Spinning;
import kr.or.iei.model.vo.Swim;

public class UserView {
	Scanner sc;
	Exercise user;
	public UserView() {
		super();
		sc = new Scanner(System.in);
		user =null;
	}
	public int showMenu() {
		System.out.println("1. 프로그램 조회");
		System.out.println("2. 수강 등록 신청");
		System.out.println("3. 수강 탈퇴 신청");
		System.out.println("4. 뒤로 가기");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}
	public void totalProgramSearch(Exercise[] ex, int index) {
		System.out.println("----- 프로그램 전체 조회 -----");
		System.out.println("프로그램 종류       프로그램명\t방이름\t강사\t수강인원\t수강기간");
		for(int i=0;i<index;i++) {
			System.out.println(ex[i].getProgrName()+"\t"+ex[i].getSubName()+"\t"+ex[i].getRoomName()+"\t"+ex[i].getTeachName()+"\t"+ex[i].getTotalNum()+"\t"+ex[i].getMonth()+"\t"+ex[i].getMonth()*ex[i].getPrice());
		}
	}
	public String insertProgram(String msg) {
		System.out.println("----- 수강 등록 신청 -----");
		System.out.print(msg+"할 프로그램 명을 입력해주세요 : ");
		String cSel = sc.next();
		return cSel;
	}
	public Exercise inputProgram(String cSel) {
		System.out.print("등록 개월 수를 입력해 주세요 : ");
	    int month = sc.nextInt();
	    switch(cSel) {
	      case "예쁜바디반":
	    	 user = new Pilates(cSel,month);
	         break;
	      case "1111반":
	    	 user = new Spinning(cSel,month);
	         break;
	      case "2222반":
	    	 user = new PT(cSel,month);
	         break;
	      case "3333반":
	    	 user = new Swim(cSel,month);
	         break;
	      }
		return user;
	}
	public void privProgramSearch(Exercise[] ex,int index) {
		System.out.println("----- 개인 수강 내역 조회 -----");
		System.out.println("프로그램명\t  등록일수\t   가격");
		for(int i=0;i<index;i++) {
			System.out.println(ex[i].getSubName()+"\t"+ex[i].getMonth()+"\t"+ex[i].getMonth()*ex[i].getPrice());
		}
	}
	public int classRegister(String cSel) {
		System.out.println("수강하시겠습니까?(1. yes/2. no)");
		int sel = sc.nextInt();
		return sel;
		
	}
	public int classExit(String oSel) {
		System.out.println("수강탈퇴시겠습니까?(1. yes/2. no)");
		int sel = sc.nextInt();
		return sel;
	}
	public int serchMenu () {
	      System.out.println("===== 프로그램 조회창입니다. ======");
	      System.out.println("1.전체 프로그램 조회");
	      System.out.println("2.내 수강목록 조회");
	      System.out.println("0.뒤로가기");
	      System.out.print("선택>");
	      int searchSel = sc.nextInt();
	      return searchSel;
	}
}
