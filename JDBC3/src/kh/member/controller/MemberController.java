package kh.member.controller;

import java.util.ArrayList;

import kh.member.model.dao.MemberDao;
import kh.member.model.vo.Member;
import kh.member.view.MemberView;

public class MemberController {
	MemberView view;
	MemberDao dao;
	public MemberController() {
		super();
		view = new MemberView();
		dao = new MemberDao();
	}
	public void main() {
		while(true) {
			int sel = view.showMenu();
			switch(sel) {
			case 1:
				printAllMember();
				break;
			case 2:
				printMemberId();
				break;
			case 3:
				printMemberName();
				break;
			case 4:
				insertMember();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			case 0:
				return;
			}
					
		}
	}
	public void updateMember() {
		view.printMrg("----- 정보 수정 -----");
		String memberId = view.getId();
		Member m = dao.selectOneMember(memberId);
		if(m!= null) {
			Member member = view.getMembers(memberId);
			member.setMemberId(memberId);
			int result = dao.updateMember(member);
			if(result > 0 ) {
				view.printMrg("회원 수정 성공");
			}else {
				view.printMrg("수정 실패");
			}
		}else {
			view.printMrg("회원 정보가 존재하지 않습니다.");
		}
		
		
	}
	public void insertMember() {
		view.printMrg("----- 회원 가입 -----");
		String memberId = null;
		while(true) {
			memberId = view.getId();
			Member member = dao.selectOneMember(memberId);
			if(member!=null) {
				view.printMrg("이미 사용중인 아이디입니다.");
			}else {
				break;
			}
		}
		Member m = view.getMember(memberId);
		int result = dao.insertMember(m);
		if(result >0) {
			view.printMrg("가입 성공!");
		}else {
			view.printMrg("가입 실패..");
		}
	}
	public void deleteMember() {
		String memberId = view.getId();
		int result = dao.deleteMember(memberId);
		if(result>0) {
			view.printMrg("삭제성공!");
		}else {
			view.printMrg("삭제실패");
		}
	}
	public void printMemberName() {
		view.printMrg("----- 이름으로 회원 조회 -----");
		String memberName = view.getName();
		ArrayList<Member> list = dao.selectMemberName(memberName);
		
		if(list.size()!=0) {
			view.printAllMember(list);
		}else {
			view.printMrg("회원정보가 존재하지 않습니다.");
		}
	}
	public void printAllMember() {
		ArrayList<Member> list = dao.selectAllMember();
		if(list.size()!=0) {
			view.printAllMember(list);
		}else {
			view.printMrg("회원 정보가 없습니다.");
		}
	}
	public void printMemberId() {
		view.printMrg("----- 아이디로 회원 조회 -----");
		String memberId = view.getId();
		Member m = dao.selectOneMember(memberId);
		if(m!=null) {
			view.printOneMember(m);
		}else {
			view.printMrg("회원정보가 존재하지 않습니다.");
		}
	}
	
}
