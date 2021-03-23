package kh.member.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.member.model.vo.Member;

public class MemberView {
	Scanner sc;

	public MemberView() {
		super();
		sc = new Scanner(System.in);
	}

	public int showMenu() {
		System.out.println("------- 회원 관리 프로그램v1 -------");
		System.out.println("1. 회원 전체 조회");		//SELECT
		System.out.println("2. 아이디로 회원 조회");	//SELECT
		System.out.println("3. 이름으로 회원 조회");	//SELECT
		System.out.println("4. 회원가입");			//INSERT
		System.out.println("5. 회원 정보 변경");		//UPDATE
		System.out.println("6. 회원 탈퇴");			//DELETE
		System.out.println("0. 프로그램 종료");
		System.out.println("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}

	public void printAllMember(ArrayList<Member> list) {
		System.out.println("------- 전체 회원 정보 -------");
		System.out.println("아이디\t이름\t나이\t가입일");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getMemberId()+
								"\t"+list.get(i).getMemberName()+
								"\t"+list.get(i).getAge()+
								"\t"+list.get(i).getEnDate());
		}
	}

	public String getId() {
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		return memberId;
	}

	public void printMrg(String string) {
		System.out.println(string);
	}

	public void printOneMember(Member m) {
		System.out.println("---- 회원 정보 출력 ----");
		System.out.println("회원번호 : "+m.getMemberNo());
		System.out.println("아이디 : "+m.getMemberId());
		System.out.println("비밀번호 : "+m.getMemberPw());
		System.out.println("이름 : "+m.getMemberName());
		System.out.println("주소 : "+m.getAddr());
		System.out.println("나이 : "+m.getAge());
		System.out.println("전화번호 : "+m.getPhone());
		System.out.println("가입일 : "+m.getEnDate());
	}

	public String getName() {
		System.out.print("조회할 이름 입력 : ");
		String name = sc.next();
		return name;
	}
}
