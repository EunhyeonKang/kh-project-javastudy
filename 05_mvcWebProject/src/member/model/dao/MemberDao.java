package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id=? and member_pw=?";
		Member m = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m = new Member();
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member values(mem_seq.nextval,?,?,?,?,?,2,to_char(sysdate,'yyyy-mm-dd'))";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getAddress());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where member_id=?";
		Member m = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m = new Member();
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result=0;
		String query="update member set member_pw=?, phone=? ,address=? where member_id=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, int memberNo) {
		PreparedStatement pstmt = null;
		int result =0;
		String query="delete from member where member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query="select * from member";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setAddress(rset.getString("address"));
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				list.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public int changeLevel(Connection conn, int memberNo, int memberLevel) {
		PreparedStatement pstmt =null;
		int result=0;
		String query="update member set member_level =? where member_no =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberLevel);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
