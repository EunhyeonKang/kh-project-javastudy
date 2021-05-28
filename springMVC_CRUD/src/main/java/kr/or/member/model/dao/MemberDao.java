package kr.or.member.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowMapper;

@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public MemberDao() {
		super();
		System.out.println("MemberDao 생성완료");
	}

	public List selectOneMember(Member m) {
		String query = "select * from member where member_id=? and member_pw=?";
		Object[] params = {m.getMemberId(),m.getMemberPw()};
		//조회결과 개수와 상관없이 무조건 list
		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		return list;
	}

	public int insertMember(Member m) {
		String query = "insert into member values(?,?,?,?,?,?)";
		Object[] params = {m.getMemberId(),m.getMemberPw(),m.getMemberName(),m.getPhone(),m.getAddress(),m.getGender()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public List searchId(Member m) {
		String query="select * from member where member_name=? and phone=?";
		Object[] params = {m.getMemberName(),m.getPhone()};
		List list = jdbcTemplate.query(query, params,new MemberRowMapper());
		return list;
	}

	public List searchPw(Member m) {
		String query="select * from member where member_id=? and phone=?";
		Object[] params = {m.getMemberId(),m.getPhone()};
		List list = jdbcTemplate.query(query,params,new MemberRowMapper());
		return list;
	}

	public int deleteMember(String memberId) {
		String query = "delete from member where member_id=?";
		Object[] params = {memberId};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public List selectOneMember(String memberId) {
		String query = "select * from member where member_id=?";
		Object[] params = {memberId};
		List list = jdbcTemplate.query(query, params, new MemberRowMapper());
		return list;
	}

	public int updateMember(Member m) {
		String query="update member set member_pw=?,phone=?,address=?,gender=? where member_id=?";
		Object[] params = {m.getMemberPw(),m.getPhone(),m.getAddress(),m.getGender(),m.getMemberId()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}

	public List selectAllMember() {
		String query="select * from member";
		List list= jdbcTemplate.query(query, new MemberRowMapper());
		return list;
	}

	public int selectAllMemberCount() {
		String query="select count(*) from member";
		int result = jdbcTemplate.queryForObject(query,int.class);
		return result;
	}
	
}
