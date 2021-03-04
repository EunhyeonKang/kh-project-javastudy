package kr.or.iei.member.controller;

import java.util.ArrayList;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.member.view.MemberView;

public class MemberController {
	ArrayList<Member> members;
	MemberView view;
	public MemberController() {
		super();
		members = new ArrayList<Member>();
		view = new MemberView();
	}
	public void main() {
		while(true) {
			int sel = view.showMenu();
			switch(sel) {
			case 0:
				view.printMsg("Bye~~~");
				return;
			case 1:
				insertMember();
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				printOneMember();
				break;
			case 4:
				modifyMember();
				break;
			case 5:
				deleteMember();
				break;
			}
		}
	}
	public void deleteMember() {
		String name = view.searchName("삭제");
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			view.printMsg("회원정보가 존재하지 않습니다.");
		}else {
			members.remove(searchIndex);
			view.finishMember("삭제");
		}
		
	}
	public void modifyMember() {
		String name = view.searchName("수정");
		int searchIndex = searchMember(name);
		if(searchIndex == -1) {
			view.printMsg("회원정보가 존재하지 않습니다.");
		}else {
			Member m = view.insertMember("수정");
			members.set(searchIndex, m);
			view.finishMember("수정");
		}
	}
	public void printOneMember() {
		String name = view.searchName("회원 1명 출력");
		int searchIndex = searchMember(name);
		view.printOneMember(members.get(searchIndex));
	}
	public int searchMember(String name) {
		for(int i=0;i<members.size();i++) {
			if(members.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public void printAllMember() {
		view.printAllMember(members);
	}
	public void insertMember() {
		Member m = view.insertMember("등록");
		members.add(m);
		view.finishMember("등록");
	}
}
