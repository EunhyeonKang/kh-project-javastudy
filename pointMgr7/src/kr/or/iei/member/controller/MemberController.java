package kr.or.iei.member.controller;

import java.util.HashMap;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.member.view.MemberView;

public class MemberController {
	HashMap<String, Member> members;
	MemberView view;
	public MemberController() {
		super();
		members= new HashMap<String, Member>();
		view = new MemberView();
	}
	public void main() {
		while(true) {
			int sel = view.showMenu();
			switch(sel) {
			case 0: return;
			//create
			case 1: 
				insertMember();
				break;
			//All read
			case 2: 
				printAllMember();
				break;
			//One read
			case 3: 
				printOneMember();
				break;
			//update
			case 4: 
				modifyMember();
				break;
			//delete
			case 5: 
				deleteMember();
				break;
			}
		}
	}
	public void deleteMember() {
		String name = view.getName("삭제");
		if(members.containsKey(name)) {
			members.remove(name);
		}else {
			view.printMsg("존재하지 않는 회원입니다.");
		}
	}
	public void modifyMember() {
		String name = view.getName("수정");
		if(members.containsKey(name)) {
			Member m = view.getMember("수정");
			members.remove(name);
			members.put(m.getName(), m);
		}else {
			view.printMsg("존재하지 않는 회원입니다.");
		}
	}
	public void printOneMember() {
		String name = view.getName("조회");
		if(members.containsKey(name)) {
			Member m = members.get(name);
			view.printOneMember(m);
		}else {
			view.printMsg("존재하지 않는 회원입니다.");
		}
	}
	public void printAllMember() {
		view.printAllMember(members);
	}
	public void insertMember() {
		Member m = view.getMember("등록");
		members.put(m.getName(), m);
	}
}
