package kh.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import kh.member.model.vo.Member;

//Data Access Object
//DB관련 코드
public class MemberDao {
	public ArrayList<Member> seletAllMember(){
		Connection conn = null;	//DBMS 연결용 객체
		Statement stmt = null;	//SQL구문을 실행하고 결과를 받아오는 객체
		ResultSet rset = null;	//SELECT실행 결과를 저장하는 객체
		ArrayList<Member> list = new ArrayList<Member>(); //전체 회원정보를 저장할 객체
		String query = "select * from member";	//쿼리문 작성시 ;포함x
		try {
			//1. 사용할 DB에 대한 드라이버 등록(사용할 클래스 등록)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 등록된 클래스를 이용해서 DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			//3. 쿼리문을 실행할 statement객체 생성
			stmt = conn.createStatement();
			//4. 쿼리문전송
			// SELET를 수행하기 떄문에 executeQuery()메소드를 호출
			//5. 쿼리문 수행결과 저장
			// SELECT 수행결과는ResultSet 객체로 리턴
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Member m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setAddr(rset.getString("addr"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setEnDate(rset.getDate("en_date"));
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6. 자원반환
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member where member_id='"+memberId+"'";
		
		try {
			//1. 사용할 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 등록된 클래스로 DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			//3. 쿼리문 실핼할 Statement객체 생성
			stmt = conn.createStatement();
			//4. 쿼리문을 실행하고 결과를 받아옴 , 5. 받은 결과를 저장
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setAddr(rset.getString("addr"));
				m.setAge(rset.getInt("age"));
				m.setPhone(rset.getString("phone"));
				m.setEnDate(rset.getDate("en_date"));
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return m;
	}


	public ArrayList<Member> selectMemberName(String memberName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Member m = null;
		ArrayList<Member> list = new ArrayList<Member>(); 
		//"'%'||"+키워드+"||'%'"
		String query = "select * from MEMBER where MEMBER_NAME like '%"+memberName+"%'";
		try {
			//1. 사용할 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 등록된 클래스로 DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			//3. 쿼리문 실핼할 Statement객체 생성
			stmt = conn.createStatement();
			//4. 쿼리문을 실행하고 결과를 받아옴 , 5. 받은 결과를 저장
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt(1));
				m.setMemberId(rset.getString(2));
				m.setMemberPw(rset.getString(3));
				m.setMemberName(rset.getString(4));
				m.setAddr(rset.getString(5));
				m.setAge(rset.getInt(6));
				m.setPhone(rset.getString(7));
				m.setEnDate(rset.getDate(8));
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		//insert 결과는 적용된 행의 갯수가 리턴되므로 정수형으로 처리
		int result = 0;
		String query = "insert into member values(mem_seq.nextval,"
						+"'"+m.getMemberId()+"',"
						+"'"+m.getMemberPw()+"',"
						+"'"+m.getMemberName()+"',"
						+"'"+m.getAddr()+"',"
						+m.getAge()+","
						+"'"+m.getPhone()+"',"
						+"sysdate)";
		//System.out.println(query);	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc","1234");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result > 0) {
				//성공한 경우(적용된 행의 갯수가 0개보다 크면)
				conn.commit();
			}else {
				//실패한 경우(작용된 행의 갯수가 0이면)
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
				stmt.close();
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
		Statement stmt = null;
		int result = 0;
		String query = "delete from member where member_id = '"+memberId+"'";
		//System.out.println(query); 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if(result > 0) {
				//성공한 경우(적용된 행의 갯수가 0개보다 크면)
				conn.commit();
			}else {
				//실패한 경우(작용된 행의 갯수가 0이면)
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}


	public int updateMember(String memberId, Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0; 
		String query = "update member set " 
						+"member_pw = '" + m.getMemberPw() +"'," 
						+"member_name = '"+ m.getMemberName()+"',"
						+"addr = '" + m.getAddr()+"',"
						+"phone = '"+ m.getPhone()+"'"
						+ "where member_id = '"+memberId+"'";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","jdbc","1234");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			if(result > 0) {
				//성공한 경우(적용된 행의 갯수가 0개보다 크면)
				conn.commit();
			}else {
				//실패한 경우(작용된 행의 갯수가 0이면)
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
}