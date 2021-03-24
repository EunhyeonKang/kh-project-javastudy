package kh.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import kh.member.model.vo.Member;

//Data Access Object
//DB관련 코드
public class MemberDao {

	public Member selectOneMember(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member where member_id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId); //첫번쨰 ?에 memberId변수에 있는 값을 세팅
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setAddr(rset.getString("addr"));
				m.setAge(rset.getInt("age"));
				m.setEnDate(rset.getDate("en_date"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return m;
	}

	public ArrayList<Member> seletAllMember() {
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		Member m = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				m = new Member();
				m.setAddr(rset.getString("addr"));
				m.setAge(rset.getInt("age"));
				m.setEnDate(rset.getDate("en_date"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<Member> selectNameMember(String memberName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		ArrayList<Member> list = new ArrayList<Member>(); 
		String query = "select * from member where member_name like ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+memberName+"%"); 
			rset = pstmt.executeQuery();
			while(rset.next()){
				m = new Member();
				m.setAddr(rset.getString("addr"));
				m.setAge(rset.getInt("age"));
				m.setEnDate(rset.getDate("en_date"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insetMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		String query ="insert into member values(mem_seq.nextval,?,?,?,?,?,?,sysdate)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3,m.getMemberName());
			pstmt.setString(4, m.getAddr());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6,m.getPhone());
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set member_pw = ?,member_name=?,addr=?,phone=? where member_id =?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,m.getMemberPw());
			pstmt.setString(2,m.getMemberName());
			pstmt.setString(3,m.getAddr());
			pstmt.setString(4,m.getPhone());
			pstmt.setString(5,m.getMemberId());
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where member_id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}