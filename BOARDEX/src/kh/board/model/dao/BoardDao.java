package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplete;
import kh.board.model.vo.Board;

public class BoardDao {

	public ArrayList<Board> selectAllBoard() {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String query = "select * from board";
		conn = JDBCTemplete.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				b = new Board();
				b.setBoardNo(rset.getInt("b_no"));
				b.setBoardTitle(rset.getString("b_title"));
				b.setBoardWriter(rset.getString("b_writer"));
				b.setBoardDate(rset.getString("b_date"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(rset);
			JDBCTemplete.close(conn);
			JDBCTemplete.close(pstmt);
		}
		return list;
	}

	public int insertBoard(Board b) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into board values(b_no_seq.nextval,?,?,?,sysdate)";
		int result = 0;
		conn = JDBCTemplete.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,b.getBoardTitle());
			pstmt.setString(2,b.getBoardContent());
			pstmt.setString(3,b.getBoardWriter());
			result = pstmt.executeUpdate();
			if(result > 0 ) {
				JDBCTemplete.commit(conn);
			}else {
				JDBCTemplete.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn);
			JDBCTemplete.close(pstmt);
		}
		
		return result;
	}

	public Board selectOneBoard(int boardId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		String query = "select * from board where b_no = ?";
		conn = JDBCTemplete.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Board();
				b.setBoardNo(rset.getInt("b_no"));
				b.setBoardTitle(rset.getString("b_title"));
				b.setBoardContent(rset.getString("b_content"));
				b.setBoardWriter(rset.getString("b_writer"));
				b.setBoardDate(rset.getString("b_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn);
			JDBCTemplete.close(pstmt);
			JDBCTemplete.close(rset);
		}
		return b;
	}

	public int deleteBoard(int boardId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from board where b_no=?";
		conn = JDBCTemplete.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,boardId);
			result = pstmt.executeUpdate();
			if(result > 0 ) {
				JDBCTemplete.commit(conn);
			}else {
				JDBCTemplete.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplete.close(conn);
			JDBCTemplete.close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Board board, int boardId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board set b_title=?,b_content=? where b_no=?";
		conn = JDBCTemplete.getConnection();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, boardId);
			result = pstmt.executeUpdate();
			if(result>0) {
				JDBCTemplete.commit(conn);
			}else {
				JDBCTemplete.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(conn);
			JDBCTemplete.close(pstmt);
		}
		return result;
	}

}
