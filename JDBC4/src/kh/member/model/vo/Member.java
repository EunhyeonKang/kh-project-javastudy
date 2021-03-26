package kh.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNO;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String addr;
	private int age;
	private String phone;
	private Date enDate;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int memberNO, String memberId, String memberPw, String memberName, String addr, int age, String phone,
			Date enDate) {
		super();
		this.memberNO = memberNO;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.addr = addr;
		this.age = age;
		this.phone = phone;
		this.enDate = enDate;
	}
	public int getMemberNO() {
		return memberNO;
	}
	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getEnDate() {
		return enDate;
	}
	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}
	
}
