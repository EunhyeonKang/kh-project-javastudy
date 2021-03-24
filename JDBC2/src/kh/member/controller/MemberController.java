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
			case 0:
				return;
			case 1:
				printAllMember();
				break;
			case 2:
				printOneMemberId();
				break;
			case 3:
				printMemberName();
				break;
			case 4:
				insetMember();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;			
			}
		}
	}
	public void deleteMember() {
		view.printMrg("----- 회원 탈퇴 -----");
		String memberId = view.getId();
		int result = dao.deleteMember(memberId);
		if(result>0) {
			view.printMrg("탈퇴 성공");
		}else {
			view.printMrg("탈퇴 실패");
		}
	}
	public void updateMember() {
		view.printMrg("----- 회원 수정 -----");
		String memberId = view.getId();
		Member member = dao.selectOneMember(memberId);
		if(member!=null) {
			Member m = view.getMembers(memberId);
			int result = dao.updateMember(m);
			if(result>0) {
				view.printMrg("수정 성공");
			}else {
				view.printMrg("회원 정보가 없습니다.");
			}
		}else {
			view.printMrg("회원 정보가 없습니다.");
		}
	}
	public void insetMember() {
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
		int result = dao.insetMember(m);
		if(result >0) {
			view.printMrg("가입 성공!");
		}else {
			view.printMrg("가입 실패..");
		}
	}
	public void printAllMember() {
		ArrayList<Member> list = dao.seletAllMember();
		if(list.isEmpty()) {
			//회원이 한명도 없는경우
			view.printMrg("회원이 존재하지 않습니다.");
		}else {
			view.printAllMember(list);
		}
	}
	public void printOneMemberId() {
		String memberId = view.getId();
		Member m = dao.selectOneMember(memberId);
		if(m!=null) {
			view.printOneMember(m);
		}else {
			view.printMrg("조회실패!");
		}
	}
	public void printMemberName() {
		String memberName = view.getName();
		ArrayList<Member> list = dao.selectNameMember(memberName);
		if(list.size()==0) {
			view.printMrg("검색결과 없음!");
		}else {
			view.printAllMember(list);
		}
	}
}
