package kr.or.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.user.model.dao.UserDao;
import kr.or.user.model.vo.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public UserService() {
		super();
		System.out.println("서비스 생성ㅎㅎㅎ");
	}
	@Transactional
	public int insertUser(User u) {
		// TODO Auto-generated method stub
		return dao.insertUser(u);
	}
	public User selectOneUser(User u) {
		// TODO Auto-generated method stub
		return dao.selectOneUser(u);
	}
	
}
