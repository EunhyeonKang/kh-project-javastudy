package kr.or.iei.member.view;

import java.util.Scanner;

import kr.or.iei.member.model.vo.Gold;
import kr.or.iei.member.model.vo.Member;
import kr.or.iei.member.model.vo.Silver;
import kr.or.iei.member.model.vo.VVip;
import kr.or.iei.member.model.vo.Vip;





public class MemberView {
	Scanner sc;
	Member m;
	public MemberView() {
		super();
		m = null;
		sc = new Scanner(System.in);
	}
	public int showMenu() {
		System.out.println("----- 회원 관리 프로그래 v5 -----");
		System.out.println("1. 회원 등록");
		System.out.println("2. 전체 회원 출력");
		System.out.println("3. 회원 정보 출력(1명)");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}
	public Member insertMember() {
		System.out.println("----- 회원 정보 등록 -----");
		System.out.println("등급입력[silver/gold/vip/vvip]");
		String grade = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("포인트 입력 : ");
		int point = sc.nextInt();
		switch(grade) {
		case "silver":
			m = new Silver(grade,name,point);
			break;
		case "gold":
			m = new Gold(grade,name,point);
			break;
		case "vip":
			m = new Vip(grade,name,point);
			break;
		case "vvip":
			m = new VVip(grade,name,point);
			break;		
		}
		return m;
	}
	public void printAllMember(Member[] m,int index) {
		for(int i=0;i<index;i++) {
			System.out.println(m[i].getGrade()+"\t"+m[i].getName()
					+"\t"+m[i].getPoint()+"\t"+m[i].getBonus());
		}
	}
	public void printOneMember(Member m) {
		System.out.println(m.getGrade()+"\t"+m.getName()+"\t"+m.getPoint()+"\t"+m.getBonus());
	}
	public Member modifyMember() {
		System.out.print("수정 등급 입력 : ");
		String mGrade = sc.next();
		System.out.print("수정 이름 입력 : ");
		String mName = sc.next();
		System.out.print("수정 포인트 입력 : ");
		int mPoint = sc.nextInt();
		switch(mGrade) {
		case "silver":
			m = new Silver(mGrade,mName,mPoint);
			break;
		case "gold":
			m = new Gold(mGrade,mName,mPoint);
			break;
		case "vip":
			m = new Vip(mGrade,mName,mPoint);
			break;
		case "vvip":
			m = new VVip(mGrade,mName,mPoint);
			break;
		}
		return m;
	}
	public String inputName(String msg) {
		System.out.print(msg+"할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	public void printMsg(String msg) {
		System.out.println(msg);
	}
}
