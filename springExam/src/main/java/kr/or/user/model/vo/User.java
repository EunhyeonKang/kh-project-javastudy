package kr.or.user.model.vo;

public class User {
	private int userNo;
	private String email;
	private String userPw;
	private String userName;
	private int age;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userNo, String email, String userPw, String userName, int age) {
		super();
		this.userNo = userNo;
		this.email = email;
		this.userPw = userPw;
		this.userName = userName;
		this.age = age;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
