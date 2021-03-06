package kr.or.iei.user.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import kr.or.iei.user.model.vo.User;

public class UserView {
	Scanner sc;
	public UserView() {
		super();
		sc = new Scanner(System.in);
	}
	public int showMenu() {
		System.out.println("-------------- 회원 관리 프로그램 --------------");
		System.out.println("1. 회원 가입");
		System.out.println("2. 전체 회원 정보 조회");
		System.out.println("3. 회원 정보 조회(1명)");
		System.out.println("4. 정보수정(아이디는 변경 불가)");
		System.out.println("5. 회원 탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		return sel;
	}
	public String insertUser(String string) {
		System.out.print(string+"할 아이디 입력 : ");
		String id = sc.next();
		return id;
	}
	public void printAllUser(HashMap<String, User> users) {
		System.out.println("-------------- 전체 회원 정보 출력 --------------");
		System.out.println("아이디\t이름\t나이\t전화번호");
		Set<String> keys = users.keySet();
		for(String key : keys) {
			System.out.println(users.get(key));
		}
	}
	public User insertInfo(String id, String string) {	
		System.out.print(string+"할 비밀번호 입력 : ");
		String password = sc.next();
		System.out.print(string+"할 이름 입력 : ");
		String name = sc.next();
		System.out.print(string+"할 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print(string+"할 전화번호 입력(ex.000-0000-0000) : ");
		String tel = sc.next();
		User u = new User(id,password,name,age,tel);
		return u;	
		}
	public void printMsg(String string) {
		System.out.println(string);
	}
	public User getInfo(String string) {
		System.out.print(string + "할 아이디 입력 : ");
		String id = sc.next();
		System.out.print(string + "할 비밀번호 입력 : ");
		String password = sc.next();
		User u = new User(id,password);
		return u;
	}
	public void printOneUser(User user) {
		System.out.println("아이디 : "+user.getId());
		System.out.println("패스워드 : "+user.getPassword());
		System.out.println("이름 : "+user.getName());
		System.out.println("나이 : "+user.getAge());
		System.out.println("전화번호 : "+user.getTel());
	}
}
