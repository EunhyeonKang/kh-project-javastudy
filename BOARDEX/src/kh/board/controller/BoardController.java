package kh.board.controller;

import java.util.ArrayList;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.Board;
import kh.board.view.BoardView;

public class BoardController {
	BoardView view;
	BoardDao dao;
	boolean bool = true;
	public BoardController() {
		super();
		view = new BoardView();
		dao = new BoardDao();
	}
	public void main() {
		while(true) {
			int sel = view.getView();
			switch(sel) {
			case 1:
				while(true) {
					selectBoard();
					int sel1 = view.BoardMenu();
					switch(sel1) {
					case 0:
						bool=false;
						break;
					case 1:
						selectOneBoard();
						break;
					case 2: 
						updateBoard();
						break;
					case 3:
						deleteBoard();
						break;
					}
					if(bool==false) {
						bool=true;
						break;
					}
				}
				break;
			case 2: 
				insetBoard();
				break;
			case 0:
				return;
			}
			
		}
	}
	public void insetBoard() {
		Board b = view.getinfo();
		int result = dao.insertBoard(b);
		if(result > 0 ) {
			view.printMgr("등록성공!!");
		}else {
			view.printMgr("등록실패..");
		}
		
	}
	public void selectBoard() {
		ArrayList<Board> list = dao.selectAllBoard();
		if(list.size()!=0) {
			view.selectAllBoard(list);
		}else {			
			view.printMgr("게시글이 없습니다.");		
		}
	}
	public void updateBoard() {
		int boardId = view.getId();
		Board b = dao.selectOneBoard(boardId);
		if(b!=null){
			Board board = view.updateBoard(b);
			int result = dao.updateBoard(board,boardId);
			if(result > 0) {
				view.printMgr("변경 완료!");
			}else {
				view.printMgr("변경 실패!");
			}
		}else {
			System.out.println("글번호를 확인해주세요");
		}
	}
	public void deleteBoard() {
		int boardId = view.getId();
		Board b = dao.selectOneBoard(boardId);
		if(b!=null){
			int sel = view.selDelete();
			if(sel == 1) {
				int result = dao.deleteBoard(boardId);
				view.printMgr("삭제 성공!");
			}else {
				view.printMgr("삭제 실패..");
			}
			
		}else {
			System.out.println("글번호를 확인해주세요");
		}
	}
	public void selectOneBoard() {
		int boardId = view.getId();
		Board b = dao.selectOneBoard(boardId);
		if(b!=null) {
			view.selectOneBoard(b);
		}else {
			System.out.println("글번호를 확인해주세요");
		}
	}

}
