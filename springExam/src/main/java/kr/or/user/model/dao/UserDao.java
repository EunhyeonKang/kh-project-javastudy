package kr.or.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.user.model.vo.User;

@Repository
public class UserDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public UserDao() {
		super();
		System.out.println("디에이오 생성ㅎㅎㅎ");
	}
	
	public int insertUser(User u) {
		// TODO Auto-generated method stub
		return sqlSession.insert("user.insertUser", u);
	}

	public User selectOneUser(User u) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.selectOneUser",u);
	}
	
}
