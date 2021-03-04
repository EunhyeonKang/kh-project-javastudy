package kr.or.iei.member.view;

import java.util.ArrayList;
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
		sc = new Scanner(System.in);
		m=null;
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
	public Member insertMember(String string) {
		System.out.println("----- 회원 정보 "+string+" -----");
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
	

	public void printMsg(String string) {
		System.out.println(string);
	}

	public void printAllMember(ArrayList<Member> members) {
		System.out.println("----- 회원 전체 출력 -----");
		System.out.println("등급\t이름\t포인트\t보너스");
		for(int i=0;i<members.size();i++) {
			System.out.println(members.get(i));
		}
	}

	public String searchName(String string) {
		System.out.println("*"+string + "* 검색할 회원 이름 입력 : ");
		String name = sc.next();
		return name;
	}
	public void printOneMember(Member member) {
		System.out.println(member);
	}

	public void finishMember(String string) {
		System.out.println(string+" 완료되었습니다.");
	}
}
