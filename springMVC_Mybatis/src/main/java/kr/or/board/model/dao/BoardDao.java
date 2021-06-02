package kr.or.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.File;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	/* private JdbcTemplate jdbcTemplete; */
	
	public int insertBoard(Board b) {
		int result = sqlSession.insert("board.insertBoard",b);
		return result;
//		String query="insert into board "
//				+"values(board_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
//		Object[] params = {b.getBoardTitle(),b.getBoardWriter(),b.getBoardContent()};
//		int result = jdbcTemplete.update(query,params);
//		return result;
	}

	public int selectBoardNo() {
		int result = sqlSession.selectOne("board.selectBoardNo");
		return result;
//		String query = "select max(board_no) from board";
//		int boardNo = jdbcTemplete.queryForObject(query, int.class);
//		return boardNo;
	}

	public int insertFile(File f) {
		return sqlSession.insert("board.insertFile",f);
//		String query = "insert into file_tbl values(file_seq.nextval,?,?,?)";
//		Object[] params = {f.getFilename(),f.getFilepath(),f.getBoardNo()};
//		int result = jdbcTemplete.update(query,params);
//		return result;
	}
	
	public List boardList() {
		List list = sqlSession.selectList("board.selectAllBoard");
		return list;
//		String query = "select * from board";
//		List list = jdbcTemplete.query(query, new BoardRowMapper());
//		return list;
	}
	/*
	public List boardView(int boardNo) {
		String query="select * from board where board_no = ?";
		Object[] params = {boardNo};
		List list = jdbcTemplete.query(query, params,new BoardRowMapper());
		return list;
	}

	public List boardView1(int boardNo) {
		String query="SELECT * FROM file_tbl f join board b ON b.board_no = f.board_no and b.board_no=?";
		Object[] params = {boardNo};
		List list = jdbcTemplete.query(query, params,new FileRowMapper());
		return list;
	}*/
}
