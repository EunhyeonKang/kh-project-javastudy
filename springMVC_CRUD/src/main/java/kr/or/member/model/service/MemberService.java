package kr.or.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	public MemberService() {
		super();
		System.out.println("MemberService 생성완료");
	}

	public Member selectOneMember(Member m) {
		List list = dao.selectOneMember(m);
		Member member = null;
		if(!list.isEmpty()) {
			member = (Member)list.get(0);
		}
		return member;
	}

	public int insertMember(Member m) {
		
		return dao.insertMember(m);
	}

	public Member searchId(Member m) {
		List list = dao.searchId(m);
		Member member = null;
		if(!list.isEmpty()) {
			member = (Member)list.get(0);
		}
		return member;
	}

	public Member searchPw(Member m) {
		List list = dao.searchPw(m);
		Member member =null;
		if(!list.isEmpty()) {
			member = (Member)list.get(0);
		}
		return member;
	}

	public int deleteMember(String memberId) {
		int result = dao.deleteMember(memberId);
		return result;
	}

	public Member selectOneMember(String memberId) {
		List list = dao.selectOneMember(memberId);
		Member m=null;
		if(!list.isEmpty()) {
			m= (Member)list.get(0);
		}
		return m;
	}

	public int updateMember(Member m) {
		int result = dao.updateMember(m);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		List list = dao.selectAllMember();
		return(ArrayList<Member>)list;
	}

	public int selectAllMemberCount() {
		int result = dao.selectAllMemberCount();
		return result;
	}
	
}
