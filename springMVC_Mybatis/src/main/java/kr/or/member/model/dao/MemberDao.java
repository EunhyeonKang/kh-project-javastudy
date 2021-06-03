package kr.or.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.member.model.vo.Member;
import kr.or.member.model.vo.MemberRowMapper;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	public MemberDao() {
		super();
		System.out.println("MemberDao 생성완료");
	}

	public Member selectOneMember(Member m) {
		return sqlSession.selectOne("member.selectOneMember",m);
	}
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		return sqlSession.insert("member.insertMember", m);
	}	

	public Member searchId(Member m) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.searchId",m);
	}

	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.delete("member.deleteMember",memberId);
	}

	public int memberUpdate(Member m) {
		// TODO Auto-generated method stub
		return sqlSession.update("member.updateMember",m);
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		List<Member> list = sqlSession.selectList("member.selectAllMember");
		return (ArrayList<Member>)list;
	}

	public int selectAllMemberCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.allMemberCount");
	}

	public int pwChangeMember(Member m) {
		// TODO Auto-generated method stub
		return sqlSession.update("member.pwChangeMember",m);
	}

	
}
