package kh.exam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kh.exam.common.JDBCTemplete;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamDao {
	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from exam_member where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setPhone(rset.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(pstmt);
			JDBCTemplete.close(rset);
		}
		return m;
	}

	public int signupMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into exam_member values(ex_mem_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(pstmt);
		}
		return result;
	}

	public Member searchMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "select * from exam_member where member_name = ? and phone=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getPhone());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new Member();
				member.setMemberName(rset.getString("member_name"));
				member.setPhone(rset.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(rset);
			JDBCTemplete.close(pstmt);
		}
		return member;
	}

	public Member loginMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "select * from exam_member where member_id = ? and member_pw =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new Member();
				member.setMemberNo(rset.getInt("member_no"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPw(rset.getString("member_pw"));
				member.setMemberName(rset.getString("member_name"));
				member.setPhone(rset.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(rset);
			JDBCTemplete.close(pstmt);
		}
		return member;
	}

	public int insertBoard(Connection conn, String memberId, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into exam_board values(board_no_seq.nextval,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, memberId);
			pstmt.setInt(4, 0);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(pstmt);
		}

		return result;
	}

	public ArrayList<Board> selectAllBoard(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;

		ArrayList<Board> list = new ArrayList<Board>();
		String query = "select board_no,board_title,nvl(member_name,'탈퇴회원'),read_count,write_date from exam_board left join exam_member on (member_id = board_writer)";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setBoardWriter(rset.getString("nvl(member_name,'탈퇴회원')"));
				b.setReadCount(rset.getInt("read_count"));
				b.setWriteDate(rset.getDate("write_date"));
				list.add(b);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(rset);
			JDBCTemplete.close(pstmt);
		}
		return list;
	}

	public Board DetailBoard(Connection conn, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		String query = "select board_no,board_title,board_content,member_name,read_count,write_date from exam_board left join exam_member on (board_writer = member_id) where board_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setBoardContent(rset.getString("board_content"));
				b.setReadCount(rset.getInt("read_count"));
				b.setWriteDate(rset.getDate("write_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JDBCTemplete.close(rset);
			JDBCTemplete.close(pstmt);
		}

		return b;
	}

	public int readCount(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		String query = "update exam_board set read_count = read_count+1 where board_no=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(pstmt);
		}

		return result;

	}

	public String checkWriter(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		String query = "select board_writer from exam_board where board_no=?";
		ResultSet rset = null;
		String boardWriter = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				boardWriter = rset.getString("board_writer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(rset);
			JDBCTemplete.close(pstmt);
		}
		return boardWriter;
	}

	public int modifyBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		String query = "update exam_board set board_title=?,board_content=? where board_no=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		String query = "delete from exam_board where board_no=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(pstmt);
		}
		return result;
	}

	public int modifyMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		String query = "update exam_member set member_pw=?,phone=? where member_id=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			int i = 1;
			pstmt.setString(i++, m.getMemberPw());
			pstmt.setString(i++, m.getPhone());
			pstmt.setString(i++, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(pstmt);
		}
		return result;
	}

	public Member login(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		String query = "select * from exam_member where member_id=? and member_pw=?";
		ResultSet rset = null;
		Member member = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = getMember(rset);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(rset);
			JDBCTemplete.close(pstmt);
		}
		return member;

	}

	public Member getMember(ResultSet rset) {
		Member m = new Member();
		try {
			m.setMemberNo(rset.getInt("member_no"));
			m.setMemberId(rset.getString("member_id"));
			m.setMemberPw(rset.getString("member_pw"));
			m.setMemberName(rset.getString("member_name"));
			m.setPhone(rset.getString("phone"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	public int deleteMember(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		String query = "delete from exam_member where member_no=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplete.close(pstmt);			
		}
		return result;
	}
}
