package kr.or.iei.user.model.vo;

public class User {
	private String id;
	private String password;
	private String name;
	private int age;
	private String tel;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public User(String id, String password, String name, int age, String tel) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		String str = getId()+"\t"+getName()+"\t"+getAge()+"\t"+getTel();
		return str;
	}
}
