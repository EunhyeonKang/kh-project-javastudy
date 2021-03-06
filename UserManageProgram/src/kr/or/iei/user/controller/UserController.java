package kr.or.iei.user.controller;

import java.util.HashMap;
import java.util.HashSet;
import kr.or.iei.user.model.vo.User;
import kr.or.iei.user.view.UserView;

public class UserController {
	HashSet<String> u;
	HashMap<String, User> users;
	UserView view;
	public UserController() {
		super();
		u = new HashSet<String>();
		users = new HashMap<String,User>();
		view = new UserView();
	}
	public void main() {
		while(true) {
			int sel = view.showMenu();
			switch(sel) {
			case 0:
				view.printMsg("Bye~");
				return;
			case 1:
				insertUser();
				break;
			case 2:
				printAllUser();
				break;
			case 3:
				printOneUser();
				break;
			case 4:
				modifyUser();
				break;
			case 5:
				deleteUser();
				break;
			}
		}
	}
	public void deleteUser() {
		String id = view.insertUser("삭제");
		if(users.containsKey(id)) {
			users.remove(id);
		}else {
			view.printMsg("아이디가 존재하지 않습니다.");
		}
	}
	public void modifyUser() {
		String id = view.insertUser("수정");
		if(users.containsKey(id)) {
			User u = view.insertInfo(id, "수정");
			users.remove(id);
			users.put(u.getId(), u);
		}else {
			view.printMsg("아이디가 존재하지 않습니다.");
		}
	}
	public void printOneUser() {
		User info = view.getInfo("조회");
		User u= users.get(info);
		if(users.containsKey(info.getId())) {
			if(users.get(info.getId()).getPassword().equals(info.getPassword())) {
				view.printOneUser(users.get(info.getId()));
			}else {
				System.out.println("비밀번호가 존재하지 않습니다.");
			}
		}else {
			view.printMsg("아이디가 존재하지 않습니다.");
		}
	}
	public void printAllUser() {
		view.printAllUser(users);
	}
	public void insertUser() {
		while(true) {
			String id = view.insertUser("가입");
			boolean bool = u.add(id);
			if(!bool) {
				if(!u.add(id)) {
					view.printMsg("아이디가 중복되었습니다. 다시 입력해주세요.");	
				}
			}else {
				User u = view.insertInfo(id,"가입");
				users.put(u.getId(), u);
				break;
			}
		}	
	}
}
