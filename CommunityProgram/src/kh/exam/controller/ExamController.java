package kh.exam.controller;

import java.sql.Connection;
import java.util.ArrayList;

import kh.exam.common.JDBCTemplete;
import kh.exam.model.dao.ExamDao;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;
import kh.exam.view.ExamView;

public class ExamController {
	ExamView view;
	ExamDao dao;
	Member loginMember;
	boolean bool =false;
	boolean bool2 = false;
	public ExamController() {
		super();
		view = new ExamView();
		dao = new ExamDao();
		loginMember = new Member();
	}
	public void main() {
		while(true) {
			int sel = view.getView();
			switch(sel) {
			case 0:
				return;
			case 1:
				loginMember();
				if(bool==true) {
					while(true) {
						int sel1 = view.boardView();
						switch(sel1) {
						case 1:
							selectBoard();
							break;
						case 2:
							DetailBoard();
							break;
						case 3:
							insertBoard();
							break;
						case 4:
							modifyBoard();
							break;
						case 5:
							deleteBoard();
							break;
						case 6:
							selectMember();
							break;
						case 7:
							modifyMember();
							break;
						case 8:
							deleteMember();
							break;
						case 0:
							logout();
							bool2=true;
							break;
						}
						if(bool2==true) {
							bool2=false;
							break;
						}
					}
				}
				break;
			case 2:
				signupMember();
				break;
			case 3:
				searchMember();
				break;
			}
		}
	}
	private void logout() {

		view.printMgr("Bye~Bye~");

		loginMember = null;		

	}
	private void deleteMember() {
		Connection conn = JDBCTemplete.getConnection();
		int sel = view.deleteMember();
		if(sel==1) {
			int result  = dao.deleteMember(conn,loginMember.getMemberNo());
			if(result>0) {
				JDBCTemplete.commit(conn);			
				logout();
			}else {
				JDBCTemplete.rollback(conn);
				view.printMgr("회원 탈퇴 실패!");
			}
		}		
		JDBCTemplete.close(conn);		
	}
	private void modifyMember() {
		Member m = view.modifyMember();
		m.setMemberId(loginMember.getMemberId());
		Connection conn = JDBCTemplete.getConnection();
		int result  = dao.modifyMember(conn,m);
		if(result>0) {
			JDBCTemplete.commit(conn);
			loginMember = dao.login(conn, m);
			view.printMgr("정보 수정 성공");
		}else {
			JDBCTemplete.rollback(conn);
			view.printMgr("정보 수정 실패");
		}
		JDBCTemplete.close(conn);	
	}
	private void selectMember() {
		view.printMember(loginMember);
	}
	private void deleteBoard() {
		int boardNo = view.getNum();
		Connection conn = JDBCTemplete.getConnection();		
		String boardWriter = dao.checkWriter(conn,boardNo);
		if(boardWriter == null){
			view.printMgr("게시글 번호를 확인하세요.");
		}else if (boardWriter.equals(loginMember.getMemberId())){
			int result = dao.deleteBoard(conn,boardNo);
			if(result>0) {
				JDBCTemplete.commit(conn);
				view.printMgr("게시글 삭제 성공!!");
			}else {
				JDBCTemplete.rollback(conn);
				view.printMgr("게시글 삭제 실패!!");
			}
		}else {
			view.printMgr("작성자만 삭제가 가능합니다.");
		}
		JDBCTemplete.close(conn);
	}

 
	public void modifyBoard() {
		int boardNo = view.getNum();
		Connection conn = JDBCTemplete.getConnection();		
		String boardWriter = dao.checkWriter(conn,boardNo);
		if(boardWriter == null){
			view.printMgr("게시글 번호를 확인하세요.");
		}else if (boardWriter.equals(loginMember.getMemberId())){
			Board b = view.insertBoard();
			b.setBoardNo(boardNo);
			int result = dao.modifyBoard(conn,b);
			if(result>0) {
				JDBCTemplete.commit(conn);
				view.printMgr("게시글 수정 성공!!");
			}else {
				JDBCTemplete.rollback(conn);
				view.printMgr("게시글 수정 실패!!");
			}
		}else {
			view.printMgr("작성자만 수정이 가능합니다.");
		}
		JDBCTemplete.close(conn);
	}
	public void DetailBoard() {
		int num = view.getNum();
		Connection conn = JDBCTemplete.getConnection();
		int result = dao.readCount(conn,num);
		if(result>0) {
			Board b = dao.DetailBoard(conn,num);	
			view.boardInfo(b);
			JDBCTemplete.commit(conn);
		}else {
			view.printMgr("게시물 번호를 확인하세요");
		}
		JDBCTemplete.close(conn);
	}
	public void selectBoard() {
		Connection conn = JDBCTemplete.getConnection();
		ArrayList<Board> list = dao.selectAllBoard(conn);
		if(list.size()!=0) {
			view.selectAllBoard(list);
		}else {
			view.printMgr("게시물 목록이 없습니다.");
		}
		JDBCTemplete.close(conn);
	}
	public void insertBoard() {
		Board b = view.insertBoard();
		Connection conn = JDBCTemplete.getConnection();
		int result = dao.insertBoard(conn,loginMember.getMemberId(),b);
		if(result > 0) {
			JDBCTemplete.commit(conn);
			view.printMgr("게시글 등록 성공!!");
		}else {
			JDBCTemplete.rollback(conn);
			view.printMgr("게시글 등록 실패");
		}
		JDBCTemplete.close(conn);
	}
	public void searchMember() {
		view.printMgr("-------- 아이디 찾기 --------");
		Member m = view.searchMember();
		Connection conn = JDBCTemplete.getConnection();
		Member member = dao.searchMember(conn,m);
		if(member!=null) {
			view.searchMemberName(member);
		}else {
			view.printMgr("일치하는 정보가 없습니다.");
		}
		JDBCTemplete.close(conn);
	}
	public void signupMember() {
		view.printMgr("-------- 회원가입 --------");
		String memberId = null;
		Connection conn = JDBCTemplete.getConnection();
		while(true) {
			memberId = view.getId();
			Member member = dao.selectOneMember(conn,memberId);
			if(member!=null) {
				System.out.println("회원아이디가 존재합니다.");
			}else {
				break;
			}
		}
		Member m = view.signupMember(memberId);
		int result = dao.signupMember(conn,m);
		if(result > 0) {
			JDBCTemplete.commit(conn);
			view.printMgr("회원가입 성공");
		}else {
			JDBCTemplete.rollback(conn);
			view.printMgr("회원가입 실패");
		}
		JDBCTemplete.close(conn);
	}
	public void loginMember() {
		view.printMgr("-------- 로그인 --------");
		Member m = view.loginMember();
		Connection conn = JDBCTemplete.getConnection();
		Member member = dao.loginMember(conn,m);
		if(member!=null) {
			bool=true;
			loginMember = member;
			view.printMgr("로그인 성공");
		}else {
			view.printMgr("아이디 또는 비밀번호를 확인하세요.");
		}
		JDBCTemplete.close(conn);
	}
	
}
