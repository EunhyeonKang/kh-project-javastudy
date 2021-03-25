package kh.board.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.board.model.vo.Board;

public class BoardView {
	Scanner sc;
	public BoardView() {
		super();
		sc = new Scanner(System.in);
	}
	public int getView() {
		System.out.println("--------- 게시판 ---------");
		System.out.println("1. 게시물 목록 보기");
		System.out.println("2. 게시물 등록");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >>> ");
		int sel = sc.nextInt();
		return sel;
	}
	public void printMgr(String string) {
		System.out.println(string);
	}
	public void selectAllBoard(ArrayList<Board> list) {
		System.out.println("---------------- 게시물 목록 -----------------");
		System.out.println("글번호\t제목\t작성자\t작성일");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getBoardNo()+"\t"
							+list.get(i).getBoardTitle()+"\t"
							+list.get(i).getBoardWriter()
							+"\t"+list.get(i).getBoardDate());
		}
	}
	public Board getinfo() {
		Board b = new Board();
		System.out.println("---------- 게시물 등록 ----------");
		System.out.print("제목 입력 : ");
		String boardTitle = sc.next();
		b.setBoardTitle(boardTitle);
		System.out.print("내용 입력 : ");
		sc.nextLine();
		String boardContent = sc.nextLine();
		b.setBoardContent(boardContent);
		System.out.print("작성자 입력 : ");
		String boardWriter = sc.next();
		b.setBoardWriter(boardWriter);
		return b;
	}
	public int BoardMenu() {
		System.out.println("---------- 게시글 메뉴 ----------");
		System.out.println("1. 게시글 상세보기");
		System.out.println("2. 게시물 수정");
		System.out.println("3. 게시물 삭제");
		System.out.println("0. 메인으로 돌아가기");
		System.out.print("선택 >>> ");
		int sel = sc.nextInt();
		return sel;
	}
	public int getId() {
		System.out.print("조회할 게시물 번호 입력 : ");
		int sel = sc.nextInt();
		return sel;
	}
	public void selectOneBoard(Board b) {
		System.out.println("--------- 게시물 상세보기 ---------");
		System.out.println("글번호 : "+b.getBoardNo());
		System.out.println("제목 : "+b.getBoardTitle());
		System.out.println("내용 : "+b.getBoardContent());
		System.out.println("작성자 : "+b.getBoardWriter());
		System.out.println("작성일 : "+b.getBoardDate());
	}
	public int selDelete() {
		System.out.print("정말 삭제하시겠습니끼[1.yes/2.no]? ");
		int sel = sc.nextInt();
		return sel;
	}
	public Board updateBoard(Board b) {

		System.out.print("수정 할 제목 입력 : ");
		String boardTitle = sc.next();
		b.setBoardTitle(boardTitle);
		sc.nextLine();
		System.out.print("수정할 내용 입력 : ");
		String boardContent = sc.nextLine();
		b.setBoardContent(boardContent);
		return b;
	}

}
