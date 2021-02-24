package kr.or.iei.member.controller;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.member.view.MemberView;

public class MemberController {
	Member[] members;
	int index;
	MemberView view;
	public MemberController() {
		super();
		members = new Member[30];
		index=0;
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
	public void insertMember() {
		members[index++] = view.insertMember();
	}
	public void printAllMember() {
		view.printAllMember(members, index);
	}
	public void printOneMember() {
		String name = view.inputName("조회");
		int searchIndex = searchMember(name);
		if(searchIndex==-1) {
			view.printMsg("회원이 존재하지 않습니다.");
		}else {
			view.printOneMember(members[searchIndex]);
		}
	}
	public void modifyMember() {
		String name = view.inputName("수정");
		int searchIndex = searchMember(name);
		if(searchIndex ==-1) {
			view.printMsg("회원이 존재하지 않습니다.");
		}else {
			members[searchIndex]=view.modifyMember();
			view.printMsg("수정완료!!");
		}
	}
	public void deleteMember() {
		String name = view.inputName("삭제");
		int searchIndex = searchMember(name);
		if(searchIndex==-1) {
			view.printMsg("회원이 존재하지 않습니다.");
		}else {
			for(int i=searchIndex;i<index-1;i++) {
				members[i]=members[i+1];
			}
			members[--index] = null;
			view.printMsg("삭제완료!!");
		}
	}
	public int searchMember(String name) {
		for(int i=0;i<index;i++) {
			if(members[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
