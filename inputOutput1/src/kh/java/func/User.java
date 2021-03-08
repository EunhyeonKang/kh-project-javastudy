package kh.java.func;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 11111111;
	private String name;
	private int age;
	private String addr;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}

