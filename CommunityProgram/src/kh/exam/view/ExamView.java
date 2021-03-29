package kh.exam.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamView {
	Scanner sc;
	public ExamView() {
		super();
		sc = new Scanner(System.in);
	}
	public int getView() {
		System.out.println("--------- KH커뮤니티 --------");
		System.out.println("1. 로그인하기");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디 찾기");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >");
		int sel = sc.nextInt();
		return sel;
	}
	public Member signupMember(String memberId) {
		Member m = new Member();
		m.setMemberId(memberId);
		System.out.print("PW 입력  : ");
		m.setMemberPw(sc.next());
		System.out.print("이름 입력  : ");
		m.setMemberName(sc.next());
		System.out.print("전화번호 입력(ex.01011112222) : ");
		m.setPhone(sc.next());
		return m;
	}
	public String getId() {
		System.out.print("ID 입력 : ");
		String memberId = sc.next();
		return memberId;
	}
	public void printMgr(String string) {
		System.out.println(string);
	}
	public Member searchMember() {
		Member m = new Member();
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("전화번호 입력 : ");
		m.setPhone(sc.next());
		return m;
	}
	public void searchMemberName(Member member) {
		System.out.println("아이디는 ["+member.getMemberName()+"] 입니다.");	
	}
	public Member loginMember() {
		Member m = new Member();
		System.out.print("ID 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("PW 입력 : ");
		m.setMemberPw(sc.next());
		return m;
	}
	public int boardView() {
		System.out.println("--------- KH커뮤니티 --------");
		System.out.println("1. 게시물 목록 보기");
		System.out.println("2. 게시물 상세 보기");
		System.out.println("3. 게시물 등록");
		System.out.println("4. 게시물 수정");
		System.out.println("5. 게시물 삭제");
		System.out.println("6. 내 정보 보기");
		System.out.println("7. 내 정보 변경");
		System.out.println("8. 내 정보 삭제");
		System.out.println("0. 로그아웃");
		System.out.print("선택 >");
		int sel = sc.nextInt();
		return sel;
	}
	public Board insertBoard() {
		Board board = new Board();	
		System.out.print("제목 입력 : ");
		board.setBoardTitle(sc.next());
		System.out.print("내용 입력 : ");
		sc.nextLine();
		board.setBoardContent(sc.nextLine());
		return board;
	}
	public void selectAllBoard(ArrayList<Board> list) {
		System.out.println("--------- 게시물 목록 --------");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getBoardNo()+"\t"
								+list.get(i).getBoardTitle()+"\t"
								+list.get(i).getBoardWriter()+"\t"
								+list.get(i).getReadCount()+"\t"
								+list.get(i).getWriteDate());
		
		}
	}
	public int getNum() {
		System.out.print("게시물 번호 입력 : ");
		int num = sc.nextInt();
		return num;
	}
	public void boardInfo(Board b) {
		System.out.println("게시물 번호 : "+b.getBoardNo());
		System.out.println("게시물 제목 : "+b.getBoardTitle());
		System.out.println("게시물 내용 : "+b.getBoardContent());
		System.out.println("게시물 작성자 : "+b.getBoardWriter());
		System.out.println("게시물 조회수 : "+b.getReadCount());
		System.out.println("게시물 작성일 : "+b.getWriteDate());
	}
	public void printMember(Member loginMember) {
		System.out.println("\n---------- 내 정보 보기 ----------");
		System.out.println("회원번호 : "+loginMember.getMemberNo());
		System.out.println("아이디 : "+loginMember.getMemberId());
		System.out.println("비밀번호 : "+loginMember.getMemberPw());
		System.out.println("이름 : "+loginMember.getMemberName());
		System.out.println("전화번호 : "+loginMember.getPhone());
	}
	public Member modifyMember() {
		System.out.println("\n---------- 내 정보 수정 ----------");
		Member m = new Member();		
		System.out.print("PW 입력 : ");
		m.setMemberPw(sc.next());		
		System.out.print("전화번호 입력(ex.01011112222) : ");
		m.setPhone(sc.next());
		return m;
	}
	public int deleteMember() {
		System.out.println("\n---------- 회원 탈퇴 ----------");
		System.out.print("정말 탈퇴 하시겠습니까(1.YES / 2.NO)? ");
		return sc.nextInt();
	}
}
