package member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(SqlSession session, Member member) {
		Member m = session.selectOne("member.selectOneMember",member);
		return m;
	}

	public int insertMember(SqlSession session, Member m) {
		int result = session.insert("member.insertMember",m);
		return result;
	}

	public Member selectOneMember(SqlSession session, String memberId) {
		Member m = session.selectOne("member.selectOneMemberId", memberId);
		return m;
	}

	public int updateMember(SqlSession session, Member m) {
		int result = session.update("member.updateMember",m);
		return result;
	}

	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("member.deleteMember",memberId);
		return result;
	}

	public ArrayList<Member> selectAllMember(SqlSession session) {
		List<Member> list = session.selectList("member.selectAllMember");
		return (ArrayList<Member>)list;
	}

	public Member selectOneMember(SqlSession session, HashMap<String, Object> map) {
		return session.selectOne("member.idSearch",map);
	}

	public Member selectOneMember1(SqlSession session, HashMap<String, Object> map) {
		return session.selectOne("member.pwSearch",map);
	}

}
