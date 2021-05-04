package board.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import common.JDBCTemplate;
import member.model.vo.BoardPageData;

public class BoardService {

	public BoardPageData selectBoardList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;
		int end = reqPage*numPerPage;
		int start = end - numPerPage+1;
		BoardDao dao = new BoardDao();
		ArrayList<Board> list = dao.selectBoardList(conn,start,end);
		int totalCount = dao.totalCount(conn);
		int totalPage = 0;
		if(totalCount%numPerPage==0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		
		int pageNaviSize = 5;
		
		
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		//페이지네비 시작
		String pageNavi = "<ul class='pagination patination-lg'>";
		if(pageNo != 1) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/boardList?reqPage="+(pageNo-1)+"'>&lt;</a></li>";
		}
		//페이지 숫자 생성
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li class='page-item active'>";
				pageNavi += "<a class='page-link' href='/boardList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}else {
				pageNavi += "<li class='page-item'>";
				pageNavi += "<a class='page-link' href='/boardList?reqPage="+pageNo+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
			if(pageNo > totalPage) {
				break;
			}
		}
		//다음버튼 생성
		if(pageNo <= totalPage) {
			pageNavi += "<li class='page-item'>";
			pageNavi += "<a class='page-link' href='/boardList?reqPage="+(pageNo)+"'>&gt;</a></li>";
			
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		BoardPageData bpd = new BoardPageData(list,pageNavi);
		return bpd;
	}

	public Board selectOneBoard(int boardNo) {
		Connection conn =JDBCTemplate.getConnection();
		Board b = new BoardDao().selectOneBoard(conn,boardNo);
		JDBCTemplate.close(conn);
		return b;
	}

}
