package kr.or.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.File;
import kr.or.notice.model.vo.Notice;


@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	@Transactional
	public int insertBoard(Board b, ArrayList<File> fileList) {
		//파일은  board_no가 필요하기 때문에 board테이블에 insert하는 것이 먼저
		int result1 = dao.insertBoard(b);
		int result = 0;
		if(result1>0) {
			int boardNo = dao.selectBoardNo();
			for(File f : fileList) {
				f.setBoardNo(boardNo);
				result+=dao.insertFile(f);
			}
		}else {
			return -1;
		}
		return result;
	}
	
	public ArrayList<Board> boardList() {
		List list = dao.boardList();
		return (ArrayList<Board>)list;
	}
	/*
	public Board boardView(int boardNo) {
		List list = dao.boardView(boardNo);
		Board b = null;
		if(!list.isEmpty()) {
			b = (Board)list.get(0);
		}
		return b;
	}

	public ArrayList<kr.or.board.model.vo.File> boardView1(int boardNo) {
		List list = dao.boardView1(boardNo);
		return (ArrayList<kr.or.board.model.vo.File>)list;
	}
	*/
	public Board selectOneBoard(int boardNo) {
		return dao.selectOneBoard(boardNo);
	}
}	
