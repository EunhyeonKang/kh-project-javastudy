package kr.or.iei.member.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

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
		System.out.println("----- 회원 관리 프로그래 v7 -----");
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

	public Member getMember(String string) {
		System.out.println("----- 회원 정보 "+string+" -----");
		System.out.println(string+"할 등급입력[silver/gold/vip/vvip]");
		String grade = sc.next();
		System.out.print(string+"할 이름 입력 : ");
		String name = sc.next();
		System.out.print(string+"할 포인트 입력 : ");
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

	public void printAllMember(HashMap<String, Member> members) {
		System.out.println("----- 회원 전체 출력 -----");
		System.out.println("등급\t이름\t포인트\t보너스");
		Set<String> keys = members.keySet();
		for(String key : keys) {
			System.out.println(members.get(key));
		}
	}

	public String getName(String string) {
		System.out.print(string+"할 이름 입력 : ");
		String name = sc.next();
		return name;
	}

	public void printOneMember(Member m) {
		System.out.println("등급 : "+m.getGrade());
		System.out.println("이름 : "+m.getName());
		System.out.println("포인트 : "+m.getPoint());
		System.out.println("보너스 : "+m.getBonus());
	}

	public void printMsg(String string) {
		System.out.println(string);
	}
}
